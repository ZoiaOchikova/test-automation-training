package Selenium.hw1.enums;

public enum HeadersSection {

    HOME("HOME"),
    CONTACT_FORM("CONTACT FORM"),
    SERVICE("SERVICE"),
    METALS_AND_COLORS("METALS & COLORS");

    final String name;

    HeadersSection(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
