
package com.passationpro;

import android.app.*;
import android.os.*;
import android.graphics.Color;
import android.view.*;
import android.widget.*;
import java.text.*;
import java.util.*;

public class MainActivity extends Activity {
    LinearLayout root;
    EditText tech, partner, work, keyName, person, reason, room;

    String time() {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm",
        Locale.getDefault()).format(new Date());
    }

    public void onCreate(Bundle b) {
        super.onCreate(b);
        home();
    }

    void setup(String title) {
        root = new LinearLayout(this);
        root.setOrientation(1);
        root.setPadding(25,25,25,25);
        root.setBackgroundColor(Color.WHITE);
        ScrollView s = new ScrollView(this);
        s.addView(root);
        setContentView(s);
        TextView t = new TextView(this);
        t.setText("PASSATION PRO\n"+title);
        t.setTextSize(24);
        t.setTextColor(Color.BLUE);
        root.addView(t);
    }

    EditText field(String h) {
        EditText e = new EditText(this);
        e.setHint(h);
        root.addView(e);
        return e;
    }

    Button button(String text, Runnable r) {
        Button b = new Button(this);
        b.setText(text);
        root.addView(b);
        b.setOnClickListener(v -> r.run());
        return b;
    }

    void home() {
        setup("Équipe technique");
        button("Passation de service", () -> passation());
        button("Gestion des clés", () -> keys());
        button("Historique", () -> history());
    }

    void passation() {
        setup("Passation");
        tech=field("اسم التقني");
        partner=field("اسم التقني المستلم");
        work=field("الأشغال المنجزة والمتبقية");
        button("حفظ", () -> {
            save("PASSATION | "+tech.getText()+" | "+
            partner.getText()+" | "+work.getText());
            home();
        });
        button("رجوع", () -> home());
    }

    void keys() {
        setup("Clés / Security");
        keyName=field("اسم المفتاح أو Service Card");
        person=field("اسم الشخص");
        reason=field("سبب الخروج");
        room=field("رقم الغرفة أو المكان");
        button("خروج المفتاح", () -> {
            save("KEY OUT | "+keyName.getText()+" | "+
            person.getText()+" | "+reason.getText()+" | "+room.getText());
            home();
        });
        button("رجوع المفتاح", () -> {
            save("KEY RETURN | "+keyName.getText()+" | "+
            person.getText());
            home();
        });
        button("رجوع", () -> home());
    }

    void save(String data) {
        String old=getPreferences(0).getString("log","");
        getPreferences(0).edit().putString("log",
        time()+" | "+data+"\n"+old).apply();
        Toast.makeText(this,"تم التسجيل",Toast.LENGTH_LONG).show();
    }

    void history() {
        setup("Historique");
        TextView t=new TextView(this);
        t.setText(getPreferences(0).getString("log","لا يوجد سجل"));
        root.addView(t);
        button("رجوع",() -> home());
    }
}
