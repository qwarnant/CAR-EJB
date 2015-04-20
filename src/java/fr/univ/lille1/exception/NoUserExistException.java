package fr.univ.lille1.exception;

/**
 *
 * Cette classe représente l'exception de non existance d'un client dans la base
 * de données
 *
 * @author Quentin Warnant
 * @version 1.0
 */
public class NoUserExistException extends Exception {

    public NoUserExistException() {
    }

    public NoUserExistException(String message) {
        super(message);
    }

}
