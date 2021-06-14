package com.example.webviewactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText e1;
    Button b1;
    WebView wv1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.edit1);
        b1=findViewById(R.id.button);
        wv1=findViewById(R.id.web);
        b1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetJavaScriptEnabled")
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.button:
                        String url= e1.getText().toString();

                        wv1.getSettings().setJavaScriptEnabled(true);
                        wv1.setWebViewClient(new MyWebViewClient());
                        wv1.loadUrl(url);
                        break;
                }
            }

             class MyWebViewClient extends WebViewClient{

                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }
            }
        });

    }
}