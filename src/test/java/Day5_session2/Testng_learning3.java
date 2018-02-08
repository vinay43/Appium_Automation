package Day5_session2;

import org.testng.annotations.Test;

public class Testng_learning3 {
	
	@Test
	public void login()
	{
		int Result=4/0;
		System.out.println("login to app");
	}
	
	@Test(dependsOnMethods={"login"})
	public void sendmail()
	{
		System.out.println("sent the mail");
	}
	
	@Test(dependsOnMethods={"sendmail"})
	public void closeapp()
	{
		System.out.println("close the app");
	}

}
