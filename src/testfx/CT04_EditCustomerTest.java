package testfx;

import static org.loadui.testfx.Assertions.verifyThat;
import static org.loadui.testfx.controls.Commons.hasText;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.loadui.testfx.GuiTest;

import javafx.scene.Parent;
import javafx.scene.input.KeyCode;

public class CT04_EditCustomerTest extends GuiTest {
	
	private TestHelper th;
	
	public CT04_EditCustomerTest() {
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
		click("#editcustomer");
		type("99");
		click("#load");
		click("#cusphone").press(KeyCode.BACK_SPACE).release(KeyCode.BACK_SPACE).type("8");
		sleep(1, TimeUnit.SECONDS);
		click("#save");
		verifyThat("#confirmation", hasText("Customer Info Updated Successfully"));
	}

	@After
	public void tearDown() {
		th.deleteCustomerTest();
	}

}
