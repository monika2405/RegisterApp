package com.mind.loginregisterapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;

public class RegisterActivity extends AppCompatActivity {

    private RelativeLayout rlayout;
    private Animation animation;
    private Button mSignUp;
    private EditText mUsername, mNomor;
    private RadioGroup mGender;
    private RadioButton mSelectedGender;
    private Spinner mNegara;
    private String mStringUsername, mStringNomor, mStringGender, mStringNegara;
    public static final String USERNAME = "username";
    public static final String NOMOR = "nomor";
    public static final String GENDER = "gender";
    public static final String NEGARA = "negara";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = findViewById(R.id.bgHeader);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rlayout = findViewById(R.id.rlayout);
        animation = AnimationUtils.loadAnimation(this,R.anim.uptodowndiagonal);
        rlayout.setAnimation(animation);

        mSignUp = findViewById(R.id.signUp);
        mUsername = findViewById(R.id.username);
        mGender = findViewById(R.id.gender);
        mNegara = findViewById(R.id.negara);
        mNomor =findViewById(R.id.nomor);
        mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = mGender.getCheckedRadioButtonId();
                mSelectedGender = findViewById(selectedId);
                mStringUsername = mUsername.getText().toString();
                mStringNomor = mNomor.getText().toString();
                mStringNegara = mNegara.getSelectedItem().toString();
                mStringGender = mSelectedGender.getText().toString();
                Intent intent = new Intent(RegisterActivity.this, DashboardActivity.class);
                intent.putExtra(USERNAME,mStringUsername);
                intent.putExtra(NOMOR, mStringNomor);
                intent.putExtra(GENDER,mStringGender);
                intent.putExtra(NEGARA, mStringNegara);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home :
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
