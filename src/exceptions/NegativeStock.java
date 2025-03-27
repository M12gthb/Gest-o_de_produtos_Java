package exceptions;

public class NegativeStock extends Exception {
    public NegativeStock() {
        super("O estoque do produto precisa ser um número positivo.");
    }

    public NegativeStock(String message) {
        super(message);
    }

}