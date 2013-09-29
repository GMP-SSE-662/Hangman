package junit.suite;

import junit.MachineTest;
import junit.PlayerTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AllDictionaryTest.class, MachineTest.class, PlayerTest.class })
public class AllTest {

}
