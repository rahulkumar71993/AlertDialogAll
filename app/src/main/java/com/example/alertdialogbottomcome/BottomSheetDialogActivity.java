package com.example.alertdialogbottomcome;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class BottomSheetDialogActivity extends AppCompatActivity {
    BottomSheetDialog mBottomSheetDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet);

        initialization();
    }

    private void initialization() {
        findViewById(R.id.tFirstDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBottomSheetDialog = new BottomSheetDialog(BottomSheetDialogActivity.this);
                View sheetView = getLayoutInflater().inflate(R.layout.list_dialog, null);
                mBottomSheetDialog.setContentView(sheetView);

                RecyclerView recyclerView = sheetView.findViewById(R.id.recyclerView);
                recyclerView.setLayoutManager(new LinearLayoutManager(BottomSheetDialogActivity.this));
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setHasFixedSize(true);

                CustomAdapter customAdapter = new CustomAdapter();
                recyclerView.setAdapter(customAdapter);

                mBottomSheetDialog.show();
            }
        });
        findViewById(R.id.tSecondDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBottomSheetDialog = new BottomSheetDialog(BottomSheetDialogActivity.this);
                View sheetView = getLayoutInflater().inflate(R.layout.list_second, null);
                mBottomSheetDialog.setContentView(sheetView);

                mBottomSheetDialog.show();
            }
        });

        findViewById(R.id.tCustomDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog ad = new Dialog(BottomSheetDialogActivity.this);
                ad.setContentView(LayoutInflater.from(BottomSheetDialogActivity.this).inflate(R.layout.list_second, null));
                ad.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                ad.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

                ImageView ivCross = ad.findViewById(R.id.ivCross);
                ivCross.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ad.dismiss();
                    }
                });
                ad.show();
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
            return 18;
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
                    Toast.makeText(BottomSheetDialogActivity.this, "" + getLayoutPosition(), Toast.LENGTH_SHORT).show();

                    mBottomSheetDialog.dismiss();
                }
            });
        }
    }
}
