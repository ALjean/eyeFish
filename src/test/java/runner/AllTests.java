package runner;

import com.jean.dao.TaskDaoTest;
import org.junit.runners.Suite.SuiteClasses;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by stas on 30.05.15.
 */
@RunWith(Suite.class)
@SuiteClasses(TaskDaoTest.class)
public class AllTests {
}
