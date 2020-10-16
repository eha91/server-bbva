const express = require('express');
const router = express.Router();
var ArticleController = require('../controller/article');


router.get('/', ArticleController.raiz);

// router.post('/add', ArticleController.add);

// router.get('/turn/:id', ArticleController.turn);


// router.get('/edit/:id',ArticleController.edit);

// router.post('/edit/:id', ArticleController.postedit);

// router.get('/delete/:id',ArticleController.delete);


module.exports = router;
