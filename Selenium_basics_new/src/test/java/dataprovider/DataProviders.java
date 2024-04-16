package dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="InvalidUserCredentials")
	public Object[][] userCredentialsData() {
		Object  data[][]= new String[3][2];
		
		data[0][0]="shameemathasnim.ma123@gmail.com";
		data[0][1]="shameema123";
		
		data[1][0]="shameemathasnim.ma@gmail.com";
		data[1][1]="shameema123";
		
		data[2][0]="shameemathasnim.ma@gmail.com";
		data[2][1]="Resiya123";
		
		return data;
	}

}
