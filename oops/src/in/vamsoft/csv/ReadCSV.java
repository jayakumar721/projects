package in.vamsoft.csv;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.vamsoft.model.Poplulation;

public class ReadCSV {

	public static void main(String[] args) throws SQLException, FileNotFoundException, IOException, ClassNotFoundException {
			String fileName = "src/populationdata.csv";
			// Converting CSV file into bean
		try(CSVReader reader = new CSVReader(new FileReader(fileName))) {
			  HeaderColumnNameMappingStrategy<Poplulation> strategy = new HeaderColumnNameMappingStrategy<>();
	            strategy.setType(Poplulation.class);
	            
	            CsvToBean<Poplulation> csvToBean = new CsvToBean<>();
	            List<Poplulation> beanList = csvToBean.parse(strategy, reader);
	            
	            for (Poplulation bean: beanList) {
	                System.out.println(bean);
	            }
			
			//Read DB Credentials using properties file
			Properties prop = new Properties();
			InputStream in = new FileInputStream("src//db.properties");
			prop.load(in);
			
			//DB Connection
			Connection con = null;
			Class.forName(prop.getProperty("db_driver_class"));
			System.out.println("Driver loaded!!!!!!!");
			con = DriverManager.getConnection(prop.getProperty("db_url"), prop.getProperty("db_username"), prop.getProperty("db_password"));
			System.out.println("DB Connected!!!!!");
			con.setAutoCommit(false);
			PreparedStatement prepStmt = con.prepareStatement("insert into population(state_code,district_code,sub_district_code,level,area_name,noofvillages,total_population,male_population,female_population) values (?,?,?,?,?,?,?,?,?)");
			 Iterator<Poplulation> it = beanList.iterator();
			  while(it.hasNext()){
				  Poplulation p = it.next();
				  System.out.println(p.getArea_name()+" "+p.getState_code());
			    prepStmt.setInt(1,p.getState_code());            
			    prepStmt.setInt(2,p.getDistrict_code());
			    prepStmt.setInt(3,p.getSub_district_code());
			    prepStmt.setString(4,p.getLevel());
			    prepStmt.setString(5,p.getArea_name());
			    prepStmt.setInt(6,p.getNoofvillages()); 
			    prepStmt.setLong(7,p.getTotal_population()); 
			    prepStmt.setLong(8,p.getMale_population()); 
			    prepStmt.setLong(9,p.getFemale_population()); 
			    prepStmt.addBatch();   
		} 
			prepStmt.executeBatch();
			con.commit();
			  System.out.println("Inserted Successfully!!!!");
		}catch(BatchUpdateException b) {
			 b.printStackTrace();
		} 

	}
}
