package Lessons;

class Ford extends Car {
    int year;
    int discount;

    Ford(int s, double p, String c, int y, int d) {
        super(s, p, c);
        this.year = y;
        this.discount = d;
    }
}