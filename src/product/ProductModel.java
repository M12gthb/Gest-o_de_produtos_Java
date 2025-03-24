package product;

public class ProductModel {
    private String barCode;
    private String name;
    private int priceInCents;
    private int stock;

    public ProductModel(String baCode, String name, int priceInCents, int stock) {
        this.barCode = baCode;
        this.name = name;
        this.priceInCents = priceInCents;
        this.stock = stock;
    }

    // Getters
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

    // Setters

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
