package tsp.pro3600.memoryrace.connectionmodel;

// WIP - not implemented yet
public abstract class PhotosWithUserRequest extends Request implements Serializable {

    protected UserData user;

    public PhotosWithUserRequest(UserData user) {
	this.user = user;
    }

    public abstract String getSerialized();
}
