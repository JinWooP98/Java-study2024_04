package day12.stream;

public class SimpleDish {

    private final String name;
    private final int calories;
    private final boolean vegi;


    public SimpleDish(Dish dish) {
        this.name = dish.getName();
        this.calories = dish.getCalories();
        this.vegi = dish.isVegeterian();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "SimpleDish{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", vegi=" + vegi +
                '}';
    }
}

