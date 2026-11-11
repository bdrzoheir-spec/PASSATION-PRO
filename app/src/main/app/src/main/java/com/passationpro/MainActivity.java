package com.example.passationpro;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etTimeIn = findViewById(R.id.etTimeIn);
        final EditText etTimeOut = findViewById(R.id.etTimeOut);
        final EditText etJobStatus = findViewById(R.id.etJobStatus);
        final EditText etKeysStatus = findViewById(R.id.etKeysStatus);
        final EditText etSecurityKeys = findViewById(R.id.etSecurityKeys);
        final EditText etSecurityTime = findViewById(R.id.etSecurityTime);
        Button btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String timeIn = etTimeIn.getText().toString();
                String timeOut = etTimeOut.getText().toString();
                String job = etJobStatus.getText().toString();

                if (timeIn.isEmpty() || timeOut.isEmpty() || job.isEmpty()) {
                    Toast.makeText(MainActivity.this, "الرجاء كتابة وقت العمل وتقرير الخدمة أولاً!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "تم حفظ تقرير التسليم بنجاح! 🎉", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
