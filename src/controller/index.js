var controller = {
  raiz: async (req, res) => {

    res.send('Server Up');
  },
  upload: async (req, res) => {
    res.send('upload file')
  }
};

module.exports = controller;
