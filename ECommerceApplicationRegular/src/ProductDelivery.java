import java.util.Scanner;

public class ProductDelivery {
    Scanner scanner = new Scanner(System.in);
    public void charges(int bill) throws Exception {
        if (bill < 499)
            bill += 50;
    }
    public void makePayment(){
        System.out.println("Please select payment type by entering the payment id" );
        PaymentSystem.PaymentMethod[] paymentMethods=  PaymentSystem.PaymentMethod.values();
        int ID=1;
        for(PaymentSystem.PaymentMethod paymentMethod: paymentMethods)
        {
            System.out.println("Payment ID "+ID+" "+paymentMethod);
        }
        ID= scanner.nextInt();
        scanner.nextLine();
        PaymentSystem paymentSystem=new PaymentSystem(paymentMethods[ID]);
    }
    public void deliveryDate() throws Exception {
        System.out.println("Minimum two days to deliver your product");
    }
}
