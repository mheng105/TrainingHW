package training.hw3.utils;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import training.hw3.log.LogHelper;

import java.io.File;
import java.io.FileInputStream;
import java.text.MessageFormat;

public class ExcelConfig {

    XSSFWorkbook wb;
    XSSFSheet ws;

    public ExcelConfig(String path) {
        File src = new File(path);
        try {
            FileInputStream fis = new FileInputStream(src);
            wb = new XSSFWorkbook(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getRowNumber(int sheetIndex) {
        ws = wb.getSheetAt(sheetIndex);
        return ws.getLastRowNum();
    }

    public int getColumnNumber(int sheetIndex) {
        ws = wb.getSheetAt(sheetIndex);
        return ws.getRow(0).getLastCellNum();
    }

    public String getDataValue(int sheetIndex, int row, int col) {
        ws = wb.getSheetAt(sheetIndex);
        DataFormatter dfm = new DataFormatter();
        return dfm.formatCellValue(ws.getRow(row).getCell(col));
    }

    public Object[][] data() {
        int rowNum = getRowNumber(0);
        int colNum = getColumnNumber(0);
        int currentRow = 0;
        Object[][] object = new Object[rowNum][colNum];
        for (int i = 1; i <= rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                object[currentRow][j] = getDataValue(0, i, j);
                LogHelper.getLogger().info(MessageFormat.format("{0}",object[currentRow][j]));
            }
            currentRow++;
        }
        return object;
    }
}
