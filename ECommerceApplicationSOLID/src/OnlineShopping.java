import java.util.Scanner;

public class OnlineShopping {

int bill=0;



    public void addToCart(){
        BuyProduct buyProduct=new BuyProduct();
        int id ;
        do {
            System.out.println("Enter product ID to add to cart or -1 to continue searching");
            Scanner scanner=new Scanner(System.in);
            id= scanner.nextInt();
            scanner.nextLine();
            if (id >= 0 && id < ProductEntry.productList.size())
                buyProduct.addToCart(ProductEntry.productList.get(id));
            else
            System.out.println("Invalid ID entered please check");
        }
        while(id!=-1);


    return;

    }
}
