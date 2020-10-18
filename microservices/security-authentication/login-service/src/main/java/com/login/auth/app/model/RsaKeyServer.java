package com.login.auth.app.model;

public class RsaKeyServer {
	private static String modulus;
	private static String exponent;
	private static String privateExponent;
	private static String primeP;
	private static String primeQ;
	private static String dmp;
	private static String dmq;
	private static String coeff;

	/**
	 * @return the modulus
	 */
	public static String getModulus() {
		return modulus;
	}
	/**
	 * @return the exponent
	 */
	public static String getExponent() {
		return exponent;
	}
	/**
	 * @return the privateExponent
	 */
	public static String getPrivateExponent() {
		return privateExponent;
	}
	/**
	 * @return the primeP
	 */
	public static String getPrimeP() {
		return primeP;
	}
	/**
	 * @return the primeQ
	 */
	public static String getPrimeQ() {
		return primeQ;
	}
	/**
	 * @return the dmp
	 */
	public static String getDmp() {
		return dmp;
	}
	/**
	 * @return the dmq
	 */
	public static String getDmq() {
		return dmq;
	}
	/**
	 * @return the coeff
	 */
	public static String getCoeff() {
		return coeff;
	}
	/**
	 * @param modulus the modulus to set
	 */
	public static void setModulus(String modulus) {
		RsaKeyServer.modulus = modulus;
	}
	/**
	 * @param exponent the exponent to set
	 */
	public static void setExponent(String exponent) {
		RsaKeyServer.exponent = exponent;
	}
	/**
	 * @param privateExponent the privateExponent to set
	 */
	public static void setPrivateExponent(String privateExponent) {
		RsaKeyServer.privateExponent = privateExponent;
	}
	/**
	 * @param primeP the primeP to set
	 */
	public static void setPrimeP(String primeP) {
		RsaKeyServer.primeP = primeP;
	}
	/**
	 * @param primeQ the primeQ to set
	 */
	public static void setPrimeQ(String primeQ) {
		RsaKeyServer.primeQ = primeQ;
	}
	/**
	 * @param dmp the dmp to set
	 */
	public static void setDmp(String dmp) {
		RsaKeyServer.dmp = dmp;
	}
	/**
	 * @param dmq the dmq to set
	 */
	public static void setDmq(String dmq) {
		RsaKeyServer.dmq = dmq;
	}
	/**
	 * @param coeff the coeff to set
	 */
	public static void setCoeff(String coeff) {
		RsaKeyServer.coeff = coeff;
	}
}
