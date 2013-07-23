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


public Login(String email, String password ){
	
this.email = email;
this.password = password;

}

}
