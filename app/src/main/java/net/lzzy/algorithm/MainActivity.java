package net.lzzy.algorithm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
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
                directSort();
                displayItems(tvResult);
                break;
            default:
                break;
        }
    }

    private void displayItems(TextView tv) {
        String display = "";
        for (Integer i : items) {
            display = display.concat(i + ",");
        }
        display = display.substring(0, display.length() - 1);
        tv.setText(display);
    }

//    private void directSort() {
//        //todo:直接选择排序的具体实现
//        //for循环
//  //定义一个空值，然后for循环找出在无序区域中最小的一个，然后再用最小的跟无序区域的第一个数值的位置交换。
//  //一直重复以上的循环，直到[i]=[j];
//        for (int i=0;i<items.length;i++){
//            for (int j=i+1;j<items.length;j++){
//                if (items[i]>items[j]){
//                    int R=items[i];
//                    items[i]=items[j];
//                    items[j]=R;
//                }
//            }
//        }
    //分为有序区和无序区，每一趟排序都在无序区一次对比，记录对比区域的最小元素的位置。
    //然后把无序区的第一个袁术和所记录的最小元素进行交换，无序区少一个、有序区多一个，循环往复直至无序区元素数量为0
private void directSort() {
        for(int i=0;i<items.length-1;i++){
            int minpos=i;
            for (int j=i+1;j<items.length;j++){
                if (items[minpos].compareTo(items[j])>0){
                    minpos=j;
                }
            }
            swap(minpos,i);
        }
        }

    private void swap(int y, int z) {
           int tmp=items[y];
            items[y]=items[z];
            items[z]=tmp;
    }


//        int R0=0;
//        for (int i=0;i<items.length;i++){
//                for (int j=i+1;j<=i;j++){
//                   if (items[i]>items[j]){
//                       R0=items[j];
//                       items[j]=items[i];
//                       items[i]=R0;
//                    }
//                }
//            }

    private void generateItems() {
        items = new Integer[10];
        Random generator = new Random();
        for (int i = 0; i < items.length; i++) {
            items[i] = generator.nextInt(99);
        }
    }
}
