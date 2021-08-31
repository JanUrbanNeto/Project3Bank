package testfx;

import static org.loadui.testfx.Assertions.verifyThat;
import static org.loadui.testfx.controls.Commons.hasText;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.loadui.testfx.GuiTest;

import javafx.scene.Parent;

public class CT08_DepositTest extends GuiTest {
	
	private TestHelper th;
	
	public CT08_DepositTest() {
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
		sleep(1, TimeUnit.SECONDS); //tem que dar tempo pra inserir no banco antes de logar no usuário recém cadastrado...
		th.userLogin("99");
	}
	
	@Test
	public void test() {
		click("#deposit");
		type("1000");
		click("#makeDeposit");
		sleep(1, TimeUnit.SECONDS);
		verifyThat("#dipositconf", hasText("Cash Has Been Deposited"));
	}
	
	@After
	public void tearDown() {
		th.deleteCustomerTest();
	}

}
