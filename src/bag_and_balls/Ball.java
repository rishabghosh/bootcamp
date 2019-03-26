package bag_and_balls;

public enum Ball {
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    private String colour;

    Ball(String colour) {
        this.colour = colour;
    }
}
