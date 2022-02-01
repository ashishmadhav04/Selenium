import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.util.HashMap;
import java.util.Map;

public class TestNgListenerFunction extends TestListenerAdapter 
{
	@Override
	public void onTestFailure(ITestResult result)
	{
		System.out.println("Test Case " + result.getName() + " Test Failed");
		System.out.println(result.getStatus());
		long startTime = result.getStartMillis();
		String starttime = new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date (startTime));
		long endTime = result.getEndMillis();
		String endtime = new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date (endTime));
		System.out.println("Start time of the test was: " + starttime);
		System.out.println("End time of the test was: " + endtime);
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Test Case " + result.getName() + " Test passed");
		System.out.println(result.getStatus());
		long startTime = result.getStartMillis();
		String starttime = new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date (startTime));
		long endTime = result.getEndMillis();
		String endtime = new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date (endTime));
		System.out.println("Start time of the test was: " + starttime);
		System.out.println("End time of the test was: " + endtime);

		HashMap<String, String> res = new HashMap<>();
		res.put("TestCase_Name", result.getName());
		res.put("Result_Status", "PASS");
		res.put("Start_Time", starttime);
		res.put("End_Time", endtime);
		System.out.println(res);

	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("Test skipped");
		System.out.println("Start time of the test was: " + result.getStartMillis());
		System.out.println("End time of the test was: " + result.getEndMillis());
		System.out.println("Total duration of test execution was: " + (result.getEndMillis()-result.getStartMillis())/1000 + "seconds");
	}

}
