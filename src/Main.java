import exceptions.NegativePrice;
import exceptions.NotFoundException;
import product.ProductController;
import product.ProductModel;

public class Main {
    public static void main(String[] args) throws NegativePrice, NotFoundException {
        var number = (int) (Math.random() * 6);
        String barCode = "PROD-" + number;
        var controller = new ProductController();
        var product = new ProductModel("Fruta", 1, 1);
        var product2 = new ProductModel("Carne", 100, 7);
        var product3 = new ProductModel("Ovos", 30, 10);
        var product4 = new ProductModel("Leite", 20, 25);
        var product5 = new ProductModel("Farinha", 5, 20);
        var product6 = new ProductModel("Café", 50000, 30);
        System.out.println(controller.create(product));
        System.out.println(controller.create(product2));
        System.out.println(controller.create(product3));
        System.out.println(controller.create(product4));
        System.out.println(controller.create(product5));
        System.out.println(controller.create(product6));
        System.out.println(controller.read());
        System.out.println(controller.retrieveProduct(barCode));
    }
}