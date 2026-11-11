package com.example.passationpro;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // استدعاء الواجهة الصحيحة للتطبيق
        setContentView(R.layout.activity_main);
    }
}
