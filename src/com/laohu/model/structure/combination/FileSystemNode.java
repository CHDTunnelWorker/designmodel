package com.laohu.model.structure.combination;

/**
 * @program: 组合模式
 * @description: 文件系统节点抽象类(用于文件 / 目录对象的继承, 定义两者的统一处理逻辑行为)
 * @author: Holland
 * @create: 2021-08-22 11:30
 **/
public abstract class FileSystemNode {

    protected String path;

    public FileSystemNode(String path) {
        this.path = path;
    }

    /**
     * @Description: 统计文件数量(文件/目录类 都需要实现这个统一接口,才能实现目录和文件的递归计算)
     * @return: int
     * @auther: Holland
     * @date: 2021/8/22 11:32
     */
    public abstract int countNumOfFiles();
    /**
     * @Description: 统计文件大小(文件/目录类 都需要实现这个统一接口,才能实现目录和文件的递归计算)
     * @return: long
     * @auther: Holland
     * @date: 2021/8/22 11:32
     */
    public abstract long countSizeOfFiles();

    public String getPath() {
        return path;
    }
}
