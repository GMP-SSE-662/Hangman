package dictionary;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Dictionary {
	private ArrayList<String> Dictionary = new ArrayList<String>();
	
	public Dictionary() {
		this.Dictionary.add("hello");
		this.Dictionary.add("world");
		this.Dictionary.add("test");
		this.Dictionary.add("programming");
		this.Dictionary.add("software");
		this.Dictionary.add("development");
		this.Dictionary.add("java");
		this.Dictionary.add("hangman");
		this.Dictionary.add("guess");
		this.Dictionary.add("dictionary");
	}

	public ArrayList<String> getDictionary() {
		return Dictionary;
	}
	public void setDictionary(ArrayList<String> dictionary) {
		Dictionary = dictionary;
	}
	
	
}
