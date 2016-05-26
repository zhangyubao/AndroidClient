package com.zbao.server.view;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zbao.server.R;
import com.zbao.server.base.BaseActivity;

import butterknife.Bind;

public class MainActivity extends BaseActivity {

    @Bind(R.id.recy_joker)
    RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        //创建默认的线性LayoutManager
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
//        mRecyclerView.setHasFixedSize(true);
//        //设置两个item之间的间隔
//        mRecyclerView.addItemDecoration(new SpaceItemDecoration(CommonUtil.dip2px(this, 5)));
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }


    private class SpaceItemDecoration extends RecyclerView.ItemDecoration {

        private int space;

        public SpaceItemDecoration(int space) {
            this.space = space;
        }


        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            if (parent.getChildCount() != 0) {
                outRect.top = space;
            }
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
    }
}
