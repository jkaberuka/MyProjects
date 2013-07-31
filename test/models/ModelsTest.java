package models;
import models.*;
import org.junit.*;
import static org.junit.Assert.*;
import play.test.WithApplication;
import static play.test.Helpers.*;

public class ModelsTest extends WithApplication {
    @Before
    public void setUp() {
        start(fakeApplication(inMemoryDatabase()));
    }
    
    @Test
    public void createAndRetrieveUser() {
        new User("jkaberuka@gmail.com", "joseph Kaberuka", "do1").save();
        User joseph = User.find.where().eq("email", "jkaberuka@gmail.com").findUnique();
        assertNotNull(joseph);
        assertEquals("", joseph.name);
    }
    
    @Test
    public void tryAuthenticateUser() {
        new User("jkaberuka@gmail.com", "joseph kaberuka", "do1").save();
        
        assertNotNull(User.authenticate("jkaberuka@gmail.com", "do1"));
        assertNull(User.authenticate("jkaberuka@gmail.com", "badpassword"));
        assertNull(User.authenticate("tom@gmail.com", "secret"));
    }
}