package srv.auth.exception;

/**
 * @author vladimir.fedotov
 * @since 28-Jan-20
 */
public class AccountNotFoundException extends Exception {

    public AccountNotFoundException(String message) {
        super(message);
    }

}
