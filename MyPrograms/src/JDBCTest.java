import java.sql.*;

public class JDBCTest implements CommonInterface{

    public String userName ="root";
    public String password ="";
    public String serverName = "localhost";
    public String port="3306";
    public String dbName = "SouvikTest";
    
    public  Connection createConnection(){
	Connection conn = null;
	try {
	    Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
	    
	    e.printStackTrace();
	}
	try {
	    conn = DriverManager.getConnection("jdbc:mysql://" + serverName + ":" + port + "/" + dbName ,userName, password);
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return conn;
    }
    
    public  void queryDatabase(){
	Connection conn =  createConnection();
	if(conn!=null){
	    System.out.println("Created the connection");
	}
	else{
	    System.out.println("Connection could not be created");
	    return;
	}
	
	try {
	    PreparedStatement stmt = conn.prepareStatement("select * from Employee");
	    ResultSet rs = stmt.executeQuery();
	    ResultSetMetaData metaData  = rs.getMetaData();
	    //Getting the column count
	    int columnCount = metaData.getColumnCount();
	    //Getting the row count
	    int currentRow = rs.getRow();            // Get current row  
	    int rowCount = rs.last() ? rs.getRow() : 0; // Determine number of rows  
	    //rs.last gets the cursor to the last position and we need to get it back
	    //to the beginning , not the first position as we are doing rs.next
	    //hence we get the cursor to the before first row to get the data back
	    rs.beforeFirst();
	    
	    System.out.println("Column Count : " + columnCount + " , RowCount : " + rowCount) ;
	    while (rs.next()){
		for(int i=1; i < columnCount+1; i++){
		    System.out.println("Data :" +rs.getObject(i));
		}
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	finally{
	    try{
		System.out.println("Closing Connections");
		conn.close();
	    }catch(SQLException sqle){
		sqle.printStackTrace();
	    }
	}
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
	JDBCTest test = new JDBCTest();
	test.queryDatabase();
    }

}
