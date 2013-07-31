package models;

import java.io.*;
import java.util.*;
import play.data.validation.Constraints.Required.*;
import play.db.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Login extends Model {
	
public String email;
public String password;



//public String validate() {
//    if (User.authenticate(email, password) == null) {
//      return "Invalid user or password";
//    }
//    return null;
//}


public String toString(){
	
	
return email + " " + password;
}
}
