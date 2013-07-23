package controllers;

import java.util.*;





import models.Business;
import models.Admin;
import play.*;
import play.data.Form;
import play.libs.Json;
import play.mvc.*;
import play.db.ebean.Model;
import views.html.*;



public class Application extends Controller {
	
	static Form <Business> businessForm = Form.form(Business.class);
	static Form<Admin> formAdmin = Form.form(Admin.class);
	static List <Business> myBusinesses = new ArrayList();
  
    public static Result index()
    {
    	
        return ok(index.render());
    }

    public static Result businesses()
	{
    	  
		return ok(registerBusiness.render(myBusinesses, businessForm));
		
	}
      
	public static Result registerBusiness()
	{
		List<Business> businesses = new Model.Finder(String.class, Business.class).all();
		return ok(registerBusiness.render(businesses, businessForm));
	}
	
	
	public static Result getBusinesses()
	{
		
		List<Business> businesses = new Model.Finder(String.class, Business.class).all();
		return ok (Json.toJson(businesses));
	}
 
	 public static Result newBusiness() {
   	  Form<Business> filledForm = businessForm.bindFromRequest();
   	  if(filledForm.hasErrors())
   	  {
   		  
   		  return badRequest(
   				  views.html.registerBusiness.render(Business.all(), filledForm));
   	  }
   	  else {
   		  
   			  Business.create(filledForm.get());
   			  return redirect(routes.Application.registerBusiness());
   		  }
   			  
   	  }
		     
	 public static Result deleteBusiness(Long id)
	 {
		 
   	  Business.delete(id);
   	  return redirect(routes.Application.businesses());
     }
	 
	
//	 public static Result updateBusiness(Long id){
//  	  Business mine = Business.find.ref(id);
//  	  businessForm.fill(mine);
//  	  return ok(views.html.editBusiness.render(businessForm, mine.id));
//  	
//   }
	 
//	 public static Result editBusiness(Long id) 
//	  {
//	    Business b = Business.find.ref(id);
//	       businessForm.fill(b);
//	     return redirect(routes.Application.saveBusiness(b.id));
//	   }
//	
	 public static Result saveBusiness(Long id)
	 
     {
		 
   	  Form<Business> filledForm = businessForm.bindFromRequest();
   	  if(filledForm.hasErrors())
   	  {
   		  
   		  return badRequest(
   				  views.html.registerBusiness.render(Business.all(), filledForm));
   	  }
   	  else {
   		  
   		  	Business b = filledForm.get();
   		  	b.id = id;
   			Business.update(b);
   			return redirect(routes.Application.businesses());
   		  }
   	  
     }
	
	public static Result login()
	
	{
		return ok (" Thank you ! Registration is done");
		
	}
	
	public static Result addAdmin(){
		Form<Admin> form = formAdmin.bindFromRequest();
		Admin myadmin = form.get();
	    myadmin.save();
	    return redirect(routes.Application.adminPage());
		
	}
	
	
	public static Result getAllAdmins(){
		
		List<Admin> admins = new Model.Finder(String.class, Admin.class).all();
		return ok (Json.toJson(admins));
		
		
	}
	public static Result adminPage()
	{
		
		return ok(AdminRegistration.render(formAdmin));
	}
	

}

