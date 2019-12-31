package com.example.myapplicationtemp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String text;
    private Spinner spinnerDegree, spinnerSubject;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        text = sharedPreferences.getString("name", " ");

        TextView nameTxt = (TextView) findViewById(R.id.nameTxt);
        nameTxt.setText(text);

        Button next = (Button) findViewById(R.id.nextBtn);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text.equals("Tests")) openTestsPage();
                else openBooksPage();
            }
        });

        Spinner spinnerFacolty = findViewById(R.id.facoltySpin);
        ArrayAdapter<CharSequence> adapterFacolty = ArrayAdapter.createFromResource(this,
                R.array.facolty, android.R.layout.simple_spinner_item);
        adapterFacolty.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFacolty.setAdapter(adapterFacolty);
        spinnerFacolty.setOnItemSelectedListener(this);

        spinnerDegree = findViewById(R.id.degreeSpin);
        ArrayAdapter<CharSequence> adapterEngineering0 = ArrayAdapter.createFromResource(this,
                R.array.DegreeEngineering, android.R.layout.simple_spinner_item);
        adapterEngineering0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDegree.setAdapter(adapterEngineering0);
        spinnerDegree.setOnItemSelectedListener(this);

        spinnerSubject = findViewById(R.id.subjectSpin);
        ArrayAdapter<CharSequence> adapterSubject = ArrayAdapter.createFromResource(this,
                R.array.SubjectComputerSciense, android.R.layout.simple_spinner_item);
        adapterSubject.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSubject.setAdapter(adapterSubject);
        spinnerSubject.setOnItemSelectedListener(this);

        Spinner spinnerBookTest = findViewById(R.id.bookTestSpin);
        ArrayAdapter<CharSequence> adapterBookTest = ArrayAdapter.createFromResource(this,
                R.array.bookTest, android.R.layout.simple_spinner_item);
        adapterBookTest.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBookTest.setAdapter(adapterBookTest);
        spinnerBookTest.setOnItemSelectedListener(this);


    }

    public void openTestsPage() {
        Intent intent = new Intent(this, TestsPage.class);
        startActivity(intent);
    }

    public void openBooksPage() {
        Intent intent = new Intent(this, BooksPage.class);
        startActivity(intent);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        text = parent.getItemAtPosition(position).toString();
        //Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();

        if (text.equals("Engineering")) {
            ArrayAdapter<CharSequence> adapterEngineering = ArrayAdapter.createFromResource(this,
                    R.array.DegreeEngineering, android.R.layout.simple_spinner_item);
            adapterEngineering.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerDegree.setAdapter(adapterEngineering);
            spinnerDegree.setOnItemSelectedListener(this);
        }

        if (text.equals("Natural sciences")) {
            ArrayAdapter<CharSequence> adapterNaturalSciences = ArrayAdapter.createFromResource(this,
                    R.array.DegreeNaturalsciences, android.R.layout.simple_spinner_item);
            adapterNaturalSciences.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerDegree.setAdapter(adapterNaturalSciences);
            spinnerDegree.setOnItemSelectedListener(this);
        }
        if (text.equals("Electrical Engineering")) {
            ArrayAdapter<CharSequence> adapterElectricalEngineering = ArrayAdapter.createFromResource(this,
                    R.array.SubjectElectricalEngineering, android.R.layout.simple_spinner_item);
            adapterElectricalEngineering.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerSubject.setAdapter(adapterElectricalEngineering);
            spinnerSubject.setOnItemSelectedListener(this);

        }
        if (text.equals("Computer Science")) {
            ArrayAdapter<CharSequence> adapterComputerScience = ArrayAdapter.createFromResource(this,
                    R.array.SubjectComputerSciense, android.R.layout.simple_spinner_item);
            adapterComputerScience.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerSubject.setAdapter(adapterComputerScience);
            spinnerSubject.setOnItemSelectedListener(this);

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    //creating the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        //if manager -   inflater.inflate(R.menu.menu_file_manager, menu);
        inflater.inflate(R.menu.menu_file, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //if manager:
        switch (item.getItemId()) {
            case R.id.Profile_item:
                Intent intent = new Intent(this, Profile.class);
                startActivity(intent);
                return true;
            case R.id.ManagerP_item:
                Intent intent2 = new Intent(this, ManagerProfile.class);
                startActivity(intent2);
                return true;
            case R.id.LogOut_item:
                Intent intent3 = new Intent(this, MainActivity.class);
                startActivity(intent3);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

        /*if user:
         switch (item.getItemId()) {
            case R.id.Profile_item:
                Intent intent = new Intent(this, Profile.class);
                startActivity(intent);
                return true;
            case R.id.ManagerP_item:
                Intent intent2 = new Intent(this, ManagerProfile.class);
                startActivity(intent2);
                return true;
            case R.id.LogOut_item:
                Intent intent3 = new Intent(this, MainActivity.class);
                startActivity(intent3);
                return true;

            default:
                return super.onOptionsItemSelected(item);
    }      */
    }
}