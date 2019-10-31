package com.markedstudios.imagetable.model;


import org.json.JSONObject;

public class HeroModel extends JSONObject {

    String name, imageurl, team, firstappearance, createdby, publisher, bio;

    public HeroModel(){

    }

    public HeroModel(String name, String team, String firstappearance, String createdby, String publisher, String bio, String imageurl){
        this.name = name;
        this.team = team;
        this.firstappearance = firstappearance;
        this.createdby = createdby;
        this.publisher = publisher;
        this.bio = bio;
        this.imageurl = imageurl;
    }

    private void setName(String name){
        this.name = name;
    }
    private void setTeam(String team){this.team = team;}
    private void setFirstAppearance(String firstappearance){this.firstappearance = firstappearance;}
    private void setCreatedBy(String createdby){this.createdby = createdby;}
    private void setPublisher(String publisher){this.publisher=publisher;}
    private void setBio(String bio) { this.bio = bio; }
    private void setUrl(String imageurl){
        this.imageurl = imageurl;
    }

    public String getName(){
        return name;
    }
    public String getTeam() { return team ; }
    public String getFirstappearance() { return firstappearance; }
    public String getCreatedby(){ return createdby;}
    public String getPublisher() { return publisher;}
    public String getBio(){ return bio;}
    public String getImageurlUrl(){
        return imageurl;
    }


}

/** Sample data model
 * {
 * "name":"Captain America",
 * "realname":"Steve Rogers",
 * "team":"Avengers",
 * "firstappearance":"1941",
 * "createdby":"Joe Simon",
 * "publisher":"Marvel Comics",
 * "imageurl":"https:\/\/www.simplifiedcoding.net\/demos\/marvel\/captainamerica.jpg",
 * "bio":"\r\n\t\tSteven Rogers was born in the Lower East Side of Manhattan,
 * New York City, in 1925 to poor Irish immigrants, Sarah and Joseph Rogers.
 * [54] Joseph died when Steve was a child,
 * and Sarah died of pneumonia while Steve was a teen. By early 1940,
 * before America's entry into World War II, Rogers is a tall,
 * scrawny fine arts student specializing in illustration and a comic book writer and artist.
 * \r\n\t\t"}**/