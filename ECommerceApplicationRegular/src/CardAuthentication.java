public class CardAuthentication {

    public void authenticate(PaymentSystem.PaymentMethod paymentMethod){
//    sout
        if(paymentMethod== PaymentSystem.PaymentMethod.DEBITCARD)
        System.out.println("Please enter your debit card CVV for authentication:");

        if(paymentMethod== PaymentSystem.PaymentMethod.CREDITCARD)
            System.out.println("Please enter your credit card CVV for authentication:");
    }


}
