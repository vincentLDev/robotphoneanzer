package com.anzer.robotphone.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.anzer.robotphone.R;
import com.anzer.robotphone.bean.RobotBean;

import java.util.List;

/**
 * Created by Lenovo on 17/4/18.
 */

public class RobotAdapter extends RecyclerView.Adapter<RobotAdapter.ViewHolder> {

    private List<RobotBean> mRobotBeanList;

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mRobotImage;
        TextView mRobotText;

        ViewHolder(View itemView) {
            super(itemView);

            mRobotImage = (ImageView) itemView.findViewById(R.id.img_robot);
            mRobotText = (TextView) itemView.findViewById(R.id.tv_robot);
        }
    }

    public RobotAdapter(List<RobotBean> robotBeanList) {
        this.mRobotBeanList = robotBeanList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.robot_item, parent, false);
        final ViewHolder mViewHolder = new ViewHolder(mView);

        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder mViewHolder, int position) {

        RobotBean mRobotBean = mRobotBeanList.get(position);

        mViewHolder.mRobotImage.setImageResource(Integer.parseInt(mRobotBean.getPasswd()));    // imageId
        mViewHolder.mRobotText.setText(mRobotBean.getName());
    }

    @Override
    public int getItemCount() {

        return mRobotBeanList.size();
    }


}
