package net.lzzy.algorithm.algorlib;

import android.util.Pair;

/**
 * Created by lzzy_gxy on 2019/6/27.
 * Description:
 */
public class BinaryTeree<T extends Comparable<? super T >>extends BaseSearch {
    private Pair<Integer, T> root;
    private BinaryTeree<T> left, right;

    BinaryTeree(T[] items) {
        super(items);
        root = new Pair<>(0, items[0]);
        for (int i = 1; i < items.length; i++) {
            addNode(new Pair<Integer, T>(i, items[i]));

        }
    }

    private BinaryTeree(Pair<Integer, T> node) {
        root = node;

    }

    private void addNode(Pair<Integer, T> node) {
        //todo:增加节点
        int comp = compare(node.second, root.second);
        if (comp > 0) {
            if (right == null) {
                right = new BinaryTeree<T>(node);

            } else {
                right.addNode(node);
            }
        }
        if (comp < 0) {
            if (left == null) {
                left = new BinaryTeree<T>(node);

            } else {
                left.addNode(node);
            }
        }
    }

    private long start = -1;

    @Override
    public int search(Comparable key) {
        if (start < 0) {
            start = System.currentTimeMillis();
        }
        int comp = compare(key, root.second);
        if (comp == 0) {
            setDuration(System.currentTimeMillis() - start);
            return root.first;
        } else if (comp > 0) {
            if (right == null) {
                setDuration(System.currentTimeMillis() - start);
                return -1;
            } else {
                return right.search(key);
            }
        } else {
            if (left == null) {
                setDuration(System.currentTimeMillis() - start);
                return -1;
            } else {
                return left.search(key);
            }
        }

    }
}
