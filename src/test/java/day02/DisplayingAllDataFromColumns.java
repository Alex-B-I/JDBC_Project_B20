package day02;

import java.sql.*;

public class DisplayingAllDataFromColumns {
    public static void main(String[] args) throws SQLException {
        String connectionStr = "jdbc:oracle:thin:@52.91.70.165:1521:XE";
        String username = "hr" ;
        String password = "hr" ;

        Connection conn = DriverManager.getConnection(connectionStr,username,password) ;
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rs   =   stmt.executeQuery("SELECT * FROM employees") ;

        // print out entire first row of Employee table from above query
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        //print out column name is the beginning row, then print first row

        for (int i = 1; i < columnCount; i++) {
            System.out.print(rsmd.getColumnLabel(i)+"\t");
        }
        System.out.println();
        System.out.println("=================================================================================");
        rs.next();

        for (int i = 1; i < columnCount; i++) {
            System.out.print(rs.getString(i)+"\t");
        }
        System.out.println();
        //now hoe do you get all the row if you know how to get one row??
        //I want to go from the first row till the last row and print all columns
        System.out.println("=================================================================================");
        rs.beforeFirst();
        while (rs.next()){
            for (int i = 1; i < columnCount; i++) {
                System.out.printf("%16s",rs.getString(i)+"\t");
            }
            System.out.println();
        }




        rs.close();
        stmt.close();
        conn.close();
    }
}
