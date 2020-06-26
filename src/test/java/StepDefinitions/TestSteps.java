package StepDefinitions;

import java.util.*;
import com.hrms.utils.*;
import io.cucumber.java.en.*;

public class TestSteps extends CommonMethod {
	
	List<Map<String, String>> dataFromUI;
	
	@Given("Naviagte to Reports Page")
	public void naviagte_to_Reports_Page() {
		report.navigateToDefineReportPage();
	}
	
	@When("user retrieve all data from the ui")
	public void user_retrieve_all_data_from_the_ui() {
	   
	
	}

	@And("user retrieves all the data from database using below query")
	public void user_retrieves_all_the_data_from_database_using_below_query(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	 
	}

	@Then("user compare both data and it should match.")
	public void user_compare_both_data_and_it_should_match() {

	}

	@And("user logs out")
	public void user_logs_out() {

	}
	

}
