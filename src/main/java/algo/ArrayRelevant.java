package src.main.java.algo;

import org.junit.Test;

/**
 * 数组相关算法
 */
public class ArrayRelevant {
    /**
     * 从数组中选取最早出现两次的数字
     */
    @Test
    public void test() {
        int[] array = new int[]{1, 2, 3, 4, 5, 2, 3, 4, 2};
        System.out.println(getTwoTimes(array));
    }

    public String getTwoTimes(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int a = array[i];
            for (int j = 0; j < array.length; j++) {
                if (i == j) { continue; }
                if (a == array[j]) {
                    return a + "";
                }
            }
        }
        return "";
    }
}
