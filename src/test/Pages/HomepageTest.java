import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertEquals;

public class HomepageTest {

    HomePage home = new HomePage();

    @Test
    public void Test1(){

        //open page url
        home.open();

        home.LoginWithEpam().click();
    }
    @Test
    public void Test2() throws InterruptedException {
        home.open();

        home.LoginWithEpam().click();
        Thread.sleep(30000);

        List<String> expectedLinksText = List.of("DASHBOARD NAME", "DESCRIPTION", "OWNER", "EDIT", "DELETE");
        List<String> MyListTexts = home.LinkLists().texts();
        assertEquals(MyListTexts,expectedLinksText);
    }
}
