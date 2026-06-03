import java.sql.*;

public class MarvellousJDBC {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/PPA54", "root", "root123"
            );
            ps = con.prepareStatement("SELECT * FROM student");
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Roll No: " + rs.getInt("rno"));
                System.out.println("Name : " + rs.getString("name"));
                System.out.println("City : " + rs.getString("city"));
                System.out.println("Marks : " + rs.getInt("marks"));
                System.out.println("---------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC driver not found. Add the driver jar to the classpath.");
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException ignored) {
            }
            try {
                if (ps != null) ps.close();
            } catch (SQLException ignored) {
            }
            try {
                if (con != null) con.close();
            } catch (SQLException ignored) {
            }
        }
    }
}