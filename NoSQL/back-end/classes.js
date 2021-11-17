const express = require("express");
const mongoose = require('mongoose');
// Get other collections for the N:M relationship
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
        // Find a professor by id
        let user = await users.model.findOne({
            _id: req.body.professor._id
        }).populate('user');

        // create a new class and save it to the database
        const newClass = new Class({
            name: req.body.name,
            professor: user,
            created: Date.now(),
        });

        await newClass.save();

        // Update the professor classes list to include the saved class
        let createdClass = await Class.findOne( {
            name: req.body.name
        }).populate('class');
        user.classes.push({
            name: createdClass.name,
            id: createdClass._id,
        })
        await user.save();

        // send back a 200 OK response, along with the user that was created
        return res.send({
            user: user
        });
    } catch (error) {
        console.log(error);
        return res.sendStatus(500);
    }
});

//Get a class by class id
router.post('/class', async (req, res) => {
    // Make sure that the form coming from the browser includes all required fields,
    // otherwise return an error. A 400 error means the request was
    // malformed.
    if (!req.body.classId)
        return res.status(400).send({
            message: "Class id is required"
        });
    try {

        const existingClass = await Class.findOne({
            _id: req.body.classId
        }).populate('class');

        if (!existingClass)
            return res.status(404).send({
                message: "Class not found"
            });

        // send back a 200 OK response, along with the class that was found
        return res.send({
            queriedClass: existingClass
        });

    } catch (error) {
        console.log(error);
        return res.sendStatus(500);
    }
});

//Add student to a class
router.post('/addStudents', async (req, res) => {
    // Make sure that the form coming from the browser includes all required fields,
    // otherwise return an error. A 400 error means the request was
    // malformed.
    if (!req.body.students || !req.body.classroom)
        return res.status(400).send({
            message: "Students and a Class are required"
        });
    try {
        let currentClass = await Class.findOne({
            _id: req.body.classroom._id
        }).populate('class');
        if (!currentClass)
            return res.status(404).send({
                message: "Class not found"
            });
        for (let i = 0; i < req.body.students.length; i++) {
           let user = await users.model.findOne({
                _id: req.body.students[i]._id
            }).populate('user');
           if(user) {
               // only add the student to the class if it doesn't exist in the student list
               if((!await currentClass.students.includes({_id: user._id}))){ // TODO: Fix this so that the students are not added more than once.
                   // Update the class' student list to include the user
                   await currentClass.students.push({
                       _id: user._id,
                       name: user.name,
                       email: user.email
                   });
                   // Update the student classes list to include the class, then save the user changes
                   await user.classes.push({
                       id: currentClass._id,
                       name: currentClass.name
                   });
                   await user.save();
               }
           } else {
               // Make sure that the form coming from the browser includes all required fields,
               // otherwise return an error. A 400 error means the request was
               // malformed. (It didn't have an id)
               return res.status(400).send({
                   message: "Student id is required, or student not found"
               });
           }
        }

        await currentClass.save();

        // send back a 200 OK response, along with the class that was found
        return res.send({
            queriedClass: currentClass
        });

    } catch (error) {
        console.log(error);
        return res.sendStatus(500);
    }
});

router.post('/lecture', async (req, res) => {
    // Make sure that the form coming from the browser includes all required fields,
    // otherwise return an error. A 400 error means the request was
    // malformed.
    if (!req.body.classroom || !req.body.startTime || !req.body.endTime)
        return res.status(400).send({
            message: "A Class, start time and an end time are required are required"
        });
    try {
        let currentClass = await Class.findOne({
            _id: req.body.classroom._id
        }).populate('class');
        if (!currentClass)
            return res.status(404).send({
                message: "Class not found"
            });
        let newLecture = {
            classID: req.body.classroom._id,
            code: Math.floor(100000 + Math.random() * 900000),
            startTime: req.body.startTime,
            endTime: req.body.endTime,
        };
        currentClass.lectures.push(newLecture);
        await currentClass.save();

        // send back a 200 OK response, along with the class that was found
        return res.send({
            queriedClass: currentClass,
            code: newLecture.code,
        });

    } catch (error) {
        console.log(error);
        return res.sendStatus(500);
    }
});

router.post('/addAttendance', async (req, res) => {
    const curTime = Date.now();
    let matchingLecture = null;
    // Make sure that the form coming from the browser includes all required fields,
    // otherwise return an error. A 400 error means the request was
    // malformed.
    if (!req.body.classID || !req.body.code || !req.body.studentID )
        return res.status(400).send({
            message: "A Class id, Student ID, start time and an end time are required"
        });
    try {
        let lecturesClass = await Class.findOne({_id: req.body.classID }).populate('class');
        if(!lecturesClass) {
            return res.sendStatus(404).send({ message: "Error: Class not found" });
        }
        let lectures = lecturesClass.lectures;
        if (lectures.length < 1) {
            return res.sendStatus(418).send({ message: "Error: Lecture doesn't exist" });
        }
        for (let curLecture of lectures) {
            if ((curLecture.startTime < curTime) && (curLecture.endTime > curTime) && (curLecture.code.toString() === req.body.code)) {
                matchingLecture = curLecture;
                break;
            }
        }
        if (!matchingLecture) {
            return res.sendStatus(401).send({ message: "Error: code invalid or time invalid" });
        }
        let student = await users.model.findOne({_id: req.body.studentID}).populate('user');
        if (!student)
            return res.status(404).send({
                message: "Student not found"
            });
        for (let curAttendance of student.attendances) {
            if (curAttendance.id === matchingLecture.id) {
                return res.sendStatus(418).send( { message: "Error: Attendance already entered"} );
            }
        }

        student.attendances.push(matchingLecture);
        await student.save();
        return res.send({
            student: student,
        });

    } catch (error) {
        console.log(error);
        return res.sendStatus(500);
    }
    });

router.delete('/enrollment/:classid/:studentid', async (req, res) => {
    try {
        const c = await Class.findOne({_id: req.params.classid}).populate('class')

        if(c) {
            console.log(c.students)
            const students = [...c.students]
            const arr = []

            students.forEach(s => {
                if(s._id != req.params.studentid)
                    arr.push(s)
            })

            c.students = arr
            await c.save()
            res.sendStatus(200)
        }

        else {
            res.sendStatus(400, 'Class not found')
        }
    }
    catch(err) {
        res.sendStatus(400, err)
    }
    
})


module.exports = {
    routes: router,
    model: Class,
};