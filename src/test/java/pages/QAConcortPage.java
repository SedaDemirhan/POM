package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class QAConcortPage {

   public WebDriver driver;

   public  QAConcortPage(){

    PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(linkText = "Log in")
    public WebElement loginTusu;

    @FindBy(id="UserName")
    public  WebElement userNameKutusu;

    @FindBy(id="Password")
    public  WebElement passwordKutusu;

    @FindBy(id="btnSubmit")
    public  WebElement loginButonu;

    @FindBy(xpath = "//span[@class='caption-subject font-green-sharp bold uppercase']")
    public WebElement basarılıGirisYazıElementi;

    @FindBy (xpath = "//*[.='Try again please']")
    public WebElement isLoginFailed;

   @FindBy(xpath = "//span[text()='Hotel Management']")
   public WebElement hotelManagementLinki;

   @FindBy(partialLinkText = "Hotel List")
   public WebElement hotelListLink;

   @FindBy(xpath = "//span[text()='Add Hotel']")
   public WebElement addHotelLink;

   @FindBy(id = "Code")
   public WebElement addHotelCodeKutusu;

    @FindBy(id = "btnSubmit")
    public WebElement createHotelSave;

    @FindBy(id = "IDGroup")
    public WebElement selectGroup;

    @FindBy(xpath = "(//div[@class='bootbox-body'])")
    public WebElement htmlalertYazisi;

    @FindBy(xpath = "//button[@class='btn btn-primary']\n")
    public WebElement alertOk;

    @FindBy(partialLinkText = "Hotel Rooms")
    public WebElement hotelRoomsLinki;

    @FindBy(xpath = "//span[text()='Add Hotelroom ']")
    public WebElement addHotelRoomButonu;

    @FindBy(id = "IDHotel")
    public WebElement addRoomIdDropDown;

    @FindBy(id="IDGroupRoomType")
    public WebElement addRoomType;

    @FindBy(id="btnSubmit")
    public WebElement addRoomSaveButonu;

    @FindBy(xpath="//div[@class='bootbox-body']")
    public WebElement addRoomSuccessfulYazısı;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement addRoomAlertOkButonu;

    @FindBy(partialLinkText ="Hotelrooms")
    public WebElement addRoomHotelRoomsLink;

    @FindBy(xpath = "//span[text()='List Of Hotelrooms']")
    public WebElement addRoomHotelRoomListYazısı;

    @FindBy(xpath = "//thead/tr[1]/th")
    public List<WebElement>baslıklarListesi;

    @FindBy(xpath = "//tbody")
    public WebElement tbodyTumu;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement>satırlarListesi;

    @FindBy(xpath = "//tbody//tr[1]")
    public WebElement birinciSatır;

   @FindBy(xpath = "//tbody//tr//td[4]")
   public List<WebElement>dorduncuSatırListesi;

   @FindBy(xpath = "//thead//tr/th")
   public List<WebElement>tbodysütunSayısı;

   @FindBy(xpath = "//thead//tr[1]")
   public List<WebElement>başlıklarİsmi;

   @FindBy(xpath = "//table//tr//td")
   public List<WebElement>tableİcindekiHücre;

   @FindBy(xpath = "//table//tr//th")
   public List<WebElement>tableİçindekiSütunlar;

   @FindBy(xpath = "//tbody//tr//td[5]")
   public List<WebElement>beşinciCoulumblementleri;



 public void ConcortHotelLogin(){
  Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
  QAConcortPage qaConcortPage=new QAConcortPage();
  qaConcortPage.loginTusu.click();
  qaConcortPage.userNameKutusu.sendKeys(ConfigReader.getProperty("CHQValidUsername"));
  qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQValidPassword"));
  qaConcortPage.loginButonu.click();
 }

    public String printData(int satir, int sutun) {
     //örnekteki haliyle 3.satır,5.sütundaki elemanı yazdıralım
    //String xpath=//tbody//tr[3]//td[5]
   //değişmeyecek kısımları String,değişecek kısımları ise parametre ismi olarak yazdık

        String xpath="//tbody//tr["+satir+"]//td["+sutun+"]";


   // @FindBy notasyonu parametreli çalışmadığı için önceki yöntemle locate edelim
     String istenenData=Driver.getDriver().findElement(By.xpath(xpath)).getText();
     System.out.println("satır no :"+satir+",sutun no :"+sutun+"'deki data :"+istenenData);

        return istenenData;
    }
}
