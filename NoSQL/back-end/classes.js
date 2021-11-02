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