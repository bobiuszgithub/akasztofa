package org.gykrdolgozat.akasztofa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class MainActivity extends AppCompatActivity {
    private ImageView akasztofa;
    private Button buttonElore, buttonHatra, buttonTipp;
    private TextView betu, kitalalView, szoo;
    private String kitalalandoSzo, abcBetui, vonalHossz, martippeltbetuk;
    private char aktualisBetu;
    private Random rng;
    private int randomSzam, index, elet;
    private AlertDialog alertDialog;
    private AlertDialog.Builder builder;
    private List<Integer> lista;
    private List<Character> marTippeltBetu;


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        for (int i = 0; i < marTippeltBetu.size(); i++) {
            martippeltbetuk += marTippeltBetu.get(i);
        }



        outState.putString("vonalakszo", vonalHossz);
        outState.putString("jelenlegiszavam", kitalalandoSzo);
        outState.putInt("index", index);
        outState.putString("martippeltbetuk", martippeltbetuk);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        randomszoValasztas();
        betu.setText(" " + abcBetui.charAt(index) + " ");
        betu.setTextColor(Color.RED);
        buttonElore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index++;
                szinvaltoztatas();
                if (index > abcBetui.length() - 1) {
                    index = 0;
                    betu.setText(" " + abcBetui.charAt(index) + " ");
                    aktualisBetu = abcBetui.charAt(index);
                } else {
                    betu.setText(" " + abcBetui.charAt(index) + " ");
                    aktualisBetu = abcBetui.charAt(index);
                }


            }
        });
        buttonHatra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index--;
                szinvaltoztatas();
                if (index < 0) {
                    index = abcBetui.length() - 1;
                    betu.setText(" " + abcBetui.charAt(index) + " ");
                    aktualisBetu = abcBetui.charAt(index);
                } else {
                    betu.setText(" " + abcBetui.charAt(index) + " ");
                    aktualisBetu = abcBetui.charAt(index);
                }
            }
        });
        buttonTipp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                marTippeltBetu.add(aktualisBetu);
                String szavam = vonalHossz;
                char[] szavambetui = szavam.toCharArray();
                for (int i = 0; i < kitalalandoSzo.length(); i++) {
                    if (aktualisBetu == kitalalandoSzo.charAt(i)) {
                        szavambetui[i] = aktualisBetu;
                        szavam = String.valueOf(szavambetui);
                        vonalHossz = szavam;
                        kitalalView.setText(szavam);
                        lista.add(1);
                    } else {
                        lista.add(0);
                    }
                }
                tippcheck();
                listaurites();
                nyerescheck();
                szinvaltoztatas();
            }
        });
        if (savedInstanceState != null) {
            vonalHossz = savedInstanceState.get("vonalakszo").toString();
            kitalalandoSzo = savedInstanceState.get("jelenlegiszavam").toString();
            martippeltbetuk = savedInstanceState.get("martippeltbetuk").toString();
            index = savedInstanceState.getInt("index");
            szoo.setText(kitalalandoSzo);
            kitalalView.setText(vonalHossz);
            betu.setText(" " + abcBetui.charAt(index) + " ");
            for (int i = 0; i < martippeltbetuk.length(); i++) {
                marTippeltBetu.add(martippeltbetuk.charAt(i));
            }
            szinvaltoztatas();
        }
    }

    private void szinvaltoztatas() {
        if (index < 0) {
            index = abcBetui.length() - 1;
        }
        if (index > abcBetui.length() - 1){
            index = 0;
        }
        if (marTippeltBetu.contains(abcBetui.charAt(index))) {
            betu.setTextColor(Color.BLACK);
        } else {
            betu.setTextColor(Color.RED);
        }

    }


    private void tippcheck() {
        Integer nullakszama = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals(0)) {
                nullakszama++;
            }
        }
        if (nullakszama == lista.size()) {
            eletVesztes();
        }

    }

    private void nyerescheck() {
        String szavam = vonalHossz;
        if (szavam.equals(kitalalandoSzo)) {

            builder.setTitle("Helyes megfejtés!");
            alertDialog = builder.create();
            alertDialog.show();
        }


    }

    private void listaurites() {
        for (int i = 0; i < lista.size(); i++) {
            lista.clear();
        }
    }

    private void eletVesztes() {
        switch (elet) {
            case 13:
                akasztofa.setImageResource(R.drawable.akasztofa01);
                elet--;
                break;
            case 12:
                akasztofa.setImageResource(R.drawable.akasztofa02);
                elet--;
                break;
            case 11:
                akasztofa.setImageResource(R.drawable.akasztofa03);
                elet--;
                break;
            case 10:
                akasztofa.setImageResource(R.drawable.akasztofa04);
                elet--;
                break;
            case 9:
                akasztofa.setImageResource(R.drawable.akasztofa05);
                elet--;
                break;
            case 8:
                akasztofa.setImageResource(R.drawable.akasztofa06);
                elet--;
                break;
            case 7:
                akasztofa.setImageResource(R.drawable.akasztofa07);
                elet--;
                break;
            case 6:
                akasztofa.setImageResource(R.drawable.akasztofa08);
                elet--;
                break;
            case 5:
                akasztofa.setImageResource(R.drawable.akasztofa09);
                elet--;
                break;
            case 4:
                akasztofa.setImageResource(R.drawable.akasztofa10);
                elet--;
                break;
            case 3:
                akasztofa.setImageResource(R.drawable.akasztofa11);
                elet--;
                break;
            case 2:
                akasztofa.setImageResource(R.drawable.akasztofa12);
                elet--;
                break;
            case 1:
                akasztofa.setImageResource(R.drawable.akasztofa13);
                elet--;
                builder.setTitle("Nem sikerült kitalálni!");
                alertDialog = builder.create();
                alertDialog.show();
                break;

        }
    }

    private void randomszoValasztas() {
        randomSzam = rng.nextInt(10) + 1;
        if (randomSzam == 1) {
            kitalalandoSzo = "VITAMIN";
            vonalFeltoltes();
            szoo.setText(kitalalandoSzo);
            kitalalView.setText(vonalHossz);
        } else if (randomSzam == 2) {
            kitalalandoSzo = "COLA";
            vonalFeltoltes();
            szoo.setText(kitalalandoSzo);
            kitalalView.setText(vonalHossz);
        } else if (randomSzam == 3) {
            kitalalandoSzo = "PEPSI";
            vonalFeltoltes();
            szoo.setText(kitalalandoSzo);
            kitalalView.setText(vonalHossz);
        } else if (randomSzam == 4) {
            kitalalandoSzo = "KUTYA";
            vonalFeltoltes();
            szoo.setText(kitalalandoSzo);
            kitalalView.setText(vonalHossz);
        } else if (randomSzam == 5) {
            kitalalandoSzo = "MACSKA";
            vonalFeltoltes();
            szoo.setText(kitalalandoSzo);
            kitalalView.setText(vonalHossz);
        } else if (randomSzam == 6) {
            kitalalandoSzo = "GOMBA";
            vonalFeltoltes();
            szoo.setText(kitalalandoSzo);
            kitalalView.setText(vonalHossz);
        } else if (randomSzam == 7) {
            kitalalandoSzo = "ZSEPI";
            vonalFeltoltes();
            szoo.setText(kitalalandoSzo);
            kitalalView.setText(vonalHossz);
        } else if (randomSzam == 8) {
            kitalalandoSzo = "HAMBURGER";
            vonalFeltoltes();
            szoo.setText(kitalalandoSzo);
            kitalalView.setText(vonalHossz);
        } else if (randomSzam == 9) {
            kitalalandoSzo = "KRUMPLI";
            vonalFeltoltes();
            szoo.setText(kitalalandoSzo);
            kitalalView.setText(vonalHossz);
        } else if (randomSzam == 10) {
            kitalalandoSzo = "KETCHUP";
            vonalFeltoltes();
            szoo.setText(kitalalandoSzo);
            kitalalView.setText(vonalHossz);
        }


    }

    private void vonalFeltoltes() {
        for (int i = 0; i < kitalalandoSzo.length(); i++) {
            vonalHossz += "_";
        }

    }

    private void init() {
        akasztofa = findViewById(R.id.kep_akasztofa);
        buttonElore = findViewById(R.id.btn_plusz);
        buttonHatra = findViewById(R.id.btn_minusz);
        buttonTipp = findViewById(R.id.btn_tipp);
        abcBetui = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        aktualisBetu = 'A';
        kitalalView = findViewById(R.id.kitalal);
        rng = new Random();
        index = 0;
        betu = findViewById(R.id.betuk);
        vonalHossz = "";
        szoo = findViewById(R.id.szo);
        elet = 13;
        lista = new ArrayList<>();
        marTippeltBetu = new ArrayList<>();
        martippeltbetuk = "";

        builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Szeretnél még egyet játszani?");
        builder.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                vonalHossz = "";
                randomszoValasztas();
                akasztofa.setImageResource(R.drawable.akasztofa00);

            }
        });
        builder.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                dialog.cancel();
            }
        });
        builder.setTitle("Jatek vege");
        builder.setCancelable(false);

        alertDialog = builder.create();


    }
}

