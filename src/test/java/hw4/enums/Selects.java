package hw4.enums;

public enum Selects {

    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    final String text;

    Selects(String text){ this.text = text;}

    public String getText() {
        return text;
    }
}
