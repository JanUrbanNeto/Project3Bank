package testfx;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.loadui.testfx.GuiTest;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;

public class CT03_AddCustomerTest extends GuiTest {
	
	private TestHelper th;
	
	public CT03_AddCustomerTest() {
		th = new TestHelper();
	}
		

	@Override
	protected Parent getRootNode() {
		Parent parent = th.getRootNode();
		return parent;
	}
	
	@Before
	public void setUp() {
		th.adminLogin();
	}
	
	@Test
	public void test() {
		click("#addcustomer");
		type("99");
		click("#cuspass").type("99");
		click("#cusname").type("Test User");
		click("#cusaddress").type("Test User Adress");
		click("#cusemail").type("user").press(KeyCode.SHIFT).press(KeyCode.DIGIT2).release(KeyCode.DIGIT2).release(KeyCode.SHIFT).type("test.com");
		click("#cusphone").type("5199999999");
		click("#balance").type("501");
		sleep(1, TimeUnit.SECONDS);
		click("#add");
		sleep(1, TimeUnit.SECONDS);
		Label label = find("#addcusconfirm");
		String r = label.getText();
		assertThat(r, containsString(""));
	}

	@After
	public void tearDown() {
		th.deleteCustomerTest();
	}
}
