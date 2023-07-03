package Dataset;

import org.testng.annotations.DataProvider;

public class Dataset {
    @DataProvider(name = "data-provider-emi")
    public Object[][] setData() {
        return new Object[][]{
                {10000, 9, 2, 2, 456.85, 964.34, 200, 10964.34},
                {325000, 9.5, 5, 1.5, 6825.6, 84536.3, 4875, 409536.3},
                {450000, 11.0, 7, 1.8, 7705.1, 197228.1, 8100, 647228.1},
                {99000000, 9.5, 4, 1.25, 2487190.53, 20385145.46, 1237500, 119385145.46},
                {50000, 14.25, 9, 2.2, 824.02, 38994.07, 1100, 88994.07}
        };
    }
}
