package com.example.andrewbrumbeloe.rockpaperscissorslab2;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Weapon playerWeapon;
    private Weapon computerWeapon;

    private int playerCount;
    private int computerCount;

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

        TextView t = (TextView) findViewById(R.id.welcomeTextView);
        t.setText("Welcome to Rock-Paper-Scissors \n Please choose your weapon: ");
        playerWeapon = Weapon.getRandomWeapon();
        computerWeapon = Weapon.getRandomWeapon();

        playerCount = 0;
        computerCount = 0;

    }

    public void rockClicked(View v) {

        playerWeapon = Weapon.ROCK;
        computerWeapon = Weapon.getRandomWeapon();

        String weapon = computerWeapon.toString();

        String result = "Test";

        String output = "";

        switch (computerWeapon) {

            case ROCK:
                result = "It's draw...";
                break;
            case PAPER:
                result = "Paper wraps Rock! Computer wins!";
                computerCount++;
                break;
            default:
                result = "Rock beats Scissors! You win!";
                playerCount++;
                break;
        }

        TextView t = (TextView) findViewById(R.id.scoreTextView);

        output += "Computer Score: " + computerCount + ", Player's Score: " + playerCount + "\nPlayer Weapon: " + playerWeapon.toString();
        output += "\nComputer Weapon: " + computerWeapon.toString() + "\n" + result;

        t.setText(output);



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

        public static Weapon getRandomWeapon() {
            Weapon[] weapons = Weapon.values();
            Random r = new Random();
            return ( weapons[r.nextInt(values().length)]);
        }



    };

}
