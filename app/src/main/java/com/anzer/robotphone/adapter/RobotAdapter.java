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

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Lenovo on 17/4/18.
 */

public class RobotAdapter extends RecyclerView.Adapter<RobotAdapter.ViewHolder> {   // 实现onCreateViewHolder()/onBindViewHolder()/getItemCount

    private List<RobotBean> data;                                   // 数据

    public RobotAdapter(List<RobotBean> data) {                   // 把数据源data 传入到集合中
        this.data = data;                                         // 赋值给全局变量, 后续的操作都在这个数据源的基础上进行
    }

    /**
     * 定义内部类ViewHolder，一般只有属性没有方法
     * 并持有每个Item的所有界面元素，此处是mTextView/mImageView
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // 容纳View视图

        @BindView(R.id.iv_robot_item)
        ImageView mImageView;
        @BindView(R.id.tv_robot_item)
        TextView mTextView;

//        ImageView mImageView;
//        TextView mTextView;

        ViewHolder(View itemView) {                             // 构造函数ViewHolder，传入一个View参数 itemView，该参数通常是 RecyclerView子项的最外层布局，即Items
            super(itemView);

            //  把每一个item的子View控件对象，如mTextView/mImageView等，实例化出来并保存到ViewHolder对象中
            ButterKnife.bind(this, itemView);
//            mImageView = (ImageView) itemView.findViewById(R.id.img_robot);
//            mTextView = (TextView) itemView.findViewById(R.id.tv_robot);
        }
    }

    /**
     * @param parent
     * @param viewType
     * @return 创建新的View，被LayoutManager调用
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_adapter, parent, false); // 获得LayoutInflater实例(LayoutInflater.from)、加载布局robot_item(.inflate)
        final ViewHolder mViewHolder = new ViewHolder(mView);   // 把布局fruit_item 加载进mViewHolder中,   作用就是一个临时的储存器，把每次返回的View存起来，可以下次再用，提高效率

        return mViewHolder;                                     // 将ViewHolder的 实例mViewHolder返回
    }

    /**
     * @param mViewHolder 将数据和界面进行绑定
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder mViewHolder, int position) {
        RobotBean robot = data.get(position);                   // 通过position参数得到当前robot的实例

        mViewHolder.mImageView.setImageResource(robot.getId()); // 将robot实例的item数据，设置到ViewHolder中
        mViewHolder.mTextView.setText(robot.getName());
    }

    /**
     * @return 获取数据的数量
     */
    @Override
    public int getItemCount() {

        return data.size();                                     // 告诉RecyclerView一共有多少子项，返回数据源长度
    }


}
