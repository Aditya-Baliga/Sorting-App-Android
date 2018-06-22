package com.example.adityabaliga.sortingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    Button ascend,descend;
    TextView output;
    EditText input;
    boolean flag;
    int noele;
    float a[];
    public  float[] ascesort(float a[])
    {
        for(int i=0;i<noele;i++)
        {
            for(int j=0;j<noele-i-1;j++)
            {
                if(a[j]>a[j+1])
                {
                    float temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;

                }

            }

        }
        return a;
    }
    public float[] descsort(float a[])
    {
        for(int i=0;i<noele;i++)
        {
            for(int j=0;j<noele-i-1;j++)
            {
                if(a[j]<a[j+1])
                {
                    float temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;

                }

            }

        }
        return a;
    }
    public  float[] getinput()
    {
        String inputstr=input.getText().toString();
        String []inter=inputstr.split(" ");
        noele=inter.length;
        a=new float[noele];
        for(int i=0;i<noele;i++)
        {
            boolean cond=Pattern.matches("((^[-+]?[0-9]*.?[0-9]+$)|(^[-+]?[0-9]+[.]$))",inter[i]);
           if(!cond||inter[i].equals("+")||inter[i].equals("")||inter[i].equals("*")||inter[i].equals("-")||inter[i].equals(".")||inter[i].equals(",")||inter[i].equals("#")||inter[i].equals(")")||inter[i].equals("(")||inter[i].equals(";")||inter[i].equals("N")){
               output.setText("Invalid Input given!!!,Please Try Again\n");
               flag=false;
               return a;
           }

        }


        for(int i=0;i<noele;i++)
        {
            a[i]=Float.parseFloat(inter[i]);


        }
        return a;


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output=(TextView)findViewById(R.id.out);
        input=(EditText)findViewById(R.id.inp);

        ascend=(Button)findViewById(R.id.asc);
        descend=(Button)findViewById(R.id.des);







        ascend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag=true;
                float ab[]=getinput();
                if(flag)
                output.setText("Ascending Ordered values are\n"+Arrays.toString(ascesort(ab))+"\nDone");
            }
        });

        descend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag=true;
                float ab[]=getinput();
                if(flag)
                output.setText("Descending Ordered values are \n"+Arrays.toString(descsort((ab)))+"\nDone");
            }
        });









    }
}
