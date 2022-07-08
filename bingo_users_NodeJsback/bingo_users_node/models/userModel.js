var mongoose = require('mongoose'),
    Schema = mongoose.Schema;

var userSchema = new Schema({
    _id: {type: String},
    userName: {type: String},
    password: {type: String}
},{ versionKey: false });

module.exports = mongoose.model('userModel', userSchema);