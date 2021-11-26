public class Electronics extends Products{

    ProductCondition productCondition;
    public Electronics(){}

    public Electronics(String productName, int price, ProductCondition productCondition) {
        super(productName, price);
        this.productCondition = productCondition;
    }
}
