package fr.ecole3il.rodez2023.perlin.terrain.elements;

/**
 * Exception levée lorsqu'une valeur ne respecte pas les limites spécifiées.
 */
public class MauvaiseValeurException extends IllegalArgumentException {

    /**
     * Constructeur de l'exception avec un message.
     *
     * @param message Message d'erreur.
     */
    public MauvaiseValeurException(String message) {
        super(message);
    }
}