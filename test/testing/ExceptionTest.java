/*
 * @author Achini Kumarasinghe
 * Date:07-05-2019
 * Created using NetBeans IDE 8.2
 */
package testing;

import exceptions.*;
import mars_rover.Rover;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

//Negative test to check whether the exceptions are thrown when given a invalid input.
public class ExceptionTest {

    String arr[];

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void exTest() throws Exception {
        System.out.println("Inside ExceptionTest : ");
        expectedEx.expect(Exception.class);

        Rover rover = new Rover();
        rover.setPlataeuSize("5 5");
        rover.setInitialPos("t 2 E");

    }

   

}
