package com.example.wuyunan.myddl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NewUser extends AppCompatActivity {
    private DBManager mgr;
    private EditText etUsername,etPassword,etPassword_confirm;
    private RadioGroup radioGroup;
    private TextView tvInfo;
    private Button btnAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        //初始化DBManager
        mgr= new DBManager(this);
        etUsername = (EditText) findViewById(R.id.NewUserName);
        etPassword= (EditText) findViewById(R.id.NewUserPwd);
        etPassword_confirm=(EditText) findViewById(R.id.NewUserPwd_confirm);
        tvInfo=(TextView) findViewById(R.id.tv_info);
        btnAdd=(Button) findViewById(R.id.btn_NewUser);



        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Users users = new Users();
                String etps= etPassword.getText().toString();
                String etps_c =etPassword_confirm.getText().toString();
                if(etps.equals(etps_c)){

                    long time = System.currentTimeMillis();
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String str = format.format(new Date(time));
                    users.setCreatetime(str);
                    users.setUsername(etUsername.getText().toString());
                    users.setPassword(etPassword.getText().toString());
                    users.setGrade("11");
                    mgr.adduser(users);      //插入数值
                    resetInfo(0,users.getUsername());}
                else {
                    resetInfo(1,"Null");

                }
            }
        });

    }

    private void resetInfo(int fg,String uname) {
        if(fg==0){
            tvInfo.setText("New User "+mgr.getUsers(uname)+" create ok.Please Login");}
        else{
            tvInfo.setText("Confirm password is not the same as the password entered");
        }
    }
}
