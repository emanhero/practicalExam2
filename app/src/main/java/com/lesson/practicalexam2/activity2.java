package com.lesson.practicalexam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class activity2 extends AppCompatActivity {
    private static final String fileName = "subjects.txt";
    private static final String comment = "comment.txt";
    TextView textView1;
    TextView textView2;
    Button previousButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        previousButton = (Button) findViewById(R.id.nextButton);


        FileInputStream fis = null;

        try {
            fis = openFileInput(fileName);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null)
            {
                sb.append(text).append("\n");
            }

            textView1.setText(sb.toString());



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void openActivity1()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



}
