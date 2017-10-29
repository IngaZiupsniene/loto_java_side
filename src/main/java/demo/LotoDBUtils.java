package demo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class LotoDBUtils {
    private static Connection connection = null;

    public static Connection getConnection(){
        if (connection!=null){
            return connection;
        }
        else {
            try {
                Properties properties = new Properties();
                InputStream inputStream = LotoDBUtils.class.getClassLoader().getResourceAsStream("db.properties");
                properties.load(inputStream);
                String driver = properties.getProperty("driver");
                String url = properties.getProperty("url");
                String username = properties.getProperty("username");
                String password = properties.getProperty("password");

                Class.forName(driver);
                connection = DriverManager.getConnection(url, username, password);
            }
            catch (ClassNotFoundException e){
                System.out.println("klaida DBUtils ClassNotFoundException  "+e);
            }
            catch (SQLException e) {
                System.out.println("klaida DBUtils SQLException  "+e);

            } catch (IOException e) {
                System.out.println("klaida IOException SQLException  "+e);
            }
        }
        return connection;
    }
}
