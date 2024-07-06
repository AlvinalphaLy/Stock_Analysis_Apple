package fileprocessors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockFileReader {
	
	String filePath = null; // This var stores the file path of the CSV file to be read
	
	public StockFileReader(String filePath){
		this.filePath = filePath; 
		
//The constructor initializes the filePath variable with 
//the given file path when an object of StockFileReader is created. 		
	}
	
	// Method to Get Headers
	
	public List<String> getHeaders() throws IOException{
//getHeaders reads the first line of the file, which contains the headers		
		
		String line = readFirstLine(filePath); // Read the first line method
		String [] header = line.split(","); // It splits the line by commas to get individual header values.
		List<String> values = new ArrayList<String>();
		values = Arrays.asList(header);
		return values;
	}
	//Static Helper Method to Read the First Line
	
	static String readFirstLine(String path) throws IOException { 
//readFirstLine is a static method that reads and returns the first line of the file specified by path		
	    
		try (BufferedReader br =
	                   new BufferedReader(new FileReader(path))) {
	        return br.readLine();
//It uses a BufferedReader wrapped around a FileReader to read the file.        
	    }
	}
	/**
	 * Complete the body of this method.
	 * @return List
	 * @throws IOException
	 */
	
	// Method to Read File Data
	public List<String> readFileData() throws IOException{
//readFileData reads all lines from the file except the first line (headers). 		
		
		List<String> lines = new ArrayList<String>();
		// Insert your code here..
		
		// BufferedReader to read line by line
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
			
			
			
			br.readLine(); // call skips the header line, read the rest of the lines
			String line = null;
			// advance from the second line onwards
			
			while((line= br.readLine()) != null) {
				lines.add(line);
			}
		}
// "try" with resources, you don't have to close the BufferedReader
	    return lines;
	}
	

}
