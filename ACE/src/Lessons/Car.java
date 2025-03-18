package Lessons;

class Car {
    int speed;
    double price;
    String color;

    Car(int s, double p, String c) {
        this.speed = s;
        this.price = p;
        this.color = c;
    }

    double getSalePrice() {
        return price;
    }
}

