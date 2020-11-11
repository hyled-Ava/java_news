package com;

public class Message {
    private int id;
    private String filename;
    private String create_time;
    private String publish_time;
    private String username;

    public Message() {
        super();
    }

    public Message(int id, String filename, String create_time, String publish_time, String username) {
        super();
        this.create_time = create_time;
        this.filename = filename;
        this.id = id;
        this.publish_time = publish_time;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(String publish_time) {
        this.publish_time = publish_time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String toString() {
        System.out.println("id:" + this.id + " filename:" + this.filename + " create_time:" + this.create_time + " publish_time:" + this.publish_time + " username:" + this.username);
        return super.toString();
    }
}
