package com.laohu.standard.practice.idgenerator.newOpti;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * @program: designmodel
 * @description: 生成随机id
 * @author: Holland
 * @create: 2021-08-09 21:02
 **/
public class RandomIdGenerator implements ILogTraceIdGenerator {

    private static final Logger logger = LoggerFactory.getLogger(RandomIdGenerator.class);

    @Override
    public String generate() {
        String substrOfHostName = getLastfieldOfHostName();
        long currentTimeMillis = System.currentTimeMillis();
        String randomString = generateRandomAlphameric(8);
        String id = String.format("%s-%d-%s", substrOfHostName, currentTimeMillis, randomString);
        return id;
    }

    /**
     * @Description: 获取本机名最后一个元素, 设置为protected, 方便单元测试调用
     * @return: String
     * @auther: Holland
     * @date: 2021/8/9 21:05
     */
    protected String getLastfieldOfHostName() {
        String substrOfHostName = null;
        try {
            String hostName = InetAddress.getLocalHost().getHostName();
            substrOfHostName = getLastSubstrSplittedByDot(hostName);
            return substrOfHostName;
        } catch (UnknownHostException e) {
            logger.warn("Failed to get the host name.", e);
        }
        return substrOfHostName;
    }

    /**
     * @Description: 截取最后一个本机名(该函数的剥离, 是为了方便单元测试)
     * @param: String hostName 本机名
     * @return: String 截取最后一个本机名
     * @auther: Holland
     * @date: 2021/8/9 21:18
     */
    protected String getLastSubstrSplittedByDot(String hostName) {
        String[] tokens = hostName.split("\\.");
        String substrOfHostName = tokens[tokens.length - 1];
        return substrOfHostName;
    }

    /**
     * @Description: 获取指定位数的随机数(大小写字母和数字), 设置为protected, 方便单元测试调用
     * @param: int length 随机数位数
     * @return: String 随机
     * @auther: Holland
     * @date: 2021/8/9 21:05
     */
    protected String generateRandomAlphameric(int length) {
        char[] randomChars = new char[length];
        int count = 0;
        Random random = new Random();
        while (count < length) {
            int maxAscii = 'z';
            int randomAscii = random.nextInt(maxAscii);
            boolean isDigit = randomAscii >= '0' && randomAscii <= '9';
            boolean isUppercase = randomAscii >= 'A' && randomAscii <= 'Z';
            boolean isLowercase = randomAscii >= 'a' && randomAscii <= 'z';
            if (isDigit || isUppercase || isLowercase) {
                randomChars[count] = (char) (randomAscii);
                ++count;
            }
        }
        return new String(randomChars);
    }
}
