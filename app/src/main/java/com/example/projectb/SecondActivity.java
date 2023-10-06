package com.example.projectb;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.squareup.picasso.Picasso;


public class SecondActivity extends AppCompatActivity {

    TextView textView;
    EditText inputText;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = (TextView) findViewById(R.id.header_page_generate);
        inputText = (EditText) findViewById(R.id.textBoxGenerate);
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    public void SendText(View view){
        String imageURL = inputText.getText().toString();

        Picasso.get().load(imageURL).into(imageView);

        System.out.println("Button clicked!");
    }


}


