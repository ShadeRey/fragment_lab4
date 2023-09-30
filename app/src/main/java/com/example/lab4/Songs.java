package com.example.lab4;

public class Songs {
    public String name;
    public String author;
    private int animeResource;
    private String description;

    public Songs(String name, String author, int anime, String description){
        this.name=name;
        this.author=author;
        this.animeResource=anime;
        this.description=description;
    }
    public Songs(String name, String author, int anime){
        this.name=name;
        this.author=author;
        this.animeResource=anime;
        this.description="";
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getAuthor(){
        return this.author;
    }
    public void setAuthor(){
        this.author=author;
    }
    public int getAnimeResource(){
        return this.animeResource;
    }
    public void setAnimeResource(int animeResource){
        this.animeResource=animeResource;
    }
    public String getDescription(){return this.description;}
    public void setDescription(String description){this.description=description;}
}
