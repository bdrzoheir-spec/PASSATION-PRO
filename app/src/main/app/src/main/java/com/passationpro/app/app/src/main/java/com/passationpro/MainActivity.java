
package com.passationpro;

import android.app.*;
import android.os.*;
import android.graphics.Color;
import android.view.*;
import android.widget.*;
import android.content.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends Activity {

    LinearLayout layout;
    EditText input;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(30, 30, 30, 30);
        layout.setBackgroundColor(Color.rgb(245,247,250));

        title = new TextView(this);
        title.setText("PASSATION PRO");
        title.setTextSize(28);
        title.setTextColor(Color.rgb(20,60,100));
        title.setGravity(Gravity.CENTER);
        layout.addView(title);

        addButton("📝 PASSATION TECHNIQUE", this::passation);
        addButton("🔑 GESTION DES CLÉS", this::keys);
        addButton("📋 HISTORIQUE", this::history);

        setContentView(layout);
    }

    void addButton(String text, Runnable action) {
        Button b = new Button(this);
        b.setText(text);
        layout.addView(b);
        b.setOnClickListener(v -> action.run());
    }

    void passation() {
        input = new EditText(this);
        input.setHint("Travaux terminés / non terminés");

        new AlertDialog.Builder(this)
            .setTitle("Nouvelle Passation")
            .setView(input)
            .setPositiveButton("ENREGISTRER", (d,w) -> {
                save("PASSATION", input.getText().toString());
                Toast.makeText(this,"Passation enregistrée",Toast.LENGTH_LONG).show();
            })
            .setNegativeButton("ANNULER",null)
            .show();
    }

    void keys() {
        input = new EditText(this);
        input.setHint("Clé / Chambre / Nom / Motif");

        new AlertDialog.Builder(this)
            .setTitle("Sortie d'une clé")
            .setView(input)
            .setPositiveButton("ENREGISTRER", (d,w) -> {
                save("CLÉ SORTIE",input.getText().toString());
                Toast.makeText(this,"Clé enregistrée",Toast.LENGTH_LONG).show();
            })
            .setNegativeButton("ANNULER",null)
            .show();
    }

    void save(String type,String value) {
        SharedPreferences p = getSharedPreferences("PASSATION",MODE_PRIVATE);
        String time = new SimpleDateFormat("dd/MM/yyyy HH:mm",Locale.getDefault()).format(new Date());
        String old = p.getString("history","");
        p.edit().putString("history",old+"\n"+time+" | "+type+" | "+value).apply();
    }

    void history() {
        SharedPreferences p = getSharedPreferences("PASSATION",MODE_PRIVATE);
        String h = p.getString("history","Aucun historique");

        new AlertDialog.Builder(this)
            .setTitle("HISTORIQUE")
            .setMessage(h)
            .setPositiveButton("FERMER",null)
            .show();
    }
}
