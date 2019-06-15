package net.lzzy.algorithm.algorlib;

import android.util.Log;

/**
 * Created by lzzy_gxy on 2019/6/13.
 * Description:
 */
public class DirectSort implements Comparable {

    private Integer[] items;
    private long duration;//运行时长
    private int compareCount;
    private int numbeA;//对比
    private int numbeB;//移动
    private int numbeC;//交换

    public DirectSort(Integer[] items) {
        this.items = items;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public long getDuration() {
        return duration;
    }


    public int getNumbeA() {//对比
        return  numbeA;
    }

    public int getNumbeB() {//移动
        return numbeB;
    }

    public int getNumbeC() {//交换
        return numbeC;
    }
    //比较
     public boolean compreTwo(Integer a,Integer b){
        numbeA++;
        return a.compareTo(b)>0;
    }
    //交换
    private void swap(int minpos ,int z) {
        numbeC++;
        int tmp=items[minpos];
        items[minpos]=items[z];
        items[z]=tmp;
    }


    //返回排序结果
    public Integer[] returnResoult(){
        directSort();
        return items;
    }

    //排序方法
    public void directSort() {
        long current=System.currentTimeMillis();
        Log.i("cruuent",current+"");
        for(int i=0;i<items.length-1;i++){
            int minpos=i;
            for (int j=i+1;j<items.length;j++){
                if (compreTwo(items[minpos],items[j])){
//                if (items[minpos].compareTo(items[j])>0){
                    minpos=j;
                    numbeA++;
                }
            }
            swap(minpos,i);

        }

        long end=System.currentTimeMillis();
        Log.i("end",end+"");
        duration=end-current;
        Log.i("runtime",duration+"");
    }



//    //排序方法
//    private void  sorting() {
//        for (int i = 1; i < items.length; i++) {
//            int j = i;
//            while (j > 0 && items[j] < items[j - 1]) {
//                swap(j,j-1);
//                numbeA++;
//
//                j--;
//            }
//        }
//    }
//    //交换方法
//    private void swap(int y, int z) {
//        int tmp=items[y];
//        items[y]=items[z];
//        items[z]=tmp;
//    }
}
