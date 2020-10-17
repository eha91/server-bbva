const express = require('express');
const router = express.Router();
const Controller = require('../controller');
const multer  = require('multer')
const midd = require('../middleware/encrytp');

const useStorage = require('../multer/multer');
const upload = multer({ storage: useStorage })


router.get('/', Controller.raiz);
router.get('/e2e/key', Controller.pkey);

router.post('/upload', upload.single('file'), Controller.upload);

router.post('/audio',midd.decode,Controller.audio);
router.post('/image',midd.decode,Controller.image);

module.exports = router;
