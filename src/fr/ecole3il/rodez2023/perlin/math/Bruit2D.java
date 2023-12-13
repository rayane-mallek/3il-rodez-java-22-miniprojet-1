package fr.ecole3il.rodez2023.perlin.math;

/**
 * La classe abstraite Noise2D est une base pour la génération de bruit en 2D.
 * Elle définit des méthodes permettant d'obtenir des valeurs de bruit en deux dimensions.
 */
public abstract class Bruit2D {
    
    /** La graine utilisée pour la génération du bruit */
    private final long graine;
    private double resolution;
    
    /**
     * Constructeur de la classe Noise2D.
     * @param graine La graine utilisée pour initialiser le générateur de bruit.
     * @param resolution
     */
    public Bruit2D(long graine, double resolution) {
        this.graine = graine;
        this.resolution = resolution;
    }
    
    /**
     * Méthode abstraite pour obtenir la valeur de bruit en 2D pour les coordonnées spécifiées.
     * @param x Coordonnée x pour laquelle obtenir le bruit.
     * @param y Coordonnée y pour laquelle obtenir le bruit.
     * @return La valeur de bruit en 2D pour les coordonnées fournies.
     */
    public abstract double bruit2D(double x, double y);

    /**
     * Méthode permettant d'obtenir la graine utilisée pour la génération du bruit.
     * @return La graine utilisée pour la génération du bruit.
     */
    public long getGraine() {
        return graine;
    }

    /**
     * Méthode permettant d'obtenir la résolution utilisée pour la génération du bruit.
     * @return La résolution utilisée pour la génération du bruit.
     */
    public double getResolution() {
        return resolution;
    }

    /**
     * Méthode permettant de définir la résolution utilisée pour la génération du bruit.
     * @return self.
     */
    public Bruit2D setResolution(double resolution) {
        this.resolution = resolution;

        return this;
    }



}
