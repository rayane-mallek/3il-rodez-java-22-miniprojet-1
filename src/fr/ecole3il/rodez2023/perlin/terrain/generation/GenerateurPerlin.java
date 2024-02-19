package fr.ecole3il.rodez2023.perlin.terrain.generation;

import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import fr.ecole3il.rodez2023.perlin.terrain.generation.GenerateurCarte;
import fr.ecole3il.rodez2023.perlin.math.SuperBruitPerlin2D;

public class GenerateurPerlin extends GenerateurCarte {
    private final SuperBruitPerlin2D bruitAltitude;
    private final SuperBruitPerlin2D bruitHydrometrie;
    private final SuperBruitPerlin2D bruitTemperature;

    /**
     * Constructeur du générateur de bruit de Perlin.
     *
     * @param graine La graine utilisée pour initialiser le générateur de bruit.
     * @param largeur La largeur de la carte.
     * @param hauteur La hauteur de la carte.
     */
    public GenerateurPerlin(long graine, int largeur, int hauteur) {
        super(graine);

        bruitAltitude = new SuperBruitPerlin2D(graine * 2, 1);
        bruitHydrometrie = new SuperBruitPerlin2D(graine, 1);
        bruitTemperature = new SuperBruitPerlin2D(graine / 2, 1);
    }

    /**
     * Génère un terrain à une position spécifiée en utilisant le bruit de Perlin.
     *
     * @param i       La position verticale dans la carte.
     * @param j       La position horizontale dans la carte.
     * @param largeur La largeur totale de la carte.
     * @param hauteur La hauteur totale de la carte.
     * @return Le terrain généré pour la position spécifiée.
     */
    @Override
    protected Terrain genererTerrain(int i, int j, int largeur, int hauteur) {
        // Normalisation des coordonnées
        double x = (double) i / largeur;
        double y = (double) j / hauteur;

        // Génération des valeurs d'altitude, hydrométrie et température en utilisant le bruit de Perlin
        int altitude = normaliserValeur(bruitAltitude.bruit2D(x, y));
        int hydrometrie = normaliserValeur(bruitHydrometrie.bruit2D(x, y));
        int temperature = normaliserValeur(bruitTemperature.bruit2D(x, y));

        return new Terrain(altitude, hydrometrie, temperature);
    }

    /**
     * Normalise la valeur du bruit de Perlin à l'intervalle [0, 100].
     *
     * @param valeur La valeur du bruit de Perlin.
     * @return La valeur normalisée dans l'intervalle [0, 100].
     */
    private int normaliserValeur(double valeur) {
        return (int) (Math.abs(valeur) * 100);
    }
}

