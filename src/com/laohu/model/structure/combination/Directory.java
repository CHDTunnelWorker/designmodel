package com.laohu.model.structure.combination;

import java.beans.FeatureDescriptor;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: designmodel
 * @description: 目录类, 需要继承文件系统抽象类, 实现统一逻辑
 * @author: Holland
 * @create: 2021-08-22 11:35
 **/
public class Directory extends FileSystemNode {
    /**
     * 目录下需要承载FileSystemNode对象(可能是一批目录,可能是一批文件)
     */
    private List<FileSystemNode> subNodes = new ArrayList<>();

    public Directory(String path) {
        super(path);
    }

    @Override
    public int countNumOfFiles() {
        int numOfFiles = 0;
        for (FileSystemNode fileOrDir : subNodes) {
            numOfFiles += fileOrDir.countNumOfFiles();
        }
        return numOfFiles;
    }

    @Override
    public long countSizeOfFiles() {
        long sizeofFiles = 0;
        for (FileSystemNode fileOrDir : subNodes) {
            sizeofFiles += fileOrDir.countSizeOfFiles();
        }
        return sizeofFiles;
    }

    public void addSubNode(FileSystemNode fileOrDir) {
        subNodes.add(fileOrDir);
    }

    public void removeSubNode(FileSystemNode fileOrDir) {
        int size = subNodes.size();
        int i = 0;
        for (; i < size; ++i) {
            if (subNodes.get(i).getPath().equalsIgnoreCase(fileOrDir.getPath())) {
                break;
            }
        }
        if (i < size) {
            subNodes.remove(i);
        }
    }
}
