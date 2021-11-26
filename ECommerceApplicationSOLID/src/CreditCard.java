public class CreditCard extends PaymentSystem implements CardPayments{
public void processPayment(){
    //;
    authenticate();
    System.out.println("Payment done successfully");
}

    @Override
    public void authenticate() {
        System.out.println(" Please enter your card details ");
    }
}
