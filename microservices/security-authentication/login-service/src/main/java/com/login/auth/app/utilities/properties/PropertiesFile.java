package com.login.auth.app.utilities.properties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {
	private InputStream stdIn = null;
    private Properties propiedades = null;
    private String ruta = "keystore/keystore.properties";
    
    public PropertiesFile () {
    }
    
    public PropertiesFile (String file) {
        this.ruta = file;
    }
    
    public Properties getProperties() throws IOException {
        try {
            this.propiedades = new Properties();
            this.stdIn = PropertiesFile
                    .class
                    .getClassLoader()
                    .getResourceAsStream(ruta);
            if ( this.stdIn == null ) {
                throw new
                    FileNotFoundException("File not found: " + ruta);
            } else {
                this.propiedades.load(this.stdIn);
            }
            if ( this.propiedades.isEmpty() ) {
                return null;
            } else {
                return this.propiedades;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if ( this.stdIn != null )
                this.stdIn.close();
        }
    }

}
