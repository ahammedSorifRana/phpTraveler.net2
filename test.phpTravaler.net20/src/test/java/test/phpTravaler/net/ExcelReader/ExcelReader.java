package test.phpTravaler.net.ExcelReader;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	FileInputStream xInput;
	XSSFWorkbook xbook;
	XSSFSheet xSheet;
	
	public ExcelReader(String FilePath) {
		
		File xFile = new File(FilePath);
	
				try {
					 xInput = new FileInputStream(xFile);
					 xbook = new XSSFWorkbook(xInput);
				} catch (Exception e) {
					System.out.println("Excel connection problem"+e.getMessage());
				} 
			}
	public String[][] getExcelData( int SheetNumber) {
		String Value= null;
		 xSheet = xbook.getSheetAt(SheetNumber);
		int RowNum = xSheet.getLastRowNum();
		int calNum = xSheet.getRow(0).getLastCellNum();
		
		String[][] ExData = new String[RowNum][calNum];
		
		for(int i=0;i<RowNum;i++) {
			XSSFRow row = xSheet.getRow(i+1);
			for(int j=0;j<calNum;j++) {
				XSSFCell cell = row.getCell(j);
				
				Value = ChangeTheValue(cell);
				ExData[i][j] = Value;
			}
			
		
			
		}
		
		try {
			xInput.close();
			xbook.close();
		
		} catch (Exception e) {
			System.out.println("Excel close Exception");
		}
		return ExData;
		
	}
	
	/**
	 * it will return the String value of cell
	 * @param cell
	 * @return
	 */
	private String ChangeTheValue(XSSFCell cell) {
		Object CellValue;
		String Result = null;
		
		if(cell==null) {
			
			Result ="";
			
		}
		else {
			
			if(cell.getCellTypeEnum() == CellType.STRING){
			
			Result = cell.getStringCellValue();
				}
			else if(cell.getCellTypeEnum()==CellType.NUMERIC){
				CellValue =(int) cell.getNumericCellValue();
				Result = CellValue.toString();
			
				}
			
			
		}
		return Result;
	}

}
