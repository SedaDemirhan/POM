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

        //SORU: Secilen hucredeki yaz??n??n luanda oldu??unu test edin

        //Assert.assertEquals(cell,"Luanda");
        /*cell'in data t??r?? cell,"Luanda" ise string
        data t??rleri farkl?? oldu??u i??in bu ikisi equal olamaz*/

        //Cell data t??r?? yazd??r??labilir ancak String methodlar?? ile kullan??lamaz
        //String manipulation yapmak i??in Cell data t??r??n?? String'e Cast yapmal??y??z
        Assert.assertEquals(cell.toString(),"Luanda");
        Assert.assertEquals(cell.getStringCellValue(),"Luanda");

        //indexi 3 olan sat??rdaki indexi 2 olan h??credeki yaz??y?? b??y??k harfle yazd??r??n

        Cell cell1=workbook.getSheet("Sayfa1").getRow(3).getCell(2);
        System.out.println(cell1.toString().toUpperCase());


        //getlastRow() bize son sat??r??n index'ini verir
        //getPhysicalNumberOfRows() ise fiili olarak kullan??lan sat??r say??s??n?? verir
        System.out.println(workbook.getSheet("Sayfa1").getLastRowNum());//190

        System.out.println(workbook.getSheet("Sayfa1").getPhysicalNumberOfRows());//fiziksel olarak kullan??lan sayfa numaras??n?? verir 191

        System.out.println(workbook.getSheet("Sayfa2").getLastRowNum());//190

        System.out.println(workbook.getSheet("Sayfa2").getPhysicalNumberOfRows());//sadece dolu(yaz??l??) olan sat??rlar??n say??s??n?? verir
    }

    @Test
    public void test3() throws IOException {
        //tablodaki 2.s??tunu bir liste olarak yazd??r??n

        List<String>ikinciS??tun=new ArrayList<>();
        String dosyaYolu="src/test/java/resources/ulkeler.xlsx";
        FileInputStream fileInputStream=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fileInputStream);


        for (int i=0; i<=workbook.getSheet("Sayfa1").getLastRowNum();i++)
        {
          ikinciS??tun.add(workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString())  ;
        }
        System.out.println(ikinciS??tun);

        //A ile ba??layan ??ehirleri liste yap??p yaz??r??n

        List<String > a??leBaslayanSehirler=new ArrayList<>();

        for (String each:ikinciS??tun)
        if(each.startsWith("A")){
            a??leBaslayanSehirler.add(each);
        }
        {
            System.out.println(a??leBaslayanSehirler);

        }
        //E??er t??m datay?? javada kullan??labilir bir collection'a cevirmek istersek
        //en uygun yap?? Map olur
        //map i??in unique degerlere sahip bir s??t??nu key
        //geriye kalan t??m s??tun lar?? ise virg??lle ayr??lan string'ler olarak value yapmal??y??z
        //key=Turkey value=Ankara,T??rkiye,Ankara

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

        //Biz java metodlar??n?? ve collectionslar?? kullanarak excelldeki dtalar?? manip??le edebilece??imiz
        //ortam??na alabiliriz

    }

}
