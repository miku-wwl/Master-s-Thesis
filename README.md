# Master‘s-Thesis

## Work log on February, 2021

### February 16

Latex 数学公式地址 https://latex.codecogs.com/eqneditor/editor.php

建立Latex模板

了解Java技术体系，Java虚拟机家族

建立VMware Ubuntu20.04虚拟机





编译JDK

但出现不明原因，导致十几次编译失败。

后使用 bash configure --disable-*warnings*-as-errors 解决，成功编译JDK12

在JDK12上运行HelloWorld

```
miku@ubuntu:~/Desktop/jdk12-06222165c35f/build/linux-x86_64-server-release/jdk/bin$ ./java -version
openjdk version "12-internal" 2019-03-19
OpenJDK Runtime Environment (build 12-internal+0-adhoc.miku.jdk12-06222165c35f)
OpenJDK 64-Bit Server VM (build 12-internal+0-adhoc.miku.jdk12-06222165c35f, mixed mode)
miku@ubuntu:~/Desktop/jdk12-06222165c35f/build/linux-x86_64-server-release/jdk/bin$ touch HelloWorld.java
miku@ubuntu:~/Desktop/jdk12-06222165c35f/build/linux-x86_64-server-release/jdk/bin$ nano HelloWorld.java
miku@ubuntu:~/Desktop/jdk12-06222165c35f/build/linux-x86_64-server-release/jdk/bin$ ./javac HelloWorld.java
miku@ubuntu:~/Desktop/jdk12-06222165c35f/build/linux-x86_64-server-release/jdk/bin$ ./java HelloWorld
HelloWorld
miku@ubuntu:~/Desktop/jdk12-06222165c35f/build/linux-x86_64-server-release/jdk/bin$ 


```

了解了Java内存区域管理，查阅了如何设定JVM参数，调试了内存溢出程序

```
import java.util.ArrayList;
import java.util.List;

public class HeapOOM {
    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
```

### February 17

理解Java内存区域与内存溢出异常

理解垃圾收集器与内存分配策略