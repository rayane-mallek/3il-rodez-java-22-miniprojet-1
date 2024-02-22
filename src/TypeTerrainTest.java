import static org.junit.Assert.*;

import fr.ecole3il.rodez2023.perlin.terrain.elements.TypeTerrain;
import org.junit.Test;

import java.awt.image.BufferedImage;

public class TypeTerrainTest {

    @Test
    public void testGetImage() {
        // Test pour chaque type de terrain si l'image associée n'est pas nulle
        for (TypeTerrain type : TypeTerrain.values()) {
            BufferedImage image = type.getImage();
            assertNotNull("L'image associée au type de terrain " + type.getNom() + " ne devrait pas être nulle.", image);
        }
    }
}
