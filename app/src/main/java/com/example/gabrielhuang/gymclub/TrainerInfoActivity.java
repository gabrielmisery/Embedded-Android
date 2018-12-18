package com.example.gabrielhuang.gymclub;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TrainerInfoActivity extends AppCompatActivity {
    private TextView trainerName;
    private TextView trainerAge;
    private TextView trainerLike;
    private TextView selfIntro;
    private TextView advice;
    private ImageView trainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainer_info);

        trainerName = findViewById(R.id.trainer_name);
        trainerAge = findViewById(R.id.trainer_age);
        trainerLike = findViewById(R.id.trainer_like);
        selfIntro = findViewById(R.id.self_intro);
        advice = findViewById(R.id.advice);
        trainer = findViewById(R.id.trainer);

        Intent intent = getIntent();
        String nameString = intent.getStringExtra("name");

        Uri uri = Uri.parse("content://cn.scu.sqlprovider/user");
        ContentResolver contentResolver = getContentResolver();

        ContentValues contentValues = new ContentValues();
        contentValues.put("name", "张三");
        contentValues.put("age", "22");
        contentValues.put("direction", "俯卧撑，跑步");
        contentValues.put("intro", "拥有9年健身中心私教经验。在帮助客户通过定制锻炼计划和饮食计划实现健身目标方面拥有良好的记录。");
        contentValues.put("advice", "一天中训练安排在什么时候并不重要，关键是每次训练时间要有一致性。当然，每个人的工作时间是有规律的，许多健美爱好者的工作时间是\"漂泊不定”的， 但无论如何必须保证一周中有三次训练时间是一致的。");
        contentValues.put("pic", "R.drawable.jishi1");

        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("name", "李四");
        contentValues2.put("age", "33");
        contentValues2.put("direction", "卧推，游泳");
        contentValues2.put("intro", "拥有9年健身中心私教经验。在帮助客户通过定制锻炼计划和饮食计划实现健身目标方面拥有良好的记录。");
        contentValues2.put("advice", "健身是对自己的身体负责的表现，而对自己的身体负责是一个人成熟的表现。一天中训练安排在什么时候并不重要，关键是每次训练时间要有一致性。当然，每个人的工作时间是有规律的");
        contentValues2.put("pic", "R.drawable.jishi1");

        contentResolver.insert(uri, contentValues);
        contentResolver.insert(uri, contentValues2);

        if (nameString.equals("张三")) {
            trainer.setBackgroundResource(R.drawable.jishi1);
        } else if (nameString.equals("李四")) {
            trainer.setBackgroundResource(R.drawable.jishi2);
        }

        Cursor cursor = contentResolver.query(uri, new String[]{"name", "age", "direction", "intro", "advice", "pic"}, "name=?", new String[]{nameString}, null);
        while (cursor.moveToNext()) {
            trainerName.setText(cursor.getString(0));
            trainerAge.setText(cursor.getString(1));
            trainerLike.setText(cursor.getString(2));
            selfIntro.setText(cursor.getString(3));
            advice.setText(cursor.getString(4));

        }
        cursor.close();
    }
}
