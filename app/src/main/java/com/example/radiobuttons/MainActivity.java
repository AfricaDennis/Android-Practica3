package com.example.radiobuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, CheckBox.OnCheckedChangeListener, View.OnClickListener{

    TextView labelEleccion, labelGustar;
    RadioGroup radioGroup;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        labelEleccion = findViewById(R.id.textView2);
        labelEleccion.setOnClickListener(this);

        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(this);

        checkBox = findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(this);

        labelGustar = findViewById(R.id.textView1);
        labelGustar.setOnClickListener(this);

    }



    @Override
    public void onCheckedChanged(CompoundButton checkBox, boolean isChecked) {
        String txtGusta = "", txtNoGusta = "";

        if (checkBox.isChecked()) {
            txtGusta = getString(R.string.txtSiTeGusta);
            labelGustar.setText(txtGusta);
        } else {
            txtNoGusta = getString(R.string.txtNoTeGusta);
            labelGustar.setText(txtNoGusta);
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int id) {

        RadioButton changedRadio = findViewById(id);

        if (changedRadio.isChecked()) {
            String textoRadio = changedRadio.getText().toString();
            String txtGustar = getString(R.string.txtGustar);
            labelEleccion.setText(txtGustar + " " + textoRadio);
        } else {
            try {
                throw new Exception("XD");
            } catch (Exception e) {
                e.toString();
            }
        }

    }

    @Override
    public void onClick(View v) {
        TextView clickTextView = (TextView) v;

        int id = clickTextView.getId();


        if (id == R.id.textView1) {
            String txt = getString(R.string.txtPregunta);
            clickTextView.setText(txt);
        } else {
            String txt = getString(R.string.txtEleccion);
            clickTextView.setText(txt);
        }

    }
}