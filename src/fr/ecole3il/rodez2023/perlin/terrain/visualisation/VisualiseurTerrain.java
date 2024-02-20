package fr.ecole3il.rodez2023.perlin.terrain.visualisation;

import fr.ecole3il.rodez2023.perlin.terrain.carte.Carte;
import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import fr.ecole3il.rodez2023.perlin.terrain.elements.TypeTerrain;

public class VisualiseurTerrain {
    private Carte carte;
    private DetermineurTerrain determineurTerrain;

    public VisualiseurTerrain(Carte carte, DetermineurTerrain determineurTerrain) {
        this.carte = carte;
        this.determineurTerrain = determineurTerrain;
    }

    public TemperatureAffichee getTemperatureAffichee(int x, int y) {
        Terrain terrain = carte.getTerrain(x, y);

        if (terrain.getTemperature() < 0.33) {
            return TemperatureAffichee.FROID;
        } else if (terrain.getTemperature() < 0.66) {
            return TemperatureAffichee.TEMPERE;
        }

        return TemperatureAffichee.CHAUD;
    }

    public AltitudeAffichee getAltitudeAffichee(int x, int y) {
        Terrain terrain = carte.getTerrain(x, y);

        if (terrain.getAltitude() < 0 ) {
            return AltitudeAffichee.FOND_MARIN;
        } else if (terrain.getAltitude() < 0.33) {
            return AltitudeAffichee.BASSE;
        } else if (terrain.getAltitude() < 0.66) {
            return AltitudeAffichee.MOYENNE;
        }

        return AltitudeAffichee.ELEVEE;
    }

    public HydrometrieAffichee getHydrometrieAffichee(int x, int y) {
        Terrain terrain = carte.getTerrain(x, y);

        if (terrain.getHydrometrie() < 0.33 ) {
            return HydrometrieAffichee.SEC;
        } else if (terrain.getHydrometrie() < 0.66) {
            return HydrometrieAffichee.MOYEN;
        }

        return HydrometrieAffichee.HUMIDE;
    }

    public TypeTerrain getTypeTerrain(int x, int y) {
        Terrain terrain = carte.getTerrain(x, y);
        return determineurTerrain.determinerTerrain(terrain.getAltitude(), terrain.getHydrometrie(), terrain.getTemperature());
    }

    public Terrain getTerrain(int x, int y) {
        return carte.getTerrain(x, y);
    }
}
