import java.time.LocalDate;

public abstract class Product {

    String id;
    LocalDate exdate;
    int qual;
    int price;
    Boolean remove = false;

    abstract void nextDay();

    abstract String info();

}
