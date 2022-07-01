package com.example.edumeet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class Teacher_dashboard extends AppCompatActivity {
TextView showname;
EditText Url1;
Button Join,take_attendance;
    String[] permission = {"android.permission.CAMERA"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_dashboard);
        showname=findViewById(R.id.Showname);
        Join = findViewById(R.id.Join);
        take_attendance = findViewById(R.id.TakeAttendance);
        String college_name=getIntent().getStringExtra("teacher_name");
        showname.setText("Hi "+college_name+"\nWelcome To Your Page");

            Url1=findViewById(R.id.Url);
            try {

                JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder()
                        .setServerURL(new URL(""))
                        .build();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            Join.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    requestPermissions(permission, 2);
                }
            });
            take_attendance.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
        @Override
        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
        {

            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            if (requestCode == 2) {
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
    }
