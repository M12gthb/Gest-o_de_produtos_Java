import exceptions.NegativePrice;
import exceptions.NegativeStock;
import exceptions.NotFoundException;
import interfaces.ProductInterfaceUpdate;
import product.ProductController;
import product.ProductModel;

public class Main {
    public static void main(String[] args) throws NegativePrice, NotFoundException, NegativeStock {
        var number = (int) (Math.random() * 6);
        String barCode = "PROD-" + number;
        var controller = new ProductController();
        var product = new ProductModel("Frutas", 4, 100);
        var product2 = new ProductModel("Carne", 100, 7);
        var product3 = new ProductModel("Ovos", 30, 10);
        var product4 = new ProductModel("name", 1, 2);
        var product5 = new ProductModel("Farinha", 5, 20);
        var product6 = new ProductModel("Café", 50000, 30);
        var product7 = new ProductModel("Chocolate", 8, 15);
        var product8 = new ProductModel("Pão", 5, 40);
        var product9 = new ProductModel("Cereal", 15, 20);
        var product10 = new ProductModel("Doce de leite", 9, 26);
        var product11 = new ProductModel("Doce de leite", 9, 26);
        controller.create(product);
        controller.create(product2);
        controller.create(product3);
        controller.create(product4);
        controller.create(product5);
        controller.create(product6);
        controller.create(product7);
        controller.create(product8);
        controller.create(product9);
        controller.create(product10);
        controller.create(product11);

        System.out.println(controller.deleteProduct("PROD-11"));
        System.out.println(controller.update(new ProductInterfaceUpdate("Leite", 20, 25), "PROD-4"));
        System.out.println(controller.read());
    }
}