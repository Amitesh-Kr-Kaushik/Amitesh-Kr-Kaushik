package com.example.chetna;

public class Students {
    String firstnm;
    String lastnm;
    String emailadd;
    String password;
    String confirmpassword;
    String gen;
    String bd;

    public Students(String firstnm, String lastnm, String bd , String gen,String emailadd, String password, String confirmpassword) {
        this.firstnm = firstnm;
        this.lastnm = lastnm;
        this.bd = bd;
        this.gen = gen;
        this.emailadd = emailadd;
        this.password = password;
        this.confirmpassword = confirmpassword;


    }

    public String getFirstnm() {
        return firstnm;
    }

    public String getLastnm() {
        return lastnm;
    }

    public String getBd() {
        return bd;
    }
    public String getGen() {
        return gen;
    }

    public String getEmailadd() {
        return emailadd;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }
}
