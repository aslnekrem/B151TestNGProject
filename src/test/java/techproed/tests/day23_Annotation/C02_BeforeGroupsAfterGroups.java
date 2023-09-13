package techproed.tests.day23_Annotation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_BeforeGroupsAfterGroups {
    WebDriver driver;
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("En başta beforeSuite çalışır");
    }
    @BeforeGroups({"Ekrem","ASLAN"}) //Buraya parantez icerisinde yazdigimiz String --> parametredir ve bu sekilde gruplayabiliyoruz
    //Istersek de yukaridaki gibi fazla parametrelerde yazip istedigimiz ile baglayabiliyoruz
    public void beforeGroups() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test(groups = "Ekrem") //Bu sekilde groups'un parametresini yazip gruplariz
    public void test01() {
        String amazonUrl = "https://amazon.com";
        driver.get(amazonUrl);
    }

    @Test(groups = "Ekrem")
    public void test02() {
        String youtubeUrl = "https://youtube.com";
        driver.get(youtubeUrl);
        driver.close();
    }
    @Test(groups = "ASLAN")
    public void test03() {
        String facebookUrl = " https://facebook.com";
        driver.get(facebookUrl);
        //Eger @Test i Group'lamadiysak ve daha önce driver baglantilarini yapmadiysak -->
        //ayni driver uzerinde group ile baglamasak da bir sonraki test methodu calisir. daha önce driver'i calistirmissak.
        // Sadece driver.close() yaparsak bir sonraki test methodu calismaz cünkü driver' bu örnekte sadece Group icerisinde bagladik
    }
}

