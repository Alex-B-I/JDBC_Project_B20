package day3;

import utility.DB_Utility;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilityPractice {
    public static void main(String[] args) throws SQLException {

        // test out all the methods you have created so far for practice
        DB_Utility.createConnection();

        ResultSet jobRS =  DB_Utility.runQuery("select * from jobs");
        /**
        * Get the row count of the ResultSet
        * move the pointer to the last row and get the row number
         */

        jobRS.last();
        int rowCount = jobRS.getRow(); //getRow is getting the current row number
        System.out.println("Row count = "+rowCount);

        int colCount = DB_Utility.getColumnCount();
        System.out.println("colCount = " + colCount);

        System.out.println("All Column names "+DB_Utility.getColumnNames());

        System.out.println("Row data at row 3 "+DB_Utility.getRowDataAsList(3));

        DB_Utility.destroy();

    }
}
