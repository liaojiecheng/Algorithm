package net.lzzy.algorithm.algorlib;

import android.util.Log;

/**
 * Created by lzzy_gxy on 2019/6/15.
 * Description:算法复杂度平方阶
 */
public class InsertSort<T extends Comparable<? super T>> extends BaseSort<T> {


    public InsertSort(T[] itmes) {
        super(itmes);
    }
    //==================7、直接插入排序的方法=================
    public void sort() {
        for (int i=1;i<itmes.length;i++){
            int j=i-1;
            if (comare(itmes[i],itmes[j])){
                continue;
            }
            T temp=  itmes[i];
            while (j >=0 && comare(itmes[j],temp)){
                itmes[j+1]=itmes[j];
                j--;
            }
            compareMove++;
            itmes[j+1]=temp;
        }
    }
}
