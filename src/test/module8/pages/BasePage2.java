package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class BasePage2 {
    public static SelenideElement DashboardSeen(){return Selenide.$(By.xpath("//span[contains(@class,\"headerCell__title-f\")][text()=\"Dashboard Name\"]"));}

    public static SelenideElement UpdateButton(){return Selenide.$(By.xpath("//button[@type=\"button\"][text()=\"Update\"]"));}
    public static SelenideElement EditButton(){return Selenide.$(By.xpath("(//span[contains(@class,\"ghost\")])[text()=\"Edit\"]"));}
    public static SelenideElement EditElement(){return Selenide.$(By.xpath("(//a[contains(@class,\"gridCell__\")])[text()=\"A113\"]"));}
    public static SelenideElement EditElementDescription(){return Selenide.$(By.xpath("(//a[contains(@class,\"gridCell__\")])[text()=\"A113\"]/following-sibling::div[1]"));}

    public static SelenideElement RemovedElement(){return Selenide.$(By.xpath("(//a[contains(@class,\"gridCell__\")])[text()=\"38VoofukFz\"]"));}
    public static SelenideElement PersonelProject(){return Selenide.$(By.xpath("(//a[@href=\"#kultigin_uludag_personal\"])[1]"));}
    public static SelenideElement ProjectSelector(){return Selenide.$(By.xpath("(//div[contains(@class,\"tooltip__tooltip-trigger-\")])[1]"));}
    public static SelenideElement All_Dashboard_Button(){return Selenide.$(By.xpath("//a[@href=\"#kultigin_uludag_personal/dashboard\"][text()=\"All Dashboards\"]"));}
    public static SelenideElement ZA111(){return Selenide.$(By.xpath("(//a[contains(@class,\"gridCell__grid-cell\")])[text() =\"ZA111\"]"));}
    public static SelenideElement LoginWithEPAM(){return Selenide.$(By.xpath("//button/span"));}
    public static SelenideElement ResizeWidget(){return Selenide.$(By.xpath("//span[@class=\"react-resizable-handle react-resizable-handle-se\"]"));
    }
    public static SelenideElement AddNewDashboard(){ return Selenide.$(By.xpath("//span[normalize-space()=\"Add New Dashboard\"]"));}
    public static SelenideElement NewDashboardName(){ return Selenide.$(By.xpath("//input[@placeholder=\"Enter dashboard name\"]"));}
    public static SelenideElement NewDashboardDescription(){ return Selenide.$(By.xpath("//textarea[@placeholder=\"Enter dashboard description\"]"));}
    public static SelenideElement AddButton(){ return Selenide.$(By.xpath("//div/button[normalize-space()=\"Add\"]"));}
    public static ElementsCollection AllDashboardNames(){
        return Selenide.$$(By.xpath("//a[@class=\"gridCell__grid-cell--EIqeC gridCell__align-left--DFXWN dashboardTable__name--t2a89\"]"));}
    public static SelenideElement DeleteButton(){ return Selenide.$(By.xpath("//span[text()='Delete']"));}
    public static SelenideElement RedDeleteButton(){ return Selenide.$(By.xpath("//button[contains(@class,\"bigButton__color-tomato\") and text()='Delete']"));}
    public static SelenideElement SideBarDashboard(){ return Selenide.$(By.xpath("//span[text()=\"Dashboards\"]/../i"));}
    public static SelenideElement EnterWidgetDashboard(){ return Selenide.$(By.xpath("//a[contains(@class,\"gridCell__grid-cell--EIqeC\") and text()='EnterWidgetTest_1']"));}
    public static SelenideElement AddNewWidget(){ return Selenide.$(By.xpath("(//button/span[normalize-space()=\"Add new widget\"])[1]/.."));}
    public static SelenideElement Widget_NextStep(){ return Selenide.$(By.xpath("//button/span[normalize-space()=\"Next step\"]/.."));}
    public static SelenideElement Widget_DEMO_FILTER(){ return Selenide.$(By.xpath("//span[@class=\"filterName__name-wrapper--nfl7l\"]"));}
    public static SelenideElement WidgetDurationChart(){ return Selenide.$(By.xpath("(//span[contains(@class,\"inputRadio__children-c\")])[3]"));}




}
