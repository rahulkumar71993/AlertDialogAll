package com.example.alertdialogbottomcome;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView btn;
    String[] name = {"Rahul", "Rahul", "Rahul", "Rahul", "Rahul", "Rahul", "Rahul", "Rahul", "Rahul", "Rahul", "Rahul", "Rahul", "Rahul", "Rahul", "Rahul", "Rahul", "Rahul",};
    BottomSheetDialog mBottomSheetDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              mBottomSheetDialog = new BottomSheetDialog(MainActivity.this, R.style.BottomSheetDialog);
                View sheetView = getLayoutInflater().inflate(R.layout.list_dialog, null);
                mBottomSheetDialog.setContentView(sheetView);


                RecyclerView recyclerView = sheetView.findViewById(R.id.recyclerView);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setHasFixedSize(true);

                CustomAdapter customAdapter = new CustomAdapter();
                recyclerView.setAdapter(customAdapter);

                mBottomSheetDialog.show();
            }
        });
    }

    class CustomAdapter extends RecyclerView.Adapter<Holder> {

        @NonNull
        @Override
        public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new Holder(getLayoutInflater().inflate(R.layout.list_recycler, viewGroup, false));
        }

        @Override
        public void onBindViewHolder(@NonNull Holder holder, int i) {

        }

        @Override
        public int getItemCount() {
            return 25;
        }
    }

    private class Holder extends RecyclerView.ViewHolder {
        LinearLayout linearLayoutClicl;

        public Holder(@NonNull View itemView) {
            super(itemView);
            linearLayoutClicl = itemView.findViewById(R.id.linearLayoutClicl);
            linearLayoutClicl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, ""+getLayoutPosition(), Toast.LENGTH_SHORT).show();

                    mBottomSheetDialog.dismiss();
                }
            });
        }
    }
}
