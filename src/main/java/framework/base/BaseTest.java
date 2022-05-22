package framework.base;

import framework.DriverStart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    @BeforeTest
    public void setUp() {
        logger.info("Driver start");
        DriverStart.getInstance();
    }

    @AfterTest
    public void tearDown() {
        logger.info("Driver tearDown");
        DriverStart.quit();
    }
}

