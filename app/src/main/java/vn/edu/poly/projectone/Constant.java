package vn.edu.poly.projectone;

public interface Constant {
    // TABLE DIARY

    String TABLE_DIARY = "Diary";

    String COLUMN_TITLE = "TieuDe";
    String COLUMN_DATE = "NgayViet";
    String COLUMN_DESCRIBE = "MoTa";

    String CREATE_TABLE_DIARY = "CREATE TABLE " + TABLE_DIARY + "(" +
            "" + COLUMN_TITLE + " NCHAR(100) PRIMARY KEY NOT NULL," +
            "" + COLUMN_DATE + " LONG NOT NULL," +
            "" + COLUMN_DESCRIBE + " NCHAR(255) NOT NULL" +
            ")";
}
