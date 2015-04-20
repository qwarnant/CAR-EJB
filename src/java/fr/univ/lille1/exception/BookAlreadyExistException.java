package fr.univ.lille1.exception;

/**
 *
 * Cette classe représente l'exception d'existance d'un livre dans la base de
 * données
 *
 * @author Quentin Warnant
 * @version 1.0
 */
public class BookAlreadyExistException extends Exception {

    public BookAlreadyExistException() {
    }

    public BookAlreadyExistException(String message) {
        super(message);
    }

}
