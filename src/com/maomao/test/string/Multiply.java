package com.maomao.test.string;

/**
 * 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，
 * 它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 *
 * 示例 2:
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 *
 * 说明：
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 *
 * @author huida
 * @date 2020/6/19
 */
public class Multiply {

    /**
     * 思路：通过两数相乘时，乘数某位num1[i]与被乘数某位num2[j]相乘，同时将乘积叠加到 res 的正确位置
     * 观察之后就发现，num1[i] 和 num2[j] 的乘积对应的就是 res[i+j] 和 res[i+j+1] 这两个位置
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i=num1.length()-1; i>=0; i--) {
            int a = num1.charAt(i) - '0';
            for (int j=num2.length()-1; j>=0; j--) {
                int b = num2.charAt(j) - '0';
                //低位求和
                int sum = (res[i + j + 1] + a * b);
                res[i + j + 1] = sum % 10;
                //进位
                res[i + j] += sum / 10;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i<res.length; i++) {
            if (res[i] ==0 && i==0) {
                //去除高位的0
                continue;
            } else {
                stringBuilder.append(res[i]);
            }
        }
        return stringBuilder.toString();
    }

}
