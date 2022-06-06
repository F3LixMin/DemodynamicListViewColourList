package com.example.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
EditText etElement;
EditText indexElement;
Button btnadd;
Button btndlte;
ListView lvColor;
EditText delte;
ArrayList<String> alColors  = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextTextPersonName);
        btnadd = findViewById(R.id.button);
        lvColor = findViewById(R.id.Listview);
        indexElement = findViewById(R.id.editTextTextPersonName2);
        btndlte = findViewById(R.id.buttondlt);
        delte = findViewById(R.id.editTextTextPersonName3);

        alColors.add("Red");
        alColors.add("Orange");

        ArrayAdapter aaColor = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alColors);

        lvColor.setAdapter(aaColor);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String colour = etElement.getText().toString();

                int pos = Integer.parseInt(indexElement.getText().toString());
                alColors.add(pos, colour);
                aaColor.notifyDataSetChanged();


            }
        });
        lvColor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String color = alColors.get(position).toString();
                Toast.makeText(MainActivity.this, color, Toast.LENGTH_SHORT).show();
            }
        });
        btndlte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int pos = Integer.parseInt(delte.getText().toString());
                alColors.remove(pos);
                aaColor.notifyDataSetChanged();
            }
        });

    }
}