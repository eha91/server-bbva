const pkey = require('../data/pkey.data');
var controller = {
  pkey: async (req, res) => {
    res.send(pkey);
  },
  raiz: async (req, res) => {

    res.send('Server Up');
  },
  upload: async (req, res) => {
    res.send('upload file')
  }
};

module.exports = controller;
