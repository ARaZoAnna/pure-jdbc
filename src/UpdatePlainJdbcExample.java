import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdatePlainJdbcExample {
    private final static String SQL = "UPDATE students SET name=?, age=?, address=? WHERE id=?";
    private final static String DB_URL = "jdbc:mysql://localhost:3306/test_db";
    public static void main(String[] args) {
        //1. DB Conn (username, pw, db_url)
        try(Connection conn = DriverManager.getConnection(DB_URL,"root","0000");
        PreparedStatement ps = conn.prepareStatement(SQL)){
            //2. conn.statement (SQL)

            ps.setString(1,"장이수2");
            ps.setInt(2,41);
            ps.setString(3,"제주도");
            ps.setInt(4,3);

            int rowNum = ps.executeUpdate();
            System.out.printf("rowNum=%d", rowNum);

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }



}