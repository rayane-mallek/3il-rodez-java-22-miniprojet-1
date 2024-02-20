package fr.ecole3il.rodez2023.perlin.terrain.concrets;

import fr.ecole3il.rodez2023.perlin.terrain.carte.Carte;
import fr.ecole3il.rodez2023.perlin.terrain.elements.TypeTerrain;
import fr.ecole3il.rodez2023.perlin.terrain.visualisation.VisualiseurTerrain;

import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import fr.ecole3il.rodez2023.perlin.terrain.visualisation.*;

public class VisualiseurTerrainEnonce extends VisualiseurTerrain {

	public VisualiseurTerrainEnonce(Carte carte) {
		super(carte, new DetermineurTerrainEnonce());
	}
}

