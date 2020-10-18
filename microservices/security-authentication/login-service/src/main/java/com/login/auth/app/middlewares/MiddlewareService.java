/**
 * Import packages
 */
package com.login.auth.app.middlewares;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.login.auth.app.model.EncryptionMessage;
import com.login.auth.app.model.PublicKey;
import com.login.auth.app.model.RsaKeyServer;
import com.login.auth.app.security.IProcess;
import com.login.auth.app.utilities.RsaDataSource;

/**
 * @author hackathon
 *
 */
@RestController
public class MiddlewareService {

	@Autowired
	@Qualifier("e2e-info")
	private IProcess e2eProcess;

	@GetMapping("/e2e/key")
	public ResponseEntity<?> getPublicKey() {
		RsaDataSource data = RsaDataSource.getInstance();
		data.getKeyServer();
		String modulus = RsaKeyServer.getModulus();
		data.getKeyServer();
		String exponent = RsaKeyServer.getExponent();
		PublicKey pk = new PublicKey(modulus, exponent);
		Map<String, String> json = new HashMap<>();
		json.put("modulus", modulus);
		json.put("exponent",exponent);
		return new ResponseEntity<Map<String, String>>(json, HttpStatus.OK);
	}
	
	@PostMapping("/security/login")
	public ResponseEntity<?> getConfiguration(@RequestBody EncryptionMessage encryptedCredential) {
		Map<String, String> json = new HashMap<>();
		final String bioImage = this.e2eProcess.doProcess(encryptedCredential.getEncryptedCredential());
		json.put("bioImage", bioImage);
		return new ResponseEntity<Map<String, String>>(json, HttpStatus.OK);
	}
}
