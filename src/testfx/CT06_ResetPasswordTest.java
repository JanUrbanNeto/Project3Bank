package testfx;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.loadui.testfx.GuiTest;

import javafx.scene.Parent;
import javafx.scene.control.TextArea;

public class CT06_ResetPasswordTest extends GuiTest {
	
	private TestHelper th;
	
	public CT06_ResetPasswordTest() {
		th = new TestHelper();
	}
		

	@Override
	protected Parent getRootNode() {
		Parent parent = th.getRootNode();
		return parent;
	}
	
	@Before
	public void setUp() {
		th.addCustomerTest();
		sleep(1, TimeUnit.SECONDS);
		th.adminLogin();	
	}
	
	@Test
	public void test() {
		click("#resetpassword");
		type("99");
		click("#resetpass");
		sleep(1, TimeUnit.SECONDS);
		TextArea ta = find("#confirmation");
		String r = ta.getText();
		assertThat(r, containsString("New Random Password"));
	}

	@After
	public void tearDown() {
		th.deleteCustomerTest();
	}

}
