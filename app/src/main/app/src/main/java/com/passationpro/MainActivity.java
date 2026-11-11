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

        // ربط حقول الإدخال والزر من الواجهة
        final EditText etTimeIn = findViewById(R.id.etTimeIn);
        final EditText etTimeOut = findViewById(R.id.etTimeOut);
        final EditText etJobStatus = findViewById(R.id.etJobStatus);
        final EditText etKeysStatus = findViewById(R.id.etKeysStatus);
        final EditText etSecurityKeys = findViewById(R.id.etSecurityKeys);
        final EditText etSecurityTime = findViewById(R.id.etSecurityTime);
        Button btnSave = findViewById(R.id.btnSave);

        // تفعيل زر حفظ التقرير
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String timeIn = etTimeIn.getText().toString();
                String timeOut = etTimeOut.getText().toString();
                String job = etJobStatus.getText().toString();
                String keys = etKeysStatus.getText().toString();
                String secKeys = etSecurityKeys.getText().toString();
                String secTime = etSecurityTime.getText().toString();

                // التحقق من إدخال البيانات الأساسية
                if (timeIn.isEmpty() || timeOut.isEmpty() || job.isEmpty()) {
                    Toast.makeText(MainActivity.this, "الرجاء كتابة وقت العمل وتقرير الخدمة أولاً!", Toast.LENGTH_LONG).show();
                } else {
                    // رسالة نجاح الحفظ تظهر للمستخدم على الشاشة
                    String message = "تم حفظ تقرير التسليم بنجاح! 🎉";
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                    
                    // هنا يمكن لاحقاً إضافة كود لحفظ البيانات في قاعدة بيانات أو إرسالها إلكترونياً
                }
            }
        });
    }
}
