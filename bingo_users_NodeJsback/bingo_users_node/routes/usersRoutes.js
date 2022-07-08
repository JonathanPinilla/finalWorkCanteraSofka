var express = require('express');
var router = express.Router();
var userModel = require('../models/userModel');

/* GET users listing. */
router.get('/v1/user', async (request, response, next) => {
  try {
    const data = await userModel.find();
    console.log("data = ", data);
    response.json(data);
  } catch (error) {
    console.log(error);
    response.json(error);
  }
});

/**
 * Creates a new user
 */
router.post('/v1/user/registration', async (request, response, next) => {
  try {
    const { _id, userName, password } = request.body;

    const newUser = new userModel({
      _id,
      userName,
      password
    });

    await newUser.save();
    response.json(newUser);
  } catch (error) {
    response.status(500).json({
      message: error.message,
      stack: error.stack
    });
  }

});


/**
 * Find user by id
 */
router.get('/v1/user/:_id', async (request, response, next) => {
  try {
    const data = await userModel.findById(request.params._id);
    response.json(data);
  } catch (error) {
    response.status(500).json({
      message: error.message,
      stack: error.stack
    });
  }
});

/**
 * Loguin request compares body with Bd and return response true or false
 */
router.post('/v1/user/login', async (request, response, next) => {
  try {
    const data = request.body;
    const pass = data.password;
    const email = data._id;
    const existent = await userModel.findById(email);
    if (existent._id == email && pass == existent.password) {
      response.send(true);
    } else {
      response.send(false);
    }
  } catch (error) {
    response.status(500).json({
      message: error.message,
      stack: error.stack
    });
  }
});

/**
 * updates user
 */
router.put('/v1/user/update/:_id', async (request, response, next) => {
  try {
    response.json(await userModel.findByIdAndUpdate(request.params._id, request.body));
  } catch (error) {
    response.status(500).json({
      message: error.message,
      stack: error.stack
    });
  }
});

/**
 * updates user
 */
router.delete('/v1/user/delete/:_id', async (request, response, next) => {
  try {
    response.json(await userModel.findByIdAndDelete(request.params._id));
  } catch (error) {
    response.status(500).json({
      message: error.message,
      stack: error.stack
    });
  }
});

module.exports = router;