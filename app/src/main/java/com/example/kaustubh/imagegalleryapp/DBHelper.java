package com.example.kaustubh.imagegalleryapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_NAME = "ImageDatabase.db";
    private static final String TABLE_IMAGEIMFO = "ImageInfo";
    private static final String KEY_CATEGORY = "category";
    private static final String KEY_IMAGE = "image";
    private static final String TABLE_CATEGORYINFO="CategoryInfo";
    private static final String KEY_ID="id";
    public DBHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_IMAGEINFO="CREATE TABLE " + TABLE_IMAGEIMFO + "("

                + KEY_IMAGE +" INTEGER  PRIMARY KEY , "
                + KEY_CATEGORY +" TEXT)";
        String CREATE_TABLE_CATEGORYINFO="CREATE TABLE "+ TABLE_CATEGORYINFO + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , "
                + KEY_CATEGORY+ " TEXT)";
        db.execSQL(CREATE_TABLE_IMAGEINFO);
        db.execSQL(CREATE_TABLE_CATEGORYINFO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_IMAGEIMFO );

        onCreate(db);
    }

    public void addImageInfo(ImageInfo imageInfo){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values=new ContentValues();

        values.put(KEY_IMAGE, imageInfo.getImg() );
        values.put(KEY_CATEGORY, imageInfo.getCategory());



        db.insert(TABLE_IMAGEIMFO, null, values);
        db.close();
    }



    public void addCategory(Category category){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values=new ContentValues();

        values.put(KEY_ID, category.getId() );
        values.put(KEY_CATEGORY, category.getCategory());



        db.insert(TABLE_CATEGORYINFO, null, values);
        db.close();
    }

    public List<ImageInfo> getAllImages(){

        List<ImageInfo> imageList = new ArrayList<ImageInfo>();
        String selectQuery = "SELECT  * FROM " + TABLE_IMAGEIMFO;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                ImageInfo imageInfo = new ImageInfo();
                imageInfo.setCategory(cursor.getString(1));
                imageInfo.setImg(cursor.getInt(0));

                imageList.add(imageInfo);
            } while (cursor.moveToNext());
        }
         cursor.close();
        db.close();
        return imageList;
    }

    public List<Category> getALLCategory(){
        List<Category> categoryList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_CATEGORYINFO;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Category category = new Category();
                category.setCategory(cursor.getString(1));
                category.setId(cursor.getInt(0));

                categoryList.add(category);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return categoryList;
    }

    public List<ImageInfo> getImageByCategory(String category){
        List<ImageInfo> imageList=new ArrayList<ImageInfo>();

        //String selectQuery="SELECT * FROM " + TABLE_IMAGEIMFO + " WHERE "+KEY_CATEGORY + "='"+category + "'" ;
        String [] col={KEY_IMAGE,KEY_CATEGORY};
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(TABLE_IMAGEIMFO,col,"category=?",new String[] {category},null,null,null);

        if (cursor.moveToFirst()) {
            do {
                ImageInfo imageInfo = new ImageInfo();
                imageInfo.setCategory(cursor.getString(1));
                imageInfo.setImg(cursor.getInt(0));

                imageList.add(imageInfo);
            } while (cursor.moveToNext());
        }
        cursor.close();
         db.close();
        return imageList;
    }

    public int updateImageInfo(ImageInfo imageInfo, int image) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_IMAGE,image);
        values.put(KEY_CATEGORY, imageInfo.getCategory());



        // updating row
        return db.update(TABLE_IMAGEIMFO, values, KEY_IMAGE + " = ?",
                new String[] { String.valueOf(image) });
    }

    public void deleteImageInfo(int Image) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_IMAGEIMFO, KEY_IMAGE + " = ?",
                new String[] { String.valueOf(Image) });
        db.close();
    }

    public void deleteCategory(String category){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CATEGORYINFO, KEY_CATEGORY + " = ?",
                new String[] { category });
        db.close();
    }

    public boolean isEmpty(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT  * FROM " + TABLE_CATEGORYINFO,null);
        if(cursor.moveToFirst())
            return true;
        else
            return false;
    }

    public void deleteData(){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("DELETE FROM "+TABLE_IMAGEIMFO);
        db.execSQL("DELETE FROM "+TABLE_CATEGORYINFO);

    }

}



