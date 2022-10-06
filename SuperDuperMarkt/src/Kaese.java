import java.time.LocalDate;

public class Kaese extends Product {

    int baseprice = 99;

    @Override
    void nextDay() {
        qual--;
        if (qual < 30 || LocalDate.now().isAfter(exdate)) { //not great; calculates LocalDate.now() for every Kaese
            remove = true;
        } else {
            price -= 10;
        }
    }

    @Override
    String info() {
        if (remove) {
            return id + " muss entfernt werden.";
        }
        return id + " // " + price / 100 + "," + price % 100 + "€" + " // " + qual + " // " + "Ablaufdatum: " + exdate;
    }

    public Kaese(String id, int qual, LocalDate exdate) {
        this.id = id;
        this.qual = qual;
        this.exdate = exdate;
        this.price = baseprice + qual * 10;
    }

    public Kaese() {
        this.id = "Käse" + Math.random();
        this.qual = (int) (Math.random() * 50 + 30);
        this.exdate = LocalDate.now().plusDays((long) (Math.random() * 50 + 50));
        this.price = baseprice + qual * 10;
    }

}
