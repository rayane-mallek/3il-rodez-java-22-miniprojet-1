package fr.ecole3il.rodez2023.perlin.terrain.elements;

import fr.ecole3il.rodez2023.perlin.terrain.visualisation.DetermineurTerrain;

/**
 * Cette classe représente un terrain avec des caractéristiques telles que l'altitude, l'hydrométrie et la température.
 */
public class Terrain {
    private final double hydrometrie;
    private final double temperature;
    private final double altitude;

    /**
     * Constructeur de la classe Terrain.
     *
     * @param hydrometrie   L'hydrométrie du terrain.
     * @param temperature   La température du terrain.
     * @param altitude      L'altitude du terrain.
     * @throws MauvaiseValeurException Si les valeurs ne respectent pas les limites spécifiées.
     */
    public Terrain(double hydrometrie, double temperature, double altitude) throws MauvaiseValeurException {
        verifierLimites(hydrometrie, temperature, altitude);

        this.hydrometrie = hydrometrie;
        this.temperature = temperature;
        this.altitude = altitude;
    }

    /**
     * Récupère l'hydrométrie du terrain.
     *
     * @return L'hydrométrie du terrain.
     */
    public double getHydrometrie() {
        return hydrometrie;
    }

    /**
     * Récupère la température du terrain.
     *
     * @return La température du terrain.
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * Récupère l'altitude du terrain.
     *
     * @return L'altitude du terrain.
     */
    public double getAltitude() {
        return altitude;
    }

    /**
     * Vérifie si les valeurs respectent les limites spécifiées.
     *
     * @param hydrometrie   L'hydrométrie à vérifier.
     * @param temperature   La température à vérifier.
     * @param altitude      L'altitude à vérifier.
     * @throws MauvaiseValeurException Si une valeur est en dehors des limites spécifiées.
     */
    private void verifierLimites(double hydrometrie, double temperature, double altitude) throws MauvaiseValeurException {
        System.out.println("after altitude" + altitude);
        System.out.println("after hydr" + hydrometrie);
        System.out.println("after tmp" + temperature);
        if (estDansInterval(0, 1, hydrometrie) || estDansInterval(0, 1, temperature) || estDansInterval(-1, 1, altitude)) {
            throw new MauvaiseValeurException("Les valeurs doivent respecter les limites spécifiées.");
        }
    }

    /**
     * Vérifie si une valeur est dans un intervalle spécifié.
     *
     * @param min   Valeur minimale de l'intervalle.
     * @param max   Valeur maximale de l'intervalle.
     * @param valeur   Valeur à vérifier.
     * @return true si la valeur est dans l'intervalle, false sinon.
     */
    private boolean estDansInterval(double min, double max, double valeur) {
        return !(valeur >= min) || !(valeur <= max);
    }

    /**
     * Accepte un visiteur pour déterminer le type de terrain.
     *
     * @param dt Le DetermineurTerrain (visiteur) utilisé pour déterminer le type de terrain.
     * @return Le type de terrain déterminé par le visiteur.
     */
    public TypeTerrain getTypeTerrain(DetermineurTerrain dt) {
        return dt.determinerTerrain(altitude, hydrometrie, temperature);
    }
}
