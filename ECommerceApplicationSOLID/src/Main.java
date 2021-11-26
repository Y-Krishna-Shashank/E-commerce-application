import java.util.Scanner;

public class Main {

   static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int choice;
        int price=0;
        int bill = 0;
        String option = null;
        String productName="";
        System.out.println("Online shopping interface");
        System.out.println("Product entry");
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
                    ProductEntry.productList.add(newClothingProduct);
                    break;
                case 2:

                    System.out.println("Enter condition OLD/NEW: ");
                    String productCondition=scanner.nextLine();
                    productCondition=productCondition.toUpperCase();
                    ProductCondition condition = ProductCondition.valueOf(productCondition);
                    Products newElectronicProduct = new Electronics(productName,price,condition);
                    ProductEntry.productList.add(newElectronicProduct);
                    break;
                default:
                    System.out.println("You have entered wrong option");
                    System.out.println("Press 0 to exit");
                    break;
            }
        }while(choice!=0);

        //interface segregation principle

        System.out.println("----------Buying------------------");
        OnlineShopping onlineShopping;
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
                case 1: onlineShopping=new ClothSearch(new Clothing());
                    break;
                case 2: onlineShopping=new ClothSearch(new Electronics());
                    break;
                case 3:
                    onlineShopping=new ClothSearch(new Clothing());
                    onlineShopping=new ClothSearch(new Electronics());
                    break;
                default:
                    System.out.println("You have entered wrong option try again or enter 0 to exit");
                    break;
            }
        }while(choice!=0);

        if (BuyProduct.cart.size() > 0) {
            System.out.println("Do you wish to checkout (Y/N): ");
            option = scanner.nextLine();
            option = option.toUpperCase();
            if (option.equals("Y")) {
                bill = new CalculateBill().calcBill();
                System.out.println("Total bill is " + bill);
            }

        }

        //Liskov Substitution Principle violation
        if(bill>0) {
            System.out.println("Product Delivery: ");
            System.out.println("Are you a premium customer? (Y/N): ");
            String answer=scanner.nextLine();
            answer=answer.toUpperCase();
            if(answer.equals("Y")) {
                ProductDelivery premiumDelivery = new PremiumCustomer();
                premiumDelivery.deliveryDate();

            }
            else{
                RegularProductDelivery regularDelivery = new RegularCustomer();
                regularDelivery.charges(bill);
                regularDelivery.deliveryDate();
            }
            makePayment();


        }


    }

    //open closed principle
    public static void makePayment(){
        System.out.println("Select payment method ");
        System.out.println("Enter: ");
        System.out.println("1. To select cash");
        System.out.println("2. To select Credit Card");
        System.out.println("3. To select Debit Card");
        System.out.println("4. To select UPI");
        System.out.println("0. To exit");
        int choice =scanner.nextInt();
        scanner.nextLine();
        switch(choice)
        {
            case 0: break;
            case 1: PaymentSystem cash = new Cash();
            cash.processPayment();
            break;
            case 2: CardPayments creditCard = new CreditCard();
            creditCard.authenticate();
            break;
            case 3: CardPayments debitCard = new DebitCard();
            debitCard.authenticate();
            case 4: PaymentSystem  upi = new UPI();
            upi.processPayment();
        }

    }






















/*--------------------------------------------------------------------
        RegularProductDelivery regularDelivery = new RegularCustomer();
        regularDelivery.charges(300);
        regularDelivery.deliveryDate();
        ProductDelivery premiumDelivery = new PremiumCustomer();
        premiumDelivery.deliveryDate();
---------------------------------------------------------------------*/


}
