package org.gykrdolgozat.akasztofa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class MainActivity extends AppCompatActivity {
    private ImageView akasztofa;
    private Button buttonElore, buttonHatra, buttonTipp;
    private TextView betu, kitalalView;
    private String kitalalandoSzo, abcBetui;
    private Random rng;
    private int randomSzam, index;
    private AlertDialog alertDialog;
    private AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        randomszoValasztas();
        betu.setText(abcBetui.charAt(index)+" ");
        buttonElore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index++;
                if (index > abcBetui.length()-1){
                    index = 0;
                    betu.setText(abcBetui.charAt(index)+" ");
                }
                else{
                    betu.setText(abcBetui.charAt(index)+" ");
                }

            }
        });
        buttonHatra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index--;
                if (index < 0){
                    index = abcBetui.length()-1;
                    betu.setText(abcBetui.charAt(index)+" ");
                }
                else{
                    betu.setText(abcBetui.charAt(index)+" ");
                }
            }
        });
        buttonTipp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void randomszoValasztas() {
        randomSzam = rng.nextInt(10) + 1;
        if (randomSzam == 1) {
            kitalalandoSzo = "VITAMIN";
            kitalalView.setText("_ _ _ _ _ _ _");
        } else if (randomSzam == 2) {
            kitalalandoSzo = "COLA";
            kitalalView.setText("_ _ _ _");
        } else if (randomSzam == 3) {
            kitalalandoSzo = "PEPSI";
            kitalalView.setText("_ _ _ _ _");
        } else if (randomSzam == 4) {
            kitalalandoSzo = "KUTYA";
            kitalalView.setText("_ _ _ _ _");
        } else if (randomSzam == 5) {
            kitalalandoSzo = "MACSKA";
            kitalalView.setText("_ _ _ _ _ _");
        } else if (randomSzam == 6) {
            kitalalandoSzo = "GOMBA";
            kitalalView.setText("_ _ _ _ _");
        } else if (randomSzam == 7) {
            kitalalandoSzo = "ZSEPI";
            kitalalView.setText("_ _ _ _ _");
        } else if (randomSzam == 8) {
            kitalalandoSzo = "HAMBURGER";
            kitalalView.setText("_ _ _ _ _ _ _ _");
        } else if (randomSzam == 9) {
            kitalalandoSzo = "KRUMPLI";
            kitalalView.setText("_ _ _ _ _ _ _");
        } else if (randomSzam == 10) {
            kitalalandoSzo = "KETCHUP";
            kitalalView.setText("_ _ _ _ _ _ _");
        }


    }


    private void init() {
        akasztofa = findViewById(R.id.kep_akasztofa);
        buttonElore = findViewById(R.id.btn_plusz);
        buttonHatra = findViewById(R.id.btn_minusz);
        buttonTipp = findViewById(R.id.btn_tipp);
        abcBetui = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        kitalalView = findViewById(R.id.kitalal);
        rng = new Random();
        index = 0;
        betu = findViewById(R.id.betuk);
    }
}

