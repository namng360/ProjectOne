package vn.edu.poly.projectone.model;

public class Food {
    private int Img;
    private String title;
    private String re;
    private String cook;

    public Food(int img, String title, String re, String cook) {
        Img = img;
        this.title = title;
        this.re = re;
        this.cook = cook;
    }

    public int getImg() {
        return Img;
    }

    public void setImg(int img) {
        Img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRe() {
        return re;
    }

    public void setRe(String re) {
        this.re = re;
    }

    public String getCook() {
        return cook;
    }

    public void setCook(String cook) {
        this.cook = cook;
    }
}
