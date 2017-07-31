package com.example.admin.tour_vaal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SchoolActivity extends AppCompatActivity {
    DatabaseReference databaseSchool;

    ListView listViewMalls;

    EditText editTextName;
    EditText editTextAddress;
    Button buttonAddSchool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school);

        databaseSchool  = FirebaseDatabase.getInstance().getReference("school");

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextAddress = (EditText) findViewById(R.id.editTextAdress);
        buttonAddSchool= (Button) findViewById(R.id.buttonAddSchool);

        listViewMalls=(ListView) findViewById(R.id.ListViewMalls);
        buttonAddSchool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSchool();
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();

        databaseSchool.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //  for (DataSnapshot schoolSnapshot)

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void addSchool() {
        String name = editTextName.getText().toString().trim();
        String Address = editTextAddress.getText().toString().trim();

        if (!TextUtils.isEmpty(name)) {

            String id = databaseSchool.push().getKey();

           School school = new School(id, name, Address);

            databaseSchool.child(id).setValue(school);

            Toast.makeText(this, "School added", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Add School", Toast.LENGTH_LONG).show();

        }
    }
}
