package vn.edu.poly.projectone.model;

public class Food {
    private int Img;
    private String title;

    public Food(int img, String title) {
        Img = img;
        this.title = title;
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
}
