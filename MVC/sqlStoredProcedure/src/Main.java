import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static final String SELECT = "select * from users";
    private static final String INSERT = "insert into users(id, name, email, country) " +
            "values(?, ?, ?, ?)";
    private static final String DELETE = "delete from users where id = ?";
    String url = "jdbc:mysql://localhost:3306/demo";
    String userName = "root";
    String pw = "01666553995";
    int cnt = 3;
    public Connection getConnection(){
        try {
            return DriverManager.getConnection(url, userName,pw);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insert(){
        Connection c = getConnection();
        try {
            PreparedStatement preparedStatement = c.prepareStatement(INSERT);
            preparedStatement.setInt(1, cnt);
            preparedStatement.setString(2,"a");
            preparedStatement.setString(3,"b");
            preparedStatement.setString(4,"c");
            preparedStatement.execute();
            getConnection().close();
            preparedStatement.close();
            cnt++;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void select(){
        Connection c = getConnection();
        try {
            PreparedStatement preparedStatement = c.prepareStatement(SELECT);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int x){
        Connection c = getConnection();
        PreparedStatement preparedStatement = null;
        try {

            preparedStatement = c.prepareStatement(DELETE);
            preparedStatement.setInt(1, x);
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void main(String[] args) {
        new Main().delete(2);
    }
}