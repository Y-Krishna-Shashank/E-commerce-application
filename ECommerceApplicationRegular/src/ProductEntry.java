import java.util.ArrayList;
import java.util.List;

public class ProductEntry {
    public static List<Products> productList = new ArrayList<Products>();
    ProductEntry(Products product)
    {

        productList.add(product);
    }
}
