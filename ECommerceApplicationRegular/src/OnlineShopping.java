import java.util.Locale;
import java.util.Scanner;

public class OnlineShopping implements ProductFilter {
    //Single Responsibility principle
    private boolean productsFound=false;
    int bill = 0;
    static Scanner scanner = new Scanner(System.in);

    Products product;
    BuyProduct buyProduct = new BuyProduct();

    public void searchProduct(Products product) {
        this.product = product;

        if (product instanceof Clothing) {
            System.out.println("----------Please select the filter you want to apply------------");
            int choice;
            do {
                System.out.println("-----Press 0 to exit-------");
                System.out.println("1. Price filter");
                System.out.println("2. Brand filter");
                System.out.println("3. Material filter");
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 0: break;
                    case 1:
                        priceFilter();
                        break;

                    case 2:
                        brandFilter();
                        break;
                    case 3:
                        System.out.println("Enter material type");
                        String material_type = scanner.nextLine();
                        materialFilter(material_type);
                        break;
                    default:
                        System.out.println("You have entered wrong option");
                        System.out.println("Press 0 to exit");
                        break;
                }
            } while (choice != 0);


        } else {
            System.out.println("----------Please select the filter you want to apply------------");
            int choice;
            do {
                System.out.println("-----Press 0 to exit-------");
                System.out.println("1. Price filter");
                System.out.println("2. Brand filter");
                System.out.println("3. Condition filter");
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        priceFilter();
                        break;

                    case 2:
                        brandFilter();
                        break;
                    case 3:
                        System.out.println("Enter Condition OLD/NEW");
                        String condition = scanner.nextLine();
                        condition = condition.toUpperCase();
                        Condition productCondition = Condition.valueOf(condition);
                        conditionFilter(productCondition);
                        break;
                    default:
                        System.out.println("You have entered wrong option");
                        System.out.println("Press 0 to exit");
                        break;
                }
            } while (choice != 0);
        }
        if (BuyProduct.cart.size() > 0) {
            System.out.println("Do you wish to checkout (Y/N): ");
            String choice = scanner.nextLine();
            choice = choice.toUpperCase();
            if (choice.equals("Y")) {
                bill = calcBill();
                System.out.println("Total bill is " + bill);
            }

        }

    }

    public void priceFilter() {
        int min = 0, max = 0;
        System.out.println("Enter minimum value: ");
        min = scanner.nextInt();
        System.out.println("Enter maximum value: ");
        max = scanner.nextInt();
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
            product = ProductEntry.productList.get(i);
            if (product.price <= max && product.price >= min) {

                System.out.println("Id: " + i + " name: " + product.productName);
                productsFound = true;
            }
        }
        if (!productsFound) {
            System.out.println("Sorry we can't find any matches");
        } else {
            addToCart();

        }

        productsFound=false;
    }

    @Override
    public void findBrand(String name) {

        for (int i = 0; i < ProductEntry.productList.size(); i++) {
            product = ProductEntry.productList.get(i);
            if (product.productName.equals(name)) {
                System.out.println("Id: " + i + " name: " + product.productName);

                productsFound = true;
            }
        }
        if (!productsFound) {
            System.out.println("Sorry we can't find any matches");
        } else {
            addToCart();
        }
        productsFound=false;

    }

    @Override
    public void materialFilter(String materialType) {
        for (int i = 0; i < ProductEntry.productList.size(); i++) {
            product = ProductEntry.productList.get(i);
            if (((Clothing) product).material.equals(materialType)) {
                System.out.println("Id: " + i + " name: " + product.productName);
                productsFound = true;
            }
        }
        if (!productsFound) {
            System.out.println("Sorry we can't find any matches");
        } else {
            addToCart();
        }
        productsFound=false;
    }

    @Override
    public void conditionFilter(Condition productCondition) {

        for (int i = 0; i < ProductEntry.productList.size(); i++) {

            product = ProductEntry.productList.get(i);

            if (((Electronics) product).condition.equals(productCondition)) {
                System.out.println("Id: " + i + " name: " + product.productName);
                productsFound = true;
            }
        }
        if (!productsFound) {
            System.out.println("Sorry we can't find any matches");
        } else {
            addToCart();
        }
        productsFound=false;

    }

    public void addToCart() {
        int id;
        do {
            System.out.println("Enter product ID to add to cart or -1 to continue searching");
            id = scanner.nextInt();
            if (id >= 0 && id < ProductEntry.productList.size())
                buyProduct.addToCart(ProductEntry.productList.get(id));
            System.out.println("Invalid ID entered please check");
        }
        while (id != -1);

    }

    public int calcBill() {
        int bill = 0;
        for (int i = 0; i < BuyProduct.cart.size(); i++)
            bill += BuyProduct.cart.get(i).price;
        return bill;
    }
}
