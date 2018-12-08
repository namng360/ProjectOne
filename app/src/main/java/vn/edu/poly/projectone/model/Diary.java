package vn.edu.poly.projectone.model;

public class Diary {
    public String title;
    public long date;
    public String describe;

    public Diary(String title, long date, String describe) {
        this.title = title;
        this.date = date;
        this.describe = describe;
    }

    public Diary() {

    }

    public String getTitle() {
        return title;
    }

    public String getDes() {
        return describe;
    }

    public void setTitle(String title) {
    }

    public void setDes(String des) {
    }

    public long getDate() {
        return date;
    }
}
