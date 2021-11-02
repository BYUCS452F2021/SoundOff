const express = require("express");
const mongoose = require('mongoose');
const users = require("./users.js");

const router = express.Router();

//
// Class schema and model
//

// This is the schema. Classes have students and professors.
const classSchema = new mongoose.Schema({
    name: String,
    professor: {
        type: users
    },
    created: {
        type: Date,
        default: Date.now
    },
    students: [],
    lectures: [],
});

// This is a method that will be called automatically any time we convert a class
// object to JSON.
classSchema.methods.toJSON = function() {
    return this.toObject();
}

// create a User model from the User schema
const Class = mongoose.model('Class', classSchema);

/* API Endpoints */

/* All of these endpoints start with "/" here, but will be configured by the
   module that imports this one to use a complete path, such as "/api/classes" */

//create a new class
router.post('/', async (req, res) => {
    // Make sure that the form coming from the browser includes all required fields,
    // otherwise return an error. A 400 error means the request was
    // malformed.
    if (!req.body.name || !req.body.professor || req.body.professor.accountType !== 'professor')
        return res.status(400).send({
            message: "Class name and a Professor are required"
        });
    try {
        //  Check to see if class name already exists and if so, send a 403 error. A 403
        // error means permission denied.
        const existingClass = await Class.findOne({
            name: req.body.name
        });
        if (existingClass)
            return res.status(403).send({
                message: "class already exists"
            });

        // create a new class and save it to the database
        const newClass = new Class({
            name: req.body.name,
            //professor: , TODO: Call user api for object with professor id, assign professor object to class
            created: Date.now(),
        });

        await newClass.save();
        // TODO: Update the professor classes list to include the saved class

        // send back a 200 OK response (front end will need to refresh the professor)
        res.sendStatus(200);
    } catch (error) {
        console.log(error);
        return res.sendStatus(500);
    }
});