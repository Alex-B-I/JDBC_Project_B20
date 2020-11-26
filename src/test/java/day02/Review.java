package day02;

import utility.DB_Utility;

import java.sql.*;

public class Review {
    public static void main(String[] args) throws SQLException {

        DB_Utility.createConnection();

        ResultSet rs   =   DB_Utility.runQuery("SELECT * FROM JOBS") ;

        // I want to read the first tow
        rs.next();
        System.out.println("First column value in Jobs: "+rs.getString(1));
        System.out.println("Second column value in Jobs: "+rs.getString(2));
        System.out.println("==========================================================");

        //move to row number 7 and get above 2 columns values
        rs.absolute(7);
        System.out.println("First column value in Jobs row 7: "+rs.getString(1));
        System.out.println("Second column value in Jobs row 7: "+rs.getString(2));
        System.out.println("==========================================================");

        rs.last();
        System.out.println("First column value in Jobs last row: "+rs.getString(1));
        System.out.println("Second column value in Jobs last row: "+rs.getString(2));
        System.out.println("==========================================================");

        rs.previous();
        System.out.println("First column value in Jobs in 2nd from last row: "+rs.getString(1));
        System.out.println("Second column value in Jobs in 2nd from last row: "+rs.getString(2));
        System.out.println("==========================================================");

        System.out.println("-------------------------Loop from first row till last row print JOB_ID-------------------------");

        rs.beforeFirst();
        while (rs.next()){
            System.out.println("Loop First Column: "+rs.getString("JOB_ID"));
        }

        //Task#2
        System.out.println("----------------------Loop from last row till first row get MIN_SALARY COLUMN AS NUMBER--------------------");
        //WE are currently at after last location
        //if you really want to make sure and explicitly say so
        // we can do below
        rs.afterLast();
        while (rs.previous()){
            //Nothing wrong with getting it as string, just for the sake of demo, we are getting as double
            System.out.println("Min salary column as number:  $"+rs.getDouble("MIN_SALARY"));
        }

        //clean up the connection, statement and resultset object after usage

       DB_Utility.destroy();


    }
}
