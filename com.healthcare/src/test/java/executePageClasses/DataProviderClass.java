package executePageClasses;

import utilities.ExcelReadClass;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
  
  @DataProvider(name="unSuccessfulLogin")
  public Object[][] dp() throws IOException {
    return new Object[][] {
      new Object[] { ExcelReadClass.getStringdata(0,2),ExcelReadClass.getStringdata(1,2)},
      new Object[] { ExcelReadClass.getStringdata(0,3),ExcelReadClass.getIntegerdata(1,3)},
      new Object[] { ExcelReadClass.getStringdata(0,4),ExcelReadClass.getIntegerdata(1,4)}
    };
  }
  
  @DataProvider(name="SuccessfulLogin")
  public Object[][] dp1() throws IOException {
    return new Object[][] {
      new Object[] { ExcelReadClass.getStringdata(0,1),ExcelReadClass.getStringdata(1,1)}
 
};

}
}
 