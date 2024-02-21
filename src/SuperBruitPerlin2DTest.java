import fr.ecole3il.rodez2023.perlin.math.SuperBruitPerlin2D;
import org.junit.Test;
import static org.junit.Assert.*;

public class SuperBruitPerlin2DTest {

    @Test
    public void testBruitReturnsResultBetweenMinus1And1() {
        SuperBruitPerlin2D bruitPerlin = new SuperBruitPerlin2D(123456, 0.1);

        double resultat = bruitPerlin.bruit2D(0.5, 0.5);

        assertTrue(resultat >= -1 && resultat <= 1);
    }
}
