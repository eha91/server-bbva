/**
 * 
 */
package com.login.auth.app.security;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Service;

import com.login.auth.app.model.RsaKeyServer;
import com.login.auth.app.utilities.RsaDataSource;

/**
 * @author hackers
 *
 */
@Service("e2e-info")
public class E2eInfoProcess implements IProcess {

	public E2eInfoProcess() {
		RsaDataSource data = RsaDataSource.getInstance();
		data.getKeyServer();
	}
	
	private RSAPrivateCrtKeySpec getPrivateCrtSpecKey() {
		final String modulus = RsaKeyServer.getModulus();
		final String exponent = RsaKeyServer.getExponent();
		final String pexponent = RsaKeyServer.getPrivateExponent();
		final String P = RsaKeyServer.getPrimeP();
		final String Q = RsaKeyServer.getPrimeQ();
		final String Dmp1 = RsaKeyServer.getDmp();
		final String Dmq1 = RsaKeyServer.getDmq();
		final String Coeff = RsaKeyServer.getCoeff();
		return new RSAPrivateCrtKeySpec(new BigInteger(modulus, 16),
				new BigInteger(exponent, 16), new BigInteger(pexponent, 16), new BigInteger(P, 16),
				new BigInteger(Q, 16), new BigInteger(Dmp1, 16), new BigInteger(Dmq1, 16),
				new BigInteger(Coeff, 16));
	}
	
	/**
	 * Decryption process
	 */
	@Override
	public String doProcess(String encryptedCredential) {
		final RSAPrivateCrtKeySpec privatecKeySpec = this.getPrivateCrtSpecKey();
		RSAPrivateKey privateKey = null;
		String bioInfo = null;
		try {
			String[] encryptedCredentialSplitted = encryptedCredential.split("\\.");
			String encryptedInfo = encryptedCredentialSplitted[0];

			KeyFactory rsaFactory = KeyFactory.getInstance("RSA");
			// private key
			privateKey = (RSAPrivateKey) rsaFactory.generatePrivate(privatecKeySpec);

			// RSA decryption process
			final byte[] encryptedInfoBytes = Base64.getDecoder().decode(encryptedInfo);
			final Cipher rsaCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			rsaCipher.init(Cipher.DECRYPT_MODE, privateKey);
			final byte[] plainTextBytes = rsaCipher.doFinal(encryptedInfoBytes);
			final String originalMessage = DatatypeConverter.printHexBinary(plainTextBytes);
			System.out.println("originalMessage: " + originalMessage);
			String plainText = new String(plainTextBytes, StandardCharsets.UTF_8);
			System.out.println("Output: " + plainText);

			// AES decryption process
			encryptedCredentialSplitted = plainText.split("\\.");
			String hexEK = encryptedCredentialSplitted[0];
			String hexIV = encryptedCredentialSplitted[1];
			String encryptedAESInfo = encryptedCredentialSplitted[2];
			final byte[] iv = DatatypeConverter.parseHexBinary(hexIV);
			final byte[] decodedKey = DatatypeConverter.parseHexBinary(hexEK);
			final byte[] encryptedBytesAesInfo = Base64.getDecoder().decode(encryptedAESInfo);
			
			byte[] cipherSr = new byte[encryptedBytesAesInfo.length - 16]; // delete padding
			System.arraycopy(encryptedBytesAesInfo, 16, cipherSr, 0, encryptedBytesAesInfo.length - 16);
			
			final SecretKey AESEncryptionKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
			final Cipher aesCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			aesCipher.init(Cipher.DECRYPT_MODE, AESEncryptionKey, new IvParameterSpec(iv));
			final byte[] srBytes = aesCipher.doFinal(cipherSr);
			bioInfo = new String(srBytes);
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}

		return bioInfo;
	}
}
