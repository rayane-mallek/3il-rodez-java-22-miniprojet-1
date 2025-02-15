package fr.ecole3il.rodez2023.perlin.terrain.elements;

import fr.ecole3il.rodez2023.perlin.Utils;

import java.awt.image.BufferedImage;

/**
 * Cette énumération représente différents types de terrain pour la génération de cartes 2D.
 */
public enum TypeTerrain {
    COLLINES("Hills"),
    DESERT("Desert"),
    FORET_CONIFÈRES("Coniferous_Forest"),
    FORET_FEUILLUS("Deciduous_Forest"),
    MARAIS("Marsh"),
    MONTAGNE("Mountain"),
    OCEAN("Ocean"),
    PLAINE("Plain"),
    TOUNDRA("Tundra");

    private final String nom;

    /**
     * Constructeur privé pour définir le nom associé à chaque type de terrain.
     *
     * @param nom Le nom du type de terrain.
     */
    private TypeTerrain(String nom) {
        this.nom = nom;
    }

    /**
     * Récupère le nom du type de terrain.
     *
     * @return Le nom du type de terrain.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Récupère une image représentant le type de terrain.
     *
     * @return Une image représentant le type de terrain.
     */
    public BufferedImage getImage() {
        return Utils.chargerTuile(nom.toLowerCase() + ".png");
    }

    /**
     * Convertit le type de terrain en chaîne de caractères (son nom en français).
     *
     * @return Le nom du type de terrain.
     */
    @Override
    public String toString() {
        return nom;
    }
}
