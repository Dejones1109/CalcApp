package vn.edu.hust.calcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvResult,tvView;


    int op1, op2;   // gia tri 2 toan hang
    String op;         // 1: add, 2: sub, 3: mul, 4: div
    int state;      // 1: nhap op1, 2: nhap op2 3: nhap op3
//    int result;
    boolean isOpera=false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.text_result);
        tvView  = findViewById(R.id.text_view);

        findViewById(R.id.btn_0).setOnClickListener(this);
        findViewById(R.id.btn_1).setOnClickListener(this);
        findViewById(R.id.btn_2).setOnClickListener(this);
        findViewById(R.id.btn_3).setOnClickListener(this);
        findViewById(R.id.btn_4).setOnClickListener(this);
        findViewById(R.id.btn_5).setOnClickListener(this);
        findViewById(R.id.btn_6).setOnClickListener(this);
        findViewById(R.id.btn_7).setOnClickListener(this);
        findViewById(R.id.btn_8).setOnClickListener(this);
        findViewById(R.id.btn_9).setOnClickListener(this);

        findViewById(R.id.btn_add).setOnClickListener(this);
        findViewById(R.id.btn_sub).setOnClickListener(this);
        findViewById(R.id.btn_mul).setOnClickListener(this);
        findViewById(R.id.btn_div).setOnClickListener(this);

        findViewById(R.id.btn_equal).setOnClickListener(this);

        findViewById(R.id.btn_rev).setOnClickListener(this);
        findViewById(R.id.btn_bs).setOnClickListener(this);
        findViewById(R.id.btn_ce).setOnClickListener(this);
        findViewById(R.id.btn_c).setOnClickListener(this);
        findViewById(R.id.btn_dot).setOnClickListener(this);

        // Khoi tao cac gia tri
       op1=op2=0;
       op=null;
        state=1;



        tvResult.setText(String.valueOf(op1));
        tvView.setText("");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_0:
                addValue(0);
                break;
            case R.id.btn_1:
                addValue(1);
                break;
            case R.id.btn_2:
                addValue(2);
                break;
            case R.id.btn_3:
                addValue(3);
                break;
            case R.id.btn_4:
                addValue(4);
                break;
            case R.id.btn_5:
                addValue(5);
                break;
            case R.id.btn_6:
                addValue(6);
                break;
            case R.id.btn_7:
                addValue(7);
                break;
            case R.id.btn_8:
                addValue(8);
                break;
            case R.id.btn_9:
                addValue(9);
                break;
            case R.id.btn_add:
                selectOperator("+");
                break;
            case R.id.btn_sub:
                selectOperator("-");
                break;
            case R.id.btn_mul:
                selectOperator("*");
                break;
            case R.id.btn_div:
                selectOperator("/");
                break;
            case R.id.btn_equal:
                calcResult();
                break;
            case R.id.btn_rev:
                reverseOperand();
                break;
            case R.id.btn_bs:
                removeDigit();
                break;
            case R.id.btn_ce:
                clearOperand();
                break;
            case R.id.btn_c:
                clearOperator();
                break;
            case R.id.btn_dot:
            //    selectOperator("5");
                adddot();
                break;
        }


    }

    private void adddot() {

    }

    private void clearOperator() {
        // Khoi tao cac gia tri
        op1=op2=0;
        op=null;
        state=1;


        tvResult.setText(String.valueOf(op1));
        tvView.setText("");


    }

    private void clearOperand() {
        if (state == 1) {
            op1=0;
            tvResult.setText(String.valueOf(op1));
        } else if(state==2){
            op2=0;
            tvResult.setText(String.valueOf(op2));
        }
    }

    private void removeDigit() {
        if (state == 1) {
            op1 = op1 / 10;
            tvResult.setText(String.valueOf(op1));
        } else if(state==2){
            op2 = op2 / 10;
            tvResult.setText(String.valueOf(op2));
        }
    }

    private void reverseOperand() {
        if (state == 1) {
            op1 = -op1;
            tvResult.setText(String.valueOf(op1));
        } else if(state==2) {
            op2 = -op2;
            tvResult.setText(String.valueOf(op2));
        }
    }

    private void calcResult() {
     int  result=0;
        switch (op){
            case "+":result = op1 +op2;
                break;
            case "-":result = op1 -op2;
                break;
            case "*":result = op1 *op2;
                break;
            case "/":result = op1 /op2;
                break;
        }
       tvView.setText(String.valueOf(op1)+op+String.valueOf(op2));
       tvResult.setText(String.valueOf(result));
       state=1;
       op1=op2=0;


        }

    private void selectOperator(String p) {
        op=p;
        state=2;
        op2=0;
        tvResult.setText(String.valueOf(op2));


    }

    private void addValue(int c) {
        if (state == 1) {
            op1 = op1 * 10 + c;
            tvResult.setText(String.valueOf(op1));
        } else if (state==2) {
            op2 = op2 * 10 + c;
            tvResult.setText(String.valueOf(op2));
        }
    }
//private  void Resuls(){
//        switch (op){
//            case "+":result = op1 +op2;
//            break;
//            case "-":result = op1 -op2;
//                break;
//            case "*":result = op1 *op2;
//                break;
//            case "/":result = op1 /op2;
//                break;
//        }
//}
}
