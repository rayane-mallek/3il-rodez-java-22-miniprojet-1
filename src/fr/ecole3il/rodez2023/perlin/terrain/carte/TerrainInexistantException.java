package fr.ecole3il.rodez2023.perlin.terrain.carte;

/**
 * Cette exception est levée lorsqu'une tentative d'accès à un terrain inexistant est effectuée.
 * Elle peut être utilisée pour signaler des erreurs lors de l'accès à des coordonnées de terrain en dehors des limites de la carte.
 *
 * @author Rayane Mallek
 */
public class TerrainInexistantException extends Exception {

    /**
     * Constructeur de l'exception avec un message spécifié.
     *
     * @param message Le message d'erreur associé à cette exception.
     */
    public TerrainInexistantException(String message) {
        super(message);
    }
}
