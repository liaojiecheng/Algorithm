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
                sorting();
//                directSort();
                displayItems(tvResult);
                DirectSort directSort=new DirectSort(items);
                directSort.directSort();
                items=directSort.returnResoult();
                new AlertDialog.Builder(MainActivity.this).setTitle("排序完成")
                        .setMessage("对比次数："+directSort.getNumbeA()+
                                "\n交换次数："+directSort.getNumbeC()+
                                "\n移动次数："+directSort.getNumbeB()+
                                "\n运行时长："+directSort.getDuration())
                        .show();
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

// todo:直接选择排序的具体实现
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
//            swap(minpos,i);
        }
        }

//    private void swap() {
//           int tmp=items[y];
////            items[y]=items[z];
////            items[z]=tmp;
////    }



    //第i+1个跟第i个相比较，如果第i+1比第i个小，则第i+1个，跟前面有序的区域在进行比较；
    //第i个跟第i-1个比如果第i个比i-1个小，则第i个继续跟第i-2个继续相比较……直到i与第i-z个相比较大于0；

    private void  sorting() {
            for (int i = 1; i < items.length; i++) {
                int j = i;
                while (j > 0 && items[j] < items[j - 1]) {
                    swap(j,j-1);
                    j--;
                }
            }
        }

    private void swap(int y, int z) {
        int tmp=items[y];
        items[y]=items[z];
        items[z]=tmp;
    }



    private void generateItems() {
        items = new Integer[10];
        Random generator = new Random();
        for (int i = 0; i < items.length; i++) {
            items[i] = generator.nextInt(99);
        }
    }
}
