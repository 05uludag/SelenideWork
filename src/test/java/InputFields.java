import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;


public class InputFields {

    /**
     * Burada Aşağıdaki Input Fields lar bakılacaak
     * Text Input Field, * Dropdown, * Checkbox, * Date
     */

    @Test
    public void testformFields(){
        //Open url bu url login olmadan ulaşamazsın 2fa istiyor v.s
        open("https://reportportal.epam.com/ui/#kultigin_uludag_personal/dashboard");
        //TextField bul ve değeri yazdır
        SelenideElement Name = $(By.xpath("//input[contains(@class,\"input__\")]"));
        Name.val("DashboardName Set");

        //direk yazdır description
        $(By.xpath("//textarea[contains(@class,\"inputTextArea\")]")).val("Description Set");


    }
    /** DropDown Menu
     * <select id ="evf-80" class="input">
     *      <option value = "Quick Support Team">Quick Support</option>
     *      <option value = "Tehchnical Team">Tehchnical</option>
     *      <option value = "Sales Team">Sales</option>
     * </select>
     */

    @Test
    public void TestDropDown (){
        SelenideElement MyDropdown = $(By.xpath("//"));
        MyDropdown.selectOption("Tehnical Team");
    }

    @Test
    public void  TestDateCalendar(){
        // once tıkla takvim açılsın
        SelenideElement tikla = $(By.xpath("//"));
        tikla.click(); // Takvim açıldı
        // date seç şimdi

    }



}
