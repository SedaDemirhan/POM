package tests.day15;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_DriverClassKullanımı {

    @Test
    public void test(){
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("CHUrl"));

       // Driver driver=new Driver();
        //driver class'ından obje üretilmesin istediğimiz için driver class'ı SINGELTON yapıyoruz
        //bunun için default constructor yerine parametresiz bir constructor oluşturup access modifer'ı
        //private seciyoruz

        Driver.closeDriver();
    }

}
