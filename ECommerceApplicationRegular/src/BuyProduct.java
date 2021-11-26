import java.util.ArrayList;
import java.util.List;


public class BuyProduct {
static List<Products> cart=new ArrayList<>();

    public void addToCart(Products product){

        cart.add(product);
        System.out.println("product added to cart successfully");
        }
    }


