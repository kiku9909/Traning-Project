/**
 * @author karmakar Sourabh
 */
package com.example.traniningproject;

import android.app.Dialog;
import android.content.ContentValues;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.traniningproject.Adaptor.studentListAdaptor;
import com.example.traniningproject.Database.DBConfig;
import com.example.traniningproject.Database.DBHelper;
import com.example.traniningproject.Model.StudentListGetSet;

import java.util.ArrayList;
import java.util.List;

public class DatabaseDemo extends AppCompatActivity {

    private RecyclerView studList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        //initialization
        studList = (RecyclerView) findViewById(R.id.studentList);

        //Default list of Student in Database
        new LoadStudentList().execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.database_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.add_new_student:

                WindowManager.LayoutParams params = new WindowManager.LayoutParams();
                params.width = WindowManager.LayoutParams.MATCH_PARENT;
                params.height =WindowManager.LayoutParams.WRAP_CONTENT;
                params.gravity = Gravity.CENTER;

                Dialog dialog = new Dialog(DatabaseDemo.this);
                dialog.setContentView(R.layout.add_new_student_dialog);
                dialog.getWindow().setAttributes(params);
                dialog.show();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    class LoadStudentList extends AsyncTask<String, String, Cursor> {

        private Cursor cursor;

        @Override
        protected void onPostExecute(Cursor s) {
            super.onPostExecute(s);

            ArrayList<StudentListGetSet> itemIds = new ArrayList<StudentListGetSet>();
            while (s.moveToNext()) {
                StudentListGetSet getSet = new StudentListGetSet();
                getSet.setName(s.getString(s.getColumnIndexOrThrow(DBConfig.DB_CO1)));
                getSet.setEno(s.getInt(s.getColumnIndexOrThrow(DBConfig.DB_CO2)));
                itemIds.add(getSet);
            }
            s.close();
            Log.e("insert", "doInBackground: " + itemIds);

            //creating RecyclerView Adaptor object
            studentListAdaptor adaptor = new studentListAdaptor(DatabaseDemo.this, itemIds);

            //Assigning Parameter for RecyclerView
            studList.setLayoutManager(new LinearLayoutManager(DatabaseDemo.this, LinearLayoutManager.VERTICAL, false));
            studList.setItemAnimator(new DefaultItemAnimator());
            studList.setAdapter(adaptor);
        }

        @Override
        protected Cursor doInBackground(String... strings) {

            //creating SqliteOpenHelper object
            DBHelper helper = new DBHelper(DatabaseDemo.this);

            //            String[] projec = {DBConfig.DB_CO1};
//            String select = DBConfig.DB_CO1 + " = ?";
//            String[] selectArg = {"Sourabh"};
//            String sortBy = DBConfig.DB_CO2 + " DESC";
            return DBHelper.dbSelection(helper, null, null, null, null);
        }
    }

    class InsertNewStudent extends AsyncTask<String,String,String>{

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

        @Override
        protected String doInBackground(String... strings) {
            return null;
        }
    }
}
