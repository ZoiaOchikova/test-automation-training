package Selenium.hw1.enums;

public enum Titeles {

    EPAM_FRAMEWORK_WISHES("EPAM FRAMEWORK WISHES…"),
    JDI_GITHUB("JDI GITHUB"),
    HOME_PAGE("Home Page");

    final String title;

    Titeles(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }
}
