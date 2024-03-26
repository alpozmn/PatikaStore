import java.util.*;

// Marka sınıfı
class Brand {
    private int id;
    private String name;

    public Brand(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

// Ürün sınıfı
class Product {
    private int id;
    private String name;
    private double price;
    private double discountRate;
    private int stock;
    private Brand brand;

    public Product(int id, String name, double price, double discountRate, int stock, Brand brand) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discountRate = discountRate;
        this.stock = stock;
        this.brand = brand;
    }

    // Getter ve Setter metotları buraya eklenebilir
}

// Cep telefonu sınıfı
class CellPhone extends Product {
    private String memory;
    private double screenSize;
    private int batteryPower;
    private int ram;
    private String color;

    public CellPhone(int id, String name, double price, double discountRate, int stock, Brand brand,
                     String memory, double screenSize, int batteryPower, int ram, String color) {
        super(id, name, price, discountRate, stock, brand);
        this.memory = memory;
        this.screenSize = screenSize;
        this.batteryPower = batteryPower;
        this.ram = ram;
        this.color = color;
    }
}

// Notebook sınıfı
class Notebook extends Product {
    private int ram;
    private String storage;
    private double screenSize;

    public Notebook(int id, String name, double price, double discountRate, int stock, Brand brand,
                    int ram, String storage, double screenSize, String color) {
        super(id, name, price, discountRate, stock, brand);
        this.ram = ram;
        this.storage = storage;
        this.screenSize = screenSize;
    }
}

public class Main{
    private static List<Brand> brands = new ArrayList<>();
    private static List<Product> products = new ArrayList<>();

    static {
        // Statik blok içinde markaların eklenmesi
        brands.add(new Brand(1, "Samsung"));
        brands.add(new Brand(2, "Lenovo"));
        brands.add(new Brand(3, "Apple"));
        brands.add(new Brand(4, "Huawei"));
        brands.add(new Brand(5, "Casper"));
        brands.add(new Brand(6, "Asus"));
        brands.add(new Brand(7, "HP"));
        brands.add(new Brand(8, "Xiaomi"));
        brands.add(new Brand(9, "Monster"));
    }

    public static void listProducts(String category) {
        // Ürünlerin listelenmesi
        System.out.println("-------- " + category + " --------");
        System.out.println("ID\tName\tPrice\tStock\tBrand");
        for (Product product : products) {
            if (category.equals("Cep Telefonları") && product instanceof CellPhone) {
                System.out.format("%d\t%s\t%.2f\t%d\t%s\n", product.getId(), product.getName(), product.getPrice(), product.getStock(), product.getBrand().getName());
            } else if (category.equals("Notebook") && product instanceof Notebook) {
                System.out.format("%d\t%s\t%.2f\t%d\t%s\n", product.getId(), product.getName(), product.getPrice(), product.getStock(), product.getBrand().getName());
            }
        }
        System.out.println("----------------------------------");
    }

    public static void addProduct(Product product) {
        // Ürün ekleme işlemi
        products.add(product);
    }

    public static void deleteProduct(int productId) {
        // Ürün silme işlemi
        products.removeIf(product -> product.getId() == productId);
    }

    public static void listBrands() {
        // Markaların listelenmesi
        System.out.println("Markalarımız");
        System.out.println("--------------");
        for (Brand brand : brands) {
            System.out.println("- " + brand.getName());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ana menüyü gösterme
        while (true) {
            System.out.println("PatikaStore Ürün Yönetim Paneli !");
            System.out.println("1 - Notebook İşlemleri");
            System.out.println("2 - Cep Telefonu İşlemleri");
            System.out.println("3 - Marka Listele");
            System.out.println("0 - Çıkış Yap");
            System.out.print("Tercihiniz : ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Boş satırı oku

            switch (choice) {
                case 1:
                    listProducts("Notebook");
                    break;
                case 2:
                    listProducts("Cep Telefonları");
                    break;
                case 3:
                    listBrands();
                    break;
                case 0:
                    System.out.println("Çıkış yapılıyor...");
                    return; // Programı sonlandır
                default:
                    System.out.println("Geçersiz seçim! Lütfen tekrar deneyin.");
            }
        }
    }
}
