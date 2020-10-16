const express = require('express');
const router = express.Router();
const Controller = require('../controller');
const multer  = require('multer')

const useStorage = require('../multer/multer');
const upload = multer({ storage: useStorage })


router.get('/', Controller.raiz);


router.post('/upload', upload.any(), Controller.upload);



module.exports = router;
