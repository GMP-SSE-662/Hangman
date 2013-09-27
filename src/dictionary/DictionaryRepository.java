package dictionary;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class DictionaryRepository implements IDictionaryService{
	private List<String []> Dictionary;
	
	public DictionaryRepository() throws IOException {
		generateDictionary();
	}
	
	public List<String[]> getDictionary() {
		return Dictionary;
	}

	@Override
	public void generateDictionary() throws IOException{
		CSVReader reader = new CSVReader(new FileReader("dictionary.csv"));
		Dictionary = (ArrayList<String []>) reader.readAll();
		reader.close();
	}

}
