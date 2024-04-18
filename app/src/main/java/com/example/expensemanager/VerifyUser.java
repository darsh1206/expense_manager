package com.example.expensemanager;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.chaos.view.PinView;

public class VerifyUser extends AppCompatActivity {

    PinView pinView;
    private Button send;
    private Button verify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verification_page);

        // hookers (binding view)
        pinView=findViewById(R.id.pinview);

        send=findViewById(R.id.send_again);
        verify=findViewById(R.id.verify);

        // setting onClickListener on Button
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast to show the OTP Data
                Toast.makeText(VerifyUser.this, "OTP sent successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

