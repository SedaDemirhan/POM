package Practice;

import org.testng.annotations.Test;
import pages.GMIBankPage;

public class Test1_GMIBank_PozitifTest {

    @Test
    public void SignInTest(){
        GMIBankPage gmiBankPage=new GMIBankPage();
        gmiBankPage.GMIBankLogin();

    }
}
