import java.util.*;
class Customer{
    Scanner scan=new Scanner(System.in);
    String name;
    String address;
    List<Product> mainset;
    List<Product> cart=new ArrayList<Product>();
    
    Customer(String name,List<Product> mainset){
        this.name=name;
        this.mainset=mainset;
    }

    void viewProducts(){
        for(Product p:mainset){
            System.out.println("Name: " + p.name );
            System.out.println("Price: " + p.price );
        }
        System.out.println();
    }

    void addtoCart(){
        String cartProduct;
        int quantity;
        int flag=0,i;
        System.out.println("ENTER THE PRODUCT NAME TO ADD TO CART: ");
        cartProduct=scan.next();
        System.out.println("Enter the quantity: ");
        quantity=scan.nextInt();
        for(Product p:mainset){
            if(p.name.equals(cartProduct)){
                for(i=0;i<quantity;i++){
                    cart.add(p);
                    flag=1;
                }
            }
        }
        if(flag==1){
            System.out.println("Product added to cart");
        }
        else if(flag==0){
            System.out.println("Product not available");
        }
        System.out.println();
    }

    void viewCart(){
        if(cart.size()==0){
            System.out.println("Cart is empty");
            return;
        }
        int num=1;
        for(Product p:cart){
            System.out.println(num+" Name: " + p.name );
            System.out.println("  Price: " + p.price );
        }
        System.out.println();
    }

    void removefromCart(){
        String name;
        System.out.println("Enter the name of the product to be removed: ");
        name=scan.next();
        int ind=-1;
        for(int i=0;i<cart.size();i++){
            if(cart.get(i).name.equals(name)){
                ind=i;
            }
        }
        cart.remove(ind);
        System.out.println("Product removed");
        System.out.println();
    }

    void viewBill(){
        int num=1;
        int bill=0;
        for(Product p:cart){
            System.out.println(num+" Name: " + p.name );
            bill+=p.price;
            num+=1;
        }
        System.out.println("Your total bill amount is: Rs"+bill);
        System.out.println();

    }

    void placeOrder(){
        viewBill();
        System.out.println("ENTER YOUR ADDRESS: ");
        address=scan.next();
        System.out.println("Your order is placed! ");
    }

}
