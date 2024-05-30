import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HomePage {

    //Browser açıp url ye gidelim

    public HomePage open() {
        Selenide.open("https://....");
        return this;
    }



    //elementleri buraya atayım locate edip

    public SelenideElement LoginWithEpam(){
        return $(By.xpath("//button[@type=\"button\"]/span"));
    }

    public ElementsCollection LinkLists(){

        return $$(By.xpath("//div[contains(@class,\"headerCell__header-cell--DCFQq \")]"));
    }
}
