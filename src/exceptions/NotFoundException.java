package exceptions;

public class NotFoundException extends Exception {
    public NotFoundException(String productName) {
        super("Product '" + productName + "' not found.");
    }
}