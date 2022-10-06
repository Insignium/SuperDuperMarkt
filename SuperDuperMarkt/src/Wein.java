public class Wein extends Product {

    int baseprice = 999;

    @Override
    void nextDay() {
        if (qual < 50) {
            qual++;
        }
    }

    @Override
    String info() {
        return id + " // " + price / 100 + "," + price % 100 + "€" + " // " + qual;
    }

    public Wein(String id, int qual) {
        this.baseprice = 1000;
        this.id = id;
        this.qual = qual;
        this.price = baseprice + qual * 10;
    }

    public Wein() {
        this.id = "Wein" + Math.random();
        this.qual = (int) (Math.random() * 100 + 0);
        this.price = baseprice + qual * 10;
    }

}
