package net.lzzy.algorithm.algorlib;

import android.util.Log;

/**
 * Created by lzzy_gxy on 2019/6/13.
 * Description:
 */
public class DirectSort <T extends Comparable<? super T>> extends BaseSort<T>{

    public DirectSort(T[] itmes) {
        super(itmes);
    }
    void swop(int a,int b){   //5、用于交换两个元素位置的方法
        T temp=itmes[a];
        itmes[a]=itmes[b];
        itmes[b]=temp;
        compareSwop++;         //交换次数++
    }

    public void sort(){            //7、排序的方法
        for (int i=0;i<itmes.length-1;i++){
            int minPos=i;
            for (int j=i+1;j<itmes.length;j++){
                if (comare(itmes[minPos],(itmes[j]))){
                    minPos=j;
                }
            }
            swop(minPos,i);
        }
    }

}
