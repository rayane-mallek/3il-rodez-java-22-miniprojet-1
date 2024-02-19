package fr.ecole3il.rodez2023.perlin.terrain.carte;

import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import fr.ecole3il.rodez2023.perlin.terrain.generation.GenerateurCarte;
import java.util.Scanner;

public class Carte {
    private String nom;
    private int largeur;

    private int hauteur;

    private Terrain[][] terrains;

    public Carte(String nom, int largeur, int hauteur, GenerateurCarte generateurCarte) {
        this.nom = nom;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.terrains = generateurCarte.genererCarte(largeur, hauteur);
    }

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
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public Terrain getTerrain(int x, int y) {
        return terrains[x][y];
    }
}
