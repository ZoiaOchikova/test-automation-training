package Selenium.hw4.enums;

public enum ServiceTexts {
    SUPPORT("SUPPORT"),
    DATES("DATES"),
    COMPLEX_TABLE("COMPLEX TABLE"),
    SIMPLE_TABLE("SIMPLE TABLE"),
    TABLES_WITH_PAGES("TABLE WITH PAGES"),
    DIFFERENT_ELEMENTS("DIFFERENT ELEMENTS"),
    SIDEBARSUPPORT("Support"),
    SIDEBARDATES("Dates"),
    SIDEBARCOMPLEX_TABLE("Complex Table"),
    SIDEBARSIMPLE_TABLE("Simple Table"),
    SIDEBARTABLES_WITH_PAGES("Table with pages"),
    SIDEBARDIFFERENT_ELEMENTS("Different elements");

    final String text;

    ServiceTexts(String text){ this.text = text;}

    public String getText() {
        return text;
    }
}
