package web.ns.utilities;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty {
	
	int test;
	
	public static Properties FileReader(String location){
		Properties property = new Properties();
		FileInputStream file=null;
		try {
			file = new FileInputStream(location);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			property.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return property;

	}

}
