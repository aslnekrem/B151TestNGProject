package techproed.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {
    @DataProvider
    public static Object[][] sehirVerileri() {

        return new Object[][]{{"Ankara","IcAnadolu","06"},{"Izmir","Ege","05"},{"Diyarbakir","Dogu","21"}};
    }
}
