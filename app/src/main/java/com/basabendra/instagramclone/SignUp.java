package com.basabendra.instagramclone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUp extends AppCompatActivity implements View.OnClickListener{

    private Button btnSave;
    private EditText edtName, edtEmail, edtPunchPower, edtPunchSpeed, edtKickPower, edtKickSpeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(SignUp.this);

        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPunchPower = findViewById(R.id.edtPunchPower);
        edtPunchSpeed = findViewById(R.id.edtPunchSpeed);
        edtKickPower = findViewById(R.id.edtKickPower);
        edtKickSpeed = findViewById(R.id.edtKickSpeed);

    }

    @Override
    public void onClick(View v) {

        try {

            final ParseObject kickBoxer = new ParseObject("KickBoxerForm");
            kickBoxer.put("Name", edtName.getText().toString());
            kickBoxer.put("Email", edtEmail.getText().toString());
            kickBoxer.put("PunchPower", edtPunchPower.getText().toString());
            kickBoxer.put("PunchSpeed", edtPunchSpeed.getText().toString());
            kickBoxer.put("KickPower", edtKickPower.getText().toString());
            kickBoxer.put("KickSpeed", edtKickSpeed.getText().toString());
            kickBoxer.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {

                    if (e == null) {

                        //                 Toast.makeText(SignUp.this, kickBoxer.get("Name")+" is Saved to Server", Toast.LENGTH_LONG).show();

                        FancyToast.makeText(SignUp.this, kickBoxer.get("Name") + " is saved to server", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, false).show();


                    } else {

                        //                  Toast.makeText(SignUp.this, e.getMessage(), Toast.LENGTH_LONG).show();

                        FancyToast.makeText(SignUp.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, false).show();
                    }
                }
            });

        }
        catch (Exception e){


            FancyToast.makeText(SignUp.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, false).show();

        }


    }
}
