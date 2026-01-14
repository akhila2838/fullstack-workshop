
package inventrory;
import java.util.*;
import java.util.stream.Collectors;

public class Inventory {

    private List<Product> productList = new ArrayList<>();
    private Set<String> categories = new HashSet<>();
    private Map<String, Product> productMap = new HashMap<>();
    private Queue<Product> lowStockQueue = new LinkedList<>();

 
    public void addProduct(Product product) {
        productList.add(product);
        categories.add(product.getCategory());
        productMap.put(product.getId(), product);

        if (product.getQuantity() < 10) {
            lowStockQueue.add(product);
        }
    }


    public void updateProduct(String id, double price, int quantity) {
        Optional<Product> optionalProduct = Optional.ofNullable(productMap.get(id));

        optionalProduct.ifPresent(p -> {
            p.setPrice(price);
            p.setQuantity(quantity);

            if (quantity < 10 && !lowStockQueue.contains(p)) {
                lowStockQueue.add(p);
            }
        });
    }


    public void deleteProduct(String id) {
        Product product = productMap.remove(id);
        if (product != null) {
            productList.remove(product);
            lowStockQueue.remove(product);
        }
    }

    public Optional<Product> getById(String id) {
        return Optional.ofNullable(productMap.get(id));
    }

    public List<Product> getByCategory(String category) {
        return productList.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public List<Product> getAllSortedByPrice() {
        return productList.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .collect(Collectors.toList());
    }

    public Queue<Product> getLowStockAlerts() {
        return new LinkedList<>(lowStockQueue);
    }
}
