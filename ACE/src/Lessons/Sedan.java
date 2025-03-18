package Lessons;

class Sedan extends Car {
    int length;

    Sedan(int s, double p, String c, int l) {
        super(s, p, c);
        this.length = l;
    }

    
    double getSalePrice() {
        return length > 20 ? price * 0.95 : price * 0.90;
    }
}
