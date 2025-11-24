package tsp.pro3600.memoryrace.connectionmodel;

/**
 * This interface represents a DataFactory
 * @see ConnectionHandler.createDataFactory()
 * @version 0.1
 */
public interface DataFactory {
    /* WIP not implemented yet
    public UserData createUserData(int id, String prenom, String nom, String dateNaissance, String email);

    public PhotoData createPhotoData(int id, String date, CourseData course, float latitude, float longitude, byte[] imageBytes);
    */
	
	/**
	 * Return a new CourseData
	 * @param id course unique id
	 * @param name course name
	 * @param place course place
	 * @param date course date
	 * @return a new CourseData object
	 */
    public CourseData createCourseData(int id, String name, String place, String date);

    /* WIP not implemented yet
    public AuthentificationData createAuthentificationData(String email, String hashedPassword);
    */
}
