package restApi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class BaseClass {

	public Properties prop;

	public BaseClass() {

		
		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream("C:\\Users\\mishrrit\\eclipse-workspace\\RestAssured\\src\\main\\resources\\config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
