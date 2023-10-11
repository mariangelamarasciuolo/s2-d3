import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        Product prod1 = new Product(2023889L, "shadowHunters", "Books", 150.33);
        Product prod2 = new Product(2023889L, "Geronimo", "Books", 111.23);
        Product prod3 = new Product(7125874L, "Bieberon", "Baby", 6.5);
        Product prod4 = new Product(7125874L, "Pannolini", "Baby", 5.9);
        Product prod5 = new Product(5896423L, "VideoGames", "Boys", 20.8);
        Product prod6 = new Product(5896423L, "Shoes", "Boys", 30.6);

        Customer tizio = new Customer(0L, "Aldo", 10);

        List<Product> pr1 = new ArrayList<>();
        pr1.add(prod1);
        pr1.add(prod2);
        pr1.add(prod3);
        pr1.add(prod4);


        List<Product> pr2 = new ArrayList<>();
        pr2.add(prod5);
        pr2.add(prod6);

        Order ord1 = new Order(10L, "ok", LocalDate.now(), LocalDate.now().plusDays(4), pr1, tizio);
        Order ord2 = new Order(15L, "ok", LocalDate.now(), LocalDate.now().plusDays(3), pr2, tizio);

        List<Product> piuDiCento = pr1.stream().filter(b -> b.category.equals("Books")).filter(b -> b.price > 100).toList();

        for (Product prod : piuDiCento) {
            System.out.println("Prodotti superiori a 100€:" + prod.toString());

            /////////////////////ESERCIZIO 2

            List<Order> prBaby = new ArrayList<>();
            prBaby.add(ord1);
            prBaby.add(ord2);
            List<Order> categoryBaby = prBaby.stream().filter(x -> x.products.stream().anyMatch(product -> product.category.equals("Baby"))).toList();
            for (Order ord : categoryBaby) {
                System.out.println("Prodotti che appartengono alla lista baby: " + ord);
            }

        }
    }
}
