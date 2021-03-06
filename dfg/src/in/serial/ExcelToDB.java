package in.serial;

import java.io.FileInputStream;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelToDB {

  @SuppressWarnings({ "deprecation", "resource", "rawtypes" })
  public static void main(String[] args) {
    Connection con = null;
    try {

      Class.forName("oracle.jdbc.driver.OracleDriver");
      con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "password");
      PreparedStatement preparedStatement = con.prepareStatement("insert into exam values(?,?)");
      InputStream fis = new FileInputStream("Untitled.xls");
      HSSFWorkbook workbook = new HSSFWorkbook(fis);
      HSSFSheet sheet = workbook.getSheetAt(0);
      HSSFRow row;
      HSSFCell cell;

      Iterator rows = sheet.rowIterator();

      while (rows.hasNext()) {
        row = (HSSFRow) rows.next();
        if (row.getRowNum() != 0) {
          Iterator cells = row.cellIterator();
          int index = 1;
          while (cells.hasNext()) {
            cell = (HSSFCell) cells.next();

            if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
              System.out.print(cell.getStringCellValue() + " ");
              preparedStatement.setString(index, cell.getStringCellValue());
            } else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
              System.out.print(cell.getNumericCellValue() + " ");
              preparedStatement.setString(index, String.valueOf(cell.getNumericCellValue()));
            } else if (cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
              System.out.print(cell.getBooleanCellValue() + " ");
              preparedStatement.setString(index, String.valueOf(cell.getBooleanCellValue()));
            }
            index++;

          }
          System.out.println();
          System.out.println(preparedStatement.executeUpdate() + " Row inserted");
        }

      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

}
