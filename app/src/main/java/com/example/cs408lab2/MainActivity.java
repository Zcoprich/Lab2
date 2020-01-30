package com.example.cs408lab2;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private String playerWeapon;
    private String computerWeapon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        int playerScore = 0;
        int computerScore = 0;

        TextView intro = (TextView) findViewById(R.id.introText);
        String introduction = "Welcome to Rock-Paper-Scissors!" + "\n" + "    Please choose your weapon:";
        intro.setText(introduction);

        TextView score = (TextView) findViewById(R.id.scoreText);
        String scr = "Player: " + playerScore + "  Computer: " + computerScore;
        score.setText(scr);
    }

    public void rockButtonClicked(View v)
    {
        playerWeapon = "Rock";
        TextView output = (TextView) findViewById(R.id.outputText);
        String msg = "Player's Weapon: " + playerWeapon;
        output.setText(msg);

    }

    public void paperButtonClicked(View v)
    {
        playerWeapon = "Paper";
        TextView output = (TextView) findViewById(R.id.outputText);
        String msg = "Player's Weapon: " + playerWeapon;
        output.setText(msg);

    }

    public void scissorsButtonClicked(View v)
    {
        playerWeapon = "Scissors";
        TextView output = (TextView) findViewById(R.id.outputText);
        String msg = "Player's Weapon: " + playerWeapon;
        output.setText(msg);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public enum Weapon {

        ROCK("Rock"),
        PAPER("Paper"),
        SCISSORS("Scissors");
        private String message;

        private Weapon(String msg) { message = msg; }

        @Override
        public String toString() { return message; }

        public Weapon getRandomWeapon(){
            Weapon[] values = Weapon.values();
            Random r = new Random();
            return (values[r.nextInt(values.length)]);
        }

    };
}
