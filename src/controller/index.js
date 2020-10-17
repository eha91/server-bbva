const pkey = require('../data/pkey.data');
const base64 = require('file-base64');
const convertAudio = require('./speech');

var controller = {
  pkey: async (req, res) => {
    res.send(pkey);
  },
  raiz: async (req, res) => {

    res.send('Server Up');
  },
  upload: async (req, res) => {
    res.send('upload file')
  },
  audio: async (req,res) => {
    let dataBase64 = req.body.data;
    // convertAudio.main(dataBase64).then((result) => {
    //   res.send({
    //     status: 'success',
    //     textAudio: result
    //   });
    // }).catch((e) => {
    //   res.send({
    //     status: 'error',
    //     textAudio: e
    //   })
    // })
    res.send({status:'success'});
  },
  image: async(req,res) => {
    let dataBase64 = req.body.data;
    res.send({status:'success'});
  }
};

module.exports = controller;
