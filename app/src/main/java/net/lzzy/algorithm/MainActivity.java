package net.lzzy.algorithm;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ZoomControls;

import net.lzzy.algorithm.algorlib.DirectSort;
import net.lzzy.algorithm.algorlib.InsertSort;

import org.json.JSONException;

import java.time.chrono.MinguoChronology;
import java.util.Calendar;
import java.util.Dictionary;
import java.util.Random;

/**
 * @author Administrator
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Integer[] items;
    private EditText edtItems;
    private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtItems = findViewById(R.id.activity_main_edt_items);
        findViewById(R.id.activity_main_btn_generate).setOnClickListener(this);
        findViewById(R.id.activity_main_btn_sort).setOnClickListener(this);
        tvResult = findViewById(R.id.activity_main_tv_result);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_main_btn_generate:
                generateItems();
                displayItems(edtItems);
                break;
            case R.id.activity_main_btn_sort:
                InsertSort<Integer> sort=new InsertSort<>(items);
                sort.sortTime();
                String result=sort.getResult();
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("排序成功");
                builder.setMessage("对比次数："+sort.getCompareCount()+
                        "\n" +"移动次数："+sort.getCompareMove()+
                        "\n"+"交换次数：" +sort.getCompareSwop()+
                        "\n"+"运算时长: "+sort.getTime()+"秒")
                        .show();
                displayItems(tvResult);
                break;
        }
    }
    private void displayItems(TextView tv) {    //生成随机数并显示出随机数
        String display ="";
        for (Integer i : items) {
            display = display.concat(i + ",");
        }
        display = display.substring(0, display.length() - 1);
        tv.setText(display);
    }
    private void swap(int m, int n) {
        int temp=items[m];
        items[m]=items[n];
        items[n]=temp;
    }
    private void generateItems() {       //生成随机数
        items = new Integer[10];
        Random generator = new Random();
        for (int i = 0; i < items.length; i++) {
            items[i] = generator.nextInt(99);
        }
    }
}
