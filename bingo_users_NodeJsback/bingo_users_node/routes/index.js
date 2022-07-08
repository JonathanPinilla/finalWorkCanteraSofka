var express = require('express');
var router = express.Router();
const userModel = require('../models/userModel');

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'NodeJs and Express' });
});


module.exports = router;
