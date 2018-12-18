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
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChannelFragment extends Fragment {
    LinearLayout pushUps;
    LinearLayout coach;
    LinearLayout coach2;
    TextView coachName;
    TextView coachName2;


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


        //教练事件
        coach = getActivity().findViewById(R.id.coach);
        coachName = getActivity().findViewById(R.id.coachName);
        coach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TrainerInfoActivity.class);
                intent.putExtra("name",coachName.getText());
                startActivity(intent);
            }
        });


        //教练事件
        coach2 = getActivity().findViewById(R.id.coach2);
        coachName2 = getActivity().findViewById(R.id.coachName2);
        coach2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TrainerInfoActivity.class);
                intent.putExtra("name",coachName2.getText());
                startActivity(intent);
            }
        });

    }

}
