package itos.ilawyer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button LoginButton = (Button) findViewById(R.id.Loginbutton);
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuPage = new Intent(MainActivity.this, Calendar_view.class);
                startActivity(menuPage);
            }
        }); // Click Login

        final TextView RegisTextView = (TextView) findViewById(R.id.RegisterText);
        RegisTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regisPage = new Intent(MainActivity.this, signup.class);
                startActivity(regisPage);
            }
        }); // Click text Register


    } // Main Method


}//
