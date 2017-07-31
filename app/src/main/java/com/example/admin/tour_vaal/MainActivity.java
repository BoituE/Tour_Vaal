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

public class MainActivity extends AppCompatActivity {
    EditText editTextName;
    EditText editTextAddress;
    Button buttonAddMall;

    DatabaseReference databaseMalls;

    ListView listViewMalls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseMalls = FirebaseDatabase.getInstance().getReference("mall");

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextAddress = (EditText) findViewById(R.id.editTextAdress);
        buttonAddMall = (Button) findViewById(R.id.buttonAddMall);

        listViewMalls=(ListView) findViewById(R.id.ListViewMalls);
        buttonAddMall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMall();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseMalls.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

              //  for (DataSnapshot mallSnapshot)

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void addMall() {
        String name = editTextName.getText().toString().trim();
        String Address = editTextAddress.getText().toString().trim();

        if (!TextUtils.isEmpty(name)) {

            String id = databaseMalls.push().getKey();

            Mall mall = new Mall(id, name, Address);

            databaseMalls.child(id).setValue(mall);

            Toast.makeText(this, "Mall added", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Add Mall", Toast.LENGTH_LONG).show();

        }
    }
}
