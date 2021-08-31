package testfx;

import static org.hamcrest.Matchers.greaterThan;
import static  org.loadui.testfx.Assertions.verifyThat;
import static org.loadui.testfx.controls.TableViews.numberOfRowsIn;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.loadui.testfx.GuiTest;

import javafx.scene.Parent;

public class CT02_LoadUserInformationTest extends GuiTest {
	
private TestHelper th;
	
	public CT02_LoadUserInformationTest() {
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
		click("#loadcusinfo");
		sleep(1, TimeUnit.SECONDS);
		verifyThat(numberOfRowsIn("#customertable"), greaterThan(0));
	}

}
