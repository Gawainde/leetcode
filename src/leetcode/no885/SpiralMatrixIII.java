package leetcode.no885;

import java.util.Arrays;

public class SpiralMatrixIII {

    //在 rows x cols 的网格上，你从单元格 (rStart, cStart) 面朝东面开始。网格的西北角位于第一行第一列，网格的东南角位于最后一行最后一列。
    //你需要以顺时针按螺旋状行走，访问此网格中的每个位置。每当移动到网格的边界之外时，需要继续在网格之外行走（但稍后可能会返回到网格边界）。
    //最终，我们到过网格的所有 rows x cols 个空间。
    //按照访问顺序返回表示网格位置的坐标列表。
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(spiralMatrixIII(1, 4, 0, 0)));
    }

    public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] res = new int[rows * cols][2];
        int left = 0, top = 0, right = cols - 1, bottom = rows - 1, start = 1;
        int startY = 0, startX = 0;
        while (top <= bottom && left <= right){

            //TODO
            top++;
            left++;
            bottom--;
            right--;
        }


        return res;
    }
}
