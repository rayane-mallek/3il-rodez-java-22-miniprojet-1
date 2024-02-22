import static org.junit.Assert.*;

import fr.ecole3il.rodez2023.perlin.math.BruitAleatoire;
import org.junit.Test;

public class BruitAleatoireTest {

    @Test
    public void testBruit2D() {
        BruitAleatoire bruit = new BruitAleatoire(12345L, 0.1); // Exemple de graine et de résolution

        // Testons quelques valeurs de bruit pour voir s'ils sont dans la plage attendue (0.0 <= bruit < 1.0)
        for (int i = 0; i < 1000; i++) {
            double x = Math.random() * 1000; // Valeur aléatoire pour x
            double y = Math.random() * 1000; // Valeur aléatoire pour y
            double valeurBruit = bruit.bruit2D(x, y);
            assertTrue("La valeur de bruit devrait être comprise entre 0.0 et 1.0", valeurBruit >= 0.0 && valeurBruit < 1.0);
        }
    }
}
