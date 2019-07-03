package hw4.enums;

public enum Radios {

    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    final String text;

    Radios(String text){ this.text = text;}

    public String getText() {
        return text;
    }
}
