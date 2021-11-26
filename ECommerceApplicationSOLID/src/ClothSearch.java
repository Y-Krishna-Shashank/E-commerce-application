public class ClothSearch extends SearchProduct implements ClothFilter {
    public ClothSearch(Products product) {
        super(product);
        selectFilter();

    }

    public void selectFilter() {

        System.out.println("----------Please select the filter you want to apply------------");
        int choice;
        do {
            System.out.println("0. Press 0 to exit");
            System.out.println("1. Price filter");
            System.out.println("2. Brand filter");
            System.out.println("3. Material filter");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0: break;
                case 1:
                    super.priceFilter();
                    if (!SearchProduct.productsFound) {
                        System.out.println("Sorry we can't find any matches");
                    } else {
                        addToCart();
                    }
                    SearchProduct.productsFound = false;
                    break;

                case 2:
                    super.brandFilter();
                    if (!SearchProduct.productsFound) {
                        System.out.println("Sorry we can't find any matches");
                    } else {
                        addToCart();
                    }
                    SearchProduct.productsFound = false;
                    break;
                case 3:
                    System.out.println("Enter material type");
                    String material_type = scanner.nextLine();
                    materialFilter(material_type);
                    if (!SearchProduct.productsFound) {
                        System.out.println("Sorry we can't find any matches");
                    } else {
                        super.addToCart();
                    }
                    SearchProduct.productsFound = false;
                    break;
            }
        } while (choice != 0);
    }

    @Override
    public void materialFilter(String material_type) {
        for (int i = 0; i < ProductEntry.productList.size(); i++) {
            product = ProductEntry.productList.get(i);
            if (((Clothing) product).material.equals(material_type)) {
                System.out.println("Id: " + i + " name: " + product.productName);
                productsFound = true;
            }
        }

    }


    @Override
    public void priceRange(int min, int max) {
        super.priceRange(min, max);
    }

    @Override
    public void findBrand(String brand_name) {
        super.findBrand(brand_name);
    }

    @Override
    public void addToCart() {
        super.addToCart();
    }
}
