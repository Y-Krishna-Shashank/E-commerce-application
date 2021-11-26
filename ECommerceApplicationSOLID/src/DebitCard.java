public class DebitCard extends PaymentSystem implements CardPayments{
    public void processPayment(){
        authenticate();
        System.out.println("Payment done successfully");
    }
    public void authenticate(){
        System.out.println("Please enter your card details");
    }
}
