public class PaymentSystem {
    enum PaymentMethod{
        CASH,
        CREDITCARD,
        DEBITCARD,
        REWARDPOINTS;
    }
    public PaymentSystem(PaymentMethod paymentMethod)
    {
        if(paymentMethod==PaymentMethod.CREDITCARD||paymentMethod==PaymentMethod.DEBITCARD)
        {
            CardAuthentication cardAuthentication= new CardAuthentication();
            cardAuthentication.authenticate(paymentMethod);

        }
//        else if(paymentMethod==)
    }
}
