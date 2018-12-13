package com.example.gabrielhuang.gymclub;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendEmailActivity extends AppCompatActivity {
    private EditText receiver, cc, theme, mailContent;
    private Button send;
    private String receiveSt, ccSt, themeSt, mailContentSt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_email);

        receiver = findViewById(R.id.receiver);
        cc = findViewById(R.id.cc);
        theme = findViewById(R.id.theme);
        mailContent = findViewById(R.id.mail_content);
        send = findViewById(R.id.send);
        receiver.setText("1051898583@qq.com");

        receiver.setFocusable(false);
        receiver.setFocusableInTouchMode(false);

        receiveSt = receiver.getText().toString();
        ccSt = cc.getText().toString();
        themeSt = theme.getText().toString();
        mailContentSt = mailContent.getText().toString();


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("mailto:1051898583@qq.com");
                String[] email = {"1051898583@qq.com"};
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra(Intent.EXTRA_CC, email); // 抄送人
                intent.putExtra(Intent.EXTRA_SUBJECT, themeSt); // 主题
                intent.putExtra(Intent.EXTRA_TEXT, mailContentSt); // 正文
                startActivity(Intent.createChooser(intent, "请选择邮件类应用"));
            }
        });


    }
}
