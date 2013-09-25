package dictionary;

import java.io.FileReader;
import java.io.IOException;

import au.com.bytecode.opencsv.CSVReader;

public class DictionaryRepository implements IDictionaryService{
	@Override
	public void generateDictionary() throws IOException{
		CSVReader reader = new CSVReader(new FileReader("dictionary.csv"));
		String [] nextLine;
	    while ((nextLine = reader.readNext()) != null) {
	        // nextLine[] is an array of values from the line
	    	int ctr = 0;
	        System.out.println(nextLine[ctr]);
	        ctr += 1;
	    }
	}

}
