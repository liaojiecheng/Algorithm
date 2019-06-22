package net.lzzy.algorithm.algorlib;

import javax.xml.datatype.Duration;

/**
 * Created by lzzy_gxy on 2019/6/22.
 * Description:
 */
public abstract class BasesearSort <T extends Comparable<? super T >> {

    T[] itmes;
    private  long duration;
    private int CompareCount;
    private int swapCount;


    BasesearSort(T[] itmes){
        this.itmes = itmes;
        CompareCount = 0;
        swapCount=0;
    }


    boolean equal(T a,T b) {
        CompareCount++;
        return a.compareTo(b) == 0;
    }

    int compare(T a, T b) {
        CompareCount++;
        return a.compareTo(b);
    }

  public abstract  int search(T key);



    boolean comare(T a,T b) {  //比较两个大小
        CompareCount++;
        return a.compareTo(b) > 0;
    }


    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration=duration;
    }

    public long getCompraeCount() {
        return CompareCount;
    }

    public void setCompareCount(int CompareCount) {
        this.CompareCount=CompareCount;
    }
}


