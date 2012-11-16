/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.webinfofrontend.Task;
import com.mycompany.webinfofrontend.InvalidTaskException;
import com.mycompany.webinfofrontend.Task;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Vylyb
 */
public class TaskTest {
    
    public TaskTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testTasks()
    {
        Task heute,invalid;

        try {
            //anpassen an aktuellen tag!
            heute=new Task(2012, 11, 16,"heute");
        } catch (InvalidTaskException ex) {
            fail(ex.getMessage());
        }

        invalid=null;
        try {
            invalid=new Task(2011, 11, 16,"invalid year");
            fail("Task "+invalid+" should throw an InvalidTaskException!");
        } catch (InvalidTaskException ex) {
            System.out.println(ex.getMessage());
        }
        assertNull("invalid should be null!",invalid);

        invalid=null;
        try {
            invalid=new Task(2012, 13, 16,"invalid month");
            fail("Task "+invalid+" should throw an InvalidTaskException!");
        } catch (InvalidTaskException ex) {
            System.out.println(ex.getMessage());
        }
        assertNull("invalid should be null!",invalid);

        invalid=null;
        try {
            invalid=new Task(2012, 0, 16,"invalid month");
            fail("Task "+invalid+" should throw an InvalidTaskException!");
        } catch (InvalidTaskException ex) {
            System.out.println(ex.getMessage());
        }
        assertNull("invalid should be null!",invalid);

        invalid=null;
        try {
            //kein Schaltjahr
            invalid=new Task(2013, 2, 29,"invalid day (no leapyear)");
            fail("Task "+invalid+" should throw an InvalidTaskException!");
        } catch (InvalidTaskException ex) {
            System.out.println(ex.getMessage());
        }
        assertNull("invalid should be null!",invalid);

        invalid=null;
        try {
            invalid=new Task(2012, 9, 31,"invalid day (too much days in a month)");
            fail("Task "+invalid+" should throw an InvalidTaskException!");
        } catch (InvalidTaskException ex) {
            System.out.println(ex.getMessage());
        }
        assertNull("invalid should be null!",invalid);

    }
}
