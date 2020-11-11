package com;

public class News {
    private int id;
    private int ispass;
    private String title;
    private String content;
    private String username;

    public News() {
        super();
    }

    public News(int id, String title, String content, String username, int ispass) {
        super();
        this.id = id;
        this.ispass = ispass;
        this.content = content;
        this.title = title;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsPass() {
        return ispass;
    }

    public void setIsPass(int id) {
        this.ispass = ispass;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getusername() {
        return username;
    }

    public void setusername(String content) {
        this.username = username;
    }

    public String toString() {
        System.out.println("id:" + this.id + " title:" + this.title + " content:" + this.content);
        return super.toString();
    }
}
