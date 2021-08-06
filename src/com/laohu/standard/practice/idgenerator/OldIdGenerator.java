package com.laohu.standard.practice.idgenerator;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * @program: designmodel
 * @description: id生成器
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
