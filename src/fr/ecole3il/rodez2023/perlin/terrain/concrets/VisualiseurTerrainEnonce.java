package fr.ecole3il.rodez2023.perlin.terrain.concrets;

import fr.ecole3il.rodez2023.perlin.terrain.carte.Carte;
import fr.ecole3il.rodez2023.perlin.terrain.elements.TypeTerrain;
import fr.ecole3il.rodez2023.perlin.terrain.visualisation.VisualiseurTerrain;

import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import fr.ecole3il.rodez2023.perlin.terrain.visualisation.*;

/**
 * Cette classe représente un visualiseur de terrain spécifique basé sur un énoncé donné.
 * Elle étend la classe `VisualiseurTerrain` en utilisant un détermineur de terrain spécifique.
 *
 * @author Rayane Mallek
 */
public class VisualiseurTerrainEnonce extends VisualiseurTerrain {

	/**
	 * Constructeur de la classe `VisualiseurTerrainEnonce`.
	 *
	 * @param carte La carte à visualiser.
	 */
	public VisualiseurTerrainEnonce(Carte carte) {
		super(carte, new DetermineurTerrainEnonce());
	}
}

