const CryptoJS = require("crypto-js");


module.exports = {
    decode: (req,res,next) => {
        console.log('body: ',req.body);
        const encrypt = req.body.data.split('.');
        const cryptoMessage = encrypt[0];
        const hash = encrypt[1];


        next();
    }
}