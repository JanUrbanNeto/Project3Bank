package testfx;

import org.junit.Test;
import org.loadui.testfx.Assertions;
import org.loadui.testfx.GuiTest;

import javafx.scene.Parent;

public class CT07_UserLoginTest extends GuiTest {
	
private TestHelper th;
	
	public CT07_UserLoginTest() {
		th = new TestHelper();
	}

	@Override
	protected Parent getRootNode() {
		Parent parent = th.getRootNode();
		return parent;
	}
	
	@Test
	public void test() {
		th.userLogin("1");
		Assertions.assertNodeExists("#welcome");
	}

}
