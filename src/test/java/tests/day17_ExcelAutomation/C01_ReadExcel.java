package tests.day17_ExcelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C01_ReadExcel {
    @Test(groups="birinciGrup")
    public void test() throws IOException {
        // 7.Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/test/java/resources/ulkeler.xlsx";

        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fileInputStream=new FileInputStream(dosyaYolu);

        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        //10. WorkbookFactory.create(fileInputStream)

        //11. Worksheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet=workbook.getSheet("Sayfa1");

        //12. Row objesi olusturun sheet.getRow(index)
        Row row= sheet.getRow(2);
        //13. Cell objesi olusturun row.getCell(index)
        Cell cell= row.getCell(3);

        System.out.println(cell);

    }
    @Test
    public void test2() throws IOException {
        // 7.Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/test/java/resources/ulkeler.xlsx";

        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim

        FileInputStream fileInputStream=new FileInputStream(dosyaYolu);

        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim

          Workbook workbook= WorkbookFactory.create(fileInputStream);

        //10. WorkbookFactory.create(fileInputStream)
    //11. Worksheet objesi olusturun workbook.getSheetAt(index)
 //12. Row objesi olusturun sheet.getRow(index)
//13. Cell objesi olusturun row.getCell(index)

        Cell cell=workbook.getSheet("sayfa1").getRow(5).getCell(3);
        System.out.println(cell);

        //SORU: Secilen hucredeki yazının luanda olduğunu test edin

        //Assert.assertEquals(cell,"Luanda");
        /*cell'in data türü cell,"Luanda" ise string
        data türleri farklı olduğu için bu ikisi equal olamaz*/

        //Cell data türü yazdırılabilir ancak String methodları ile kullanılamaz
        //String manipulation yapmak için Cell data türünü String'e Cast yapmalıyız
        Assert.assertEquals(cell.toString(),"Luanda");
        Assert.assertEquals(cell.getStringCellValue(),"Luanda");

        //indexi 3 olan satırdaki indexi 2 olan hücredeki yazıyı büyük harfle yazdırın

        Cell cell1=workbook.getSheet("Sayfa1").getRow(3).getCell(2);
        System.out.println(cell1.toString().toUpperCase());


        //getlastRow() bize son satırın index'ini verir
        //getPhysicalNumberOfRows() ise fiili olarak kullanılan satır sayısını verir
        System.out.println(workbook.getSheet("Sayfa1").getLastRowNum());//190

        System.out.println(workbook.getSheet("Sayfa1").getPhysicalNumberOfRows());//fiziksel olarak kullanılan sayfa numarasını verir 191

        System.out.println(workbook.getSheet("Sayfa2").getLastRowNum());//190

        System.out.println(workbook.getSheet("Sayfa2").getPhysicalNumberOfRows());//sadece dolu(yazılı) olan satırların sayısını verir
    }

    @Test
    public void test3() throws IOException {
        //tablodaki 2.sütunu bir liste olarak yazdırın

        List<String>ikinciSütun=new ArrayList<>();
        String dosyaYolu="src/test/java/resources/ulkeler.xlsx";
        FileInputStream fileInputStream=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fileInputStream);


        for (int i=0; i<=workbook.getSheet("Sayfa1").getLastRowNum();i++)
        {
          ikinciSütun.add(workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString())  ;
        }
        System.out.println(ikinciSütun);

        //A ile başlayan şehirleri liste yapıp yazırın

        List<String > aıleBaslayanSehirler=new ArrayList<>();

        for (String each:ikinciSütun)
        if(each.startsWith("A")){
            aıleBaslayanSehirler.add(each);
        }
        {
            System.out.println(aıleBaslayanSehirler);

        }
        //Eğer tüm datayı javada kullanılabilir bir collection'a cevirmek istersek
        //en uygun yapı Map olur
        //map için unique degerlere sahip bir sütünu key
        //geriye kalan tüm sütun ları ise virgülle ayrılan string'ler olarak value yapmalıyız
        //key=Turkey value=Ankara,Türkiye,Ankara

        Map<String ,String> ulkelerMap=new HashMap<>();
        String key="";
        String value="";
        for (int i=0; i<=workbook.getSheet("Sayfa1").getLastRowNum();i++) {
            key=workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            key=workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()+","+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()+","+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            ulkelerMap.put(key,value);
        }
        System.out.println(ulkelerMap);

        //Biz java metodlarını ve collectionsları kullanarak excelldeki dtaları manipüle edebileceğimiz
        //ortamına alabiliriz

    }

}
