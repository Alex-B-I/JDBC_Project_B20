package day01;

import java.sql.*;

public class MovingResultSetPointer {
    public static void main(String[] args) throws SQLException {

        // we want to create a statement object that generate
        // ResultSet that can move forward and backward anytime
        String connectionStr = "jdbc:oracle:thin:@52.91.70.165:1521:XE";
        String username = "hr" ;
        String password = "hr" ;

        Connection conn = DriverManager.getConnection(connectionStr,username,password) ;
        // this way of creating statement will give you ability to generate
        // ResultSet that can move forward and backward anytime
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet rs   =   stmt.executeQuery("SELECT * FROM REGIONS") ;

        while (rs.next()){
            System.out.println("Region_name "+rs.getString("Region_name"));
        }

       // rs.previous();
       // System.out.println("Region_name "+rs.getString("Region_name"));
        System.out.println("=====================================================");

        while (rs.previous()){
            System.out.println("Backward-Region_name "+rs.getString("Region_name"));
        }
        System.out.println("=====================================================");

        /**
         * Other ResultSet methods for moving your pointer to specific locations
         */
        rs.beforeFirst(); // before first location
        rs.first() ;  // first row
        rs.last() ; // last row
        rs.afterLast(); // after last location
        rs.absolute(3) ; // move to specific row

        // how to find out which row the pointer is at right now
        rs.last() ;
        int currentRowNum = rs.getRow() ;
        System.out.println("Row Count = " + currentRowNum);


    }
}
