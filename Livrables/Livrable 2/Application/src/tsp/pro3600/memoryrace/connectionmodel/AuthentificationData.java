package tsp.pro3600.memoryrace.connectionmodel;

// WIP - not implemented yet
public abstract class AuthentificationData implements Serializable {

    private String email;
    private String hashedPassword;

    public AuthentificationData(String email, String hashedPassword){
	this.email = email;
	this.hashedPassword = hashedPassword;
    }


    public abstract String getSerialized();

}
