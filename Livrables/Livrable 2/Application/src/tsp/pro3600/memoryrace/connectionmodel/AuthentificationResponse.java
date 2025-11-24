package tsp.pro3600.memoryrace.connectionmodel;

// WIP - not implemented yet
public abstract class AuthentificationResponse extends Response {

    private Boolean authentificationAccepted;

    public void actionsAfterReception() throws AuthentificationFailedException {
	if (!this.authentificationAccepted)
	    {
		throw new AuthentificationFailedException("Wrong email/password or user not found");
	    }
    }

    public Boolean hasBeenAccepted()
    {
	return this.authentificationAccepted;
    }

}
