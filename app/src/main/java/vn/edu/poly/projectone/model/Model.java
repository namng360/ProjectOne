package vn.edu.poly.projectone.model;

public class Model {
    private String Img;
    private String title;

    public Model(String img, String title) {
        Img = img;
        this.title = title;
    }

    public String getImg() {
        return Img;
    }

    public void setImg(String img) {
        Img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
