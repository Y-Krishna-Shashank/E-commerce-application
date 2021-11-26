public class Electronics extends Products{

Condition condition;
public Electronics(){}

    public Electronics(String productName, int price,Condition condition) {
        super(productName, price);
        this.condition=condition;
    }
}
