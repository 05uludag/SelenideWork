import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static org.testng.Assert.*;

public class HomeTest {

    @Test
    public void TestPageUrlAndTitle() {
        open("https://reportportal.epam.com/ui/#login");

        String url = WebDriverRunner.url();

        assertEquals(url, "https://reportportal.epam.com/ui/#login");

        System.out.println(title());
        String title = title();

        assertEquals(title, "Report Portal");

    }

    @Test
    public void ClickLoginWithEpam() {
        open("https://reportportal.epam.com/ui/#login");
        String LoginName = $(By.xpath("//button[@type=\"button\"]/span")).
                getText();
        System.out.println(LoginName);

        $(By.xpath("//button[@type=\"button\"]/span")).
                shouldHave(text("Login with EPAM"));

        $(By.xpath("//button[@type=\"button\"]/span")).should(be(visible));

    }

    @Test
    public void multipleElement() throws InterruptedException {
        open("https://reportportal.epam.com/ui/#login");

        //Burada Login Buttonu Webelement'e atmadan direk tıkladık
        // Bunu webElement'e de atabilirdim ---> SelenideElement MyButton = $(By.xpath(---)); şeklinde syntax bu
        $(By.xpath("//button[@type=\"button\"]")).click();
        Thread.sleep(30000);

        List<String> expectedLinksText = List.of("DASHBOARD NAME", "DESCRIPTION", "OWNER", "EDIT", "DELETE");

        //Burada WebElement List Bunu Dikkat "ElementCollection" olarak tanımladım --->  List<WebElement>  ***= findElements gibi
        ElementsCollection MyList = $$(By.xpath("//div[contains(@class,\"headerCell__header-cell--DCFQq \")]"));

        List<String> MylistTexts = MyList.texts();

        assertEquals(MylistTexts,expectedLinksText);



    }
}
