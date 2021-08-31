package testfx;

import static org.loadui.testfx.Assertions.verifyThat;
import static org.loadui.testfx.controls.Commons.hasText;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.loadui.testfx.GuiTest;

import javafx.scene.Parent;

public class CT13_ChangePasswordTest extends GuiTest {
	
	private TestHelper th;
	
	public CT13_ChangePasswordTest() {
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
		click("#changePassword");
		click("#oldpass").type("99");
		click("#newpass").type("77");
		click("#passretype").type("77");
		click("#changePwd");
		sleep(1, TimeUnit.SECONDS);
		verifyThat("#changepassconf", hasText("Password Changed"));
	}
	
	@After
	public void tearDown() {
		th.deleteCustomerTest();
	}

}
