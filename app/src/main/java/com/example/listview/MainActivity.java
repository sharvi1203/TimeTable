package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView timesTableList;
    public void generate(int timesTableRunner){
        ArrayList<Integer> table=new ArrayList<Integer>();
        for(int j=1;j<=100;j++){
            table.add(j*timesTableRunner);
        }
        ArrayAdapter<Integer> tableAdapter=new ArrayAdapter<Integer>(getApplicationContext(),android.R.layout.simple_list_item_1,table);
        timesTableList.setAdapter(tableAdapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar seekBar=findViewById(R.id.seekBarTable);
        timesTableList=findViewById(R.id.TableList);
        int max=20;
        int initial=10;
        seekBar.setMax(max);
        seekBar.setProgress(initial);
        generate(initial);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min=1;
                int timesTableRunner;
                if(i<min){
                    timesTableRunner=min;
                }else{
                    timesTableRunner=i;
                }
                Log.i("Value",Integer.toString(timesTableRunner));
                generate(timesTableRunner);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
