package com.syntax.DB;

import java.util.*;
import java.util.Map.Entry;

import org.junit.*;

import com.hrms.utils.*;

public class DbTest extends JDBCUtil {
	@Test
	public void mapTest() {
		
		String query = "SELECT \r\n" + "    emp.emp_number,\r\n" + "    emp.emp_firstname,\r\n"
				+ "    emp.emp_lastname,\r\n" + "    language.name,\r\n" + "    CASE\r\n"
				+ "        WHEN fluency = 1 THEN 'Writing'\r\n" + "        WHEN fluency = 2 THEN 'Speaking'\r\n"
				+ "        WHEN fluency = 1 THEN 'Reading'\r\n" + "        ELSE 'NA'\r\n"
				+ "    END AS FluencyType ,\r\n" + "    CASE\r\n" + "        WHEN competency = 1 THEN 'Poor'\r\n"
				+ "        WHEN competency = 2 THEN 'Basic'\r\n" + "        WHEN competency = 3 THEN 'Good'\r\n"
				+ "        WHEN competency = 4 THEN 'Mother Tongue'\r\n" + "        ELSE 'NA'\r\n"
				+ "    END As CompetencyLevel\r\n" + "FROM\r\n" + "    hs_hr_employees emp\r\n" + "        JOIN\r\n"
				+ "    hs_hr_emp_language lang ON emp.emp_number = lang.emp_number\r\n" + "        JOIN\r\n"
				+ "    ohrm_language language ON lang.lang_id = language.id";
		
		String query1="Select emp_number,emp_firstname, emp_lastName from hs_hr_employees where emp_number='6961';";
		
		List<Map<String, String>>dListMap=dataListMap(query1);
		
		for(Map<String, String> mData:dListMap) {
			
			for(Entry<String, String> e:mData.entrySet()) {
				String colName=e.getKey();
				String colData=e.getValue();
				System.out.println(colName+"\t = "+colData);
				
			}
			System.out.println("======================================");
			
		}
		
	}

}
