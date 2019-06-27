package net.lzzy.algorithm.algorlib;

/**
 * Created by lzzy_gxy on 2019/6/22.
 * Description:
 */
public class SearchFactory {
    public static <T extends Comparable<? super T>> BaseSearch<T>  getInstance(int key, T[] items){
        BaseSearch<T> search;
        switch (key){
            case 0:
                search = new DirectSearch<>(items);
                break;
            case 1:
                search = new BianrySearch<>(items);
                break;

            default:
                return null;
        }
        return search;
    }
    public static  String [] getsearchNames(){
        return  new String[]{
                "顺序查找","二分查找"};
    }
}

