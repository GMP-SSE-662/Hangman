package junit.suite;

import junit.suite.tests.MachineCase;
import junit.suite.tests.PlayerCase;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AllDictionaryCaseSuite.class, MachineCase.class, PlayerCase.class })
public class AllMavenTest {

}
