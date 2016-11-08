package com.ckcc.sengheng.brabkhneaapp.container;

/**
 * Created by HP on 04-Nov-16.
 */
public class Album {
    private String provinceKh;
    private String ProvinceEn;
    private int thumbnail;
    private int itemColor;

    public Album() {
    }


    public Album(String provinceKh, String ProvinceEn, int thumbnail, int itemColor) {
        this.provinceKh = provinceKh;
        this.ProvinceEn = ProvinceEn;
        this.thumbnail = thumbnail;
        this.itemColor = itemColor;
    }

    public String getProvinceKh() {
        return provinceKh;
    }

    public String getProvinceEn() {
        return ProvinceEn;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public int getItemColor() {
        return itemColor;
    }
}
