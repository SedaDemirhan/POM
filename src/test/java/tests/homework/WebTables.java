package tests.homework;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.Driver;

public class WebTables {
    @Test
    public void test(){
        //●Bir class oluşturun : D18_ WebTables
        //●login() metodun oluşturun ve oturum açın.
        //●https://qa-environment.concorthotel.com/admin/HotelRoomAdmin adresine gidin
        //○Username : manager
        // ○Password : Manager1!
        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.ConcortHotelLogin();

        //●table() metodu oluşturun
        //○Tüm table body’sinin boyutunu(s utun sayisi ) bulun. /tbody
        System.out.println("Tbody içindeki sütün saysısı :"+qaConcortPage.tbodysütunSayısı.size());

        //○Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        System.out.println(qaConcortPage.tbodyTumu.getText());
        for (WebElement each:qaConcortPage.başlıklarİsmi) {
            System.out.println(each.getText());

        }
        //●printRows() metodu oluşturun //tr
        //○table body’sinde bulunan toplam satir(row) sayısını bulun.
        System.out.println(qaConcortPage.satırlarListesi.size());

        //○Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (int i=0;i<qaConcortPage.satırlarListesi.size();i++){
            System.out.println(i+1 +".Satır :"+qaConcortPage.satırlarListesi.get(i).getText());
        }
        //○4.satirdaki(row) elementleri konsolda yazdırın.
        for (WebElement each: qaConcortPage.dorduncuSatırListesi) {
            System.out.println("4.satır elementi :"+ each.getText());

        }

        //●printCells() metodu oluşturun //td
        //○table body’sinde bulunan toplam hücre(cell) sayısını bulun.
        System.out.println("Toplam hücre sayısı :"+ qaConcortPage.tableİcindekiHücre.size());

        //○Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
        for (int i=1;i<qaConcortPage.tableİcindekiHücre.size();i++){
            System.out.println(i+" "+qaConcortPage.tableİcindekiHücre.get(i).getText());
        }

        //●printColumns() metodu oluşturun
        //○table body’sinde bulunan toplam sutun(column) sayısını bulun.
        System.out.println("Table içindeki sütünların sayısı :"+qaConcortPage.tableİçindekiSütunlar.size());

        //○Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
        for (WebElement each :qaConcortPage.tableİçindekiSütunlar) {
            System.out.println("Table body deki elementler :"+each.getText());

        }
        //○5.column daki elementleri konsolda yazdırın.
        for (WebElement each:qaConcortPage.beşinciCoulumblementleri) {
            System.out.println("beşinci coulumb elementleri :"+ each.getText());

        }

        Driver.closeDriver();

    }
}
