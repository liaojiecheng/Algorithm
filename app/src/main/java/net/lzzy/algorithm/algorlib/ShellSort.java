package net.lzzy.algorithm.algorlib;

/**
 * Created by lzzy_gxy on 2019/6/20.
 * Description:
 */
public  class ShellSort <T extends Comparable<? super T>> extends BaseSort<T> {
    public ShellSort(T[] itmes) {
        super(itmes);
    }


    @Override
    public void sort() {
        int len = itmes.length;
        int g = len / 2;
        while (g > 0) {
            for (int i = g; i < itmes.length; i += g) {
                int j = i - g;
                if (comare(itmes[i], itmes[j])) {
                    continue;
                }
                T temp = itmes[i];
                while (j >= 0 && comare(itmes[j], temp)) {
                    itmes[j + 1] = itmes[j];
                    j--;
                    compareMove++;
                }
                itmes[j + 1] = temp;
            }
            g=g/2;
        }
    }
}
