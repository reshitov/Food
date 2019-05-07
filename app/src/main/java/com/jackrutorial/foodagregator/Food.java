package com.jackrutorial.foodagregator;

import java.io.Serializable;

public class Food implements Serializable {
    private String vName; //Цена
    private String vSurname;
    private String vTitle; //Название
    private int _idImage;

    public Food(String vName, String vSurname,String vTitle, int _idImage) {
        this.vName = vName;
        this.vSurname = vSurname;
        this.vTitle = vTitle;
        this._idImage = _idImage;
    }

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    public String getvSurname() {
        return vSurname;
    }

    public void setvSurname(String vSurname) {
        this.vSurname = vSurname;
    }



    public String getvTitle() {
        return vTitle;
    }

    public void setvTitle(String vTitle) {
        this.vTitle = vTitle;
    }

    public int get_idImage() {
        return _idImage;
    }

    public void set_idImage(int _idImage) {
        this._idImage = _idImage;
    }
}
