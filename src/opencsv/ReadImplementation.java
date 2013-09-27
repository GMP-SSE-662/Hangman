package opencsv;

import java.util.List;
import java.io.FileReader;
import java.io.IOException;

import au.com.bytecode.opencsv.CSVReader;

/**
 * opencsv test implementation
 * @author zurcnay4
 */
public class ReadImplementation {
	/**
	 * reads per line
	 */
	public static void readLineFromCSV() throws IOException{
		CSVReader reader = new CSVReader(new FileReader("sample.csv"), ',');
		String [] nextLine;
		int ctr =1;
	    while ((nextLine = reader.readNext()) != null) { //new array for every line
	    	System.out.println("Row " + ctr);
	        System.out.print(nextLine[0] + " ");
	    	System.out.print(nextLine[1] + " ");
	    	System.out.print(nextLine[2] + " ");
	    	System.out.print(nextLine[3] + "\n");
	    	ctr++;
	    }
	    reader.close();
	}
	/**
	 * reads all
	 */
	public static void readAllFromCSV() throws IOException {
		CSVReader reader = new CSVReader(new FileReader("sample.csv"), ',');
	    List<String[]> sampleList = reader.readAll();
	    int ctr =1;
	    for(String[] str : sampleList) {
	    	System.out.println("Row " + ctr);
	    	System.out.print(str[0] + " ");
	    	System.out.print(str[1] + " ");
	    	System.out.print(str[2] + " ");
	    	System.out.print(str[3] + "\n");
	    	ctr++;
	    }
	    reader.close();
	}
}
