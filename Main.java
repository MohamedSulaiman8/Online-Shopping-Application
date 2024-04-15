import java.util.*;
public class Main{
    public static void main(String[] args) {
        ArrayList<Customer> Customers=new ArrayList<Customer>();
        Admin a1=new Admin();
        Scanner scan=new Scanner(System.in);
        String user="";
        List<Product> mainset=new ArrayList<Product>();

        while(!user.equals("exit")){
            System.out.println("Admin\nCustomer\nSeller");
            System.out.println();
            System.out.println("Exit");
            System.out.println();
            System.out.println("Enter your Identity: ");
            user=scan.next();
            System.out.println();

            if(user.toLowerCase().equals("admin")){
                String ch="Y";
                int choice;

                while(ch.toLowerCase().equals("y")){
                    System.out.println("1.APPROVE PRODUCTS \n2.VIEW PRODUCTS\n3.REMOVE PRODUCTS \n4.VIEW CUSTOMER\n5.EXIT\n");
                    System.out.println("ENTER YOUR CHOICE: ");
                    choice=scan.nextInt();
                    System.out.println();

                    if(choice==1){
                        a1.approveRequest();
                    }
                    else if(choice==2){
                        a1.viewProducts();
                    }
                    else if(choice==3){
                        a1.removeProduct();
                    }
                    else if(choice==4){
                        a1.viewCustomers(Customers);
                    }
                    else if(choice==5){
                        break;
                    }
                }

                for(Map.Entry<String,List<Product>> item:a1.Products.entrySet()){
                       for(Product p: item.getValue()){
                        if(!mainset.contains(p)){
                            mainset.add(p);
                        }
                       }
                }
            }
            else if(user.toLowerCase().equals("customer")){
                System.out.println("Enter your name: ");
                String name=scan.next();
                System.out.println();
                Customer c1=new Customer(name, mainset);
                Customers.add(c1);
                String ch="Y";
                int choice;

                while(ch.toLowerCase().equals("y")){
                    System.out.println("1.VIEW PRODUCTS \n2.ADD PRODUCT TO CART\n3.REMOVE PRODUCT FROM CART \n4.VIEW CART\n5.VIEW BILL\n6.PLACE ORDER\n7.EXIT\n");
                    System.out.println("ENTER YOUR CHOICE: ");
                    choice=scan.nextInt();
                    System.out.println();

                    if(choice==1){
                        c1.viewProducts();;
                    }
                    else if(choice==2){
                        c1.addtoCart();
                    }
                    else if(choice==3){
                        c1.removefromCart();
                    }
                    else if(choice==4){
                        c1.viewCart();
                    }
                    else if(choice==5){
                        c1.viewBill();
                    }
                    else if(choice==6){
                        c1.placeOrder();
                    }
                    else if(choice==7){
                        break;
                    }
                }
            }
            else if(user.toLowerCase().equals("seller")){
                System.out.println("Enter your name: ");
                String name=scan.next();
                System.out.println();
                System.out.println("Enter the Seller ID");
                int id=scan.nextInt();
                System.out.println();
                Seller s=new Seller(name,id);
                String ch="Y";
                int choice;

                while(ch.toLowerCase().equals("y")){
                    System.out.println("1.ADD PRODUCTS \n2.VIEW PRODUCTS\n3.EXIT\n");
                    System.out.println("ENTER YOUR CHOICE: ");
                    choice=scan.nextInt();
                    System.out.println();

                    if(choice==1){
                        System.out.println("Enter product name: ");
                        String pname=scan.next();
                        System.out.println();
                        System.out.println("Enter product price: ");
                        int price=scan.nextInt();
                        System.out.println();
                        Product p=new Product(pname,price,s.name);
                        a1.request(name,p);
                    }
                    else if(choice==2){
                        
                        List<Product> sellerProducts=a1.Products.get(name);
                        if(sellerProducts==null){
                            System.out.println("You have not added any products yet");
                        }
                        else{
                            for(Product p:sellerProducts){
                                System.out.println("PRODUCT: "+p.name);
                                System.out.println("PRICE: "+p.price);
                            }
                        }
                    }
                    else if(choice==3){
                        break;
                    }
                }
            }
            else if(user.toLowerCase().equals("exit")){
                break;
            }
        }  
        scan.close();
    }
}
