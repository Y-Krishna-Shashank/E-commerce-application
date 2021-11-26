public class Clothing extends Products {

String material;
public Clothing(){}

    public Clothing(String productName, int price,String material) {
        super(productName, price);
        this.material=material;
    }
}
