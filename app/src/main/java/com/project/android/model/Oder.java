package com.project.android.model;

import java.util.ArrayList;

public class Oder {
    String id;
    String pbuyName;
    String phoneNumber;
    String Note;
    String dayCrate;
    String status;
    String idAccount;
    int cost;
    int ship;
    int net;
    int total;
    String address;
    ArrayList<String> allOderCart;

    public Oder() {
    }

    public Oder(String id, String pbuyName, String phoneNumber, String idAccount) {
        this.id = id;
        this.pbuyName = pbuyName;
        this.phoneNumber = phoneNumber;
        this.idAccount = idAccount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPbuyName() {
        return pbuyName;
    }

    public void setPbuyName(String pbuyName) {
        this.pbuyName = pbuyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public String getDayCrate() {
        return dayCrate;
    }

    public void setDayCrate(String dayCrate) {
        this.dayCrate = dayCrate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getShip() {
        return ship;
    }

    public void setShip(int ship) {
        this.ship = ship;
    }

    public int getNet() {
        return net;
    }

    public void setNet(int net) {
        this.net = net;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<String> getAllOderCart() {
        return allOderCart;
    }

    public void setAllOderCart(ArrayList<String> allOderCart) {
        this.allOderCart = allOderCart;
    }
}
