package com.anzer.robotphone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.anzer.robotphone.adapter.RobotAdapter;
import com.anzer.robotphone.bean.RobotBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<RobotBean> mRobotBeanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRobots();

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);   // this
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        RobotAdapter mRobotAdapter = new RobotAdapter(mRobotBeanList);
        mRecyclerView.setAdapter(mRobotAdapter);

    }


    private void initRobots() {
        for (int i = 0; i < 2; i++) {

            RobotBean mRobot1 = new RobotBean("Robot1", R.mipmap.ic_robot1 );
            mRobotBeanList.add(mRobot1);

            RobotBean mRobot2 = new RobotBean("Robot2", R.mipmap.ic_robot2 + "", "r2");
            mRobotBeanList.add(mRobot2);

            RobotBean mRobot3 = new RobotBean("Robot3", R.mipmap.ic_robot3 + "", "r3");
            mRobotBeanList.add(mRobot3);

            RobotBean mRobot4 = new RobotBean("Robot4", R.mipmap.ic_robot4 + "", "r4");
            mRobotBeanList.add(mRobot4);

            RobotBean mRobot5 = new RobotBean("Robot5", R.mipmap.ic_robot5 + "", "r5");
            mRobotBeanList.add(mRobot5);

            RobotBean mRobot6 = new RobotBean("Robot6", R.mipmap.ic_robot6 + "", "r6");
            mRobotBeanList.add(mRobot6);

            RobotBean mRobot7 = new RobotBean("Robot7", R.mipmap.ic_robot7 + "", "r7");
            mRobotBeanList.add(mRobot7);

            RobotBean mRobot8 = new RobotBean("Robot8", R.mipmap.ic_robot8 + "", "r8");
            mRobotBeanList.add(mRobot8);
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
