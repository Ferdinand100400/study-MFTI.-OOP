package studyMFTI;

import java.util.ArrayList;
import java.util.List;

// Задача 1.3.3
// Задача 1.4.8
public class City {
    private String name;
    private List<Way> ways = new ArrayList<>();

    public City(String name, List<Way> ways) {
        this.name = name;
        if (ways != null) this.ways = ways;
    }
    public City(String name) {
        this(name, null);
    }

    @Override
    public String toString() {
        String res = name + " {";
        for (int i = 0; i < ways.size() - 1; i++) {
            res += ways.get(i) + ", ";
        }
        res += ways.get(ways.size() - 1) + "}";
        return res;
    }
    public String getName() {
        return name;
    }

    public void setWay(int index, Way way) {
        if (index >= this.ways.size() || index < 0) {
            if (index > this.ways.size() || index < 0) throw new ArrayIndexOutOfBoundsException();
            ways.add(way);
            return;
        }
        ways.set(index, way);
    }
    public void setWays(List<Way> ways) {
        this.ways = ways;
    }
}
