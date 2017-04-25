package com.joyful.joyfulkitchen.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.joyful.joyfulkitchen.R;
import com.joyful.joyfulkitchen.view.RulerView;


/**
 * Created by Administrator on 2017/3/29.
 */

public class RuleViewMainActivity extends AppCompatActivity {

    private RulerView ruler_height;   //身高的view
    private RulerView ruler_weight;  //体重的view

    private ImageView back;
    private Button gonext;





    private TextView tv_register_info_height_value, tv_register_info_weight_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_a_mian);

        //返回上一个页面
        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //下一步
        gonext = (Button) findViewById(R.id.gonext);
        gonext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gonext = new Intent(RuleViewMainActivity.this, DatePickerMainActivity.class);
                startActivity(gonext);
            }
        });

        ruler_height = (RulerView) findViewById(R.id.ruler_height);
        ruler_weight = (RulerView) findViewById(R.id.ruler_weight);

        tv_register_info_height_value = (TextView) findViewById(R.id.tv_register_info_height_value);
        tv_register_info_weight_value = (TextView) findViewById(R.id.tv_register_info_weight_value);


        ruler_height.setOnValueChangeListener(new RulerView.OnValueChangeListener() {
            @Override
            public void onValueChange(float value) {
                tv_register_info_height_value.setText(value + "");
            }
        });


        ruler_weight.setOnValueChangeListener(new RulerView.OnValueChangeListener() {
            @Override
            public void onValueChange(float value) {
                tv_register_info_weight_value.setText(value + "");
            }
        });

        ruler_height.setValue(165, 80, 250, 1);

        ruler_weight.setValue(55, 20, 200, 0.1f);

    }
}