/*** VM Args：-Xss128k * @author zzm */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        // 基本数据类型之间的 ==  是比较值，引用数据类型 == 比较的是地址值
        // 1：在Java Heap中创建对象 2：在字符串常量池中添加 zhangsan
        String a = new String("zhangsan");

        // 调用 intern 方法，因上一步中已经将zhangsan存入常量池中，这里直接返回常量池 zhangsan 的引用地址
        String b = a.intern();
        // a 的地址在Java Heap中 ， b的地址在 常量池中 ，所以结果是flase

        System.out.println(b);

        System.out.println(b == a);



        // 因为常量池中已经包含zhangsan，所以直接返回
        String c = "zhangsan";
        // b c 的地址一致，所以是true
        System.out.println(b == c);


        String str1 = new String("计算机")+"软件";



        System.out.println(str1.intern() == str1);
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}

