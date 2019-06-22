package net.lzzy.algorithm;

import android.annotation.SuppressLint;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.AndroidException;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ZoomControls;

import net.lzzy.algorithm.algorlib.BaseSort;
import net.lzzy.algorithm.algorlib.DirectSort;
import net.lzzy.algorithm.algorlib.InsertSort;
import net.lzzy.algorithm.algorlib.SearchFactory;
import net.lzzy.algorithm.algorlib.sortFactory;

import org.json.JSONException;

import java.time.chrono.MinguoChronology;
import java.util.Calendar;
import java.util.Dictionary;
import java.util.Objects;
import java.util.Random;

/**
 * @author Administrator
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Integer[] items;
    private EditText edtItems;
    private TextView tvResult;
    private Spinner spinner;
    private View container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=findViewById(R.id.Spinner);
        edtItems = findViewById(R.id.activity_main_edt_items);
        findViewById(R.id.activity_main_btn_generate).setOnClickListener(this);
        findViewById(R.id.activity_main_btn_sort).setOnClickListener(this);
        tvResult = findViewById(R.id.activity_main_tv_result);
        initSpinner();


    }
    @SuppressLint("WrongViewCast")
    private void initSearch(){
        spinner=findViewById(R.id.activity_main_btn_search);
        spinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, SearchFactory.getsearchNames()));
        container=findViewById(R.id.activity_min_btn_container);
        findViewById(R.id.activity_main_btn_search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_main_btn_generate:
                generateItems();
                displayItems(edtItems);
                break;

            case R.id.activity_main_btn_sort:

                BaseSort<Integer> sort=
                        sortFactory.getInstance(spinner.getSelectedItemPosition(),items);
                BaseSort<Integer> sortNotNull = Objects.requireNonNull(sort);
                sortNotNull.sortTime();
                /*InsertSort<Integer> sort = new InsertSort<>(items);*/
                String result = sort.getResult();
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("排序成功");
                builder.setMessage("对比次数：" + sort.getCompareCount() +
                        "\n" + "移动次数：" + sort.getCompareMove() +
                        "\n" + "交换次数：" + sort.getCompareSwop() +
                        "\n" + "运算时长: " + sort.getTime() + "秒")
                        .show();
                displayItems(tvResult);
                break;
            case R.id.activity_main_btn_search:

        }
    }

    private void initSpinner() {
        Spinner spinner = findViewById(R.id.Spinner);
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, sortFactory.getsortNames()));

    }




    private void displayItems(TextView tv) {    //生成随机数并显示出随机数
        String display = "";
        for (Integer i : items) {
            display = display.concat(i + ",");
        }
        display = display.substring(0, display.length() - 1);
        tv.setText(display);
    }

    private void swap(int m, int n) {
        int temp = items[m];
        items[m] = items[n];
        items[n] = temp;
    }


    private void generateItems() {       //生成随机数
        items = new Integer[10];
        Random generator = new Random();
        for (int i = 0; i < items.length; i++) {
            items[i] = generator.nextInt(99);
        }
    }
}
