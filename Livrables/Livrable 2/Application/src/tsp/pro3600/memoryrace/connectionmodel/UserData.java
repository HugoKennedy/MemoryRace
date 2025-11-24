package tsp.pro3600.memoryrace.connectionmodel;

// WIP - not implemented yet
public abstract class UserData implements Serializable{

    private int id;
    private String surname;
    private String name;
    private String birthDate;
    private String email;
    private int permissionLevel;

    public UserData(int id, String surname, String name, String birthDate, String email, int permissionLevel){
	this.id = id;
	this.surname = surname;
	this.name = name;
	this.birthDate = birthDate;
	this.email = email;
	this.permissionLevel = permissionLevel;
    }

    public UserData(int id, String surname, String name, String birthDate, String email){
	this.id = id;
	this.surname = surname;
	this.name = name;
	this.birthDate = birthDate;
	this.email = email;
	this.permissionLevel = 0;
    }

    public abstract String getSerialized();
    
   // Getters and Setters
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPermissionLevel() {
        return permissionLevel;
    }

}
