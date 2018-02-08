package Day5_session2;

import org.testng.annotations.Test;

public class Testng_learning2 {
	
	@Test(priority=1)
	public void login()
	{
		System.out.println("login to app");
	}
	
	@Test(priority=2)
	public void sendmail()
	{
		System.out.println("sent the mail");
	}
	
	@Test(priority=3)
	public void closeapp()
	{
		System.out.println("close the app");
	}

}
