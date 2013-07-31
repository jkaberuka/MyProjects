package models;
import java.io.*;
import java.util.*;

import play.data.validation.Constraints.Required.*;
import play.data.validation.Constraints.*;
import play.db.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;




@Entity
public class Business extends Model {


public String businessEmail;

public String businessName;

public String businessType;

 @Id
public  Long id;
 

public String businessPhoneNumber;

  
public String businessDescription;
public File image;

//@Required
//public String businessType;




public static Finder<Long,Business> find = new Finder(Long.class, Business.class);


public String getBusinessEmail()
{
	
	return businessEmail;
}

public String getBusinessName()
{
	
	return businessName;
}

public String getBusinessPhoneNumber()
{
	
	return businessPhoneNumber;
	
}

public Long getId(){
	return id;
}

public String getBusinessType(){
	
	return businessType;
}

public static List<Business> all() {
    //return new ArrayList<Task>();
	return find.all();
}
  
public static void create(Business business) {
	 System.out.println(business);
	business.save();
}
public static void update(Business business)
{
	business.update();
}
  
public static void delete(Long id) {
	find.ref(id).delete();
}
 public String toString(){
	 return businessName + " " + id;
 }


}



