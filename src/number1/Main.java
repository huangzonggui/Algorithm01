package number1;

public class Main {

    public static void main(String[] args) {
//        System.out.println("输入数据：");
//        Scanner s = new Scanner(System.in);
//        int m=s.nextInt();
//        System.out.println(m);
//        Object[] list = new Object[4];
//        for (int i=0;i<4;i++){
//            list[i]=i;
//        }
        Object[] list ={1,2,3,4};
        FullArray.perm(list, 0, 3);
    }
}

//全排列
 class FullArray {
    public static void perm(Object []list,int k, int m){
        //产生list[k:m]的所有排列，即是从k开始排
        if(k==m) {
            //只剩下一个元素
            for (int i = 0; i <= m; i++) {
                System.out.print(list[i]);
            }
            System.out.println();
        }else {
            //还有很多元素，递归产生排列
            for (int i = k; i <= m; i++) {
                //将整组数中的所有的数分别与第一个数交换
                MyMath.swap(list, k, i);
                perm(list, k + 1, m);
                //最后两位换位置
                MyMath.swap(list, k, i);
            }
        }
    }
}

//交换两个数
class MyMath {
    public static void swap(Object []a,int i,int j){
        Object temp=a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}