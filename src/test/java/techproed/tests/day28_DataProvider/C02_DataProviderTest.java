package techproed.tests.day28_DataProvider;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.GooglePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C02_DataProviderTest {
    @DataProvider
    public static Object[][] arabalar() {
        return new Object[][]{{"volvo"},{"audi"},{"mercedes"},{"ford"}};
    }

    /*
        Google sayfasına gidip
        DataProvider ile belirtilen araç isimlerini aratalım
         */
    @Test(dataProvider = "arabalar")
    public void test01(String araclar) {
        //Google sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));


        //Dataprovider'daki verilerle arama yapalım
        GooglePage googlePage = new GooglePage();
        googlePage.cerezleriKapatma.click();
        googlePage.aramaKutusu.sendKeys(araclar);
        googlePage.aramaKutusu.submit();
        ReusableMethods.bekle(2);

        //Her arama icin sayfa resmi alalim
        ReusableMethods.tumSayfaResmi(araclar);

        //Sayfayi kapatalim
        Driver.closeDriver();







    }
}
