package tsp.pro3600.memoryrace.connectionlocal;

import tsp.pro3600.memoryrace.connectionmodel.*;

import java.io.IOException;
import java.sql.*;

/**
 * This class represents a connection with a local database
 * @version 0.1
 */

public class LocalConnectionHandler implements ConnectionHandler{

    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";

    /**
     * Address of MariaDB instance
     */
    private String host;

    /**
     * Port of MariaDB instance
     */
    private int port;

    /**
     * User for connection to MariaDB
     */
    private String user;

    /**
     * Password for connection to MariaDB
     */
    private String password;

    /**
     * Connection to the MariaDB databse
     */
    private Connection conn;


    /**
     * Selected Request
     */
    private Request req;

    /**
     * Last Response
     */
    private Response res;
    
    /**
     * Root of file image directory
     */
    private String rootPath;
    
    /**
     * @param host Address of MariaDB instance
     * @param port Port of MairiaDB instance
     * @param user Username for MariaDB
     * @param password Password for MariaDB
     * @param rootPath Root folder of photos on the file system
     */
    public LocalConnectionHandler(String host, int port, String user, String password, String rootPath){
	this.host = host;
	this.port = port;
	this.user = user;
	this.password = password;
	this.rootPath = rootPath;
    }

    /**
     * Open a connection to the MariaDB database
     * @throws ConnectionErrorExeption if the connection fail
     */
    public void connect() throws ConnectionErrorException {
	this.conn = null;

	try {
	    Class.forName("org.mariadb.jdbc.Driver");
	    conn = DriverManager.getConnection("jdbc:mariadb://"+this.host+":"+this.port+"/db", this.user, this.password);
	}
	catch(Exception e){
	    e.printStackTrace();
	    throw new ConnectionErrorException(e.getMessage());
	}
    }

    /**
     * Close the connection to the MariaDB database
     * @throws ConnectionErrorExeption if the disconnection fail
     */
    public void disconnect() throws ConnectionErrorException {
	try {
	    this.conn.close();
	}
	catch(Exception e){
	    e.printStackTrace();
	    throw new ConnectionErrorException(e.getMessage());
	}
    }

    // You understand this function
    public void setRequest(Request req)
    {
	this.req = req;
    }

    // You understands this function
    public Response getResponse() {
	return this.res;
    }

    /**
     * Create a DataFactory for use with local database connection
     * @return a DataFactory object to create Data objects
     */
    public LocalDataFactory createDataFactory()
    {
	return new LocalDataFactory();
    }
    
    /**
     * Create a RequestFactory for use with local database connection
     * @return a RequestFactory object to create Request objects
     */
    public LocalRequestFactory createRequestFactory()
    {
	return new LocalRequestFactory();
    }

     /**
     * Create a ResponseFactory for use with local database connection
     * @return a ResponseFactory object to create Response objects
     */
	@Override
	public ResponseFactory createResponseFactory() {
		// WIP not implemented yet
		return null;
	}

    /**
     * Execute the request set by setRequest(Request req)
     */
    public void execute() throws ConnectionErrorException
    {
    	Statement stmt; // statement to execute queries on the DB
	try {
	    stmt = conn.createStatement();
	    /* LocalCourseListRequest : get a list of all courses */
	    if (this.req instanceof LocalCourseListRequest)
	    {
	    	// MariaDB Query
	    	ResultSet rs = stmt.executeQuery(this.req.getSerialized());
	    	// Treatment is done in the LocalCourseListResponse class
	    	this.res = new LocalCourseListResponse(rs);
	    	
	    }
	    else if (this.req instanceof LocalPhotoWithDossardRequest)
	    {
	    	/*LocalPhotoWithDossardRequest : get photos with a certain dossard in a course*/
	    	
	    	// MariaDB Query
	    	ResultSet rs = stmt.executeQuery(this.req.getSerialized());
	    	// Treatment is done in the LocalPhotoListResponse class
	    	this.res = new LocalPhotoListResponse(rs, this.rootPath);
	    }
	    stmt.close();
	    
	    
    } catch (SQLException e) {
    	/*Replacing implementation specific exception by a more general one*/
		throw new ConnectionErrorException("Issue while accessing the database : "+ e.getMessage());

    } catch (IOException e)
	{
    	/*Replacing implementation specific exception by a more general one*/
    	throw new ConnectionErrorException("Issue while reading the files : "+ e.getMessage());
	}
   }

    
}

