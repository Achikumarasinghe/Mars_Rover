/*
 * @author Achini Kumarasinghe
 * Date:07-05-2019
 * Created using NetBeans IDE 8.2
 */
package mars_rover;

import exceptions.*;

public class Rover {

    private static int marsMaxX, marsMaxY;
    static String commands[];
    private int currentX, currentY;
    private String currentDir;
    
    //set Plateau size as a static variable which is common to every objects
    public void setPlataeuSize(String size) throws Exception {
        int x = Integer.parseInt(size.substring(0, 1));
        int y = Integer.parseInt(size.substring(2, 3));
        marsMaxX = x;
        marsMaxY = y;

    }

    //method for setting initial possitions of the rover.
    public void setInitialPos(String pos) throws Exception {

        int x = Integer.parseInt(pos.substring(0, 1));
        int y = Integer.parseInt(pos.substring(2, 3));
        String dir = pos.substring(4, 5);
     
        currentX = x;
        currentY = y;
        currentDir = dir;

    }

    //method for changing direction of the rover.
    public void setDirection(String dir) {
        if (dir.equals("L")) {
            switch (currentDir) {
                case "N":
                    currentDir = "W";
                    break;
                case "E":
                    currentDir = "N";
                    break;
                case "S":
                    currentDir = "E";
                    break;
                case "W":
                    currentDir = "S";
                    break;
                default:
                    break;
            }
        } else if (dir.equals("R")) {
            switch (currentDir) {
                case "N":
                    currentDir = "E";
                    break;
                case "E":
                    currentDir = "S";
                    break;
                case "S":
                    currentDir = "W";
                    break;
                case "W":
                    currentDir = "N";
                    break;
                default:
                    break;
            }
        }
    }
    
    //method for moving the rover by one grid point
    public void movePosition() throws OutOfBoundException {
        if (currentDir.equals("N")) {

            if (currentY < marsMaxY) {
                currentY = currentY + 1;
            } else {
                throw new OutOfBoundException("out of bound in Y direction");
            }

        } else if (currentDir.equals("S")) {

            if (currentY > 0) {
                currentY = currentY - 1;
            } else {
                throw new OutOfBoundException("out of bound in Y direction");
            }

        } else if (currentDir.equals("E")) {

            if (currentX < marsMaxX) {
                currentX = currentX + 1;
            } else {
                throw new OutOfBoundException("out of bound in X direction");
            }

        } else if (currentDir.equals("W")) {

            if (currentX > 0) {
                currentX = currentX - 1;
            } else {
                throw new OutOfBoundException("out of bound in X direction");
            }

        }
    }

    //method for moving the rover.
    public String[] moveRover(String command) {
        String commandSet[] = new String[command.length()];
        for (int i = 0; i < command.length(); i++) {
            commandSet[i] = command.substring(i, i + 1);
        }

        for(int i = 0; i < commandSet.length; i++) {
            try {
                if (commandSet[i].equals("L") || commandSet[i].equals("R")) {

                    setDirection(commandSet[i]);

                } else if (commandSet[i].equals("M")) {

                    try {
                        movePosition();
                    } catch (OutOfBoundException ex) {
                        System.out.println(ex);
                        break;
                    }

                } else {

                    throw new InvalidArgumentsException("invalid direction inputs!");

                }
            } catch (InvalidArgumentsException ex) {
                System.out.println(ex);
                break;
            }

        }

        String arr[] = new String[3];
        arr[0] = Integer.toString(currentX);
        arr[1] = Integer.toString(currentY);
        arr[2] = currentDir;
        return arr;
    }

}
