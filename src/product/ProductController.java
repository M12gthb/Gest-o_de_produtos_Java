package product;

import java.util.ArrayList;
import exceptions.NotFoundException;
import exceptions.NegativePrice;

public class ProductController {
    private ArrayList<ProductModel> products = new ArrayList<>();

    public String create(ProductModel product) throws NegativePrice {
        products.add(product);
        return "Produto " + product.getName() + " adicionado.";
    }

    public String read() {
        StringBuilder json = new StringBuilder("[\n");

        for (int i = 0; i < products.size(); i++) {
            json.append("  ").append(products.get(i).toString());
            if (i < products.size() - 1) {
                json.append(",");
            }
            json.append("\n");
        }

        json.append("]");
        return json.toString();
    }

    public ProductModel retrieveProduct(String barCode) throws NotFoundException {
        return products.stream()
                .filter(p -> p.getBarCode().equals(barCode))
                .findFirst()
                .orElseThrow(() -> new NotFoundException(
                        "Produto com código " + barCode + " não encontrado"));
    }
}