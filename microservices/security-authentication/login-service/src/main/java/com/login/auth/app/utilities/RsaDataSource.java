package com.login.auth.app.utilities;

import java.io.IOException;

import com.login.auth.app.model.RsaKeyServer;
import com.login.auth.app.utilities.properties.PropertiesFile;

public class RsaDataSource {
	private RsaKeyServer keyServer;
	
	private RsaDataSource() {
		this.setParametersForRsaData();
	}
	
	/**
	 * @return the keyServer
	 */
	public RsaKeyServer getKeyServer() {
		return keyServer;
	}

	private static class RsaDataSourceHolder {
        private static final RsaDataSource INSTANCE = 
            new RsaDataSource();
    }
    
    public synchronized static RsaDataSource getInstance() {
        return RsaDataSourceHolder.INSTANCE;
    }

	private void setParametersForRsaData() {
		PropertiesFile params;
		try {
			params = new PropertiesFile();
			RsaKeyServer.setModulus(params.getProperties().getProperty("rsa.public.modulus"));
			RsaKeyServer.setExponent(params.getProperties().getProperty("rsa.public.exponent"));
			RsaKeyServer.setPrivateExponent(params.getProperties().getProperty("rsa.private.exponent"));
			RsaKeyServer.setPrimeP(params.getProperties().getProperty("rsa.private.primeP"));
			RsaKeyServer.setPrimeQ(params.getProperties().getProperty("rsa.private.primeQ"));
			RsaKeyServer.setDmp(params.getProperties().getProperty("rsa.private.dmp"));
			RsaKeyServer.setDmq(params.getProperties().getProperty("rsa.private.dmq"));
			RsaKeyServer.setCoeff(params.getProperties().getProperty("rsa.private.coeff"));
		} catch (IOException ex) {
			System.out.println("Error de I/O: " + ex.toString());
		}
	}
}
