import java.util.Scanner;

/**
 * 对数组的增删查改操作
 * sc.nextInt() 方法阻塞进程,获取用户输入
 */

public class ArrayTest {

    public void notice(){
        System.out.println("***********************");

        System.out.println("1---插入数据" +
                "\n2---显示所有数据" +
                "\n3---在指定位置处插入数据" +
                "\n4---查询能被3整除的数据" +
                "\n0---退出");
        System.out.println("***********************");
        System.out.println("选择操作序号");
    }

    // 插入数据
    public void insert(int n,int arr[]){
        arr[0] = n;
    }


    // 插入数据,指定位置处插入
    public void insert(int index,int n,int arr[]){
        if(index >= 0 || index <= arr.length) {
            arr[index] = n;
        }else {
            System.out.println("插入失败");
        }
    }

    // 显示所有数据
    public void show(int arr[]){
        for(int i : arr){
            System.out.print(i + "   ");
        }
        System.out.println();
    }



    // 查询能被3整除的数据
    public int[] search(int arr[]){

        int result[] = new int[arr.length];

        for(int i=0;i<arr.length;i++){

            if(arr[i] % 3 == 0){
                result[i] = arr[i];
            }
        }
        return result;
    }


    public static void main(String[] args) {


        int arr[] = new int[5];
        ArrayTest ar = new ArrayTest();

        Scanner sc = new Scanner(System.in);

        int userstart;

        ar.notice();

        // 1. 用户初始化数组
        for(int i=0;i < arr.length -1;i++){
            System.out.println("输入第"+(i+1)+"个元素,0退出");
            arr[i] = sc.nextInt();
        }


        // 2. 展示数组
        ar.show(arr);

        while (true){

            ar.notice();
            int choose = sc.nextInt();

            // 3. 用户输入选择

            switch (choose){

                case 0:
                    // break 只能跳出当前循环, 不能终止程序
                    System.exit(1);

                case 1:
                    System.out.println("输入要插入的数据");
                    userstart = sc.nextInt();
                    ar.insert(userstart,arr);
                    System.out.println("插入成功");
                    break;

                case 2:
                    ar.show(arr);
                    break;

                case 3:
                    System.out.println("输入位置");
                    int position = sc.nextInt();

                    System.out.println("输入数据");
                    int data = sc.nextInt();

                    ar.insert(position,data,arr);
                    System.out.println("插入完成");
                    break;

                case 4:
                    int result[] = ar.search(arr);
                    if(result.length == 0){
                        System.out.println("没有相关结果");
                    }else {
                        System.out.println("能被3整除的数为:");
                        ar.show(result);
                    }
                    break;
            }

        }

    }
}
