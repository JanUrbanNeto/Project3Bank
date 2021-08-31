package testfx;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.loadui.testfx.Assertions;
import org.loadui.testfx.GuiTest;

import javafx.scene.Parent;

public class CT11_AccountInfoTest extends GuiTest {
	
private TestHelper th;
	
	public CT11_AccountInfoTest() {
		th = new TestHelper();
	}

	@Override
	protected Parent getRootNode() {
		Parent parent = th.getRootNode();
		return parent;
	}
	
	@Before
	public void setUp() {
		th.userLogin("1");
	}
	
	@Test
	public void test() {
		click("#accountInfo");
		type("1");
		click("#loadInfo");
		sleep(1, TimeUnit.SECONDS);
		Assertions.assertNodeExists("#uid");
	}
	
	@After
	public void tearDown() {
	}	

}
