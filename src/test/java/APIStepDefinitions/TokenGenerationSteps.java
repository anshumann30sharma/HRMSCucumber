package APIStepDefinitions;

import static io.restassured.RestAssured.*;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TokenGenerationSteps {
	/**
	 * Storing token as static variable
	 */
	public static String token;
	/**
	 * BaseURI
	 */
 String BaseURI = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";

	@Given("a JWT is generated")
	public void a_JWT_is_generated() {

		String body1 = "{\r\n" + 
				"  \"email\": \"anshumannsharma48@gmail.com\",\r\n" + 
				"  \"password\": \"Asharma64#@\"\r\n" + 
				"}";
		RequestSpecification generateTokenRequest = given().header("Content-Type", "application/json").body(body1);
		Response generateTokenResponse = generateTokenRequest.when().post("/generateToken.php");
		 String rp=generateTokenResponse.prettyPrint();
		/**
		 * Retrieving token from generate response body and concatenating "Bearer"
		 */
		token = "Bearer " + generateTokenResponse.body().jsonPath().getString("token");
		/**
		 * optional to print out token
		 */
//		 System.out.println(token);

	}
	
//	public static void main(String[] args) {
//		 String BaseURI = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
//		String body1 = "{\r\n" + 
//				"  \"email\": \"anshumannsharma48@gmail.com\",\r\n" + 
//				"  \"password\": \"Asharma64#@\"\r\n" + 
//				"}";
//		RequestSpecification rHeader = given().header("Content-type", ContentType.JSON).body(body1).log().all();
//		
//		Response rp = rHeader.when().post("/generateToken.php");
//		rp.prettyPrint();
//	}
}
