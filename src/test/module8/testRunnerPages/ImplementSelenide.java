package testRunnerPages;

import static pages.BasePage2.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import Utilities.RandomText;
import pages.BasePage2;
import Utilities.BrowserUtils;
import Utilities.WaitsPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Utilities.ConfigurationReader;
import java.time.Duration;


public class ImplementSelenide {
    private static final Logger logger = LoggerFactory.getLogger(ImplementSelenide.class);
    String name = RandomText.generateRandomText(10);
    String description = RandomText.generateRandomText(20);

    @BeforeSuite
    public void setUp(){
        logger.info("Setup configured");
        Configuration.browser=ConfigurationReader.get("browser");
        open(ConfigurationReader.get("url"));
        getWebDriver().manage().window().maximize();
        Configuration.screenshots = Boolean.parseBoolean(ConfigurationReader.get("screenshot"));
        BasePage2.LoginWithEPAM().shouldBe(Condition.visible).click();
        WaitsPage.FluentlyWaitForVisibility(AddNewDashboard(),45,500);

    }
    @BeforeTest
    public void SetCurrentDashboardsList(){
        BasePage2.ProjectSelector().shouldBe(Condition.visible,Duration.ofSeconds(10)).click();
        BasePage2.PersonelProject().shouldBe(Condition.visible,Duration.ofSeconds(10)).click();

    }

    @Test
    public void AddDashboard() throws InterruptedException {
        logger.info("Adding new DAshboard Start");
        //open(ConfigurationReader.get("url"));
        //basepage.LoginWithEPAM().shouldBe(Condition.visible).click();
        WaitsPage.FluentlyWaitForVisibility(AddNewDashboard(),45,500);
        BasePage2.AddNewDashboard().shouldBe(Condition.visible, Duration.ofSeconds(30));
        BasePage2.AddNewDashboard().click();
        BasePage2.NewDashboardName().shouldBe(Condition.visible,Duration.ofSeconds(10));
        BasePage2.NewDashboardName().val(name);
        BasePage2.NewDashboardDescription().val(description);
        BasePage2.AddButton().click();
        WaitsPage.FluentlyWaitForVisibility(BasePage2.All_Dashboard_Button(),20,500);
        BasePage2.All_Dashboard_Button().shouldBe(Condition.visible,Duration.ofSeconds(5));
        logger.info("Adding dashboard completed");

    }
    @Test
    public void JsAndActionTest() throws InterruptedException {
        //Scroll to element and click by Js
        logger.info("Scroll with Js and click the element by JS used clickWithJS method used");
        BrowserUtils.clickWithJS(BasePage2.ZA111());
        //with action method resize the widget
        logger.info("Resize the element my action method performed");
        BrowserUtils.ResizeElement(BasePage2.ResizeWidget(),50,50);
        Thread.sleep(5000);
        //BrowserUtils.ResizeElementByJS(basepage.ResizeWidget(), 500,500);
        //with action method it was seen that element resized, but it was reverted back
        //On the other hand it was resized by JS, and it was Ok no reverted back
        logger.info("JsAndActionTest was completed");

    }

}
