package tsp.pro3600.memoryrace.connectionmodel;

/**
 * The interface represents a RequestFactory
 * @see ConnectionHandler.createDataFactory()
 * @version 0.1
 */
public interface RequestFactory {
    /* WIP not implemented yet
    public AuthentificationRequest createAuthentificationRequest(AuthentificationData user);

    public UserInfoRequest createUserInfoRequest(String email);
    public UserInfoRequest createUserInfoRequest(int id);

    public PhotosWithUserRequest createPhotosWithUserRequest(UserData user);
    */

	/**
	 * Create a new CourseListRequest
	 * @return a new CourseListRequest
	 */
    public CourseListRequest createCourseListRequest();
    
    /**
     * Create a new PhotoWithDossardRequest
     * @param numDossard dossard number
     * @param course selected course
     * @return a new PhotoWithDossardRequest
     */
    public PhotoWithDossardRequest createPhotoWithDossardRequest(int numDossard, CourseData course);

}
