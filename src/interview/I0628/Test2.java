package interview.I0628;

import java.util.HashSet;
import java.util.Set;


/**
 *
 * @author wy
 */
public class Test2 {

    /**
     * 采用set 当做缓存。由于本题原因，不考虑持久化
     */
    private static Set<String> phoneCache = new HashSet<>(16);

    public static void main(String[] args) {

        String[] phoneNum = {"138 1234 1234", "13812345abc", "13812345678", "138 1234 5678", "98765432101"};

        start(phoneNum);
    }

    /**
     * 校验入口
     *
     * @param phoneNum  phone number
     */
    private static void start(String[] phoneNum) {
        for (String phone : phoneNum) {
            if (check(phone)) {
                register(format(phone));
            } else {
                error("手机号：" + phone + " ，非法手机号码！");
            }
        }
    }

    /**
     * 注册
     * @param phone phone number
     */
    public static void register(String phone) {
        try {
            if (phoneCache.contains(phone)) {
                error("手机号：" + phone + " ，该手机号已被注册！");
            } else {
                phoneCache.add(phone);
                info("手机号：" + phone + " ，注册成功！");
            }
        } catch (Exception e) {
            error("程序发生错误...");
        }
    }

    /**
     * 格式化手机号码
     *
     * @param phoneNum phone number
     * @return  格式化后手机号
     */
    private static String format(String phoneNum) {
        return phoneNum.replaceAll("( )\\1*", "");
    }

    /**
     * 校验手机号码是否正确
     *
     * @param phoneNum  phone number
     * @return t/f
     */
    private static boolean check(String phoneNum) {
        return phoneNum.matches("1(3[0-9]|5[189]|8[6789])( )?[0-9]{4}( )?[0-9]{4}");
    }

    /**
     * 错误日志
     *
     * @param o 日志信息
     */
    private static void error(Object o) {
        System.err.println(o);
    }

    /**
     * 正确日志
     *
     * @param o 日志信息
     */
    private static void info(Object o) {
        System.out.println(o);
    }
}
