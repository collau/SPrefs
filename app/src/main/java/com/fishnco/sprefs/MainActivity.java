package com.fishnco.sprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String MESSAGE_ID = "messages_prefs";
    private EditText editTextMessage;
    private TextView textViewMessage;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextMessage = this.findViewById(R.id.editText_message);
        textViewMessage = this.findViewById(R.id.textView_message);
        buttonSave = this.findViewById(R.id.buttonSave);

        buttonSave.setOnClickListener(this);

        //Get data back from SharedPreferences
        SharedPreferences getSharedData = getSharedPreferences(MESSAGE_ID, MODE_PRIVATE);
        String value = getSharedData.getString("message", "Nothing yet");

        textViewMessage.setText(value);
    }

    @Override
    public void onClick(View v) {
        String message = editTextMessage.getText().toString().trim();

        /* Create shared preferences instantiation
         * @param   name    key of shared preferences
         * @param   mode    accessibility of shared preferences
         */
        SharedPreferences sharedPreferences = getSharedPreferences(MESSAGE_ID, MODE_PRIVATE);

        //invoke the editor
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //store data in key-value pair structure
        editor.putString("message", message);

        //save to disk
        editor.apply();
    }
}