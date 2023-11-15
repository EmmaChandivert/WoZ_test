import java.util.ArrayList;
import java.io.*;
import java.lang.*;
import java.util.Scanner;
import java.util.List;

/**
 * Décrivez votre classe WORLD ici.
 *
 * @author Group11
 * @version (31/10/2023)
 */
public class World 
{
   // instance variables - replace the example below with your own
    public ArrayList<RobotG> robots;
    private int maxRobots; //The number max of robots
    private rabbitRobot myRobot;
    
    /**
     * Constructor for objects of class World
     */
    public World()
    {
        robots = new ArrayList<RobotG>();
        maxRobots = 6;
    }

    /**
     * Add a new robot and verify that this robot is not already in the world
     * @param  The new Robot to add
     */
    public void addRobot(RobotG robot)
    { 
        if (numberOfRobots()<maxRobots &&(!robots.contains(robot))){
            robots.add(robot); 
        }
        else{
            System.out.println("Le nombre de robots maximal est atteint ou ce robot est déjà présent dans le monde.");
            //System.exit(0);
        }
    }
    
    /**
     * Delete a robot
     * @param  The robot to remove
     */
    public void delRobots(RobotG robot)
    {
        if (robots.contains(robot)){
            robots.remove(robot);
        }
    }
      
    /**
     * Display the actually number of robots
     * @return The number of robots
    */
    public int numberOfRobots(){
        return robots.size();
    }
    
    /**
     * Modify the maximun number of robots
     * @param  the number of max robot
    */
    public void setMaxRobots(int nb){
        maxRobots = nb ;
    }
    
     /**
     * Move all the robots
     */
    public void moveAll(){
        for (int i = 0; i < robots.size(); i++) {
            boolean collision = false;
            int xPos1 = robots.get(i).getNextXPosition(1);
            int yPos1 = robots.get(i).getNextYPosition(1);
            for (int j = 0; j < robots.size(); j++) {
                // Faites quelque chose avec les robots[i] et robots[j] si nécessaire
                int xPos2 = robots.get(j).getPositionX();
                int yPos2 = robots.get(j).getPositionY();
                if (xPos1 == xPos2 && yPos1 == yPos2){
                    collision = true;
                }
            }
            // Faites avancer le robot i
            if(!collision){
                robots.get(i).avancer();
            }
        }
    }
    
    /**
     * méthode pour tester si tous les robots avancent bien 
     */
    public void testAvancerAll(){
        for (int i=0; i<100; i++){
            moveAll(); Canvas.wait(200);
        }
    }
}//End class