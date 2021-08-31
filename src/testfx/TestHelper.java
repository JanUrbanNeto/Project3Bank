package testfx;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.loadui.testfx.GuiTest;

import com.mycompany.atmmanagementsys.DbConnection;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;


public class TestHelper extends GuiTest{

	@Override
	protected Parent getRootNode() {
		Parent parent = null;
		try {
			parent = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return parent;
	}
	
	public void adminLogin() {
		click("#adminrb");
		click("#useridtf").type("1");
		click("#passwordtf").type("1");
		click("#loginb");
	}
	
	public void userLogin(String id) {
		click("#userrb");
		click("#useridtf").type(id);
		click("#passwordtf").type(id);
		click("#loginb");
	}	
	
	public void addCustomerTest() {
		try {
            Connection con = DbConnection.Connection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO users VALUES (?,?,?,?,?,?,?,?)");
            ps.setInt(1, 99);
            ps.setString(2, "99");
            ps.setString(3, "Test User");
            ps.setString(4, "Test User Address");
            ps.setString(5, "user@test.com");
            ps.setString(6, "5199999999");
            ps.setString(7, "8500");
            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("New Test Customer Added Successfully");
            } else {
            	System.out.println("Test Customer not added");
            }
            ps.close();
            con.close();
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
        }
	}
	
	public void addCustomerTest2() {
		try {
            Connection con = DbConnection.Connection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO users VALUES (?,?,?,?,?,?,?,?)");
            ps.setInt(1, 88);
            ps.setString(2, "88");
            ps.setString(3, "Test User 2");
            ps.setString(4, "Test User Address 2");
            ps.setString(5, "user2@test.com");
            ps.setString(6, "5188888888");
            ps.setString(7, "5000");
            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("New Test Customer 2 Added Successfully");
            } else {
            	System.out.println("Test Customer 2 not added");
            }
            ps.close();
            con.close();
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
        }
	}
	
	public void deleteCustomerTest() {
		try {
            Connection con = DbConnection.Connection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM users WHERE id = ?");
            ps.setInt(1, 99);
            int k = ps.executeUpdate();
            if (k > 0) {
                System.out.println("Successfully Removed The Test Customer");
            } else {
            	System.out.println("Fail to remove the Test Customer");
            }
            ps.close();
            con.close();
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
        }
	}
	
	public void deleteCustomerTest2() {
		try {
            Connection con = DbConnection.Connection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM users WHERE id = ?");
            ps.setInt(1, 88);
            int k = ps.executeUpdate();
            if (k > 0) {
                System.out.println("Successfully Removed The Test 2 Customer");
            } else {
            	System.out.println("Fail to remove the Test 2 Customer");
            }
            ps.close();
            con.close();
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
        }
	}
}
