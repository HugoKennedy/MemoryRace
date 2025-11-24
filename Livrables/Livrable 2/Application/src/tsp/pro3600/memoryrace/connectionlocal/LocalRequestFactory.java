package tsp.pro3600.memoryrace.connectionlocal;

import tsp.pro3600.memoryrace.connectionmodel.*;

/**
 * The RequestFactory to use with a local db
 * @version 0.1
 */
public class LocalRequestFactory implements RequestFactory{

	@Override
    public CourseListRequest createCourseListRequest()
    {
	return new LocalCourseListRequest();
    }

	@Override
	public PhotoWithDossardRequest createPhotoWithDossardRequest(int numDossard, CourseData course) {
		return new LocalPhotoWithDossardRequest(numDossard, course);
	}

}
