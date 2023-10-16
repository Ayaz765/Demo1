package Data_driven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;





public class Datafromexcel {

	public ArrayList<String> getData(String TestCaseName) throws IOException {
		
		ArrayList<String> a= new ArrayList<String>();
		
		FileInputStream fis= new FileInputStream("C:\\Users\\Ayaz.Ahamad\\Testdatame.xlsx");
		
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		
		int sheet=workbook.getNumberOfSheets();
		
		for(int i=0;i<sheet;i++)
		{
			
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
			{
				
				//to get the testcase column we are searching the rows
				XSSFSheet sheetone=workbook.getSheetAt(i);
				
				//sheet is the collection of row
				Iterator<Row> rows=sheetone.iterator();
				Row firstrow= rows.next();
				//row is collection of cell
				Iterator<Cell> ce=firstrow.cellIterator();
				int k=0;
				int column=0;
				while(ce.hasNext())
				{
					Cell value=ce.next();
					if(value.getStringCellValue().equalsIgnoreCase("TestCases"))
					{
						
						column=k;
					}
					k++;
				}
				
				
				//once column has been indenfied then scan whole column to get exact row
				
				while(rows.hasNext())
				{
				Row r=	rows.next();
				
				if(r.getCell(column).getStringCellValue().equalsIgnoreCase(TestCaseName))
				{
					//after we have pull out the purchase row then pull out all data of the row
					
					Iterator<Cell> cv=r.cellIterator();
					while(cv.hasNext())
					{
						a.add(cv.next().getStringCellValue());
					}
				}
				}
				
			}
			
		}
		return a;

	}


}
