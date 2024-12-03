package leetcode.no54;


import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    //给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1}, {2}, {3}, {11}};
        System.out.println(spiralOrder(nums));
    }

    //注意边界
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            if (top < bottom && left < right) {
                for (int i = right - 1; i > left; i--) {
                    list.add(matrix[bottom][i]);
                }
                for (int i = bottom; i > top; i--) {
                    list.add(matrix[i][left]);
                }
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        return list;
    }
}
