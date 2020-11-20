package com.example.pagirunarvu;

public class Member{

    private String Name;
    private Long Contact;
    private String Address;
    private String List;
    private String Description;
    private String Quantity;
    private String Date;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        Name = Name;
    }

    public Member() {
    }

    public Long getNumber() {
        return Contact;
    }

    public void setNumber(Long number) {
        Contact = number;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getList() {
        return List;
    }

    public void setList(String list) {
        List = list;
    }

    public String getDes() {
        return Description;
    }

    public void setDes(String des) {
        Description = des;
    }

    public String getQuan() {
        return Quantity;
    }

    public void setQuan(String quan) {
        Quantity = quan;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}


