package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CSV {
	
	//This function will read data from a CSV file and return as a list
	public static List<String[]> read(String file) {
		List<String[]> data = new LinkedList<String[]>();
		BufferedReader reader;
		String dataRow;
		try {
			reader = new BufferedReader(new FileReader(file));
			while ((dataRow = reader.readLine()) != null) {
				String[] dataRecords = dataRow.split(",");
				data.add(dataRecords);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("FILE NOT FOUND!!!");
		} catch (IOException e) {
			System.out.println("CAN'T READ DATA FROM FILE!!!");
		}
		return data; 	
	}
	
}
