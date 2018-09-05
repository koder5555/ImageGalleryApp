package com.example.kaustubh.imagegalleryapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import  android.support.design.widget.TabLayout;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    public static    int[] nature_im = {R.drawable.nature1, R.drawable.nature2, R.drawable.nature3, R.drawable.nature4, R.drawable.nature5,
            R.drawable.nature6, R.drawable.nature7, R.drawable.nature8, R.drawable.nature9, R.drawable.nature10,
            R.drawable.nature11, R.drawable.nature12,R.drawable.images23,R.drawable.images24,R.drawable.images25,R.drawable.images26};

    public static int[] anime_im = {R.drawable.anime1, R.drawable.anime2, R.drawable.anime3, R.drawable.anime4, R.drawable.anime5, R.drawable.anime6,
            R.drawable.anime7, R.drawable.anime8, R.drawable.anime9, R.drawable.anime10, R.drawable.anime11, R.drawable.anime12,
            R.drawable.images1,R.drawable.images2,R.drawable.images3,R.drawable.images4,R.drawable.images5,R.drawable.images6
    };

    public static   int[] people_im = {R.drawable.people1, R.drawable.people2, R.drawable.people3, R.drawable.people4, R.drawable.people5, R.drawable.people6,
            R.drawable.people7, R.drawable.people8, R.drawable.people9, R.drawable.people10, R.drawable.people11, R.drawable.people12,
            R.drawable.images12,R.drawable.images13,R.drawable.images14,R.drawable.images15,R.drawable.images16
    };

    public static int[] mv_im = {R.drawable.motor_vehicle1, R.drawable.motor_vehicle2, R.drawable.motor_vehicle3, R.drawable.motor_vehicle4, R.drawable.motor_vehicle5,
            R.drawable.motor_vehicle6, R.drawable.motor_vehicle7, R.drawable.motor_vehicle8, R.drawable.motor_vehicle9, R.drawable.motor_vehicle10,
            R.drawable.motor_vehicle11, R.drawable.motor_vehicle12};

    public static int [] other_im={R.drawable.nature13, R.drawable.nature14, R.drawable.nature15,
            R.drawable.nature16, R.drawable.nature17, R.drawable.nature18, R.drawable.nature19, R.drawable.nature20, R.drawable.anime13, R.drawable.anime14, R.drawable.anime15, R.drawable.anime16, R.drawable.anime17, R.drawable.anime18,
            R.drawable.anime19, R.drawable.anime20,R.drawable.people13, R.drawable.people14, R.drawable.people15, R.drawable.people16, R.drawable.people17, R.drawable.people18,
            R.drawable.people19, R.drawable.people20, R.drawable.motor_vehicle13, R.drawable.motor_vehicle14, R.drawable.motor_vehicle15,
            R.drawable.motor_vehicle16, R.drawable.motor_vehicle17, R.drawable.motor_vehicle18, R.drawable.motor_vehicle19, R.drawable.motor_vehicle20};


    public static DBHelper dbHelper;
    ViewPager viewPager;
    PagerAdapter pagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BackgroundTask backgroundTask=new BackgroundTask(getApplicationContext());
        backgroundTask.execute(getApplicationContext());
        setContentView(R.layout.activity_main);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_1: {
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = MainActivity.this.getLayoutInflater();
                final View view = inflater.inflate(R.layout.dialog, null);
                builder.setTitle("Enter Category");
                builder.setView(view)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText editText = (EditText) view.findViewById(R.id.category);
                                String s = editText.getText().toString();
                                getInstance().addCategory(new Category(Category.getCount(), s));
                                Category.setCount(1);
                                GetAdapter.getMyAdapter().refresh();
                                // GetAdapter.getImageAdapter().refresh();
                                GetAdapter.getImageAdapter2().refresh();
                                GetAdapter.getImageAdapter3().refresh();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });

                builder.create().show();
            }

            return true;
            case R.id.menu_2: {

                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = MainActivity.this.getLayoutInflater();
                final View view = inflater.inflate(R.layout.dialog, null);
                builder.setTitle("Enter Category");
                builder.setView(view)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText editText = (EditText) view.findViewById(R.id.category);
                                String s = editText.getText().toString();
                                getInstance().deleteCategory(s);
                                Category.setCount(-1);
                                GetAdapter.getMyAdapter().refresh();
                                // GetAdapter.getImageAdapter().refresh();
                                GetAdapter.getImageAdapter2().refresh();
                                GetAdapter.getImageAdapter3().refresh();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });

                builder.create().show();
            }


           return true;
            case R.id.menu_3: {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("About");
                builder.setMessage("Description.......");
                builder.create().show();

            }

            return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

        @Override
    protected void onDestroy() {
        super.onDestroy();
        dbHelper.close();
    }

    public static DBHelper getInstance(){
        return dbHelper;
    }



    public class BackgroundTask extends AsyncTask<Context,Void, String> {
        Context context;
        ProgressDialog progressDialog;
        public BackgroundTask(Context context) {
            this.context=context;
            progressDialog=new ProgressDialog(MainActivity.this);
        }

        @Override
        protected void onPreExecute() {
            dbHelper=new DBHelper(context);
            progressDialog.setMessage("Loading......Please Wait");
            progressDialog.show();

        }

        @Override
        protected String doInBackground(Context... contexts) {
            addData(nature_im,"nature");
            addData(anime_im,"anime");
            addData(people_im,"people");
            addData(mv_im,"motor_vehicle");
            addData(other_im,"other");
            getInstance().addCategory(new Category(0,"nature"));
            getInstance().addCategory(new Category(1,"anime"));
            getInstance().addCategory(new Category(2,"people"));
            getInstance().addCategory(new Category(3,"motor_vehicle"));
            getInstance().addCategory(new Category(4,"other"));
            return "Hi";
        }

        @Override
        protected void onPostExecute(String s) {

            ViewPager viewPager=(ViewPager)(findViewById(R.id.pager));
            PagerAdapter pagerAdapter=new SlideScreenAdapter(getSupportFragmentManager());
            viewPager.setAdapter(pagerAdapter);
            viewPager.setOffscreenPageLimit(3);
            TabLayout tabLayout=(TabLayout) findViewById(R.id.tablayout);
            tabLayout.setupWithViewPager(viewPager);
            if(progressDialog.isShowing())
                progressDialog.dismiss();
        }

        public void addData(int[] img, String category) {
            for(int i=0;i<img.length;i++){

                dbHelper.addImageInfo(new ImageInfo(category,img[i]));
            }
        }
    }


}