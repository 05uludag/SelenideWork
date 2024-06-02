package testRunnerPages;

import Utilities.*;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.BasePage2;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;

public class SeleniumGrid {
    private static final Logger logger = LoggerFactory.getLogger(ImplementSelenide.class);

    //To avoid duplicated name error, generate random texts for Name and Description
    String name = RandomText.generateRandomText(10);
    String description = RandomText.generateRandomText(20);


    @BeforeSuite
    public void setUp(){
        Driver.SetlogInfo("Selenium Grid Run Started");

        Driver.SetlogInfo("Localhost:444/wd/hub configured");
        ConfigGrid.configure();

        Driver.SetlogInfo("Setup configured");
        Driver.BrowserSetup();
        Driver.OpenUrlMaximizeWindow();
        Driver.ConfigScreenshot();
        BasePage2.LoginWithEPAM().shouldBe(Condition.visible).click();
        WaitsPage.FluentlyWaitForVisibility(BasePage2.AddNewDashboard(),45,500);

    }
    @BeforeMethod
    public void RunBeforeEachTests(){
        BrowserUtils.MainDashboardPage();

    }

    @Test
    public void AddNewDashboardTest(){
        BasePage2.AddNewDashboard().shouldBe(Condition.visible, Duration.ofSeconds(30)).click();

        BasePage2.NewDashboardName().shouldBe(Condition.visible,Duration.ofSeconds(10))
                .val(name);

        BasePage2.NewDashboardDescription().val(description);
        BasePage2.AddButton().click();

        logger.info("Adding dashboard completed");
    }

    @Test
    public void RemoveDashboardTest(){
        String name2 = "(//a[contains(@class,\"gridCell__\")])[text()=\""+name+"\"]";
        WaitsPage.FluentlyWaitForVisibility($(By.xpath(name2)),5,500);

        $(By.xpath(name2)).shouldBe(Condition.visible).click();
        BasePage2.DeleteButton().shouldBe(Condition.visible).click();
        BasePage2.RedDeleteButton().click();
    }
    @Test
    public void EditDashboardTest() throws InterruptedException {

        WaitsPage.FluentlyWaitForVisibility(BasePage2.EditElement(),5,500);
        BasePage2.EditElement().shouldBe(Condition.visible).click();
        BasePage2.EditButton().shouldBe(Condition.visible).click();
        BasePage2.NewDashboardName().shouldHave(Condition.visible,Duration.ofSeconds(5))
                .clear();

        String updatedDescription = RandomText.generateRandomText(15);
        BasePage2.NewDashboardName().val("A113");
        BasePage2.NewDashboardDescription().shouldHave(Condition.visible,Duration.ofSeconds(5))
                .val(updatedDescription);

        BasePage2.UpdateButton().click();
        Thread.sleep(2000);

        BrowserUtils.MainDashboardPage();;

        String actualValue = BasePage2.EditElementDescription().getText();

        assertEquals(actualValue,updatedDescription);
    }
    @Test
    public void EditWidgetTest(){
        BasePage2.EditElement().click();
        BasePage2.AddNewWidget().click();
        BrowserUtils.AddWidget(BasePage2.WidgetDurationChart());

        String Actual = $(By.xpath("//span[contains(@class,\"widget\")]"))
                .shouldBe(Condition.visible, Duration.ofSeconds(5))
                .getText();
        String Expected = "Launches duration chart";

        assertEquals(Actual,Expected);

    }
}
