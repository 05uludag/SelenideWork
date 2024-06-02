package Utilities;
import com.codeborne.selenide.Configuration;


public class ConfigGrid {


    public static void configure() {
        Configuration.remote = "http://localhost:4444/wd/hub";
    }
}
