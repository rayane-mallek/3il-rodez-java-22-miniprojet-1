package fr.ecole3il.rodez2023.perlin.terrain.generation;

import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import fr.ecole3il.rodez2023.perlin.terrain.generation.GenerateurCarte;

import java.util.Random;

public class GenerateurAleatoire extends GenerateurCarte {
    private final Random random;

    /**
     * Constructeur du générateur aléatoire.
     *
     * @param graine La graine utilisée pour initialiser le générateur de nombres aléatoires.
     */
    public GenerateurAleatoire(long graine) {
        super(graine);
        this.random = new Random(graine);
    }

    /**
     * Génère un terrain aléatoire pour une position donnée.
     *
     * @param i       La position verticale dans la carte.
     * @param j       La position horizontale dans la carte.
     * @param largeur La largeur totale de la carte.
     * @param hauteur La hauteur totale de la carte.
     * @return Le terrain généré pour la position spécifiée.
     */
    @Override
    protected Terrain genererTerrain(int i, int j, int largeur, int hauteur) {
        // Génération aléatoire des valeurs d'altitude, hydrométrie et température
        return new Terrain(random.nextDouble(), random.nextDouble(), random.nextDouble());
    }
}
