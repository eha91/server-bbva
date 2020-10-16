// const path = require('path');
const express = require('express');
const morgan = require('morgan');


const app = express();

const indexRoutes = require('./routes/index');

app.set('port', process.env.PORT || 3000);

app.use(morgan('dev'));
app.use(express.urlencoded({extended: false}))  

app.use('/', indexRoutes);

app.listen(app.get('port'), () => {
  console.log(`server on port ${app.get('port')}`);
});
