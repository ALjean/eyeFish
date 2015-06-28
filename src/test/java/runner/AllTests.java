package runner;

import com.jean.dao.FishDaoTest;
import org.junit.runners.Suite.SuiteClasses;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by stas on 30.05.15.
 */
@RunWith(Suite.class)
@SuiteClasses(FishDaoTest.class)
public class AllTests {
}
