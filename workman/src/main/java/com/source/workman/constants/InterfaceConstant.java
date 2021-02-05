package com.source.workman.constants;

/**
 * @author liuzh
 * <p>
 * 接口中定义的"变量"，其实就是常量，接口中的"变量"默认都是 "public static final"类型，即为常量，因此接口可以省略"public static final"而直接写成 "type variable"
 * 接口定义常量，虽不能实例化，确可以被其他类实现
 * <p>
 * 在interface和class中定义相同的常量，interface生成的class文件比class生成的class文件会更小，而且更简洁，效率更高。可以使用jad和javap反编译去分析一下
 * <p>
 * 对于用是用interface定义常量还是使用class定义常量，看个人喜好. 个人觉得interface定义常量更为优美：代码更简洁， 生成的class文件更小，JVM不要考虑类的附加特性，如方法重载等，因而更为高效
 */
public interface InterfaceConstant {
    int DEFAULT_SERVER_PORT = 8848;

    String DEFAULT_CONTROLLER_PREFIX = "helloworld";

    String DEFAULT_CONTROLLER_PREFIX_1 = "helloworld1";
}
