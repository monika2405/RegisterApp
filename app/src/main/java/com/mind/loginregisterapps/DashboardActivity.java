package com.mind.loginregisterapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {
    private Button mLogout;
    private TextView mUsername, mNomor, mGender, mNegara;
    private String mStringUsername, mStringNomor, mStringGender, mStringNegara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        mUsername = findViewById(R.id.username);
        mNomor = findViewById(R.id.nomor);
        mGender = findViewById(R.id.gender);
        mNegara = findViewById(R.id.negara);
        mLogout = findViewById(R.id.logout);

        Intent intent = getIntent();

        mStringUsername = intent.getStringExtra(RegisterActivity.USERNAME);
        mStringGender = intent.getStringExtra(RegisterActivity.GENDER);
        mStringNegara = intent.getStringExtra(RegisterActivity.NEGARA);
        mStringNomor = intent.getStringExtra(RegisterActivity.NOMOR);

        mUsername.setText(mStringUsername);
        mNomor.setText(mStringNomor);
        mGender.setText(mStringGender);
        mNegara.setText(mStringNegara);

        mLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
}
