package day02;

import java.sql.*;

public class GettingMoreInfoAboutResultSetObject {
    public static void main(String[] args) throws SQLException {
        String connectionStr = "jdbc:oracle:thin:@52.91.70.165:1521:XE";
        String username = "hr" ;
        String password = "hr" ;

        Connection conn = DriverManager.getConnection(connectionStr,username,password) ;
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rs   =   stmt.executeQuery("SELECT * FROM employees") ;

        //Metadata-- data about the data --
        //ResultSetMetaData -- data about the ResultSet object that contain our resulting rows and columns
        // for example column names, column counts .. and more
        //This is how we get the ResultSetMetaData object

        ResultSetMetaData rsmd = rs.getMetaData();
        //we only need two methods from this to get column count and column name I label

        int colCount = rsmd.getColumnCount();
        System.out.println("colCount = " + colCount);
        System.out.println("===============================================");

        //this is how we get column label I name using index
        //get first column name
        System.out.println("First Column Name is "+rsmd.getColumnLabel(1));
        System.out.println("Second Column Name is "+rsmd.getColumnLabel(2));
        System.out.println("===============================================");

        // now print out all column names
        for (int i = 1; i<=colCount;i++){
            System.out.println(i +". Column Name is "+rsmd.getColumnLabel(i));
        }
        System.out.println("===============================================");

        rs.close();
        stmt.close();
        conn.close();
    }
}
