package com.laohu.model.structure.combination;

/**
 * @program: designmodel
 * @description: 文件类, 需要继承文件系统抽象类, 实现统一逻辑
 * @author: Holland
 * @create: 2021-08-22 11:35
 **/
public class File extends FileSystemNode {

    public File(String path) {
        super(path);
    }

    @Override
    public int countNumOfFiles() {
        return 1;
    }

    @Override
    public long countSizeOfFiles() {
        java.io.File file = new java.io.File(path);
        if (!file.exists()) {
            return 0;
        }
        return file.length();
    }
}
