package testfx;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.loadui.testfx.GuiTest;

import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class CT10_BalanceInfoTest extends GuiTest {
	
	private TestHelper th;
	
	public CT10_BalanceInfoTest() {
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
		click("#checkBalance");
		sleep(1, TimeUnit.SECONDS);
		TextField tf = (TextField)find("#balanceinfo");
		double valor = Double.parseDouble(tf.getText());
		assertEquals(7645.0, valor, 0);
	}
	
	@After
	public void tearDown() {
	}	
	

}
