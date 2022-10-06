import java.time.LocalDate;

public class Crackers extends Product{

    int baseprice = 99;
    int counter = 0;

    @Override
    void nextDay() {
        if (counter == 5){
            qual--;
            counter = 0;
        }else {
            counter++;
        }
        if (qual < 30 || LocalDate.now().isAfter(exdate)){ //not great; calculates LocalDate.now() for every Kaese
            remove = true;
        }
    }
    @Override
    String info() {
        if (remove == true){
            return id + " muss entfernt werden.";
        }
        return id + " // " + price/100 + "," + price%100 + "€" + " // " + qual + " // " + "Ablaufdatum: " + exdate;
    }


    public Crackers(String id, int qual, LocalDate exdate){
        this.id = id;
        this.qual = qual;
        this.exdate = exdate;
        this.price = baseprice + qual * 10;
    }

    public Crackers(){
        this.id = "Käse" + Math.random();
        this.qual = (int)(Math.random()*50+30);
        this.exdate = LocalDate.now().plusDays((long)(Math.random()*50+50));
        this.price = baseprice + qual * 10;
    }

}
