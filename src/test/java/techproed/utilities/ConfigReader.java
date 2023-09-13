package techproed.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    /*
    .properties uzantili dosyaya erisebilmemiz icin Properties class'indan obje olusturmamiz gerekir.
    Bu olusturdugumuz obje ile akisa aldigimiz dosya yolunu load(fis) methodu ile properties dosyasindaki
    key degerini return edebiliriz.
     */
    static Properties properties;
    static {
        String dosyaYolu = "configuration.properties";
        try {
            FileInputStream fis = new FileInputStream(dosyaYolu);
            properties = new Properties();
            properties.load(fis);//-->dis'in okudugu bilgileri properties'e yükler
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getProperty(String key){
        String value = properties.getProperty(key);//-->getProperty(key) methodu properties dosyasindaki key'in degerini verir
        return value;
    }
}
