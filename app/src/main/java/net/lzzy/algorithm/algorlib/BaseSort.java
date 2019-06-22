package net.lzzy.algorithm.algorlib;

import android.util.Log;

import java.sql.Time;

/**
 * Created by lzzy_gxy on 2019/6/15.
 * Description:典型参数T需要加的约束，约束T实现Comparable<T>接口
 */
public abstract class BaseSort <T extends Comparable<? super T >>  {

    T[] itmes;
    long time;        //运算时间
    int compareCount; //对比次数
    int compareMove;  //移动次数
    int compareSwop;  //交换次数
    long directSort;   //排序结果



    public BaseSort(T[] itmes) {  //数据集合
        this.itmes = itmes;
        compareCount = 0;
        compareMove = 0;
        compareSwop = 0;
    }

    boolean comare(T a,T b) {  //比较两个大小
        compareCount++;
        return a.compareTo(b) > 0;
    }


    public  String getResult(){    //返回排序结果
        String display ="";
        for (T i : itmes) {
            display = display.concat(i + ",");
        }
        return  display.substring(0, display.length() - 1);
    }

    public void sortTime(){
        long startTime=System.currentTimeMillis();
        sort();
        long endTime=System.currentTimeMillis();
        time=endTime-startTime;
        directSort=System.currentTimeMillis()-startTime;
    }

    public abstract  void sort();   //抽象类

    public long getTime() {  //算法的运行时长
        return time;
    }
    public int getCompareCount() { //对比次数
        return compareCount;
    }
    public int getCompareMove() {  //移动次数
        return compareMove;
    }
    public int getCompareSwop() {  //交换次数
        return compareSwop;
    }
}
