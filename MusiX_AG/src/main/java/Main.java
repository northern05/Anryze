import models.Product;
import service.Service;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        Product product = new Product(1, "Boss", "550");
        service.saveProduct(product);
    }
}
