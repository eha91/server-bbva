// const path = require('path');
//const bodyParser = require('body-parser')
const express = require('express');
const morgan = require('morgan');
const bodyParser = require('body-parser')

const app = express();

const indexRoutes = require('./routes/index');

app.set('port', process.env.PORT || 3000);
// parse application/json
app.use(bodyParser.json({limit:'200mb'}))


app.use(morgan('dev'));
app.use(express.urlencoded({extended: false}))  


app.use('/', indexRoutes);

app.listen(app.get('port'), () => {
  console.log(`server on port ${app.get('port')}`);
});
