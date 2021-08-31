package testfx;

import static org.loadui.testfx.Assertions.verifyThat;
import static org.loadui.testfx.controls.Commons.hasText;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.loadui.testfx.GuiTest;

import javafx.scene.Parent;

public class CT09_WithdrawlTest extends GuiTest {
	
	private TestHelper th;
	
	public CT09_WithdrawlTest() {
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
		click("#withdrawl");
		type("1000");
		click("#makeWithdrawl");
		sleep(1, TimeUnit.SECONDS);
		verifyThat("#withdrawinfo", hasText("Transaction Successfull"));
	}
	
	@After
	public void tearDown() {
		th.deleteCustomerTest();
	}
}
