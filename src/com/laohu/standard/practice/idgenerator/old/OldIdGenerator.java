package com.laohu.standard.practice.idgenerator.old;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * @program: designmodel
 * @description: id生成器 (能用版本)
 * 重构建议:
 * 一.提高代码的可读性
 * 1.hostName变量不应被重复使用,因为两次使用时的含义不一样;
 * 2.将获取hostName变量的代码抽离,组成getLastfieldOfHostName() 函数;
 * 3.删除代码中的魔法数;
 * 4.将随机数代码生成抽离,定义为 generateRandomAlphameric() 函数;
 * 5.三个if()判断逻辑重复,且复杂,对其进行简化;
 * 6.提高扩展性,将类重名名,并抽象出接口;
 *
 * 二.提高代码的可测试性
 * 1.generate() 函数定义为静态函数，会影响使用该函数的代码的可测试性;
 * 2.generate() 函数的代码实现依赖运行环境（本机名）、时间函数、随机函数，所以 generate() 函数
 * 本身的可测试性也不好;
 *
 * 三.完善单元测试
 * 四.所有重构完成后,添加注释
 * @author: Holland
 * @create: 2021-08-06 16:47
 **/
public class OldIdGenerator {

    private static final Logger logger = LoggerFactory.getLogger(OldIdGenerator.class);

    /**
     * @Description: ID生成器
     * @return: String ID 格式组成 本机名最后一个字段-时间戳(毫秒级)-随机8位大小写数字
     * @auther: Holland
     * @date: 2021/8/6 5:21 下午
     */
    public static String generate() {

        String id = "";

        try {
            //获取本机名最后一个字段
            String hostName = InetAddress.getLocalHost().getHostName();
            String[] tokens = hostName.split("\\.");
            if (tokens.length > 0) {
                hostName = tokens[tokens.length - 1];
            }

            //获取随机8位大小写数字
            char[] randomChars = new char[8];
            int count = 0;
            Random random = new Random();

            while (count < 8) {

                int randomAscii = random.nextInt(122);

                if (randomAscii >= 48 && randomAscii <= 57) {
                    randomChars[count] = (char) ('0' + (randomAscii - 48));
                    count++;
                } else if (randomAscii >= 65 && randomAscii <= 90) {
                    randomChars[count] = (char) ('A' + (randomAscii - 65));
                    count++;
                } else if (randomAscii >= 97 && randomAscii <= 122) {
                    randomChars[count] = (char) ('a' + (randomAscii - 97));
                    count++;
                }
            }

            //组装id
            id = String.format("%s-%d-%s", hostName, System.currentTimeMillis(), new String(randomChars));

        } catch (UnknownHostException e) {
            logger.warn("Failed to get the host name.", e);
        }

        return id;
    }
}
