package com.syntax.DB;

import java.sql.DatabaseMetaData;
import java.util.*;
import java.util.Map.*;

import org.apache.commons.collections4.iterators.EntrySetMapIterator;
import org.junit.*;

import com.hrms.utils.JDBCUtil;

public class Recap extends JDBCUtil {
	
	@Test
	public void getConnected() {
		
//		DBInfo();
		
		List<Map<String, String>> queryData=dataListMap("select id, name, country_code from ohrm_location");
		
		for (Map<String,String> mp:queryData) {
			
			for(Entry<String, String> data:mp.entrySet()) {
				
				String colName=data.getKey();
				String colData=data.getValue();
				System.out.println(colName+" = "+colData);
				
			}
			System.out.println("\n======================================");
		}
		
	}

}
