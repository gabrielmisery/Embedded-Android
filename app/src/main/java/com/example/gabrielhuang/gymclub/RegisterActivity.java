package com.example.gabrielhuang.gymclub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class RegisterActivity extends AppCompatActivity {
    private static final String METHOD_POST = "POST";
    private EditText emailAddress;
    private EditText passWord;
    private EditText confirmPass;
    private EditText userName;
    private String userEmail, userPassWord, userConfirm, userNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        emailAddress = findViewById(R.id.emailEdit);
        passWord = findViewById(R.id.passwordEdit);
        confirmPass = findViewById(R.id.passwordEdit2);
        Button button = findViewById(R.id.registerButton);
        userName = findViewById(R.id.userName);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userEmail = emailAddress.getText().toString();
                userPassWord = passWord.getText().toString();
                userConfirm = confirmPass.getText().toString();
                userNames = userName.getText().toString();
                if (!userConfirm.equals(userPassWord)) {
                    Toast.makeText(getApplicationContext(), "密码不一致，请重新确认",
                            Toast.LENGTH_SHORT).show();
                } else {
                    register();
                }
            }
        });

    }

    /**
     * 注册，提交数据
     */
    private void register() {
        try {
            registerSuccess();

            URL url = new URL("https://www.csdn.net");
            HttpURLConnection mConnection = (HttpURLConnection) url.openConnection();
            //设置链接超时时间
            mConnection.setConnectTimeout(10000);
            //设置读取超时时间
            mConnection.setReadTimeout(15000);
            //设置请求方法
            mConnection.setRequestMethod(METHOD_POST);
            //添加Header
            mConnection.setRequestProperty("Connection", "keep-Alive");
            //接受输入流
            mConnection.setDoInput(true);

            //有请求数据时，必须开启此项！
            mConnection.setDoOutput(true);
            //POST不支持缓存
            mConnection.setUseCaches(false);

            mConnection.connect();

            //传输'请求数据'
            String body = "userName=" + userName + "&password=" + userPassWord + "&userEmail=" + userEmail;
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(mConnection.getOutputStream(), "UTF-8"));
            writer.write(body);
            writer.flush();
            writer.close();
            if (mConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = mConnection.getInputStream();
//                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String reader = "success";
                if (reader.toString().equals("success")) {
                    registerSuccess();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void registerSuccess() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
//                HttpSession session = request.getSession(true);  //创建session
//                session.setAttribute("uid", user.getUid());      //session中放入id
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), userNames + "注册成功",
                        Toast.LENGTH_SHORT).show();

            }
        });
    }
}

