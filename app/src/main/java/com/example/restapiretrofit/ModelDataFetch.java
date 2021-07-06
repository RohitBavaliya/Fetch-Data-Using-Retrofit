package com.example.restapiretrofit;

public class ModelDataFetch {
    String id, name, profession, image;

    public ModelDataFetch() {
    }

    public ModelDataFetch(String id, String name, String profession, String image) {
        this.id = id;
        this.name = name;
        this.profession = profession;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
