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
public class Admin extends Model {
	
@Id
public long id;

@Required
public String adminLoginName;

@Required	
public String adminPasswordName;
	
public static Finder<Long,Admin> find = new Finder(Long.class, Admin.class);


public static List<Admin> all() {
    //return new ArrayList<Task>();
	return find.all();
}

public String getAdminLoginName(){
	
	return adminLoginName;
	
}

public String getAdminPasswordName(){
	
	
	return adminPasswordName;
}




}
