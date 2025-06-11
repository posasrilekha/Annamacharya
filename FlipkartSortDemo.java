import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

class Product {
    private String name;
    private double price;
    private double rating;

    public Product(String name, double price, double rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public double getPrice() { return price; }
    public double getRating() { return rating; }
    public String getName() { return name; }

    public String toString() {
        return name + " - Rs." + price + ", Rating: " + rating;
    }
}

public class FlipkartSortDemo {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 45000, 4.5));
        products.add(new Product("Phone", 25000, 4.7));
        products.add(new Product("Headphones", 1500, 4.2));

        System.out.println("Sort by Price (Low to High):");
        products.sort(Comparator.comparing(Product::getPrice));
        products.forEach(System.out::println);

        System.out.println("\nSort by Price (High to Low):");
        products.sort(Comparator.comparing(Product::getPrice).reversed());
        products.forEach(System.out::println);

        System.out.println("\nSort by Rating (High to Low):");
        products.sort(Comparator.comparing(Product::getRating).reversed());
        products.forEach(System.out::println);
    }
}


