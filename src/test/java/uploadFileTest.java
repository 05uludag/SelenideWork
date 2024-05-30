import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class uploadFileTest {
    @Test
    public void uploadfileOnVisibleInput(){

        //file data nın altındaki png yi upload edeceğim
        $(By.xpath("//")).uploadFile(new File("src/test/data/sample.png"));

        //click upload button
        SelenideElement UploadButton = $(By.xpath("//"));
        UploadButton.click();
    }

    @Test
    public void  uploadFileOnHiddenInput(){
        //choose file yok html i manipule et
        //class = "file_input_hidden" diyor bunu remove edeceksin
        //html de consolu aç ve şu kodu yaz
        //document.getelementById("upfile_1").classList.remove("file_input_hidden")
        // undefined diyecek

        // java script execute ettireceksin bu komutu

        executeJavaScript("document.getelementById(\"upfile_1\").classList.remove(\"file_input_hidden\")");

        //şimdi upload ed
        $("#upfile_1").uploadFile(new File("src/test/data/sample.png"));



    }
}
