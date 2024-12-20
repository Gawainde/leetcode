package leetcode.no59;

import java.util.Arrays;

public class GenerateMatrix {

    //给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(1)));
        System.out.println(Arrays.deepToString(generateMatrix2(1)));
    }

    //注意每一条边的处理规则要统一  即每一条边的赋值循环都是从起始端点到终止端点的前一位
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        //判断需要转几圈 如果n为奇数则需单独给最中间的赋值
        int flag = n / 2, start = 1;
        //正方形的每条边赋值从起始位置开始到n - offset
        int x, y, offset = 1, startX = 0, startY = 0;
        while (flag > 0) {
            //最上面的边 从左上端点到右上端点的之前的位置依次赋值 即如果n = 6第一层为res[0][0] ~  res[0][4] 第二层为res[1][1] ~  res[1][3] ...以此类推
            for (x = startX; x < n - offset; x++) {
                res[startY][x] = start++;
            }
            //最右面的边 从右上端点到右下端点的之前的位置依次赋值 即如果n = 6第一层为res[0][5] ~  res[4][5] 第二层为res[1][4] ~  res[3][4] ...以此类推
            for (y = startY; y < n - offset; y++) {
                res[y][x] = start++;
            }
            //最下面的边 从右上端点到右下端点的之前的位置依次赋值 即如果n = 6第一层为res[5][5] ~  res[1][5] 第二层为res[4][4] ~  res[4][2] ...以此类推
            for (; x > startX; x--) {
                res[y][x] = start++;
            }
            //最左面的边 从右上端点到右下端点的之前的位置依次赋值 即如果n = 6第一层为res[5][0] ~  res[1][0] 第二层为res[4][1] ~  res[2][1] ...以此类推
            for (; y > startY; y--) {
                res[y][x] = start++;
            }
            //缩减圈数
            flag--;
            //变为内圈的正方形起始值
            startX++;
            startY++;
            //由于小了一圈 每条边的终止位置也向里缩减一位
            offset++;
        }
        if ((n & 1) == 1) {
            res[startY][startX] = start;
        }
        return res;
    }

    public static int[][] generateMatrix2(int n) {
        int[][] res = new int[n][n];
        //设置x，y轴的起始和终止点  为每条边赋值时取左闭右开区间
        // 1 2 3  上边赋值[1，3）即 1，2 右边赋值[3，9）即 3，6 下边赋值[9，7）即 9，8  左边赋值[7，1）即 7，4
        // 4 5 6
        // 7 8 9
        int top = 0, bottom = n - 1, left = 0, right = n - 1, start = 1;
        while (top <= bottom && left <= right) {
            //最上面的边
            for (int i = left; i < right; i++) {
                res[top][i] = start++;
            }
            //最右面的边
            for (int i = top; i < bottom; i++) {
                res[i][right] = start++;
            }
            //最下面的边
            for (int i = right; i > left; i--) {
                res[bottom][i] = start++;
            }
            //最右面的边
            for (int i = bottom; i > top; i--) {
                res[i][left] = start++;
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        //如果n是奇数 需要对最中间的值赋值
        if ((n & 1) == 1){
            res[--top][--left] = start;
        }
        return res;
    }
}
