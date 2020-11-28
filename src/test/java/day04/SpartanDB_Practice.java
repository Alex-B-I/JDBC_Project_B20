package day04;


import utility.DB_Utility;

public class SpartanDB_Practice {

    // create a main method
    public static void main(String[] args) {

        String connectionStr = "jdbc:oracle:thin:@52.91.70.165:1521:XE" ;
        String username = "SP";
        String password = "SP";
        // call your create connection method with 3 params
        // provide same connection string as HR
        // provide username and password as SP SP
        DB_Utility.createConnection(connectionStr , username,password);

        // run query SELECT * FROM SPARTANS
        DB_Utility.runQuery("SELECT * FROM SPARTANS");
        // call few methods from DB_Utility
        // print out row number
        System.out.println("DB_Utility.getRowCount() = " + DB_Utility.getRowCount());
        // get all the column names and print
        System.out.println("DB_Utility.getColumnNames() = " + DB_Utility.getColumnNames());


        DB_Utility.destroy();


    }



    // after you are done with this :
    // now add below to your properties file
    // spartan.database.url=jdbc:oracle:thin:@YOUR_IP_HERE:1521:XE
    // spartan.database.username=SP
    // spartan.database.password=SP

    // REPLACE YOUR HARDCODED CONNECTION INFO IN THIS CLASS WITH PROPERTIES FILE

}
