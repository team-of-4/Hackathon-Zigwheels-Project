package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static void savetoExcel(String sheetName,Map<String,String[]> bikeUnder4Lac) {
		
		FileOutputStream file = null;
		try {
			file = new FileOutputStream(System.getProperty("user.dir")+"/ouput_excel.xlsx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		int rowNo = bikeUnder4Lac.size()+1;
		
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet s = wb.createSheet(sheetName);
		XSSFRow r0 = s.createRow(0);
		r0.createCell(0).setCellValue("Bike Name");
		r0.createCell(1).setCellValue("Price");
		r0.createCell(2).setCellValue("Release Date");
		
		Set<String> keys = bikeUnder4Lac.keySet();
		
		int i = 1;
		for(String str : keys) {
			XSSFRow r = s.createRow(i);
			i++;
			r.createCell(0).setCellValue(str);
			r.createCell(1).setCellValue(bikeUnder4Lac.get(str)[0]);
			r.createCell(2).setCellValue(bikeUnder4Lac.get(str)[1]);
		}
		
		try {
			wb.write(file);
			wb.close();
			file.close();
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Write Sucessfully");
				
		
	}
	
	public static void writeIntoExistingExcel(String sheetname ,List<String> carmodels) throws IOException {
		
		FileInputStream file = new FileInputStream(new File(".\\ouput_excel.xlsx"));
		
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet s = wb.createSheet(sheetname);
		XSSFRow r0 = s.createRow(0);
		r0.createCell(0).setCellValue("Popular car models");
		
		for(int i=1;i<=carmodels.size();i++) {
			
			XSSFRow r = s.createRow(i);
			r.createCell(0).setCellValue(carmodels.get(i-1));
			
		}
		
		FileOutputStream f = new FileOutputStream(".\\ouput_excel.xlsx");
		wb.write(f);
		wb.close();
		f.close();
		file.close();
		System.out.println("write sucessfully");
		
	}
	
	
}
