import com.codeborne.selenide.Configuration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;


public class LaunchDifferentBrowsers {
    @Test
    public void launchBrowsertest() throws InterruptedException {
        Configuration.browser ="chrome";
        Configuration.screenshots =true;

        open("https://reportportal.epam.com/ui/#login");
        //Configuration.startMaximized = true;

        //Burada Login Buttonu Webelement'e atmadan direk tıkladık
        // Bunu webElement'e de atabilirdim ---> SelenideElement MyButton = $(By.xpath(---)); şeklinde syntax bu
        $(By.xpath("//button[@type=\"button8\"]")).click();
        Thread.sleep(30000);

    }


}
