package dictionary;

import java.io.FileReader;
import java.io.IOException;

import au.com.bytecode.opencsv.CSVReader;

public class DictionaryRepository implements IDictionaryService{
	@Override
	public void generateDictionary() throws IOException{
		CSVReader reader = new CSVReader(new FileReader("dictionary.csv"), ',');
		String [] nextLine;
		int ctr =1;
	    while ((nextLine = reader.readNext()) != null) { //new array for every line
	    	System.out.println("Row " + ctr);
	        System.out.println(nextLine[0]);
	    	System.out.println(nextLine[1]);
	    	System.out.println(nextLine[2]);
	    	System.out.println(nextLine[3] + "\n");
	    	ctr++;
	    }
	}

}
