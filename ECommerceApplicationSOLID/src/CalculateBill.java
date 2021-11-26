public class CalculateBill extends OnlineShopping{

    public int calcBill() {
        int bill = 0;
        for (int i = 0; i < BuyProduct.cart.size(); i++)
            bill += BuyProduct.cart.get(i).price;
        return bill;
    }
}
