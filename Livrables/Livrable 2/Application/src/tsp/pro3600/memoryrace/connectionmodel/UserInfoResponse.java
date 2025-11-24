package tsp.pro3600.memoryrace.connectionmodel;

// WIP - not implemented yet
public abstract class UserInfoResponse extends Response {

    protected Boolean userFound;
    protected UserData user;

    public void actionsAfterReception() throws UserNotFoundException
    {
	if (!this.userFound)
	    {
		throw new UserNotFoundException("The requested user does not exist");
	    }
    }
					       
      
    public UserData getUserData()
    {
	return this.user;
    }

}

    
					     
