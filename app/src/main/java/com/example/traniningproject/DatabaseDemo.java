/**
 * @author karmakar Sourabh
 */
package com.example.traniningproject;

import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.traniningproject.Database.DBHelper;

public class DatabaseDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        new DataBaseOperation().execute();
    }

    class DataBaseOperation extends AsyncTask<String,String,String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

        }

        @Override
        protected String doInBackground(String... strings) {
            DBHelper helper = new DBHelper(DatabaseDemo.this);
            SQLiteDatabase liteDatabase = helper.getWritableDatabase();
            return null;
        }
    }
}
