package com.kafkaapps.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileAppender {
	
	public static void appendData(String filepath, String data) {
		 try {
			 
	            // Open given file in append mode by creating an
	            // object of BufferedWriter class
	            BufferedWriter out = new BufferedWriter(
	                new FileWriter(filepath, true));
	 
	            // Writing on output stream
	            out.write(data);
	            out.newLine();
	            // Closing the connection
	            out.close();
	        }
	 
	        // Catch block to handle the exceptions
	        catch (IOException e) {
	 
	            // Display message when exception occurs
	            System.out.println("exception occurred" + e);
	        }
	}

}
