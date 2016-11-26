package number1;

public class FullPermutation4 {

    public static void swap(int[] intarr, int i, int j)
    {
        int temp;
        temp = intarr[i];
        intarr[i] = intarr[j];
        intarr[j] = temp;
    }
    public static  int SJTNext( int[] index, int[] move)
    {
        int i, j, t;

        int array_size = index.length;

        //找到最大合法移动的元素索引  
        for(i = array_size - 1, j = array_size; i >= 0; --i)
        {
            if(i + move[i] < array_size && i + move[i] >= 0 && index[i] > index[i + move[i]])
            {
                if(j == array_size)
                {
                    j = i;
                    continue;
                }

                if(index[i] > index[j])
                {
                    j = i;
                }
            }
        }

        //未发现合法的移动策略  
        if(j == array_size)
        {
            return 1;
        }

        t = index[j];//要交换位置的元素  
        i = j + move[j];//发生交换的位置  
        swap(index, i, j);
        swap(move, i, j);

        //将所有比t大的元素的移动方向反转  
        for(i = 0; i < array_size; ++i)
        {
            if(index[i] > t)
            {
                move[i] = -move[i];
            }
        }

        return 0;
    }



    public static void arrayPrint(char[] array,int[] index,int[] move){
        int array_size = array.length;
        for(int x:index){
            System.out.print(array[x]);
            if (move[x] == 1) {
                System.out.print("> ");
            } else {
                System.out.print("< ");
            }
        }
        System.out.println();

    }

    /* 
     * 基于最小变换的Steinhaus–Johnson–Trotter算法 
     */
    static void FullArray(char[] array)
    {
        int array_size = array.length;
        int[] index = new int[array_size];
        int[] move = new int[array_size];

        for( int i = 0; i < array_size; ++i)
        {
            index[i] = i;
            move[i] = -1;
        }

        arrayPrint(array, index,move);

        while(SJTNext(index, move) == 0)
        {
            arrayPrint(array, index,move);
        }
    }

    public static void main(String[] args) {
        char[]  charx = {'a','b','c','d'};
        FullArray(charx);

    }

} 