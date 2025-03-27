package product;

import exceptions.NegativePrice;
import interfaces.ProductInterface;

public class ProductModel extends ProductInterface {

    private static int nextBarCode = 1;

    private String barCode;
    private String name;
    private int price;
    private int stock;

    @Override
    public String toString() {
        return String.format(
                "{ \"Código\": \"%s\", \"Nome\": \"%s\", \"Preço\": \"R$ %d.00\", \"Estoque\": %d }",
                barCode,
                name,
                price,
                stock);
    }

    public ProductModel(String name, int price, int stock) throws NegativePrice {
        this.barCode = "PROD-" + nextBarCode++;
        if (price < 0) {
            throw new NegativePrice("O preço do produto precisa ser um número positivo.");
        }
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getBarCode() {
        return this.barCode;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public int getStock() {
        return this.stock;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setPrice(int newPriceInCents) {
        this.price = newPriceInCents;
    }

    public void setStock(int newStock) {
        this.stock = newStock;
    }
}
