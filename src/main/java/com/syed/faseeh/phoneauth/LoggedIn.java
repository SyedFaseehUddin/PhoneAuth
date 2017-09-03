package com.syed.faseeh.phoneauth;

/**
 * Created by Syed on 03-Sep-17.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.gigamole.library.PulseView;
import com.google.firebase.auth.FirebaseAuth;
public class LoggedIn extends AppCompatActivity implements View.OnClickListener{

    private Button mSignOutButton;
    private FirebaseAuth mAuth;
    PulseView pulseView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);

        pulseView =(PulseView) findViewById(R.id.pv);
        pulseView.startPulse();
        mSignOutButton = (Button) findViewById(R.id.sign_out_button);
        mSignOutButton.setOnClickListener(this);


        mAuth = FirebaseAuth.getInstance();
    }

    private void signOut() {
        mAuth.signOut();
        pulseView.finishPulse();
        this.finish();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sign_out_button:
                signOut();
                Intent i = new Intent(this,MainActivity.class);
                startActivity(i);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
