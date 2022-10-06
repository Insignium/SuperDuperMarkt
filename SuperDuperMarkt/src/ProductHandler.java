import java.util.List;

public class ProductHandler {
    
    List<Product> wares;
    
    ProductHandler(List<Product> wares){
        this.wares = wares;
        for (Product p : wares) {
            System.out.println(p.info());
        }
    }
    
    public void nextDay(){
        for (Product p : wares) {
            p.nextDay();
            System.out.println(p.info());
        }
    }

    public void remove(int i){
        wares.remove(i);
    }

}
