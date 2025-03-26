package exceptions;

public class NegativePrice extends Exception {
    public NegativePrice() {
        super("O preço do produto precisa ser um número positivo.");
    }

    public NegativePrice(String message) {
        super(message);
    }

}
