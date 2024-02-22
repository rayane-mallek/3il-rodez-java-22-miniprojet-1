import static org.junit.Assert.*;

import fr.ecole3il.rodez2023.perlin.terrain.carte.Carte;
import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import fr.ecole3il.rodez2023.perlin.terrain.generation.GenerateurCarte;
import org.junit.Test;

public class CarteTest {

    @Test
    public void testConstructeurSimple() {
        // Création d'une carte avec des valeurs de base
        Carte carte = new Carte("Ma Carte", 10, 10, new GenerateurCarte(11111) {
            @Override
            protected Terrain genererTerrain(int i, int j, int largeur, int hauteur) {
                return null;
            }
        }); // Le générateur de carte est null pour ce test

        // Vérification des propriétés de la carte
        assertEquals("Le nom de la carte devrait être 'Ma Carte'.", "Ma Carte", carte.getNom());
        assertEquals("La largeur de la carte devrait être 10.", 10, carte.getLargeur());
        assertEquals("La hauteur de la carte devrait être 10.", 10, carte.getHauteur());
    }
}
