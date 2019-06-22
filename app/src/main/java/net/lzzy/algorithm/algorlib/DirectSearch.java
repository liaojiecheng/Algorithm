package net.lzzy.algorithm.algorlib;

/**
 * Created by lzzy_gxy on 2019/6/22.
 * Description:
 */
public class DirectSearch <T extends Comparable<? super T >> extends BasesearSort<T> {
    DirectSearch(T[] itmes) {
        super(itmes);
    }


    @Override
    public int search(T key) {
        long start=System.currentTimeMillis();
        int pos=0;
        for (T item:itmes){
            if (equal(item,key)){
                setDuration(System.currentTimeMillis()-start);
                return pos;
            }
            pos++;
        }
            setDuration(System.currentTimeMillis());
           return -1;
    }
}
