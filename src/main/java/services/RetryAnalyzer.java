package services;

import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	int counter = 0;
	int retryLimit = 2;

	@Override
	public boolean retry(ITestResult result) {
		if (counter < retryLimit) {
			System.out.println("Retrying "+ counter+1);
			counter++;
			return true;
		}
		return false;
	}

}
