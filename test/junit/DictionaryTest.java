package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import dictionary.Dictionary;

public class DictionaryTest {

	@Test
	public void testGenerateDictionary() {
		Dictionary dictionary = new Dictionary();
		assertNotNull(dictionary.getDictionary());
	}

}
