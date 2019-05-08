/*
 * @author Achini Kumarasinghe
 * Date:07-05-2019
 * Created using NetBeans IDE 8.2
 */
package mars_rover;

import java.util.Scanner;
public class Main {

    static String commands[];
    static String arr[];


    public static void main(String[] args) {
        
        arr = new String[3];
        commands = new String[5];
        
        //get inputs and add them in to a array.
        System.out.println("INPUTS : ");
        Scanner sc = new Scanner(System.in);
        
        for (int i = 0; i < 5; i++) {
            commands[i] = sc.nextLine();

        }
        
        System.out.println("OUTPUTS FOR ROVER 1: ");        
        Rover rover1 = new Rover(); //create object for rover 1
        try {
            rover1.setPlataeuSize(commands[0]);
        } catch (Exception ex) {
            System.out.println("invalid inputs for plataeu size : "+ex);;
        }
        try {
            rover1.setInitialPos(commands[1]);
            arr = rover1.moveRover(commands[2]);
            System.out.println(arr[0]+" "+arr[1]+" "+arr[2]);
        } catch (Exception ex) {
            System.out.println("invalid arguments for intial possition : "+ex);
        }
        
        System.out.println("OUTPUTS FOR ROVER 2: ");
        Rover rover2 = new Rover(); //create object for rover 2.
        try {
            rover2.setInitialPos(commands[3]);
            arr = rover2.moveRover(commands[4]);
            System.out.println(arr[0]+" "+arr[1]+" "+arr[2]);
        } catch (Exception ex) {
            System.out.println("invalid arguments for intial possition : "+ex);
        }
        
    }
}
