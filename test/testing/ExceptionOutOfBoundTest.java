/*
 * @author Achini Kumarasinghe
 * Date:07-05-2019
 * Created using NetBeans IDE 8.2
 */
package testing;

import exceptions.OutOfBoundException;
import mars_rover.Rover;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

//Negative test to check whether the exceptions are thrown when given a invalid input.
public class ExceptionOutOfBoundTest {

    Rover rover;
    String arr[];

//Set up initial data before running the test
    @Before
    public void setUp() {
        rover = new Rover();
        try {

            rover.setPlataeuSize("5 5");
            rover.setInitialPos("5 2 E");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Test
    public void exOutOfBoundTest() {
        System.out.println("Inside ExceptionOutOfBoundTest : ");
        try {
            rover.movePosition();
            fail("should have thrown!");
        } catch (OutOfBoundException ex) {
            System.out.println(ex);
        }

    }

}
