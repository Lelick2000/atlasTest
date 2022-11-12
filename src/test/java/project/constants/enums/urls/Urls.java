package project.constants.enums.urls;

public enum Urls {
    BASE_UI("https://www.saucedemo.com/"),
    BASE_API("/");


    private String url;

    Urls(String urlPart) {
        this.url = urlPart;
    }

    public String getUrl() {
        return url;
    }
}
