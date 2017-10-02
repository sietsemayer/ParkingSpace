package nl.estate.parking.amsterdam.util;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.json.JSONArray;
import org.json.JSONObject;

import nl.estate.parking.amsterdam.Garage;

public class GetGarageAmsterdam {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ParkingSpace");
	private static List<String> parkingSpaceIdList = new ArrayList<>();
    public static void main(String[] args) {
    	
        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get("textfile.txt")));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//        System.out.println(content);
        
        parse(content);
    }

    private static void parse(String content) {
        
        JSONObject jsonObject = new JSONObject(content);
        
        JSONArray features = jsonObject.getJSONArray("features");
        //TODO Iterate throw all json objects using  (for int i loop
        System.out.println(features.length());
        for(int i = 0; i<= features.length()-1; i++){
            System.out.println("Garage counter "+ i);
            
            
            JSONObject feature = features.getJSONObject(i);
//            System.out.println(feature);
            
            JSONObject properties = feature.getJSONObject("properties");
            JSONObject geometry = feature.getJSONObject("geometry"); 
            JSONArray coordinatesArray = geometry.getJSONArray("coordinates");
           
            //FEATURE OBJECT
            String type = feature.getString("type");
            String estateIdName = feature.getString("Id");
            
            //GEOMETRY OBJECT
            String geometryType = geometry.getString("type");   
            BigDecimal latitude = coordinatesArray.getBigDecimal(0);
            BigDecimal longitude = coordinatesArray.getBigDecimal(1);
            //PROPERTY OBJECT
            String name = properties.getString("Name");
            String pubDate = properties.getString("PubDate");
            String locationType = properties.getString("Type");
            String status = properties.getString("State");
            String freeSpaceShortTemp = properties.getString("FreeSpaceShort");
            String freeSpaceLongTemp = properties.getString("FreeSpaceLong");
            String shortCapacityTemp = properties.getString("ShortCapacity");
            String longCapacityTemp = properties.getString("LongCapacity");           
            
            int freeSpaceLong = Integer.parseInt(freeSpaceLongTemp = isEmptyCheck(freeSpaceLongTemp));
            int freeSpaceShort = Integer.parseInt(freeSpaceShortTemp = isEmptyCheck(freeSpaceShortTemp));
            int longCapacity = Integer.parseInt(shortCapacityTemp = isEmptyCheck(shortCapacityTemp));
            int shortCapacity = Integer.parseInt(longCapacityTemp = isEmptyCheck(longCapacityTemp));
            
            writeToDatabase(type, estateIdName, geometryType, latitude, longitude,
            		name, pubDate, locationType, status, freeSpaceShort, freeSpaceLong, shortCapacity, longCapacity);            
        }
    }

	private static String isEmptyCheck(String value) {
		if(value.isEmpty()){
			value = "0";
		}
		return value;
	}

	private static void writeToDatabase(String type, String estateIdName, String geometryType, BigDecimal latitude,
			BigDecimal longitude, String name, String pubDate, String locationType, String status, int freeSpaceShort,
			int freeSpaceLong, int shortCapacity, int longCapacity) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
    	Query query1 = entityManager.createQuery("SELECT e FROM estate e");
    	parkingSpaceIdList = query1.getResultList();
    	for(String s : parkingSpaceIdList){
    		System.out.println(s);
    	}
    	
//    	 parkingSpaceIdList  = query.getResultList();    
//    	System.out.println(parkingSpaceIdList);
//    	entityManager.close();
		
		//Like
//		Query query1 = entitymanager.
//		createQuery("Select e " +
//		"from Employee e " +
//		"where e.ename LIKE 'M%'");
//		List<Employee> list1=(List<Employee>)query1.getResultList( );
//		for( Employee e:list1 )
//		{
//		System.out.print("Employee ID :"+e.getEid( ));
//		System.out.println("\t Employee name :"+e.getEname( ));
//		
		
		if(parkingSpaceIdList.contains(estateIdName)){
			System.out.println(" in database");
		}
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Garage garage = new Garage(type, estateIdName, geometryType, latitude, longitude,
        		name, pubDate, locationType, status, freeSpaceShort, freeSpaceLong, shortCapacity, longCapacity);
		entityManager.persist(garage);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}        
