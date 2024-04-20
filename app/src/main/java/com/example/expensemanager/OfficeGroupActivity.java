package com.example.expensemanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class OfficeGroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.office_group); // Assuming the layout file name is office_group.xml

        // Find the button
        View btnAddExpenses = findViewById(R.id.btn_add_expenses);

        // Set OnClickListener
        btnAddExpenses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create Intent to start AddExpense activity
                Intent intent = new Intent(OfficeGroupActivity.this, AddExpense.class);
                startActivity(intent);
            }
        });
    }
}
