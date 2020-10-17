import * as functions from "firebase-functions";
import * as admin from 'firebase-admin';

admin.initializeApp();
exports.pushMessage = functions.https.onRequest(async (req, res) => {
  
    var message = {
    notification: {
        title: "Tienes una nueva notificacion",
        body: "Tu banco",
    }
  }
  const writeResult = await admin.database().ref().child("Usuarios")

  writeResult.once('value').then((snapshot)=>{
    snapshot.forEach(function(data) {
      if (data.val().PhoneNumber === req.body.phonenumber) {
        const token = data.val().token;
       admin.messaging().sendToDevice(token,message);
      }
   });
   res.status(200).send("SE MANDO LA NOTIFICACION");
 }); 
});
