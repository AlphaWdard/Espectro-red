package com.example.chart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {

    private EditText  txtbw, txtpot,txtfrec,txttemp;
    private EditText  txtbw2, txtpot2,txtfrec2;
    private EditText  txtbw3, txtpot3,txtfrec3;
    private EditText  txtbw4, txtpot4,txtfrec4;
    private TextView txtcreditos;

    private String bw, frec,pot,temp;
    private String bw2, frec2,pot2;
    private String bw3, frec3,pot3;
    private String bw4, frec4,pot4;

    Spinner spn,spn2,spn3,spn4;

     double onda1bw,onda1po,onda1fre,tempp;
     double onda2bw=0,onda2po=0,onda2fre=0;
     double onda3bw=0,onda3po=0,onda3fre=0;
     double onda4bw=0,onda4po=0,onda4fre=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        spn = (Spinner) findViewById(R.id.spnid);
        spn2 = (Spinner) findViewById(R.id.spn2id);
        spn3 = (Spinner) findViewById(R.id.spn3id);
        spn4 = (Spinner) findViewById(R.id.spn4id);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.opc, android.R.layout.simple_spinner_item);
        spn.setAdapter(adapter);
        spn2.setAdapter(adapter);
        spn3.setAdapter(adapter);
        spn4.setAdapter(adapter);
        txttemp =  findViewById(R.id.txt_temp);
        txtcreditos =  findViewById(R.id.txt_credi);
        txtbw =  findViewById(R.id.txt_bw);
        txtfrec = findViewById(R.id.txt_frec);
        txtpot = findViewById(R.id.txt_pot);
        //ONDA2
        txtbw2 =  findViewById(R.id.txt_bw2);
        txtfrec2 = findViewById(R.id.txt_frec2);
        txtpot2 = findViewById(R.id.txt_pot2);

        //ONDA3
        txtbw3=  findViewById(R.id.txt_bw3);
        txtfrec3 = findViewById(R.id.txt_frec3);
        txtpot3 = findViewById(R.id.txt_pot3);

        //ONDA4
        txtbw4 =  findViewById(R.id.txt_bw4);
        txtfrec4 = findViewById(R.id.txt_frec4);
        txtpot4 = findViewById(R.id.txt_pot4);


    }
    public void creditos (View view){
        Intent intent = new Intent(Menu.this, Creditos.class);
        startActivity(intent);
    }

    public void graficar (View view){
        Intent intent = new Intent(Menu.this, MainActivity.class);

        temp = txttemp.getText().toString().trim();
        if ("".equals(temp) ) {
            temp = "300";

        }

        tempp = Double.parseDouble(temp);
        if (tempp<100) {
            tempp=300;
        }
        intent.putExtra("temp",tempp);


        //ONDA 1
        bw = txtbw.getText().toString().trim();
        frec = txtfrec.getText().toString().trim();
        pot = txtpot.getText().toString().trim();

        if ("".equals(bw) ) {
            // Primer error
            txtbw.setError("Introduce un número");
            // Le damos focus
            txtbw.requestFocus();
            // Y terminamos la ejecución
            return;
        }
        if ("".equals(frec) ) {
            // Primer error
            txtfrec.setError("Introduce un número");
            // Le damos focus
            txtfrec.requestFocus();
            // Y terminamos la ejecución
            return;
        }
        if ("".equals(pot) ) {
            // Primer error
            txtpot.setError("Introduce un número");
            // Le damos focus
            txtpot.requestFocus();
            // Y terminamos la ejecución
            return;
        }
        onda1bw = Double.parseDouble(bw);
        onda1po = Double.parseDouble(pot);
        onda1fre = Double.parseDouble(frec);

        if(spn.getSelectedItem().toString().equals("dBw y Mhz")){
            onda1po=onda1po+30;
            if (onda1bw>10 || onda1bw<0 )  {
                // Primer error
                txtbw.setError("El Ancho De Banda debe ser < 10");
                // Le damos focus
                txtbw.requestFocus();
                // Y terminamos la ejecución
                return;

            }

        }
        if(spn.getSelectedItem().toString().equals("dBk y Mhz")){
            onda1po=onda1po+60;
            if (onda1bw>10 || onda1bw<0 )  {
                // Primer error
                txtbw.setError("El Ancho De Banda debe ser < 10");
                // Le damos focus
                txtbw.requestFocus();
                // Y terminamos la ejecución
                return;

            }
        }
        if(spn.getSelectedItem().toString().equals("dBm y Khz")){

            onda1bw=onda1bw/1000;
            onda1fre=onda1fre/1000;
            if (onda1bw>1000 || onda1bw<0 )  {
                // Primer error
                txtbw.setError("El Ancho De Banda debe ser < 1000");
                // Le damos focus
                txtbw.requestFocus();
                // Y terminamos la ejecución
                return;

            }
        }
        if(spn.getSelectedItem().toString().equals("dBk y Khz")){
            onda1po=onda1po+60;
            onda1bw=onda1bw/1000;
            onda1fre=onda1fre/1000;
            if (onda1bw>1000 || onda1bw<0 )  {
                // Primer error
                txtbw.setError("El Ancho De Banda debe ser < 1000");
                // Le damos focus
                txtbw.requestFocus();
                // Y terminamos la ejecución
                return;

            }
        }
        if(spn.getSelectedItem().toString().equals("dBw y Khz")){
            onda1po=onda1po+30;
            onda1bw=onda1bw/1000;
            onda1fre=onda1fre/1000;
            if (onda1bw>1000 || onda1bw<0 )  {
                // Primer error
                txtbw.setError("El Ancho De Banda debe ser < 1000");
                // Le damos focus
                txtbw.requestFocus();
                // Y terminamos la ejecución
                return;

            }
        }
        if(spn.getSelectedItem().toString().equals("dBm y Hz")){
            onda1po=onda1po/1000000;
            onda1fre=onda1fre/1000000;

            if (onda1bw>1000000 || onda1bw<0 )  {
                // Primer error
                txtbw.setError("El Ancho De Banda debe ser < 1000000");
                // Le damos focus
                txtbw.requestFocus();
                // Y terminamos la ejecución
                return;

            }
        }
        if(spn.getSelectedItem().toString().equals("dBw y Hz")){
            onda1po=onda1po+30;
            onda1bw=onda1bw/1000000;
            onda1fre=onda1fre/1000000;
            if (onda1bw>1000000 || onda1bw<0 )  {
                // Primer error
                txtbw.setError("El Ancho De Banda debe ser < 1000000");
                // Le damos focus
                txtbw.requestFocus();
                // Y terminamos la ejecución
                return;

            }
        }
        if(spn.getSelectedItem().toString().equals("dBk y Hz")){
            onda1po=onda1po+60;
            onda1bw=onda1bw/1000000;
            onda1fre=onda1fre/1000000;
            if (onda1bw>1000000 || onda1bw<0 )  {
                // Primer error
                txtbw.setError("El Ancho De Banda debe ser < 1000000");
                // Le damos focus
                txtbw.requestFocus();
                // Y terminamos la ejecución
                return;

            }
        }

        intent.putExtra("pw1",onda1bw);
        intent.putExtra("po1",onda1po);
        intent.putExtra("fre1",onda1fre);
        //ONDA2
        bw2 = txtbw2.getText().toString().trim();
        frec2 = txtfrec2.getText().toString().trim();
        pot2 = txtpot2.getText().toString().trim();
        if ("".equals(bw2) ) {
            bw2 = "2";

        }
        if ("".equals(frec2) ) {
            frec2 = "-200";

        }
        if ("".equals(pot2) ) {
            pot2 = "0";

        }
        onda2bw = Double.parseDouble(bw2);
        onda2po = Double.parseDouble(pot2);
        onda2fre = Double.parseDouble(frec2);

        if(spn2.getSelectedItem().toString().equals("dBw y Mhz")){
            onda2po=onda2po+30;
            if (onda2bw>10 || onda2bw<0 )  {
                // Primer error
                txtbw2.setError("El Ancho De Banda debe ser < 10");
                // Le damos focus
                txtbw2.requestFocus();
                // Y terminamos la ejecución
                return;

            }
        }
        if(spn2.getSelectedItem().toString().equals("dBk y Mhz")){
            onda2po=onda2po+60;
            if (onda2bw>10 || onda2bw<0 )  {
                // Primer error
                txtbw2.setError("El Ancho De Banda debe ser < 10");
                // Le damos focus
                txtbw2.requestFocus();
                // Y terminamos la ejecución
                return;

            }
        }
        if(spn2.getSelectedItem().toString().equals("dBm y Khz")){

            onda2bw=onda2bw/1000;
            onda2fre=onda2fre/1000;
            if (onda2bw>1000 || onda2bw<0 )  {
                // Primer error
                txtbw2.setError("El Ancho De Banda debe ser < 1000");
                // Le damos focus
                txtbw2.requestFocus();
                // Y terminamos la ejecución
                return;

            }
        }
        if(spn2.getSelectedItem().toString().equals("dBk y Khz")){
            onda2po=onda2po+60;
            onda2bw=onda2bw/1000;
            onda2fre=onda2fre/1000;
            if (onda2bw>1000 || onda2bw<0 )  {
                // Primer error
                txtbw2.setError("El Ancho De Banda debe ser < 1000");
                // Le damos focus
                txtbw2.requestFocus();
                // Y terminamos la ejecución
                return;

            }
        }
        if(spn2.getSelectedItem().toString().equals("dBw y Khz")){
            onda2po=onda2po+30;
            onda2bw=onda2bw/1000;
            onda2fre=onda2fre/1000;
            if (onda2bw>1000 || onda2bw<0 )  {
                // Primer error
                txtbw2.setError("El Ancho De Banda debe ser < 1000");
                // Le damos focus
                txtbw2.requestFocus();
                // Y terminamos la ejecución
                return;

            }
        }
        if(spn2.getSelectedItem().toString().equals("dBm y Hz")){
            onda2po=onda2po/1000000;
            onda2fre=onda2fre/1000000;

            if (onda2bw>1000000 || onda2bw<0 )  {
                // Primer error
                txtbw2.setError("El Ancho De Banda debe ser < 1000000");
                // Le damos focus
                txtbw2.requestFocus();
                // Y terminamos la ejecución
                return;

            }
        }
        if(spn2.getSelectedItem().toString().equals("dBw y Hz")){
            onda2po=onda2po+30;
            onda2bw=onda2bw/1000000;
            onda2fre=onda2fre/1000000;
            if (onda2bw>1000000 || onda2bw<0 )  {
                // Primer error
                txtbw2.setError("El Ancho De Banda debe ser < 1000000");
                // Le damos focus
                txtbw2.requestFocus();
                // Y terminamos la ejecución
                return;

            }
        }
        if(spn2.getSelectedItem().toString().equals("dBk y Hz")){
            onda2po=onda2po+60;
            onda2bw=onda2bw/1000000;
            onda2fre=onda2fre/1000000;
            if (onda2bw>1000000 || onda2bw<0 )  {
                // Primer error
                txtbw2.setError("El Ancho De Banda debe ser < 1000000");
                // Le damos focus
                txtbw2.requestFocus();
                // Y terminamos la ejecución
                return;

            }
        }

        intent.putExtra("pw2",onda2bw);
        intent.putExtra("po2",onda2po);
        intent.putExtra("fre2",onda2fre);
        //ONDA3
        bw3 = txtbw3.getText().toString().trim();
        frec3 = txtfrec3.getText().toString().trim();
        pot3 = txtpot3.getText().toString().trim();
        if ("".equals(bw3) ) {
            bw3 = "2";

        }
        if ("".equals(frec3) ) {
            frec3 = "-200";

        }
        if ("".equals(pot3) ) {
            pot3 = "0";

        }
        onda3bw = Double.parseDouble(bw3);
        onda3po = Double.parseDouble(pot3);
        onda3fre = Double.parseDouble(frec3);
        if(spn3.getSelectedItem().toString().equals("dBw y Mhz")){
            onda3po=onda3po+30;
            if (onda3bw>10 || onda3bw<0 )  {
                // Primer error
                txtbw3.setError("El Ancho De Banda debe ser < 10");
                // Le damos focus
                txtbw3.requestFocus();
                // Y terminamos la ejecución
                return;

            }
        }
        if(spn3.getSelectedItem().toString().equals("dBk y Mhz")){
            onda3po=onda3po+60;
            if (onda3bw>10 || onda3bw<0 )  {
                // Primer error
                txtbw3.setError("El Ancho De Banda debe ser < 10");
                // Le damos focus
                txtbw3.requestFocus();
                // Y terminamos la ejecución
                return;

            }
        }
        if(spn3.getSelectedItem().toString().equals("dBm y Khz")){

            onda3bw=onda3bw/1000;
            onda3fre=onda3fre/1000;
            if (onda3bw>1000 || onda3bw<0 )  {
                // Primer error
                txtbw3.setError("El Ancho De Banda debe ser < 1000");
                // Le damos focus
                txtbw3.requestFocus();
                // Y terminamos la ejecución
                return;

            }
        }
        if(spn3.getSelectedItem().toString().equals("dBk y Khz")){
            onda3po=onda3po+60;
            onda3bw=onda3bw/1000;
            onda3fre=onda3fre/1000;
            if (onda3bw>1000 || onda3bw<0 )  {
                // Primer error
                txtbw3.setError("El Ancho De Banda debe ser < 1000");
                // Le damos focus
                txtbw3.requestFocus();
                // Y terminamos la ejecución
                return;

            }
        }
        if(spn3.getSelectedItem().toString().equals("dBw y Khz")){
            onda3po=onda3po+30;
            onda3bw=onda3bw/1000;
            onda3fre=onda3fre/1000;
            if (onda3bw>1000 || onda3bw<0 )  {
                // Primer error
                txtbw3.setError("El Ancho De Banda debe ser < 1000");
                // Le damos focus
                txtbw3.requestFocus();
                // Y terminamos la ejecución
                return;

            }
        }
        if(spn3.getSelectedItem().toString().equals("dBm y Hz")){
            onda3po=onda3po/1000000;
            onda3fre=onda3fre/1000000;

            if (onda3bw>1000000 || onda3bw<0 )  {
                // Primer error
                txtbw3.setError("El Ancho De Banda debe ser < 1000000");
                // Le damos focus
                txtbw3.requestFocus();
                // Y terminamos la ejecución
                return;

            }
        }
        if(spn3.getSelectedItem().toString().equals("dBw y Hz")){
            onda3po=onda3po+30;
            onda3bw=onda3bw/1000000;
            onda3fre=onda3fre/1000000;
            if (onda3bw>1000000 || onda3bw<0 )  {
                // Primer error
                txtbw3.setError("El Ancho De Banda debe ser < 1000000");
                // Le damos focus
                txtbw3.requestFocus();
                // Y terminamos la ejecución
                return;

            }
        }
        if(spn3.getSelectedItem().toString().equals("dBk y Hz")){
            onda3po=onda3po+60;
            onda3bw=onda3bw/1000000;
            onda3fre=onda3fre/1000000;
            if (onda3bw>1000000 || onda3bw<0 )  {
                // Primer error
                txtbw3.setError("El Ancho De Banda debe ser < 1000000");
                // Le damos focus
                txtbw3.requestFocus();
                // Y terminamos la ejecución
                return;

            }
        }

        intent.putExtra("pw3",onda3bw);
        intent.putExtra("po3",onda3po);
        intent.putExtra("fre3",onda3fre);
        //ONDA4
        bw4 = txtbw4.getText().toString().trim();
        frec4 = txtfrec4.getText().toString().trim();
        pot4 = txtpot4.getText().toString().trim();
        if ("".equals(bw4) ) {
            bw4 = "2";

        }
        if ("".equals(frec4) ) {
            frec4 = "-200";

        }
        if ("".equals(pot4) ) {
            pot4 = "0";

        }
        onda4bw = Double.parseDouble(bw4);
        onda4po = Double.parseDouble(pot4);
        onda4fre = Double.parseDouble(frec4);
        if(spn4.getSelectedItem().toString().equals("dBw y Mhz")){
            onda4po=onda4po+30;
            if (onda4bw>10 || onda4bw<0 )  {
                // Primer error
                txtbw4.setError("El Ancho De Banda debe ser < 10");
                // Le damos focus
                txtbw4.requestFocus();
                // Y terminamos la ejecución
                return;

            }
        }
        if(spn4.getSelectedItem().toString().equals("dBk y Mhz")){
            onda4po=onda4po+60;
            if (onda4bw>10 || onda4bw<0 )  {
                // Primer error
                txtbw4.setError("El Ancho De Banda debe ser < 10");
                // Le damos focus
                txtbw4.requestFocus();
                // Y terminamos la ejecución
                return;

            }
        }
        if(spn4.getSelectedItem().toString().equals("dBm y Khz")){

            onda4bw=onda4bw/1000;
            onda4fre=onda4fre/1000;
            if (onda4bw>1000 || onda4bw<0 )  {
                // Primer error
                txtbw4.setError("El Ancho De Banda debe ser < 1000");
                // Le damos focus
                txtbw4.requestFocus();
                // Y terminamos la ejecución
                return;

            }
        }
        if(spn4.getSelectedItem().toString().equals("dBk y Khz")){
            onda4po=onda4po+60;
            onda4bw=onda4bw/1000;
            onda4fre=onda4fre/1000;
            if (onda4bw>1000 || onda4bw<0 )  {
                // Primer error
                txtbw4.setError("El Ancho De Banda debe ser < 1000");
                // Le damos focus
                txtbw4.requestFocus();
                // Y terminamos la ejecución
                return;

            }
        }
        if(spn4.getSelectedItem().toString().equals("dBw y Khz")){
            onda4po=onda4po+30;
            onda4bw=onda4bw/1000;
            onda4fre=onda4fre/1000;
            if (onda4bw>1000 || onda4bw<0 )  {
                // Primer error
                txtbw4.setError("El Ancho De Banda debe ser < 1000");
                // Le damos focus
                txtbw4.requestFocus();
                // Y terminamos la ejecución
                return;

            }
        }
        if(spn4.getSelectedItem().toString().equals("dBm y Hz")){
            onda4po=onda4po/1000000;
            onda4fre=onda4fre/1000000;

            if (onda4bw>1000000 || onda4bw<0 )  {
                // Primer error
                txtbw4.setError("El Ancho De Banda debe ser < 1000000");
                // Le damos focus
                txtbw4.requestFocus();
                // Y terminamos la ejecución
                return;

            }
        }
        if(spn4.getSelectedItem().toString().equals("dBw y Hz")){
            onda4po=onda4po+30;
            onda4bw=onda4bw/1000000;
            onda4fre=onda4fre/1000000;
            if (onda4bw>1000000 || onda4bw<0 )  {
                // Primer error
                txtbw4.setError("El Ancho De Banda debe ser < 1000000");
                // Le damos focus
                txtbw4.requestFocus();
                // Y terminamos la ejecución
                return;

            }
        }
        if(spn4.getSelectedItem().toString().equals("dBk y Hz")){
            onda4po=onda4po+60;
            onda4bw=onda4bw/1000000;
            onda4fre=onda4fre/1000000;
            if (onda4bw>1000000 || onda4bw<0 )  {
                // Primer error
                txtbw4.setError("El Ancho De Banda debe ser < 1000000");
                // Le damos focus
                txtbw4.requestFocus();
                // Y terminamos la ejecución
                return;

            }
        }

        intent.putExtra("pw4",onda4bw);
        intent.putExtra("po4",onda4po);
        intent.putExtra("fre4",onda4fre);
        Toast.makeText(Menu.this,"Datos Actualizados"
                ,Toast.LENGTH_SHORT).show();

        startActivity(intent);
    }


}
