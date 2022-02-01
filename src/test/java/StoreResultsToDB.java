import org.testng.ITestResult;

import java.sql.Connection;
import java.sql.Statement;
import java.util.HashMap;

public class StoreResultsToDB
{
    public static void SaveResultsToDB(ITestResult result) throws Exception {
        Connection conn = CreateDB_Connection.Make_DB_Connection();

        String sDBTableName = "Results";
        String Result_Status = "";
        String TestCase_Name = result.getName();

        long startTime = result.getStartMillis();
        String Start_Time = new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date (startTime));

        long endTime = result.getEndMillis();
        String End_Time = new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date (endTime));

        int iValue = result.getStatus();
        switch (iValue)
        {
            case 1: Result_Status = "PASS";
                    break;
            case 2: Result_Status = "FAIL";
                    break;
            case 3: Result_Status = "SKIP";
                    break;
            default: Result_Status = "INVALID";
                    break;
        }

        ////////////THIS BELOW BLOCK OF CODE IS AN EXAMPLE OF USING STATEMENT IN MYSQL (IMPORTANT: USE EITHER STATEMENT OR PREPARE STATEMENT)/////////////

        //Creating a SQL Statement
        Statement myStmt = conn.createStatement();

        //creating a sql query to remove an already existing test case result
        String squery1 = "DELETE FROM " +sDBTableName+ " WHERE TestCase_Name = " + "\"" + TestCase_Name + "\"";
        System.out.println(squery1);
        myStmt.executeUpdate(squery1);

        //Creating a sql query to insert result into the DB for each test case
        String squery = "INSERT INTO " + sDBTableName + "(TestCase_Name, Result_Status, Start_Time, End_Time)";
        squery = squery+" VALUES ('" + TestCase_Name + "', '" + Result_Status + "', '" + Start_Time + "', '" + End_Time + "')";

        //Executing a sql query
        myStmt.executeUpdate(squery);
        myStmt.close();
        ////////////////////////////////////////////////////////////////////////////////////////////

    }
}