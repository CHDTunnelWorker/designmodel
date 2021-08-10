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
    public String generate() throws IdGenerationFailureException {
        //此处最好抛出受检异常,明确提示调用者;
        String substrOfHostName = null;
        //getLastfieldOfHostName()抛出的异常,是属于比较底层的异常,暴露了实现细节;调用generate()函数的人员并不知道如何实现,因此我们需要将异常进行包装成IdGenerationFailureException
        try {
            substrOfHostName = getLastfieldOfHostName();
        } catch (UnknownHostException e) {
            throw new IdGenerationFailureException("hostName is empty");
        }

        long currentTimeMillis = System.currentTimeMillis();
        String randomString = generateRandomAlphameric(8);
        String id = String.format("%s-%d-%s", substrOfHostName, currentTimeMillis, randomString);
        return id;
    }

    /**
     * @Description: 获取本机名最后一个元素, 设置为protected, 方便单元测试调用
     * 因为getLastfieldOfHostName函数与调用方generate()有业务相关性,因此直接抛出异常,让上层处理
     * @return: String
     * @auther: Holland
     * @date: 2021/8/9 21:05
     */
    protected String getLastfieldOfHostName() throws UnknownHostException {
        String substrOfHostName = null;
        String hostName = InetAddress.getLocalHost().getHostName();
        //需要保证hostName参数不为空,因此需要校验
        if (hostName == null || hostName.isEmpty()) {
            throw new UnknownHostException("hostName is empty");
        }
        substrOfHostName = getLastSubstrSplittedByDot(hostName);
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
        //需要校验参数
        if (hostName == null || hostName.isEmpty()) {
            throw new IllegalArgumentException("hostName is empty");
        }

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
        //length<=0 明显是不符合逻辑的参数异常情况,因此需要抛出参数异常
        if (length <= 0) {
            throw new IllegalArgumentException("length <= 0 !");
        }

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
