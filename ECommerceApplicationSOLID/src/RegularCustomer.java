public class RegularCustomer implements RegularProductDelivery{
    @Override
    public int charges(int bill) {
        if(bill<499)
        bill+=499;
        return bill;
    }

    @Override
    public void deliveryDate() {
        System.out.println("Takes minimum 2 days for delivery");
    }
}
