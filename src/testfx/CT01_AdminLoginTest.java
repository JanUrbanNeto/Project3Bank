package testfx;

import org.junit.Test;
import org.loadui.testfx.Assertions;
import org.loadui.testfx.GuiTest;

import javafx.scene.Parent;

public class CT01_AdminLoginTest extends GuiTest{
	
	private TestHelper th;
	
	public CT01_AdminLoginTest() {
		th = new TestHelper();
	}

	@Override
	protected Parent getRootNode() {
		Parent parent = th.getRootNode();
		return parent;
	}
	
	@Test
	public void test() {
		th.adminLogin();
		Assertions.assertNodeExists("#adminid");
	}

}
