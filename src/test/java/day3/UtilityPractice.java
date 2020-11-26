package day3;

import utility.DB_Utility;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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

        System.out.println("Get Cell value at row 1 column 2: "+DB_Utility.getColumnDataAtRow(1,2));

        System.out.println("Row data at row 1 "+DB_Utility.getRowDataAsList(1));

        System.out.println("Get Cell value at row 2 column MIN_SALARY: "+DB_Utility.getColumnDataAtRow(1,"MIN_SALARY"));

        System.out.println("3rd column value: "+DB_Utility.getColumnDataAsList(3));

        System.out.println("Job_title column value: "+DB_Utility.getColumnDataAsList("Job_title"));

        System.out.println("===============================");

        //        DB_Utility.displayAllData();

        Map<String,String>  row1Map = new LinkedHashMap<>() ; //new HashMap<>() ;
        //JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY
        //AC_ACCOUNT   Public Accountant  4200   9000
        row1Map.put("JOB_ID", "AC_ACCOUNT");
        row1Map.put("JOB_TITLE", "Public Accountant");
        row1Map.put("MIN_SALARY", "4200");
        row1Map.put("MAX_SALARY", "9000");
        // now do above programmatically
        // create row 1 map like above programmatically
//        System.out.println("row1Map = " + row1Map);

        Map<String,String>  rowMap = new LinkedHashMap<>() ;
        jobRS.absolute(1) ;
        ResultSetMetaData rsmd = jobRS.getMetaData() ;
        for (int colNum = 1; colNum <= rsmd.getColumnCount() ; colNum++) {
            String columnName   =  rsmd.getColumnLabel( colNum ) ;
            String cellValue    =  jobRS.getString( colNum ) ;
            rowMap.put(columnName, cellValue) ;
        }
        System.out.println("first row rowMap = " + rowMap);
        System.out.println("first row rowMap = " + DB_Utility.getRowMap(1));
        DB_Utility.destroy();
    }
}
