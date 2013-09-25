package dictionary;

import java.util.List;
import java.util.ArrayList;

public class Dictionary implements IDictionaryService{
	private List<String> Dictionary;
	
	public Dictionary() {
		generateDictionary();
	}
	
	public List<String> getDictionary() {
		return this.Dictionary;
	}

	public void generateDictionary() {
		Dictionary = new ArrayList<String>();
		
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
}
