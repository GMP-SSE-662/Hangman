package junit;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import dictionary.DictionaryRepository;

public class DictionaryRepositoryTest {

	@Test
	public void testGenerateDictionary() throws IOException {
		DictionaryRepository dr = new DictionaryRepository();
		assertNotNull(dr.getDictionary());
	}

}
