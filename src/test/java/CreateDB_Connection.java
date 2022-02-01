import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDB_Connection
{
    static Connection connection = null;
    static ReadingPropertyFile readingPropertyFile = new ReadingPropertyFile();

    public static Connection Make_DB_Connection() throws Exception
    {
        String jdbcUrl = readingPropertyFile.ReadingPropertiesFile("url");
        String userName = readingPropertyFile.ReadingPropertiesFile("username");
        String passwprd = readingPropertyFile.ReadingPropertiesFile("password");

        /*try
        {
            //setting up JDBC driver to be used
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Driver class not found.");
            e.printStackTrace();
        }*/

        //Make Connection to the Database
        //Connection connection = null;
        try
        {
            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Selenium_Results", "root", "ampm$248");
            connection = DriverManager.getConnection(jdbcUrl, userName, passwprd);
            if (connection != null)
            {
                System.out.println("Hurrah, we have the connection to the DB");
            }
        }
        catch(SQLException e)
        {
            System.out.println("There is an error in establishing database connection");
            e.printStackTrace();
        }
        return connection;
    }

    public static void Close_Connection(String connectionValue) throws SQLException {
        if (connectionValue != null)
        {
            connection.close();
            if (connection.isClosed() == true)
            {
                System.out.println("Connection is now closed: ");
            }
        }

    }
}
