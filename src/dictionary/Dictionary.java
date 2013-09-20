package dictionary;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Dictionary {
	private Map<Integer, String> Dictionary;
	
	public Dictionary() {
		Dictionary.put(1, "hello");
		Dictionary.put(2, "world");
		Dictionary.put(3, "test");
		Dictionary.put(4, "programming");
		Dictionary.put(5, "software");
		Dictionary.put(6, "development");
		Dictionary.put(7, "java");
		Dictionary.put(8, "hangman");
		Dictionary.put(9, "guess");
		Dictionary.put(10, "dictionary");
	}

	public Map<Integer, String> getDictionary() {
		return Dictionary;
	}
	public void setDictionary(Map<Integer, String> dictionary) {
		Dictionary = dictionary;
	}
	
	
}
