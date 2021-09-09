package com.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @author G006696 zgq
 */
public class Sort {

    public static void main(String[] args) {
        int[] d = {3, 2, 10, 7, 6, 9, 15, 1, 17, 0, 8, 4, 13};
//        int[] d = {5,4,3,2,1};
        selectSort(d);
//        bubbleSort(d);
        System.out.println(Arrays.toString(d));
       /* long start = System.currentTimeMillis();
        int[] d = new int[100000000];
        Random r = new Random();
        for (int i = 0; i < d.length - 1; i++) {
            int num = r.nextInt();
            d[i] = num;
        }
        bubbleSort(d);  //22351ms
        quickSort(d); //用时72ms
        long finish = System.currentTimeMillis();
        System.out.println("用时" + (finish - start) + "ms");*/
    }

    //冒泡排序(它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来)
    public static void bubbleSort(int[] data) {
        int temp = 0;
        int length = data.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
            System.out.println("i=" + i + Arrays.toString(data));
        }
    }

    /*快速排序
     * 以数组第一个数作为基数，从右往左检索，如果检索到比基数小的就停下；然后从左往右检索比基数大的，如果检索到比基数大的就停下；交换这两个数后再进行,如果i=j时，
     * 交换基准数和相遇位置的元素。基数左边都是小于此基数的值，左边按上边方法排序；基数右边都是大于此基数的值，右边按上边方法排序*/
    public static void quickSort(int[] data) {
        if (data.length > 0) {
            quick(data, 0, data.length - 1);
        }
    }

    public static void quick(int[] data, int left, int right) {
        if (right > left) {
            //定义变量base保存基数
            int base = data[left];
            //定义变量i指向最左边
            int i = left;
            //定义变量j指向最右边
            int j = right;
            while (i != j) {
                //由j从右往左检索比基数小的，如果检索到比基数小的就停下。
                //检索到比基数大的或者相等的继续。
                while (data[j] >= base && j > i) {
                    j--;
                }
                //由i从左往右检索比基数大的，如果检索到比基数大的就停下。
                //检索到比基数小的或者相等的继续。
                while (data[i] <= base && j > i) {
                    i++;
                }
                //交换这两个数
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
            //如果i=j时，交换基准数和相遇位置的元素
            data[left] = data[i];
            data[i] = base;
            //基数左边都是小于此基数的值，左边按上边方法排序
            quick(data, left, j - 1);
            //基数右边都是大于此基数的值，右边按上边方法排序
            quick(data, i + 1, right);
        }
        return;
    }

    /*选择排序算法
     *在未排序序列中找到最小元素，存放到排序序列的起始位置
     * 再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾。
     * 以此类推，直到所有元素均排序完毕。*/
    public static void selectSort(int[] data) {
        int length = data.length;
        int min_value = data[0];
        int min_pos = 0;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (data[j] < min_value) {
                    min_pos = j;
                }
                int temp = min_value;
                min_value = data[min_pos];
                data[min_pos] = temp;
            }
        }
    }
}
