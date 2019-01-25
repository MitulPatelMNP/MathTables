package com.m2.developer.mathtables;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    EditText numberAdd;
    Button enter;
    RecyclerView recyclerView;
    NumberAdapter numberAdapter;
    LinearLayout ll_Blank;
    ArrayList number1to10 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
    TextView hintss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        init();

        try {
            ll_Blank.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } catch (Exception e) {
            e.getMessage();
        }
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EnterClick();

            }
        });


    }

    public void EnterClick(){
        try {
            String number = numberAdd.getText().toString().trim();
            numberAdd.setText("");
            if (!number.isEmpty()) {
                ll_Blank.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(linearLayoutManager);
                numberAdapter = new NumberAdapter(number, number1to10);
                recyclerView.setAdapter(numberAdapter);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private void init() {
        try {
            ll_Blank = findViewById(R.id.ll_Blank);
            numberAdd = findViewById(R.id.numberAdd);
            enter = findViewById(R.id.enter);
            recyclerView = findViewById(R.id.recyclerView);
            hintss = findViewById(R.id.hintss);

            hintss.setSelected(true);


            numberAdd.setOnKeyListener(new View.OnKeyListener() {
                public boolean onKey(View v, int keyCode, KeyEvent keyevent) {
                    try {
                        //If the keyevent is a key-down event on the "enter" button
                        if ((keyevent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                            InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                            EnterClick();
                            return true;
                        }
                        return false;
                    }catch (Exception e){
                        e.getMessage();
                    }
                    return false;
                }
            });

        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        try {
            ll_Blank.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            ll_Blank.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            ll_Blank.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
