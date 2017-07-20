package com.example.root.simplerobotiumtest.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.root.simplerobotiumtest.R;

/**
 * Created by root on 20/7/17.
 */

public class LoginActivity extends AppCompatActivity {
    Button bLogin;
    boolean doubleBackToExitPressedOnce = false;
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //making full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);


        bLogin = (Button)findViewById(R.id.btn_login);
        coordinatorLayout = (CoordinatorLayout)findViewById(R.id.coordinator_login);

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                finish();
//                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);

            }
        });

    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();

        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            //kill all Activities and process oF app
            android.os.Process.killProcess(android.os.Process.myPid());
            return;
        }

        this.doubleBackToExitPressedOnce = true;
//        Toast.makeText(this, "Double Tap to Exit", Toast.LENGTH_SHORT).show();
        Snackbar snackbar = Snackbar.make(coordinatorLayout,"Double tap to Exit",Snackbar.LENGTH_SHORT);
        ViewGroup group = (ViewGroup) snackbar.getView();
        group.setBackgroundResource(R.color.actionbar2);
        TextView t = (TextView)group.findViewById(android.support.design.R.id.snackbar_text);
        t.setTextColor(Color.WHITE);
        snackbar.show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
}

