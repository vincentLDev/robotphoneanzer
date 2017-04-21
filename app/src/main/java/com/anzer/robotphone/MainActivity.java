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

    private List<RobotBean> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRobots();

        // 在MainActivity中 获取RecyclerView的实例 mRecyclerView
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        //创建默认的线性LayoutManager
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);   // 创建LinearLayoutManager的对象 mLinearLayoutManager
        mRecyclerView.setLayoutManager(mLinearLayoutManager);   // 指定RecyclerView的布局：线性布局LinearLayoutManager

        //创建并设置Adapter
        RobotAdapter mRobotAdapter = new RobotAdapter(data);    // 创建RobotAdapter的实例，建立RecyclerView和数据RobotBean之间的关联
        mRecyclerView.setAdapter(mRobotAdapter);                // setAdapter(),完成适配器设置

//        Log.e(TAG, "onCreate: " + Process.myPid());

    }

    private void initRobots() { // Items 初始化
        for (int i = 0; i < 2; i++) {

            RobotBean robotBean1 = new RobotBean();
            robotBean1.setName("Robot1");
            robotBean1.getName();
            robotBean1.setId(R.mipmap.ic_item_robot1);
            robotBean1.getId();
            data.add(robotBean1);

            RobotBean robotBean2 = new RobotBean();
            robotBean2.setName("Robot2");
            robotBean2.getName();
            robotBean2.setId(R.mipmap.ic_item_robot2);
            robotBean2.getId();
            data.add(robotBean2);

            RobotBean robotBean3 = new RobotBean();
            robotBean3.setName("Robot3");
            robotBean3.getName();
            robotBean3.setId(R.mipmap.ic_item_robot3);
            robotBean3.getId();
            data.add(robotBean3);

            RobotBean robotBean4 = new RobotBean();
            robotBean4.setName("Robot4");
            robotBean4.getName();
            robotBean4.setId(R.mipmap.ic_item_robot4);
            robotBean4.getId();
            data.add(robotBean4);

            RobotBean robotBean5 = new RobotBean();
            robotBean5.setName("Robot5");
            robotBean5.getName();
            robotBean5.setId(R.mipmap.ic_item_robot5);
            robotBean5.getId();
            data.add(robotBean5);

            RobotBean robotBean6 = new RobotBean();
            robotBean6.setName("Robot6");
            robotBean6.getName();
            robotBean6.setId(R.mipmap.ic_item_robot6);
            robotBean6.getId();
            data.add(robotBean6);

            RobotBean robotBean7 = new RobotBean();
            robotBean7.setName("Robot7");
            robotBean7.getName();
            robotBean7.setId(R.mipmap.ic_item_robot7);
            robotBean7.getId();
            data.add(robotBean7);

            RobotBean robotBean8 = new RobotBean();
            robotBean8.setName("Robot8");
            robotBean8.getName();
            robotBean8.setId(R.mipmap.ic_item_robot8);
            robotBean8.getId();
            data.add(robotBean8);
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
