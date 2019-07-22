package Selenium.hw4.enums;

public enum Checkboxes {
    WATER("Water"),
    WIND("Wind"),
    EARTH("Earth"),
    FIRE("Fire");

    final String text;

    Checkboxes(String text){ this.text = text;}

    public String getText() {
        return text;
    }
}
