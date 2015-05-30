package runner;


import com.jean.config.TestConfiguration;
import com.jean.dao.TaskDao;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * Created by stas on 30.05.15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =TestConfiguration.class, loader=AnnotationConfigContextLoader.class)
public class BaseTest {

    @Autowired
    protected TaskDao taskDao;


}
