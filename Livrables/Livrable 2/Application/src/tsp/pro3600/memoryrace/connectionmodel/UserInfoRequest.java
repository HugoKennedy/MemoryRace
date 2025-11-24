package tsp.pro3600.memoryrace.connectionmodel;

// WIP - not implemented yet
public abstract class UserInfoRequest extends Request implements Serializable {

    private Boolean emailOrId; // true if email, false if id
    private String email;
    private int id;
    
    public UserInfoRequest(String email)
    {
	this.emailOrId = true;
	this.email = email;
    }

    public UserInfoRequest(int id)
    {
	this.emailOrId = false;
	this.id = id;
    }

    public abstract String getSerialized();
}

    
