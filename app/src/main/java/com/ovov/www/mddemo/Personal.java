package com.ovov.www.mddemo;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by luweicheng on 2017/3/20 0020.
 */
public class Personal extends AppCompatActivity{
   private Toolbar mToolBar;
    private RecyclerView mRecycleView;
    private ImageView imageView;
    public String[] data = {"你好","你好","你好","你好","你好","你好","你好","你好","你好","你好","你好"

            ,"你好","你好","你好","你好","你好","你好","你好","你好","你好","你好"
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        mRecycleView = (RecyclerView) findViewById(R.id.rv_recycle);
        imageView = (ImageView) findViewById(R.id.iv_header);
        mToolBar = (Toolbar)findViewById(R.id.mToolBar);


        int img = getIntent().getIntExtra("data",R.drawable.m1002);
        imageView.setBackgroundResource(img);

        //状态栏透明
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setSupportActionBar(mToolBar);

        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        mRecycleView.setAdapter(new Adapter());




    }



    class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

        @Override
        public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(Personal.this).inflate(R.layout.item,null);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(Adapter.ViewHolder holder, int position) {
            Log.e("onBind", "onBindViewHolder: "+data[position] );
              holder.textView.setText(data[position]);

        }

        @Override
        public int getItemCount() {
            return data.length;
        }

        class ViewHolder extends RecyclerView.ViewHolder{
            private TextView textView;
            public ViewHolder(View itemView) {
                super(itemView);
                textView = (TextView) itemView.findViewById(R.id.tv_content);
            }
        }
    }

    //给ToolBar的返回图标设置监听事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
