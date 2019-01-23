package com.example.wuyunan.myddl;

/**
 * Created by wuyunan on 18/7/21.
 *
 *
 */

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;


public class LoginActivity  extends AppCompatActivity {
    private Button btn_login;
    private EditText etuname;
    private EditText etpwd;
    private DBManager mgr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView tv = findViewById(R.id.tv_new_user);
        btn_login=(Button) findViewById(R.id.btn_Login_Confirm);
        etuname=(EditText) findViewById(R.id.LoginName);
        etpwd=(EditText) findViewById(R.id.LoginPwd);
        mgr= new DBManager(this);
        final SpannableStringBuilder style = new SpannableStringBuilder();

        style.append(tv.getText());
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String strusers=mgr.getUsers(etuname.getText().toString());
                 if(strusers.equals(etuname.getText().toString()+"/"+etpwd.getText().toString()+"//") ==true){
                     Toast.makeText(LoginActivity.this, "Pwd OK", Toast.LENGTH_SHORT).show();
                 }
                 else {
                     Toast.makeText(LoginActivity.this, strusers, Toast.LENGTH_SHORT).show();
                 }

            }
        });

        //设置部分文字点击事件
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
               // Toast.makeText(LoginActivity.this, "触发点击事件!", Toast.LENGTH_SHORT).show();
                To_New_User();
            }
        };
        style.setSpan(clickableSpan, 0, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv.setText(style);
        //设置部分文字颜色
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#0000FF"));
        style.setSpan(foregroundColorSpan, 0, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        //配置给TextView
        tv.setMovementMethod(LinkMovementMethod.getInstance());
        tv.setText(style);

    }

    private void To_New_User () {
        Runnable mRunnable=new Runnable() {
            @Override
            public void run () {

                Intent mIntent=new Intent(LoginActivity.this,NewUser.class);
                startActivity(mIntent);
            }
        };
        Thread mThread=new Thread(mRunnable);
        mThread.start();
    }
}

