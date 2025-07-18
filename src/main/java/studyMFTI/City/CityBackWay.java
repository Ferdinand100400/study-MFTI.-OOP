package studyMFTI.City;

// Задача 2.1.3
public class CityBackWay extends City {
    public CityBackWay(String name, Way... ways) {
        super(name, ways);
    }
    public CityBackWay(String name) {
        super(name);
    }

    @Override
    public void setWay(int index, Way way) {
        super.setWay(index, way);
        if (way != null) way.getCity().addWay(new Way(this, way.getPrice()));
    }
}
