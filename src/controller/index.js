var controller = {
  raiz: async (req, res) => {

    res.send('Server Up');
  },
  upload: async (req, res) => {
    res.status(200);
  }
};

module.exports = controller;
