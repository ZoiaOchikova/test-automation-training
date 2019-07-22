package Selenium.hw1.enums;

public enum Urls {

    JDI("http://epam.github.io/JDI/index.html"),
    GITHUB_JDI("https://github.com/epam/JDI");

    final String url;

    Urls(String url){
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
