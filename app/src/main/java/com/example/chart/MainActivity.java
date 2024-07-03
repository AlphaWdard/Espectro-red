package com.example.chart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {LineChart line;
    double x,rui;
    float data=100000;
    ArrayList<ILineDataSet>  lineData = new ArrayList<>();

    ArrayList<Entry> OndaA = new ArrayList<>();
    ArrayList<Entry> OndaB = new ArrayList<>();
    ArrayList<Entry> ruidoGrafica = new ArrayList<>();
    ArrayList<Entry> potencia1 = new ArrayList<>();
    ArrayList<Entry> potencia2 = new ArrayList<>();
    ArrayList<Entry> potencia3 = new ArrayList<>();
    ArrayList<Entry> potencia4 = new ArrayList<>();
    ArrayList<Entry> cero = new ArrayList<>();
    ArrayList<Entry> OndaC = new ArrayList<>();
    ArrayList<Entry> OndaD = new ArrayList<>();
    ArrayList<Entry> cero1 = new ArrayList<>();
    ArrayList<Entry> cero2 = new ArrayList<>();
    ArrayList<Entry> cero3 = new ArrayList<>();
    ArrayList<Entry> cero4 = new ArrayList<>();
    ArrayList<Entry> cero5 = new ArrayList<>();
    ArrayList<Entry> cero6 = new ArrayList<>();
    ArrayList<Entry> cero7 = new ArrayList<>();
    //ONDA 1

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        line = (LineChart) findViewById(R.id.lineChart);
        line.getDescription().setText("Frecuencia(Mhz)");

        Rgrafica();

        ondaA();
        OndaC();
        line.animateX(2000, Easing.EasingOption.EaseInBack);
        line.setData(new LineData(lineData));
    }

    double f(double x,double bw,double frec, double pot){
        double a=(-12/Math.pow(bw,2))*(Math.pow(x,2)-2*frec*x+Math.pow(frec,2))+pot;
        return a;
    }
    double ruido(double fr){
        double temp = getIntent().getDoubleExtra("temp",300);
        double a=10 * Math.log10((temp*Math.pow(10,-23)*fr*1.38)/
                0.001);

        return a;
    }

    double ruidoG(double r1,double r2,double r3,double r4){
        double r=0;
        if(r1<r2){
            if(r1<r3){
                if(r1<r4){
                    r=r1;
                }else{
                    r=r4;
                }
            }else{
                r=r3;
            }
        }else{
            r=r2;
        }

        return r;
    }
    void ondaA(){

        double bw1 = getIntent().getDoubleExtra("pw1",2);
        double po1 = getIntent().getDoubleExtra("po1",2);
        double fre1 = getIntent().getDoubleExtra("fre1",2);

        //ONDA 2
        double bw2 = getIntent().getDoubleExtra("pw2",2);
        double po2 = getIntent().getDoubleExtra("po2",5);
        double fre2 = getIntent().getDoubleExtra("fre2",5);
        //ONDA 3
        double bw3 = getIntent().getDoubleExtra("pw3",2);
        double po3 = getIntent().getDoubleExtra("po3",10);
        double fre3 = getIntent().getDoubleExtra("fre3",10);
        //ONDA 4
        double bw4 = getIntent().getDoubleExtra("pw4",2);
        double po4 = getIntent().getDoubleExtra("po4",15);
        double fre4 = getIntent().getDoubleExtra("fre4",15);

        rui= ruidoG(ruido(bw1*1000),ruido(bw2*1000),ruido(bw3*1000),ruido(bw4*1000));
        int y=0;
        int i=0;
        x=0;
        do {
            y++;
            potencia4.add(new Entry((float) y, (float) po1));
            potencia1.add(new Entry((float) y, (float) po4));
            potencia2.add(new Entry((float) y, (float) po3));
            potencia3.add(new Entry((float) y, (float) po2));
            ruidoGrafica.add(new Entry((float) x, (float) rui));
            if(-i>=rui){
                cero.add((new Entry((float) ((float)  fre1+(bw1/2)), (float) (fre1-3)-i)));
                cero1.add((new Entry((float) ((float)  fre1-(bw1/2)), (float) (fre1-3)-i)));
                cero2.add((new Entry((float) ((float)  fre2+(bw2/2)), (float) (fre2-3)-i)));
                cero3.add((new Entry((float) ((float)  fre2-(bw2/2)), (float) (fre2-3)-i)));
                cero4.add((new Entry((float) ((float)  fre3+(bw3/2)), (float) (fre3-3)-i)));
                cero5.add((new Entry((float) ((float)  fre3-(bw3/2)), (float) (fre3-3)-i)));
                cero6.add((new Entry((float) ((float)  fre4+(bw4/2)), (float) (fre4-3)-i)));
                cero7.add((new Entry((float) ((float)  fre4-(bw4/2)), (float) (fre4-3)-i)));
            }

            if(f(x, bw1, fre1, po1) >= f(x, bw2, fre2, po2) && f(x, bw1, fre1, po1) >= f(x, bw3, fre3, po3)
                    && f(x, bw1, fre1, po1) >= f(x, bw4, fre4, po4) && f(x, bw1, fre1, po1) >rui){

                OndaA.add(new Entry((float) x, (float) f(x, bw1, fre1, po1)));

                // x = x + 0.001;

            }else if(f(x, bw2, fre2, po2) >= f(x, bw1, fre1, po1) && f(x, bw2, fre2, po2) >= f(x, bw3, fre3, po3)
                    && f(x, bw2, fre2, po2) >= f(x, bw4, fre4, po4) && f(x, bw2, fre2, po2) >rui){

                OndaA.add(new Entry((float) x, (float) f(x, bw2, fre2, po2)));

                //  x = x + 0.001;

            }else if(f(x, bw3, fre3, po3) >= f(x, bw2, fre2, po2) && f(x, bw3, fre3, po3) >= f(x, bw1, fre1, po1)
                    && f(x, bw3, fre3, po3) >= f(x, bw4, fre4, po4) && f(x, bw3, fre3, po3) >rui){

                OndaA.add(new Entry((float) x, (float) f(x, bw3, fre3, po3)));

                //  x = x + 0.001;

            }else if(f(x, bw4, fre4, po4) >= f(x, bw2, fre2, po2) && f(x, bw4, fre4, po4) >= f(x, bw3, fre3, po3)
                    && f(x, bw4, fre4, po4) >= f(x, bw1, fre1, po1) && f(x, bw4, fre4, po4) >rui){

                OndaA.add(new Entry((float) x, (float) f(x, bw4, fre4, po4)));

                //  x = x + 0.001;
            }
            x = x + 0.001;
            i++;

        }while(i<100000);

        LineDataSet lineData1 = new LineDataSet(OndaA,"Onda A");
        lineData1.setDrawCircles((false));
        lineData1.setColor(Color.rgb(50,100,50));
        lineData.add(lineData1);

    }

    void OndaC(){
        LineDataSet lineData2 = new LineDataSet(ruidoGrafica,"Ruido");
        lineData2.setDrawCircles((false));
        lineData2.setColor(Color.RED);
        lineData.add(lineData2);
    }

    void Rgrafica()
    {

        LineDataSet lineData6 = new LineDataSet(potencia1,"Potencia #4");

        lineData6.setDrawCircles((false));
        lineData6.setLineWidth(2);
        lineData6.setColor(Color.DKGRAY);
        lineData6.enableDashedLine(5,10,0);

        lineData.add(lineData6);

        LineDataSet lineData7 = new LineDataSet(potencia2,"Potencia #3");
        lineData7.enableDashedLine(5,10,0);
        lineData7.setDrawCircles((false));
        lineData7.setColor(Color.MAGENTA);
        lineData.add(lineData7);

        LineDataSet lineData8 = new LineDataSet(potencia3,"Potencia #2");
        lineData8.enableDashedLine(5,10,0);
        lineData8.setDrawCircles((false));
        lineData8.setColor(Color.GREEN);
        lineData.add(lineData8);

        LineDataSet lineData9 = new LineDataSet(potencia4,"Potencia #1");

        lineData9.setDrawCircles((false));
        lineData9.enableDashedLine(5,10,0);
        lineData9.setColor(Color.BLUE);
        lineData.add(lineData9);

        LineDataSet lineData10 = new LineDataSet(cero,"Media potencia");

        lineData10.setDrawCircles((false));

        lineData10.enableDashedLine(5,10,0);
        lineData10.setColor(Color.CYAN);
        lineData.add(lineData10);
        LineDataSet lineData11 = new LineDataSet(cero1,"");

        lineData11.setDrawCircles((false));

        lineData11.enableDashedLine(5,10,0);
        lineData11.setColor(Color.CYAN);
        lineData.add(lineData11);
        LineDataSet lineData12 = new LineDataSet(cero2,null);

        lineData12.setDrawCircles((false));

        lineData12.enableDashedLine(5,10,0);
        lineData12.setColor(Color.CYAN);
        lineData.add(lineData12);
        LineDataSet lineData13 = new LineDataSet(cero3,null);

        lineData13.setDrawCircles((false));

        lineData13.enableDashedLine(5,10,0);
        lineData13.setColor(Color.CYAN);
        lineData.add(lineData13);
        LineDataSet lineData14 = new LineDataSet(cero4,null);

        lineData14.setDrawCircles((false));

        lineData14.enableDashedLine(5,10,0);
        lineData14.setColor(Color.CYAN);
        lineData.add(lineData14);
        LineDataSet lineData15 = new LineDataSet(cero5,null);

        lineData15.setDrawCircles((false));

        lineData15.enableDashedLine(5,10,0);
        lineData15.setColor(Color.CYAN);
        lineData.add(lineData15);
        LineDataSet lineData16 = new LineDataSet(cero6,null);

        lineData16.setDrawCircles((false));

        lineData16.enableDashedLine(5,10,0);
        lineData16.setColor(Color.CYAN);
        lineData.add(lineData16);
        LineDataSet lineData17 = new LineDataSet(cero7,null);

        lineData17.setDrawCircles((false));

        lineData17.enableDashedLine(5,10,0);
        lineData17.setColor(Color.CYAN);
        lineData.add(lineData17);
    }
}
