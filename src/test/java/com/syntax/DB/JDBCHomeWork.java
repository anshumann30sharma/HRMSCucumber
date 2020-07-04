package com.syntax.DB;

import java.sql.*;
import java.util.*;
import java.util.Map.*;
import org.junit.*;
import com.hrms.testbase.*;

public class JDBCHomeWork extends JDBCUtil {

	// HW==>get the resultset metadata store it in the arraylist and retrieve it
	// from arraylist
	// also get column type name get the table names

	@Test
	public void JDBCHW() throws SQLException {

		String query = "SELECT \r\n" + "    emp.emp_number,\r\n" + "    emp.emp_firstname,\r\n"
				+ "    emp.emp_lastname,\r\n" + "    language.name,\r\n" + "    CASE\r\n"
				+ "        WHEN fluency = 1 THEN 'Writing'\r\n" + "        WHEN fluency = 2 THEN 'Speaking'\r\n"
				+ "        WHEN fluency = 1 THEN 'Reading'\r\n" + "        ELSE 'NA'\r\n"
				+ "    END AS FluencyType ,\r\n" + "    CASE\r\n" + "        WHEN competency = 1 THEN 'Poor'\r\n"
				+ "        WHEN competency = 2 THEN 'Basic'\r\n" + "        WHEN competency = 3 THEN 'Good'\r\n"
				+ "        WHEN competency = 4 THEN 'Mother Tongue'\r\n" + "        ELSE 'NA'\r\n"
				+ "    END As CompetencyLevel\r\n" + "FROM\r\n" + "    hs_hr_employees emp\r\n" + "        JOIN\r\n"
				+ "    hs_hr_emp_language lang ON emp.emp_number = lang.emp_number\r\n" + "        JOIN\r\n"
				+ "    ohrm_language language ON lang.lang_id = language.id;";

		executeCode(query);

		// Getting resultset metadata from Query and Storing Column Name & Column Type
		// Name in the List of Maps.
		List<Map<String, String>> column = new ArrayList<>();
	
		Set<String> tableName = new HashSet<>();

		int colNum = getRsMetadata().getColumnCount();

		for (int i = 1; i <= colNum; i++) {
			Map<String, String> metaData = new LinkedHashMap<>();

			String colName = getRsMetadata().getColumnName(i);

			String colType = getRsMetadata().getColumnTypeName(i);

			String tName = getRsMetadata().getTableName(i);

			if (tName.isEmpty()) {
				tableName.add("hs_hr_emp_language");
			} else {
				tableName.add(tName);
			}
			metaData.put(colName, colType);
			column.add(metaData);
		}

		// Retrieving Column Name & Column Type Name from the List of Maps.
		System.out.println("Column Name from the Query Are :");
		System.out.println("ColumnName\t" + "ColumnTypeName" + "\n=======================================");
		for (Map<String, String> mp : column) {
			for (Entry<String, String> s : mp.entrySet()) {
				String colName = s.getKey();
				String colType = s.getValue();
				System.out.print(colName + "\t\t");
				System.out.print(colType + "\n");
			}
		}
		System.out.println("======================================");
		System.out.println("Table Names from the Query are:" + "\n==================================");
		for (String str : tableName) {
			System.out.println(str);
		}
	
		//=====Following Section is not part of HomeWork===
		System.out.println("\n=====Following Section is not part of HomeWork==="+"\n=========Retrieving data from the Query as List of Maps & displaying from it==============\n");

		List<Map<String, String>> dataMap = new ArrayList<>();

		while (getResultSet().next()) {
			Map<String, String> dMap = new LinkedHashMap<>();

			for (int i = 1; i <= colNum; i++) {
				String colName = getRsMetadata().getColumnName(i);
				String data = getResultSet().getObject(i).toString();
				dMap.put(colName, data);
			}
			dataMap.add(dMap);
		}
		
		for(Map<String, String> mData:dataMap) {
			
			for(Entry<String, String> e:mData.entrySet()) {
				String colName=e.getKey();
				String colData=e.getValue();
				System.out.println(colName+"\t = "+colData);
				
			}
			System.out.println("======================================");
			
		}
		
		
	}

}
