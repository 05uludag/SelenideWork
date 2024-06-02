package Utilities;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.BasePage2;

import java.time.Duration;


public class BrowserUtils {

    static WebDriver driver = WebDriverRunner.getWebDriver();
    static Actions actions = new Actions(driver);
    public static void clickWithJS(SelenideElement element) {
       // Driver.Setlog("Click with JS");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public static void ActionDragAndDrop(SelenideElement firstPoint, SelenideElement lastPoint){
      // Driver.Setlog("Drag and Drop the Element");

        actions.dragAndDrop(firstPoint,lastPoint).perform();
    }
    public static void ResizeElement(SelenideElement resizeElement, int width, int height) {
        Actions actions = new Actions(resizeElement.getWrappedDriver());

        actions.clickAndHold(resizeElement)
                .moveByOffset(width,height).release().perform();
    }
    public static void ResizeElementByJS(SelenideElement resizeElement, int width, int height){
        String script ="arguments[0].style.width='"+width+"px'; arguments[0].style.height='"+height+"px';";
        ((JavascriptExecutor) driver).executeScript(script, resizeElement);
    }
    public static void MainDashboardPage(){
        BasePage2.ProjectSelector().shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        BasePage2.PersonelProject().shouldBe(Condition.visible,Duration.ofSeconds(10)).click();
        WaitsPage.FluentlyWaitForVisibility(BasePage2.DashboardSeen(),10,500);
    }
    public static void AddWidget(SelenideElement element){
        element.click();
        BasePage2.Widget_NextStep().click();
        BasePage2.Widget_DEMO_FILTER().click();
        BasePage2.Widget_NextStep().click();
        BasePage2.AddButton().click();

    }


}
