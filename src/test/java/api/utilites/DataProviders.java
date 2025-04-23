package api.utilites;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "Data")
	public String[][] getAllData() throws IOException {
		String path = ".\\testData\\UserData.xlsx";
		ExcelUtility xlUtil = new ExcelUtility(path);

		int totalRowCount = xlUtil.getRowCount("Sheet1");
		int totalCellCount = xlUtil.getCellCount("Sheet1", 1);

		String apiData[][] = new String[totalRowCount][totalCellCount];

		for (int i = 1; i <= totalRowCount; i++) {
			for (int j = 0; j < totalCellCount; j++) {
				apiData[i - 1][j] = xlUtil.getCellData("Sheet1", i, j);
			}
		}
		return apiData;
	}

	@DataProvider(name = "UserNames")
	public String[] getUserNames() throws IOException {
		String path = ".\\testData\\UserData.xlsx";
		ExcelUtility xlUtil = new ExcelUtility(path);

		int rownum = xlUtil.getRowCount("Sheet1");

		String apiData[] = new String[rownum];

		for (int i = 1; i <= rownum; i++) {

			apiData[i - 1] = xlUtil.getCellData("Sheet1", i, 1);

		}
		return apiData;
	}
}
