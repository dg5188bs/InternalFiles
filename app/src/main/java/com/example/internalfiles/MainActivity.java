package com.example.internalfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity {

    Intent si;
    FileOutputStream fos;

    OutputStreamWriter osw;

    BufferedWriter bw;

    FileInputStream fis;

    InputStreamReader isr;

    BufferedReader br;

    String strrd;

    String line;
    EditText et;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textView);
        et = (EditText) findViewById(R.id.editTextTextPersonName);
        si = new Intent(this,MainActivity2.class);

        try {
            fis = openFileInput("test.txt");
        } catch (FileNotFoundException e) {
            try {
                FileOutputStream fos = openFileOutput("test.txt",MODE_PRIVATE);
                fis = openFileInput("test.txt");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        isr = new InputStreamReader(fis);
        br = new BufferedReader(isr);
        StringBuffer sb = new StringBuffer();
        try {
            line = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while (line != null) {
            sb.append(line+'\n');
            try {
                line = br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        strrd=sb.toString();
        try {
            isr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        tv.setText(strrd);


    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem){
        String st = menuItem.getTitle().toString();
        if(st.equals("credits")){
            startActivity(si);
        }
        return true;
    }

    /**
     * Save.
     *
     * @param view the view
     */
    public void save(View view) {
        String st = et.getText().toString();
        try {
            fos = openFileOutput("test.txt",MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        osw = new OutputStreamWriter(fos);
        bw = new BufferedWriter(osw);
        try {
            bw.write(tv.getText()+st);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            bw.close(); //כתיבה אל הקובץ וסגירתו
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            fis= openFileInput("test.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        isr = new InputStreamReader(fis);
        br = new BufferedReader(isr);
        StringBuffer sb = new StringBuffer();
        try {
            line = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while (line != null) {
            sb.append(line+'\n');
            try {
                line = br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        strrd=sb.toString();
        try {
            isr.close(); //לקרוא את כל הטקסט ולסגור את הקובץ
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        tv.setText(strrd);
        et.setText("");

    }

    /**
     * Reset.
     *
     * @param view the view
     */
    public void reset(View view) {
        tv.setText("");
        try {
            FileOutputStream fos = openFileOutput("test.txt",MODE_PRIVATE);
            String empty = "";
            fos.write(empty.getBytes());
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    /**
     * Exit.
     *
     * @param view the view
     */
    public void exit(View view) {
        String st = et.getText().toString();
        try {
            fos = openFileOutput("test.txt",MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        osw = new OutputStreamWriter(fos);
        bw = new BufferedWriter(osw);
        try {
            bw.write(tv.getText()+st);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            bw.close(); //כתיבה אל הקובץ וסגירתו
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finish();

    }





}