package Utilitities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	
	public static String takeScreenshot(WebDriver driver, String Filename) throws IOException {
		String logFileName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
		Filename = Filename + logFileName + ".png";
		String directory = "C:\\Users\\mishrrit\\eclipse-workspace\\TestNGProject\\Screenshots\\";
		String FileReturn = directory+Filename;
		File Sourcefile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Sourcefile,new File(FileReturn));
		return FileReturn;
		
	}

}
