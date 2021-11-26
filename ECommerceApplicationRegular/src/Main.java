import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
    int choice;
    int price=0;
    String productName="";
        System.out.println("Online shopping interface");
        System.out.println("-----------Product entry-----------");
        System.out.println("Press: ");
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("0. To exit");
            System.out.println("1. To enter a clothing product ");
            System.out.println("2. To enter a electronic product");

            choice=scanner.nextInt();
            scanner.nextLine();
            if(choice!=0) {
                System.out.println("Enter brand name: ");
                productName = scanner.nextLine();
                System.out.println("Enter price: ");
                price = scanner.nextInt();
                scanner.nextLine();
            }
            switch(choice){
                case 0: break;
                case 1:

                    System.out.println("Enter material type: ");
                    String material=scanner.nextLine();
                    Products newClothingProduct= new Clothing(productName,price,material);
                    ProductEntry newClothingProductEntry = new ProductEntry(newClothingProduct);
                    break;
                case 2:

                    System.out.println("Enter condition OLD/NEW: ");
                    String productCondition=scanner.nextLine();
                    productCondition=productCondition.toUpperCase();
                    Condition condition = Condition.valueOf(productCondition);
                    Products newElectronicProduct = new Electronics(productName,price,condition);
                    ProductEntry newElectronicProductEntry = new ProductEntry(newElectronicProduct);
                    break;
                default:
                    System.out.println("You have entered wrong option");
                    System.out.println("Press 0 to exit");
                    break;
            }
        }while(choice!=0);

        System.out.println("------------Online Shopping----------------------");
    OnlineShopping onlineShopping=new OnlineShopping();
    do{
        System.out.println("Enter: ");
        System.out.println("0. To exit");
        System.out.println("1. If you want to buy clothes");
        System.out.println("2. If you want to buy electronics");
        System.out.println("3. For both");
        choice=scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 0: break;

            case 1: onlineShopping.searchProduct(new Clothing());
            break;
            case 2: onlineShopping.searchProduct(new Electronics());
            break;
            case 3: onlineShopping.searchProduct(new Clothing());
            onlineShopping.searchProduct(new Electronics());
            break;
            default:
                System.out.println("You have entered wrong option try again or enter 0 to exit");
                break;
        }
    }while(choice!=0);

        //Liskov Substitution Principle violation
        if(onlineShopping.bill>0) {
            System.out.println("Product Delivery: ");
            System.out.println("Are you a premium customer? (Y/N): ");
            String answer=scanner.nextLine();
            answer=answer.toUpperCase();
            if(answer.equals("Y")) {
                ProductDelivery premiumCustomer = new PremiumCustomer();
                premiumCustomer.charges(onlineShopping.bill);
                premiumCustomer.makePayment();
            }
            else {
                ProductDelivery regularCustomer = new RegularCustomer();
                regularCustomer.charges(onlineShopping.bill);
                regularCustomer.makePayment();
            }


        }

    }
}
