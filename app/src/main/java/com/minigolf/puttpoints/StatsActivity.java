package com.minigolf.puttpoints;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;


public class StatsActivity extends AppCompatActivity {

    private ImageButton homeButton;
    private CircleImageView settingsButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        UserPreferencesManager manager = new UserPreferencesManager(this);

        homeButton = findViewById(R.id.homePageButton);
        settingsButton = findViewById(R.id.settingsPageButton);
        settingsButton.setImageDrawable(manager.getPlayers().get(0).getPlayerProfileImage(this));

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomePage();
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSettingsPage();
            }
        });

    }

    private void openHomePage(){
        Intent homePage = new Intent(this, MainActivity.class);
        startActivity(homePage);
        this.overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
    }

    private void openSettingsPage(){
        Intent settingsPage = new Intent(this, SettingsActivity.class);
        startActivity(settingsPage);
        this.overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
    }

}
