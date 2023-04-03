package com.example.internalfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * The type Main activity 2.
 */
public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        menu.add("main app");
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem menuItem){
        String st = menuItem.getTitle().toString();
        if(st.equals("main app")){
            finish();
        }
        return true;
    }
}