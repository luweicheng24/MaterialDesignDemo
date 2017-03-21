package com.ovov.www.mddemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private Toolbar toolbar;
    private NavigationView mNavigationView;
    private RecyclerView mRecycleView;
    private ActionBarDrawerToggle mToggle;
    private RecycleViewAdapter mAdapter;
    private Integer[] imgs = {R.drawable.m1000, R.drawable.m1002,
            R.drawable.m1003,
            R.drawable.m1004, R.drawable.m1005, R.drawable.m1006,
            R.drawable.m1008, R.drawable.m1009, R.drawable.m1010,
            R.drawable.m1013, R.drawable.m1014, R.drawable.m1021
            };

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mDrawerLayout = (DrawerLayout) findViewById(R.id.mDrawer);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        mRecycleView = (RecyclerView) findViewById(R.id.mRecycleView);
        mNavigationView = (NavigationView) findViewById(R.id.navigationView);

        mRecycleView.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));
        mAdapter = new RecycleViewAdapter(imgs,this);
        mRecycleView.setAdapter(mAdapter);


        setSupportActionBar(toolbar);


        //设置菜单点击弹出的监听
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.open,R.string.close);
        mToggle.syncState();
        mDrawerLayout.addDrawerListener(mToggle);




        //侧边的菜单监视
        mNavigationView.setCheckedItem(R.id.first);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                final Snackbar snackBar = Snackbar.make(mDrawerLayout,item.getTitle(),Snackbar.LENGTH_INDEFINITE);
                snackBar.setAction("Cancel", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                snackBar.setActionTextColor(Color.BLUE);
                snackBar.show();
                return true;
            }
        });



    }
    //创建菜单布局
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_menu,menu);
        return true;
    }
    //菜单选项的监听

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
            switch(item.getItemId()){
                case R.id.first:
                    Toast.makeText(this,"first",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.second:
                    Toast.makeText(this,"second",Toast.LENGTH_SHORT).show();

                    break;
                case R.id.three:
                    Toast.makeText(this,"three",Toast.LENGTH_SHORT).show();

                    break;
                case R.id.four:
                    Toast.makeText(this,"four",Toast.LENGTH_SHORT).show();

                    break;
                case R.id.five:
                    Toast.makeText(this,"five",Toast.LENGTH_SHORT).show();

                    break;
            }


        return true;


    }
}
