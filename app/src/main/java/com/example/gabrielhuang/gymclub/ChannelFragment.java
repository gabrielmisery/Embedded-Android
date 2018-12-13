package com.example.gabrielhuang.gymclub;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChannelFragment extends Fragment {
    LinearLayout pushUps;
    LinearLayout coach;


    public ChannelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_channel, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //俯卧撑事件
        pushUps = getActivity().findViewById(R.id.pushUps);
        pushUps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BookingChannelActivity.class);
                startActivity(intent);
            }
        });


        //给教练发送邮件
        coach = getActivity().findViewById(R.id.coach);
        coach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SendEmailActivity.class);
                startActivity(intent);
//                Uri uri = Uri.parse("mailto:1051898583@qq.com");
//                String[] email = {"1051898583@qq.com"};
//                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
//                intent.putExtra(Intent.EXTRA_CC, email); // 抄送人
//                intent.putExtra(Intent.EXTRA_SUBJECT, "这是邮件的主题部分"); // 主题
//                intent.putExtra(Intent.EXTRA_TEXT, "这是邮件的正文部分"); // 正文
//                startActivity(Intent.createChooser(intent, "请选择邮件类应用"));
            }
        });


        //教练事件

    }

}
