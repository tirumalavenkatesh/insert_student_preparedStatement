import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InstData {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/db";
        String user = "root";
        String password = "manikanta@07";

        String query = "INSERT INTO students(id,name, age, course) VALUES(?, ?, ?,?)";

        try {
            Connection con = DriverManager.getConnection(url, user, password);

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, "5");
            ps.setString(2, "Mani");
            ps.setInt(3, 20);
            ps.setString(4, "CSE");

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Data inserted successfully!");
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}