package Utilities;
import com.codeborne.selenide.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Driver {
    private static final Logger logger = LoggerFactory.getLogger(Driver.class);

    public static void BrowserSetup(){
        String browserName = ConfigurationReader.get("browser");
        Boolean screenshot = Boolean.valueOf(ConfigurationReader.get("screenshot"));

        if(browserName !=null){
            Configuration.browser = browserName;
            Configuration.screenshots = screenshot;

        } else {
            logger.error("define Browser in configuration.properties");
        }
        logger.info("Browse set to :" + browserName );
        logger.info("Screenshot set to : " + screenshot);
    }

    public static void OpenUrlMaximizeWindow(){
        open(ConfigurationReader.get("url"));
        getWebDriver().manage().window().maximize();

    }
    public static void ConfigScreenshot(){
        Configuration.screenshots = Boolean.parseBoolean(ConfigurationReader.get("screenshot"));
    }

    public static void SetlogInfo (String LogMessage) {
        logger.info(LogMessage);
    }

}
