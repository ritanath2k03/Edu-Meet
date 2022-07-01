package com.example.edumeet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.jitsi.meet.sdk.JitsiMeet;
import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class Student_dashboard extends AppCompatActivity {
TextView showname;
EditText Url1;
Button  Join;
Dialog mydialog;
    String[] permission = {"android.permission.CAMERA"};
    public static final String Extra_Url="keyUrl";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);
        showname = findViewById(R.id.Showname);
        Join = findViewById(R.id.Join);
//        check_attendance = findViewById(R.id.CheckAttendance);
mydialog=new Dialog(this);

        Intent intent = getIntent();
        String getText = intent.getStringExtra(Student_verification.Extra_name);
        showname.setText("Hi " + getText + "\nWelcome to your page");

        URL serverUrl;
        Url1=findViewById(R.id.Url);
        try {
            // object creation of JitsiMeetConferenceOptions
            // class by the name of options
            JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder()
                    .setServerURL(new URL(""))
                    .build();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestPermissions(permission, 1);
            }
        });

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
        {

            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            if (requestCode == 1) {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Camera Permission accepted", Toast.LENGTH_SHORT).show();
                }
                JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder()
                        .setRoom(Url1.getText().toString())
                        .build();
                JitsiMeetActivity.launch(this, options);

            } else {
                Toast.makeText(this, "Camera Permission Decline", Toast.LENGTH_SHORT).show();
            }

        }
        public void ShowPopup(View v){
        ImageButton txtclose;
        mydialog.setContentView(R.layout.activity_attendance_popup);
        txtclose=mydialog.findViewById(R.id.txtdel);
            txtclose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mydialog.dismiss();
                }
            });
            mydialog.show();
        }
    }

