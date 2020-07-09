package com.syntax.DB;

import java.util.*;
import java.util.Map.*;
import org.junit.*;
import com.hrms.testbase.JDBCUtil;
public class EnhancedStoreData extends JDBCUtil {

	@Test
	public void storeData() {
		String query1="select * from ohrm_language";
		List<Map<String, String>> column = dataListMap(query1);

		for (Map<String, String> mData : column) {

			for (Entry<String, String> e : mData.entrySet()) {
				String colName = e.getKey();
				String colData = e.getValue();
				
				if(colName.contentEquals("id")) {
					colName="Language_id";
				}else if(colName.contentEquals("name")) {
					colName="Language Name";
				}
				System.out.println(colName + "\t = " + colData);
			}
			System.out.println("======================================");
		}
	}
}
