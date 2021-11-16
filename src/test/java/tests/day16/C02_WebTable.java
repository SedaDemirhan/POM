package tests.day16;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.Driver;

public class C02_WebTable {

    @Test
    public void test() throws InterruptedException {
        //● login() metodun oluşturun ve oturum açın.
        //● https://www.concorthotel.com//admin/HotelRoomAdmin adresine gidin
        // ○ Username : manager
        // ○ Password : Manager1!
        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.ConcortHotelLogin();

        qaConcortPage.hotelManagementLinki.click();
        qaConcortPage.hotelRoomsLinki.click();
        //● table() metodu oluşturun
        // ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody


        System.out.println("Tablodaki sütun sayısı :"+qaConcortPage.baslıklarListesi.size());

        // ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        /*Eger tüm tablo body'sini hücrelere ayırmadan tek bir string olarak görmek istersek
        * tüm bodyi tek bir web element olarak locate edebiliriz
        *Bu yaklaşım Tabloda happy hotel varmı gibi sorular için ideal çözüm */
        System.out.println(qaConcortPage.tbodyTumu.getText());

        Thread.sleep(2000);
        Assert.assertTrue(qaConcortPage.tbodyTumu.getText().contains("HAPPY HOTEL"));

        for (WebElement each:qaConcortPage.baslıklarListesi) {
            System.out.println(each.getText());
        }


        //● printRows() metodu oluşturun //tr
        // ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        System.out.println("Tablodaki satır sayısı :"+qaConcortPage.satırlarListesi.size());

        // ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        System.out.println(qaConcortPage.birinciSatır.getText());

        /*Eğer tüm satırları yazdırmak istersek*/
        for (int i=0;i<qaConcortPage.satırlarListesi.size();i++){
            System.out.println(i+1 +". satır :"+ qaConcortPage.satırlarListesi.get(i).getText());
        }
        // ○ 4.satirdaki(row) elementleri konsolda yazdırın.
        for (WebElement each: qaConcortPage.dorduncuSatırListesi) {
            System.out.println(each.getText());

        }

        Driver.closeDriver();
    }
}
