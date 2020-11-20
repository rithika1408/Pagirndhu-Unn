package com.example.pagirunarvu;

public class Upload {

    public String name;
    public String description;
    public String url;


    public Upload() {
    }

    public Upload(String name, String description, String url) {
        this.name = name;
        this.description=description;
        this.url= url;

    }

    public String getName() {
        return name;
    }

    public String getDescription(){return description;}

    public String getUrl() {
        return url;
    }
}
