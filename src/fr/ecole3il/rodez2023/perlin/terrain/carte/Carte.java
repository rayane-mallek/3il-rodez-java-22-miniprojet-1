package fr.ecole3il.rodez2023.perlin.terrain.carte;

import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import fr.ecole3il.rodez2023.perlin.terrain.generation.GenerateurCarte;

import java.util.Scanner;

/**
 * Représente une carte composée de terrains.
 */
public class Carte {
    private String nom;
    private int largeur;
    private int hauteur;
    private Terrain[][] terrains;

    /**
     * Constructeur pour créer une carte à partir d'un générateur de carte.
     *
     * @param nom             Le nom de la carte.
     * @param largeur         La largeur de la carte.
     * @param hauteur         La hauteur de la carte.
     * @param generateurCarte Le générateur de carte à utiliser pour créer les terrains.
     */
    public Carte(String nom, int largeur, int hauteur, GenerateurCarte generateurCarte) {
        this.nom = nom;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.terrains = generateurCarte.genererCarte(largeur, hauteur);
    }

    /**
     * Constructeur pour créer une carte à partir de données fournies.
     *
     * @param donneesCarte Les données de la carte sous forme de chaîne de caractères.
     */
    public Carte(String donneesCarte) {
        Scanner scanner = new Scanner(donneesCarte);

        this.nom = scanner.nextLine();
        this.largeur = Integer.parseInt(scanner.nextLine());
        this.hauteur = Integer.parseInt(scanner.nextLine());
        this.terrains = new Terrain[largeur][hauteur];

        for (int y = 0; y < hauteur; y++) {
            for (int x = 0; x < largeur; x++) {
                int altitude = scanner.nextInt();
                int hydrometrie = scanner.nextInt();
                int temperature = scanner.nextInt();
                terrains[x][y] = new Terrain(altitude, hydrometrie, temperature);
            }
        }

        scanner.close();
    }

    // Getters et Setters

    /**
     * Récupère le nom de la carte.
     *
     * @return Le nom de la carte.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom de la carte.
     *
     * @param nom Le nom de la carte.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Récupère la largeur de la carte.
     *
     * @return La largeur de la carte.
     */
    public int getLargeur() {
        return largeur;
    }

    /**
     * Définit la largeur de la carte.
     *
     * @param largeur La largeur de la carte.
     */
    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    /**
     * Récupère la hauteur de la carte.
     *
     * @return La hauteur de la carte.
     */
    public int getHauteur() {
        return hauteur;
    }

    /**
     * Définit la hauteur de la carte.
     *
     * @param hauteur La hauteur de la carte.
     */
    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    /**
     * Récupère le terrain à une position donnée sur la carte.
     *
     * @param x La coordonnée horizontale du terrain.
     * @param y La coordonnée verticale du terrain.
     * @return Le terrain à la position spécifiée.
     */
    public Terrain getTerrain(int x, int y) {
        return terrains[x][y];
    }
}
