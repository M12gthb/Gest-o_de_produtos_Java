package interfaces;

public class ProductInterfaceUpdate {
    public String name = null;
    public int price = 0;
    public int stock = 0;

    public ProductInterfaceUpdate(String string, int i, int j) {
        this.name = string;
        this.price = i;
        this.stock = j;
    }
}
