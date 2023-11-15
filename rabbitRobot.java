import java.util.Random;

/**
 * La classe rabbitRobot représente un robot spécialisé dans le déplacement en doublant la distance à chaque avancement.
 * Il peut changer de direction de manière aléatoire.
 * Cette classe hérite de la classe RobotG.
 *
 * @author Emma CHANDIVERT
 * @version 31/10/23
 */
public class rabbitRobot extends RobotG {
    /**
     * Constructeur de la classe rabbitRobot.
     *
     * @param nameRobot Le nom du robot.
     * @param dir La direction initiale du robot (0, 1, 2 ou 3).
     * @param x La position initiale en abscisse (x).
     * @param y La position initiale en ordonnée (y).
     */
    public rabbitRobot(String nameRobot, int dir, int x, int y) {
        super(nameRobot, dir, x, y);
    }
    
    /**
     * Redéfinition de la méthode avancer pour que le robot avance de 2 cases à chaque fois et dans une direction aléatoire.
     */
    @Override
    public void avancer()  {
        Random random = new Random();
        int newDirection = random.nextInt(4); // Génère une direction aléatoire (0, 1, 2 ou 3)
        setDirection(newDirection); // Change la direction du robot
        for (int i = 0; i < 2; i++) {
            super.avancer(); // Appelle la méthode avancer de la classe (RobotG)
        }
    }
    
    /**
     * Méthode utilisée pour tester le fonctionnement de la méthode avancer du rabbitRobot.
     * Elle fait avancer le robot 100 fois avec un délai de 200 millisecondes entre chaque déplacement.
     */
    public void testAvancerR() {
        for (int i = 0; i < 100; i++) {
            avancer();
            Canvas.wait(200);
        }
    }
}
