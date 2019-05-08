/*
 * @author Achini Kumarasinghe
 * Date:07-05-2019
 * Created using NetBeans IDE 8.2
 */
package testing;

import mars_rover.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class FinalPosTest {

    String arr[];

//Positive test to check whether the output is correct.
    @Test
    public void finalPossitionTest() {
        System.out.println("FinalPosTest : ");
        Rover rover = new Rover();
        try {

            rover.setPlataeuSize("5 5");
            rover.setInitialPos("1 2 N");
            arr = rover.moveRover("LMLMLMLMM");
        } catch (Exception ex) {
            System.out.println(ex);
        }

        assertArrayEquals(new String[]{"1", "3", "N"}, arr);
    }
}
