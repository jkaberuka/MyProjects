package models;
import java.io.*;
import java.util.*;

import play.data.validation.Constraints.Required.*;
import play.data.validation.Constraints.*;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class User extends Model {


@Id
public String email;
public String password;
public String name;

public  User(String email,String password, String name){
	
	this.email=email;
	this.password=password;
	this.name=name;
}


public static Finder<String,User> find = new Finder<String,User>(String.class, User.class);



//public static List<User> all() {
//    //return new ArrayList<Task>();
//	return find.all();
//}
//
//
//public String getEmail()
//{
//	
//	return email;
//}
//
//public String getFirstName()
//{
//	
//	return firstname;
//	
//}
//  
//public String getLastName()
//{
//	
//	return lastname;
//}

public static User authenticate(String email, String password) 
{
    return find.where().eq("email", email)
        .eq("password", password).findUnique();
}

}
