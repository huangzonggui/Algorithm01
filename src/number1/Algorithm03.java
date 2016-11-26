package number1;

/**
 * Created by hzg on 2016/9/26.
 */
public class Algorithm03 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        FullArray(array);
    }

    /*
    * 基于最小变换的Steinhaus–Johnson–Trotter算法
    */
    static void FullArray(int[] array) {
        int[] index = new int[array.length];
        //移动的方向：-1左边 1右边,每个数都有一个方向，这些方向就记录在move数组里
        int[] move = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            index[i] = i;
            move[i] = -1;//初始化箭头都指向左
        }

        arrayPrint(array, index, move);

        //等于0表示发现合法的移动策略
        while (SJTNext(index, move) == 0) {
            arrayPrint(array, index, move);
        }
    }

    private static int SJTNext(int[] index, int[] move) {
        //用j来记录最大活动数的下标的下标
        int i, j;
        int array_size = index.length;

        //循环查找最大的活动数
        for (i = array_size - 1, j = array_size; i >= 0; i--) {
            //移动的下标合法：i + move[i] < array_size && i + move[i] >= 0 移动的数值大于另一个： index[i] > index[i + move[i]]:表示下标加一或者减一
            if (i + move[i] < array_size && i + move[i] >= 0 && index[i] > index[i + move[i]]) {
                //如果j==array_size
                if (j == array_size) {
                    j = i;
                    continue;
                }
                if (index[i] > index[j]) {
                    j = i;
                }
            }
        }

        //未发现合法的移动策略,返回的是1
        if (j == array_size) {
            return 1;
        }

        int t = index[j];//要交换的元素
        i = j + move[j];//发生交换的位置
        swap(index, i, j);
        swap(move, i, j);

        //将所有比t大的元素的移动方向反转
        for (i = 0; i < array_size; i++) {
            if (index[i] > t) {
//                System.out.print(index[i]+">"+t+"?  ");
                move[i] = -move[i];
            }
        }
//            发现合法的移动策略,返回的是0
        return 0;

    }

    public static void swap(int[] intarr, int i, int j) {
        int temp;
        temp = intarr[i];
        intarr[i] = intarr[j];
        intarr[j] = temp;
    }

    private static void arrayPrint(int[] array, int[] index, int[] move) {
        for (int x : index) {
            System.out.print(array[x]);
//            if (move[x] == 1) {
//                System.out.print("右 ");
//            } else {
//                System.out.print("< ");
//            }
        }
        System.out.println();
    }


}
