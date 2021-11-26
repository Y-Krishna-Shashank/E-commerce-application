public class PremiumCustomer extends ProductDelivery{
    @Override
    public void charges(int bill) throws Exception {
        throw new Exception("Delivery charges not applicable");
    }

    @Override
    public void deliveryDate() throws Exception {
        super.deliveryDate();
    }
}
