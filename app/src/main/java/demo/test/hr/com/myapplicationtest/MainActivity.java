package demo.test.hr.com.myapplicationtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import demo.test.hr.com.myapplicationtest.ui.PullToRefreshExpandableListActivity;
import demo.test.hr.com.myapplicationtest.ui.RefreshActivity;


public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.text).setOnClickListener(this);
        findViewById(R.id.text1).setOnClickListener(this);
        findViewById(R.id.text2).setOnClickListener(this);
        findViewById(R.id.text3).setOnClickListener(this);
        findViewById(R.id.text4).setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.text:
                Intent intent=new Intent(this, PullToRefreshExpandableListActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in,R.anim.hold_out);
                break;
            case R.id.text1:
                Intent intent1=new Intent(this, PullToRefreshExpandableListActivity.class);
                startActivity(intent1);
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
                break;
            case R.id.text2:
                Intent intent2=new Intent(this, PullToRefreshExpandableListActivity.class);
                startActivity(intent2);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                break;
            case R.id.text3:
                Intent intent3=new Intent(this, PullToRefreshExpandableListActivity.class);
                startActivity(intent3);
                overridePendingTransition(R.anim.zoom_in,R.anim.zoom_out);
                break;
            case R.id.text4:
                Intent intent4=new Intent(this, RefreshActivity.class);
                startActivity(intent4);
                break;
        }
    }


}
