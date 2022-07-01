package com.example.edumeet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.jitsi.meet.sdk.JitsiMeet;
import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;

import timber.log.Timber;

public class Calling_page extends AppCompatActivity {

    EditText codeBox,schoolnameBox,nameBox,idbox;
    Button meetBtn;
    String[] permission = {"android.permission.CAMERA"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calling_page);
        codeBox = findViewById(R.id.codeBox);
        meetBtn = findViewById(R.id.meetBtn);
        schoolnameBox=findViewById(R.id.schoolname_box);
        nameBox=findViewById(R.id.nameBox);
        idbox=findViewById(R.id.idBox);
        URL serverURL;
        try {
            serverURL = new URL("https://meet.jit.si");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Invalid server URL!");
        }
        JitsiMeetConferenceOptions defaultOptions = new JitsiMeetConferenceOptions.Builder()
                .setServerURL(serverURL)
                .build();
        JitsiMeet.setDefaultConferenceOptions(defaultOptions);
        meetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                requestPermissions(permission, 1);
            }
        });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Camera Permission accepted", Toast.LENGTH_SHORT).show();

                JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder()
                        .setRoom(codeBox.getText().toString())
                        .setAudioMuted(false)
                        .setVideoMuted(false)
                        .setAudioOnly(false)
                        .setFeatureFlag("welcomepage.enabled", false)
                           .setConfigOverride("requireDisplayName", true)
                        .build();
                JitsiMeetActivity.launch(Calling_page.this, options);
            }
        } else {
            Toast.makeText(this, "Camera Permission Decline", Toast.LENGTH_SHORT).show();
        }
    }
}