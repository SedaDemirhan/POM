package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class DriverCross {
    private DriverCross(){

    }
    private static WebDriver driver;

    //driver'ı başka classlardan sadece driver class ismi ile cağırabilmek için STATİC yaptık
    //henüz bu driver ile ilgili ayarlar yapmadığmız için classlar bunu yanlışlıkla kullanmasın diye
    //erişimi private yaptık(sadece bu classın kullanımına acık yaptık)

    public static WebDriver getDriver(String browser) {

        if (driver == null) {
            //if'i bu method her çalıştığında yeni bir driver oluşturmaması için kullanıyoruz
            //if driver'ı kontrol edecek eger bir değer ataması yapıldıysa yeni bir driver oluşturmayacak
            //browser=browser==null ? ConfigReader.getProperty("browser") :browser;
            switch (browser) {
                // case'i driver'i istedigimiz browser'da calistirmak icin kullaniyoruz
                // configuration.properties dosyasinda browser olarak ne yazdiksa tum testlerimiz o browser'da calisacak
                // browser secimi yapilmadiysa default olarak chrome devreye girecek
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();

            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }
        return driver;
    }
    public static void closeDriver(){
        if(driver!=null){
            driver.quit();
        }
        // burada yeniden null degeri atamamizin sebebi. bir sonraki getDriver method'u cagirisimizda
        // yeni deger atayabilmek istememizdir.
        driver=null;
    }
}
