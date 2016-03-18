package com.cvte.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtn0;
    private Button mBtn1;
    private Button mBtn2;
    private Button mBtn3;
    private Button mBtn4;
    private Button mBtn5;
    private Button mBtn6;
    private Button mBtn7;
    private Button mBtn8;
    private Button mBtn9;
    private Button mBtnDot;
    private Button mBtnAdd;
    private Button mBtnSub;
    private Button mBtnMul;
    private Button mBtnDiv;
    private Button mBtnEnter;
    private Button mBtnClear;
    private Button mBtnDelete;
    private EditText mETInput;

    private boolean mIsNeedClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.init();
    }

    private void init() {
        mBtn0 = (Button) findViewById(R.id.btn_0);
        mBtn1 = (Button) findViewById(R.id.btn_1);
        mBtn2 = (Button) findViewById(R.id.btn_2);
        mBtn3 = (Button) findViewById(R.id.btn_3);
        mBtn4 = (Button) findViewById(R.id.btn_4);
        mBtn5 = (Button) findViewById(R.id.btn_5);
        mBtn6 = (Button) findViewById(R.id.btn_6);
        mBtn7 = (Button) findViewById(R.id.btn_7);
        mBtn8 = (Button) findViewById(R.id.btn_8);
        mBtn9 = (Button) findViewById(R.id.btn_9);
        mBtnDot = (Button) findViewById(R.id.btn_dot);
        mBtnAdd = (Button) findViewById(R.id.btn_add);
        mBtnSub = (Button) findViewById(R.id.btn_sub);
        mBtnMul = (Button) findViewById(R.id.btn_mul);
        mBtnDiv = (Button) findViewById(R.id.btn_div);
        mBtnEnter = (Button) findViewById(R.id.btn_enter);
        mBtnClear = (Button) findViewById(R.id.btn_c);
        mBtnDelete = (Button) findViewById(R.id.btn_del);
        mETInput = (EditText) findViewById(R.id.ed_input);

        mBtn0.setOnClickListener(this);
        mBtn1.setOnClickListener(this);
        mBtn2.setOnClickListener(this);
        mBtn3.setOnClickListener(this);
        mBtn4.setOnClickListener(this);
        mBtn5.setOnClickListener(this);
        mBtn6.setOnClickListener(this);
        mBtn7.setOnClickListener(this);
        mBtn8.setOnClickListener(this);
        mBtn9.setOnClickListener(this);
        mBtnDot.setOnClickListener(this);
        mBtnAdd.setOnClickListener(this);
        mBtnSub.setOnClickListener(this);
        mBtnMul.setOnClickListener(this);
        mBtnDiv.setOnClickListener(this);
        mBtnEnter.setOnClickListener(this);
        mBtnClear.setOnClickListener(this);
        mBtnDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String str = mETInput.getText().toString();
        switch (v.getId()) {
            case R.id.btn_0:
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
            case R.id.btn_dot:
                if(mIsNeedClear) {
                    mIsNeedClear = false;
                    str = "";
                }
                mETInput.setText(str + ((Button)v).getText());
                break;
            case R.id.btn_add:
            case R.id.btn_sub:
            case R.id.btn_mul:
            case R.id.btn_div:
                if(mIsNeedClear) {
                    mIsNeedClear = false;
                }
                mETInput.setText(str + " " + ((Button)v).getText() + " ");
                break;
            case R.id.btn_del:
                if(mIsNeedClear) {
                    mIsNeedClear = false;
                }
                if ((str != null) && (!str.equals(""))) {
                    mETInput.setText(str.substring(0, str.length() - 1));
                }
                break;
            case R.id.btn_c:
                if(mIsNeedClear) {
                    mIsNeedClear = false;
                }
                mETInput.setText("");
                break;
            case R.id.btn_enter:
                getResult();
                break;
        }
    }

    private void getResult() {
        String expStr = mETInput.getText().toString();
        if ((expStr != null) && (!expStr.equals(""))) {
            if (expStr.contains("")) {
                String s1 = expStr.substring(0, expStr.indexOf(" "));
                String op = expStr.substring(expStr.indexOf(" ") + 1, expStr.indexOf(" ") + 2);
                String s2 = expStr.substring(expStr.indexOf(" ") + 3);
                if (!s1.equals("") && !s2.equals("")) {
                    double rslt = 0;
                    double d1 = Double.parseDouble(s1);
                    double d2 = Double.parseDouble(s2);
                    if (op.equals("+")) {
                        rslt = d1 + d2;
                    }
                    else if (op.equals("-")) {
                        rslt = d1 - d2;
                    }
                    else if (op.equals("x")) {
                        rslt = d1 * d2;
                    }
                    else if (op.equals("÷")) {
                        if (d2 == 0) {
                            rslt = 0;
                        }
                        else {
                            rslt = d1 / d2;
                        }
                    }

                    if (s1.contains(".") || s2.contains(".")) {
                        mETInput.setText(rslt + "");
                    }
                    else {
                        mETInput.setText((int)rslt + "");
                    }
                }
            }
        }

        mIsNeedClear = true;
    }
}
