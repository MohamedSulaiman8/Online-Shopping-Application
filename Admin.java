import java.util.*;
class Admin{
    Scanner scan=new Scanner(System.in);
    HashMap<String,List<Product>> Products=new HashMap<>();
    HashMap<String,List<Product>> requests=new HashMap<>();
    ArrayList<Customer> SetCustomer=new ArrayList<Customer>();

    void approveRequest(){
        if(requests.size()==0){
            System.out.println("No new requests");
        }
        else{
            for(Map.Entry<String,List<Product>> current:requests.entrySet()){
                System.out.println("Seller: "+current.getKey()+" "+"Product: "+current.getValue().get(current.getValue().size()-1).name);
            }
            System.out.println("Enter the seller name to be approved or 0 to exit: ");
            String name=scan.next();
            for(Map.Entry<String,List<Product>> current:requests.entrySet()){
                if(current.getKey().equals(name)){
                    List<Product> list=requests.get(name);
                    Products.put(name,list);
                    break;
                }
            }
        }
    }

    void request(String s,Product p){
        for(Map.Entry<String,List<Product>> item:requests.entrySet()){
            if(item.getKey().equals(s)){
                // System.out.println(requests);
                List<Product> req=requests.get(item.getKey());
                req.add(p);
                requests.put(s,req);
                return;
            }
        }
        List<Product> req=new ArrayList<>();
        req.add(p);
        requests.put(s,req);
    }

    void viewProducts(){
        if(Products.size()==0){
            System.out.println("No products available!!!");
        }
        for(Map.Entry<String,List<Product>> current:Products.entrySet()){
            for(Product p:current.getValue()){
                System.out.println("Product: "+p.name);
                System.out.println("Price: "+p.price);
                System.out.println("Seller: "+p.seller);
            }
            System.out.println();
        }
        System.out.println();
    }

    void removeProduct(){
        if(Products.size()==0){
            System.out.println("No products available!!!");
            return;
        }
        System.out.println("Enter product name to delete : ");
        String pname=scan.next();
        for(Map.Entry<String,List<Product>> current:Products.entrySet()){
            List<Product> list=current.getValue();
            for(Product p:list){
                if(p.name.equals(pname)){
                    System.out.println(p.name);
                    list.remove(p);
                    if(list.size()==0){
                        Products.remove(current.getKey());
                    }
                    else{
                        Products.put(current.getKey(),list);
                    }
                    break;
                }
            }
        }
        System.out.println("Product Removed"); 
        System.out.println(Products);      
    }

    void viewCustomers(ArrayList<Customer> Customers){
        if(Customers.size()==0){
            System.out.println("No customers available!!!");
            return;
        }
        int num=1;
        SetCustomer=Customers;
        for(Customer c:SetCustomer){
            System.out.println(num+" Name: " + c.name );
            System.out.println("  Price: " + c.address );
            num+=1;
            System.out.println();
        }
        System.out.println();
    }
}
