package product;

import java.util.ArrayList;
import exceptions.NotFoundException;
import interfaces.ProductInterfaceUpdate;
import exceptions.NegativePrice;
import exceptions.NegativeStock;

public class ProductController {
    private ArrayList<ProductModel> products = new ArrayList<>();

    public String create(ProductModel product) throws NegativePrice, NegativeStock {
        if (product.getStock() < 0) {
            throw new NegativeStock("O estoque do produto precisa ser um número positivo.");
        }
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

    public String deleteProduct(String barCode) throws NotFoundException {
        var findProduct = products.stream().filter(p -> p.getBarCode().equals(barCode))
                .findFirst().orElseThrow(() -> new NotFoundException("Produto com código" + barCode + "encontrado"));
        products.remove(findProduct);
        return "Produto deletado";
    }

    public ProductModel update(ProductInterfaceUpdate product, String barCode)
            throws NotFoundException, NegativePrice, NegativeStock {

        if (product.price < 0) {
            throw new NegativePrice("O preço do produto precisa ser um número positivo.");
        }
        if (product.stock < 0) {
            throw new NegativeStock("O estoque do produto precisa ser um número positivo.");
        }
        ProductModel productToUpdate = products.stream()
                .filter(p -> p.getBarCode().equals(barCode))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Produto com código " + barCode + " não encontrado"));

        if (product.name != null && !product.name.isEmpty()) {
            productToUpdate.setName(product.name);
        }

        if (product.price > 0) {
            productToUpdate.setPrice(product.price);
        }

        if (product.stock > 0) {
            productToUpdate.setStock(product.stock);
        }

        return productToUpdate;
    }
}