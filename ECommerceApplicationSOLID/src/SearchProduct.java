import java.util.Scanner;

public class SearchProduct extends OnlineShopping implements ProductFilter {
    Scanner scanner = new Scanner(System.in);
    static boolean productsFound=false;

    Products product;
    BuyProduct buyProduct = new BuyProduct();

    public SearchProduct() {
    }

    public SearchProduct(Products product) {
        this.product = product;
    }




    public void priceFilter() {
        int min = 0, max = 0;
        System.out.println("Enter minimum value: ");
        min = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter maximum value: ");
        max = scanner.nextInt();
        scanner.nextLine();
        priceRange(min, max);
    }

    public void brandFilter() {
        String brand_name;
        System.out.println("Enter brand name");
        brand_name = scanner.nextLine();
        findBrand(brand_name);
    }

    @Override
    public void priceRange(int min, int max) {
        for (int i = 0; i < ProductEntry.productList.size(); i++) {
            Products productFromList = ProductEntry.productList.get(i);
            if (product.getClass().equals(productFromList.getClass())) {
                if (product.price <= max && product.price >= min) {

                    System.out.println("Id: " + i + " name: " + productFromList.productName);
                    productsFound = true;
                }
            }
        }

    }

    @Override
    public void findBrand(String brand_name) {
        for (int i = 0; i < ProductEntry.productList.size(); i++) {
            Products productFromList = ProductEntry.productList.get(i);

            if (product.getClass().equals(productFromList.getClass())) {

                if (productFromList.productName.equals(brand_name)) {
                    System.out.println("Id: " + i + " name: " + productFromList.productName);

                    productsFound = true;
                }
            }
        }
    }

    @Override
    public void addToCart() {
        super.addToCart();
    }
}
