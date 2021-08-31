package testfx;

import static org.loadui.testfx.Assertions.verifyThat;
import static org.loadui.testfx.controls.Commons.hasText;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.loadui.testfx.GuiTest;

import javafx.scene.Parent;

public class CT05_DeleteCustomerTest extends GuiTest {
	
private TestHelper th;
	
	public CT05_DeleteCustomerTest() {
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
		click("#deletecustomer");
		type("99");
		click("#load");
		sleep(1, TimeUnit.SECONDS);
		click("#delete");
		verifyThat("#confirmation", hasText("Successfully Removed The Customer"));
	}

	@After
	public void tearDown() {
		
	}

}
