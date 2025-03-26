package product;

import exceptions.NegativePrice;

public class ProductModel {

    private static int nextBarCode = 1;

    private String barCode;
    private String name;
    private int priceInCents;
    private int stock;

    @Override
    public String toString() {
        return String.format(
                "{ \"Código\": \"%s\", \"Nome\": \"%s\", \"Preço\": %.2f, \"Estoque\": %d }",
                barCode,
                name,
                priceInCents / 100.0,
                stock);
    }

    public ProductModel(String name, int priceInCents, int stock) throws NegativePrice {
        this.barCode = "PROD-" + nextBarCode++;
        if (priceInCents < 0) {
            throw new NegativePrice("O preço do produto precisa ser um número positivo.");
        }
        this.name = name;
        this.priceInCents = priceInCents;
        this.stock = stock;
    }

    public String getBarCode() {
        return this.barCode;
    }

    public String getName() {
        return this.name;
    }

    public int getPriceInCents() {
        return this.priceInCents;
    }

    public int getStock() {
        return this.stock;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setName(int newPriceInCents) {
        this.priceInCents = newPriceInCents;
    }

    public void setStock(int newStock) {
        this.stock = newStock;
    }
}
