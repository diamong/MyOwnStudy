package com.diamong.a022study_spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private ArrayAdapter<String> spinnerAdapter;
    private TextView selectedText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Spinner spinner = findViewById(R.id.spinner);
        TextView selectedTextview = findViewById(R.id.select_text);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>
                (MainActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.name));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(myAdapter);
        spinner.setOnItemSelectedListener();*/

        spinner = (Spinner)findViewById(R.id.spinner);
        selectedText = (TextView)findViewById(R.id.select_text);

        String[] alphabetArray = Utils.readTextFromAssets(this, "new.txt");

        if (alphabetArray != null) {
            spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alphabetArray);
            spinner.setAdapter(spinnerAdapter);
        }
        spinner.setOnItemSelectedListener(onItemSelected());


    }

    private AdapterView.OnItemSelectedListener onItemSelected() {
        return new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView adapterView, View view, int i, long l) {

                int mId = view.getId();
                selectedText.setText((String)adapterView.getSelectedItem());
            }

            @Override
            public void onNothingSelected(AdapterView adapterView) {

            }
        };
    }
}
