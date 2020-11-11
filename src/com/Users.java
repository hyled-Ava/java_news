package com;

public class Users {
    private String sex;
    private String username;//用户名
    private String password;//密码
    private String name;
    private String hoby;
    private int ispass;
    private int id;

    public Users() {
        super();
    }

    public Users(String name, String sex, String username, String password, String hoby) {
//        int id,int ispass 暂时先不要
        super();
        this.sex = sex;
//        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.hoby = hoby;
//        this.ispass = ispass;
    }

    public Users(int id, String name, String sex, String hoby) {
//        int id,int ispass 暂时先不要
        super();
        this.sex = sex;
        this.id = id;
        this.name = name;
        this.hoby = hoby;
//        this.ispass = ispass;
    }

    public Users(int id, String username, String password, String hoby, String sex, String name, int ispass) {
        super();
        this.sex = sex;
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.hoby = hoby;
        this.ispass = ispass;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String gethoby() {
        return hoby;
    }

    public void sethoby(String hoby) {
        this.hoby = hoby;
    }

    public int getispass() {
        return ispass;
    }

    public void setispass(int ispass) {
        this.ispass = ispass;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }


    //    重写的toString()方法，便于测试Users类
    @Override
    public String toString() {
        System.out.println("sex:" + this.getSex() + ", username:" + this.getUsername() + ",password:" + this.getpassword() + ",name:" + this.getname() + ",hoby:" + this.gethoby() + ",ispass:" + this.getispass());
        return super.toString();
    }
}
