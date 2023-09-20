package com.example.lab4;

public class Songs {
    private String name;
    private String author;
    private int animeResource;

    public Songs(String name, String author, int anime){
        this.name=name;
        this.author=author;
        this.animeResource=anime;
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
}
