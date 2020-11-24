package day01;

import  java.sql.*;

public class TestConnection {
    public static void main(String[] args) throws SQLException {
        // REPLACE THIS IP ADDRESS WITH YOUR OWN THAT WORKING IN SQL DEVELOPER
        String connectionStr = "jdbc:oracle:thin:@52.91.70.165:1521:XE";
        String username = "hr" ;
        String password = "hr" ;
        Connection conn = DriverManager.getConnection(connectionStr,username,password) ;
        Statement stmnt = conn.createStatement();
        ResultSet rs   =   stmnt.executeQuery("SELECT * FROM REGIONS") ;

        rs.next(); // currently we are at the very first row
        // rs.getString(column index) can be used to read the data of that column in current row
        System.out.println("first column value using index: --> " +  rs.getString(1)   );
        System.out.println("first column value using index: --> " +  rs.getString(2)   );

        //  rs.getString(column names)
        System.out.println("Region_ID at this row is : " + rs.getString("REGION_ID") );
        System.out.println("Region_Name at this row is : " + rs.getString("REGION_NAME") );

        rs.next() ; // this will move us to next row so we can read next row
        System.out.println("Region_ID at this row is : " + rs.getString("REGION_ID") );
        System.out.println("Region_Name at this row is : " + rs.getString("REGION_NAME") );
        // What if we want to keep moving ?

        rs.next() ; // this will move us to next row so we can read next row
        System.out.println("Region_ID at this row is : " + rs.getString("REGION_ID") );
        System.out.println("Region_Name at this row is : " + rs.getString("REGION_NAME") );

        rs.next() ; // this will move us to next row so we can read next row
        System.out.println("Region_ID at this row is : " + rs.getString("REGION_ID") );
        System.out.println("Region_Name at this row is : " + rs.getString("REGION_NAME") );


    }
}
