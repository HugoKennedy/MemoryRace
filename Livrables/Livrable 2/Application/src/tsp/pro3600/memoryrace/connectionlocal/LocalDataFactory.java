package tsp.pro3600.memoryrace.connectionlocal;

import tsp.pro3600.memoryrace.connectionmodel.*;

/**
 * This class is the DataFactory to use with a local db
 * @version 0.1
 */
public class LocalDataFactory implements DataFactory{

   public CourseData createCourseData(int id, String name, String place, String date)
    {
	return new LocalCourseData(id, name, place, date);
    }
}
