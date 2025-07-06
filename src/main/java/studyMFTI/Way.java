package studyMFTI;

// Задача 1.3.3
public class Way {
    private City city;
    private int price;

    public Way(City city, int price) {
        this.city = city;
        this.price = price;
    }

    @Override
    public String toString() {
        return city.getName() + ": " + price;
    }
}
