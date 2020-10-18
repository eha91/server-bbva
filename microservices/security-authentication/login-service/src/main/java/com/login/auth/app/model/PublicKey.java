package com.login.auth.app.model;

public class PublicKey {
	private String modulus;
	private String exponent;
	
	public PublicKey() {}
	
	public PublicKey(String modulus, String exponent) {
		this.modulus = modulus;
		this.exponent = exponent;
	}
	
	/**
	 * @return the modulus
	 */
	public String getModulus() {
		return modulus;
	}
	/**
	 * @return the exponent
	 */
	public String getExponent() {
		return exponent;
	}
	/**
	 * @param modulus the modulus to set
	 */
	public void setModulus(String modulus) {
		this.modulus = modulus;
	}
	/**
	 * @param exponent the exponent to set
	 */
	public void setExponent(String exponent) {
		this.exponent = exponent;
	}
}
