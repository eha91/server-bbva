package com.login.auth.app.model;

public class EncryptionMessage {
	private String encryptedCredential;

	/**
	 * @return the encryptedCredential
	 */
	public String getEncryptedCredential() {
		return encryptedCredential;
	}

	/**
	 * @param encryptedCredential the encryptedCredential to set
	 */
	public void setEncryptedCredential(String encryptedCredential) {
		this.encryptedCredential = encryptedCredential;
	}
}
