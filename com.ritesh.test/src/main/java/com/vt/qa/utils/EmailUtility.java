package com.vt.qa.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

import com.vt.qa.base.TestBase;

public class EmailUtility extends TestBase{
	String EmailFrom = getEmailFrom();
	String EmailTo = getEmailTo();
	String HostName = getEmailHostName();
	String SmtpPort = getEmailSMTPPort();
	boolean SSLHost = getSSLHost();
	
	
	public void SimpleTextEmail() throws EmailException {
	
	System.out.println(" Start");
	Email email = new SimpleEmail();
	email.setHostName(HostName);
	System.out.println(HostName);
	
	email.setSmtpPort(Integer.parseInt(SmtpPort));
	System.out.println(SmtpPort);
	email.setSSLOnConnect(SSLHost);
	System.out.println(SSLHost);
	email.setAuthenticator(new DefaultAuthenticator("youradorablesanta@gmail.com","alti.ritesh@gmail.com"));
	email.setFrom(EmailFrom);
	System.out.println(EmailFrom);
	email.addTo(EmailTo);
	System.out.println(EmailTo);
	email.setSubject("this is for test ");
	email.setMsg(" this is the first email shoot from selenium");
	email.send();
	System.out.println("email sent");
	
	
	}
	
	public void SendEmailWithAttachment() throws EmailException {
		EmailAttachment attachment = new EmailAttachment();
		  attachment.setPath("C:\\Users\\mishrrit\\eclipse-workspace\\com.ritesh.test\\test-output\\testng-results.xml");
		  attachment.setDisposition(EmailAttachment.ATTACHMENT);
		  attachment.setDescription("TestNg Result");
		  attachment.setName("TestNg.xml");

		  // Create the email message
		  MultiPartEmail email = new MultiPartEmail();
		  email.setHostName(HostName);
			System.out.println(HostName);
			
			email.setSmtpPort(Integer.parseInt(SmtpPort));
			System.out.println(SmtpPort);
			email.setSSLOnConnect(SSLHost);
			System.out.println(SSLHost);
			email.setAuthenticator(new DefaultAuthenticator("youradorablesanta@gmail.com","alti.ritesh@gmail.com"));
			email.setFrom(EmailFrom);
			System.out.println(EmailFrom);
			email.addTo(EmailTo);
			System.out.println(EmailTo);
			email.setSubject("------------------------Test Email from Selenium---------------------- ");
			email.setMsg(" this is the first email shoot from selenium");

		  // add the attachment
		  email.attach(attachment);

		  // send the email
		  email.send();
	}
	
	public void SendHTMLFormattedEmail() throws EmailException, IOException {	
		/*// load your HTML email template
		  String htmlEmailTemplate = ".... <img src=\"http://www.apache.org/images/feather.gif\"> ....";
		  

		  // define you base URL to resolve relative resource locations
		  URL url = new URL("http://www.apache.org");*/
		//  String path ="C:\\Users\\mishrrit\\eclipse-workspace\\com.ritesh.test\\test-output\\emailable-report.html";
		  String Html = HtmlSourceCode();
		  System.out.println(Html);
		  // create the email message
		  ImageHtmlEmail email = new ImageHtmlEmail();
		 // email.setDataSourceResolver(new DataSourceUrlResolver(url));
		  email.setHostName(HostName);
			System.out.println(HostName);
			
			email.setSmtpPort(Integer.parseInt(SmtpPort));
			System.out.println(SmtpPort);
			email.setSSLOnConnect(SSLHost);
			System.out.println(SSLHost);
			email.setAuthenticator(new DefaultAuthenticator("youradorablesanta@gmail.com","alti.ritesh@gmail.com"));
			email.setFrom(EmailFrom);
			System.out.println(EmailFrom);
			email.addTo(EmailTo);
			System.out.println(EmailTo);
			email.setSubject("------------------------Test Email from Selenium---------------------- ");
			
		  
		  // set the html message
	//	  email.setHtmlMsg(htmlEmailTemplate);
		  email.setHtmlMsg(Html);
		  // set the alternative message
		  email.setTextMsg("Your email client does not support HTML messages");

		  // send the email
		  email.send();
		
	}
	
	public String HtmlSourceCode() throws IOException {
		
		/*String path ="C:\\Users\\mishrrit\\eclipse-workspace\\com.ritesh.test\\test-output\\emailable-report.html";
		File file = new File(path);
		
	//	BufferedReader in = new BufferedReader(file);
        String inputLine;
        StringBuilder a = new StringBuilder();
        while ((inputLine = in.readLine()) != null)
            a.append(inputLine);
        in.close();

        System.out.println(a.toString());*/
		/*String file ="C:\\Users\\mishrrit\\eclipse-workspace\\com.ritesh.test\\test-output\\emailable-report.html";
		FileReader fileReader = new FileReader(file);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(fileReader);
		@SuppressWarnings("resource")
		BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\mishrrit\\eclipse-workspace\\com.ritesh.test\\test-output\\newFile.txt"));
		String s;

		while ((s = br.readLine()) !=null) {
		    System.out.println(s);
		            out.write(s);
		        
		    }*/
		String pathname ="C:\\Users\\mishrrit\\eclipse-workspace\\com.ritesh.test\\test-output\\emailable-report.html";
		File file = new File(pathname);
	    StringBuilder fileContents = new StringBuilder((int)file.length());
	    Scanner scanner = new Scanner(file);
	    String lineSeparator = System.getProperty("line.separator");

	    try {
	        while(scanner.hasNextLine()) {
	            fileContents.append(scanner.nextLine() + lineSeparator);
	            System.out.println("in");
	        }
	        return fileContents.toString();
	    } finally {
	        scanner.close();
	    }
	}

}
