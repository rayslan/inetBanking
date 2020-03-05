package com.inetbanking.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfig {
	
	public static Properties configFile;
	
static {
		
		try {
		
		configFile = new Properties();
			FileInputStream inputStream = new FileInputStream("./config.properties");
			configFile.load(inputStream);
			inputStream.close();
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}

}
