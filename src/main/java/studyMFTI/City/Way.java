package studyMFTI.City;

import lombok.Data;
import studyMFTI.City.City;

// Задача 1.3.3
// Задача 1.6.9
@Data
public class Way {
    private final City city;
    private Integer price;

    public Way(City city, int price) {
        this.city = city;
        this.price = price;
    }
    @Override
    public String toString() {
        return city.getName() + ": " + price;
    }
}
