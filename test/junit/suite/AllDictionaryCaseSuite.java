package junit.suite;

import junit.suite.tests.DictionaryRepositoryCase;
import junit.suite.tests.DictionaryCase;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DictionaryRepositoryCase.class, DictionaryCase.class})
public class AllDictionaryCaseSuite {

}
