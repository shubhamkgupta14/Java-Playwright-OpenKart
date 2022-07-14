package stepDefTest;

import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.Given;

public class TestStepDef {

	@Given("Pass Step")
	public void pass_step() {
		assertEquals(true, true);
	}

	@Given("Fail Step")
	public void fail_step() {
		assertEquals(true, false);		
//		assertEquals(true, true);
	}

}
