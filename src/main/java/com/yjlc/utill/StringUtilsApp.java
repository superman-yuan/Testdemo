package com.yjlc.utill;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * @program function-app
 * @description: StringUtilsApp
 * @autor: Mr.Zhang
 * @create: 2018-03-31 14:59
 */
public class StringUtilsApp {
    /**
     * 检查这个字符串是不是空字符串。
     * 如果这个字符串为null或者trim后为空字符串则返回true，否则返回false。
     *
     * @param chkStr 被检查的字符串
     * @return boolean
     */
    @Contract("null -> true")
    public static boolean isEmpty(String chkStr) {
        return chkStr == null || chkStr.trim().equals(EMPTY) || chkStr.trim().equalsIgnoreCase("null");
    }

    /**
     * 检查这个字符串是不是空字符串。
     * 如果不是空字符串那么返回true，否则返回false。
     *
     * @param chkStr 被检查的字符串
     * @return boolean
     */
    @Contract("null -> false")
    public static boolean notIsEmpty(String chkStr) {
        return !isEmpty(chkStr);
    }

    /**
     * 进行tostring操作，如果传入的是null，返回空字符串。
     * StringUtils.toString(null)         = ""
     * StringUtils.toString(Boolean.TRUE) = "true"
     *
     * @param obj 源
     * @return String
     */
    public static String toString(Object obj) {
        return obj == null ? EMPTY : obj.toString();
    }

    /**
     * 进行tostring操作，如果传入的是null，返回指定的默认值。
     * StringUtils.toString(null, null)           = null
     * StringUtils.toString(null, "null")         = "null"
     * StringUtils.toString(null, "")           = ""
     * StringUtils.toString(Boolean.TRUE, "null") = "true"
     *
     * @param obj     源
     * @param nullStr 如果obj为null时返回这个指定值
     * @return String
     */
    public static String toString(Object obj, String nullStr) {
        return obj == null ? nullStr : obj.toString();
    }

    /**
     * 将半角的符号转换成全角符号.(即英文字符转中文字符)
     *
     * @param str 源字符串
     * @return String
     */
    @NotNull
    public static String changeToFull(String str) {
        String source = "1234567890!@#$%^&*()abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_=+\\|[];:'\",<.>/?";
        String[] decode = {"１", "２", "３", "４", "５", "６", "７", "８", "９", "０",
                "！", "＠", "＃", "＄", "％", "︿", "＆", "＊", "（", "）", "ａ", "ｂ",
                "ｃ", "ｄ", "ｅ", "ｆ", "ｇ", "ｈ", "ｉ", "ｊ", "ｋ", "ｌ", "ｍ", "ｎ",
                "ｏ", "ｐ", "ｑ", "ｒ", "ｓ", "ｔ", "ｕ", "ｖ", "ｗ", "ｘ", "ｙ", "ｚ",
                "Ａ", "Ｂ", "Ｃ", "Ｄ", "Ｅ", "Ｆ", "Ｇ", "Ｈ", "Ｉ", "Ｊ", "Ｋ", "Ｌ",
                "Ｍ", "Ｎ", "Ｏ", "Ｐ", "Ｑ", "Ｒ", "Ｓ", "Ｔ", "Ｕ", "Ｖ", "Ｗ", "Ｘ",
                "Ｙ", "Ｚ", "－", "＿", "＝", "＋", "＼", "｜", "【", "】", "；", "：",
                "'", "\"", "，", "〈", "。", "〉", "／", "？"};
        StringBuffer result = new StringBuffer();
        for (int i = 0, len = str.length(); i < len; i++) {
            int po = source.indexOf(str.charAt(i));
            if (po != INDEX_NOT_FOUND) {
                result.append(decode[po]);
            } else {
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }

    /**
     * 分割字符，从开始到第一个split字符串为止
     *
     * @param src   源字符串
     * @param split 截止字符串
     * @return
     */
    public static String subStr(String src, String split) {
        if (!isEmpty(src)) {
            int index = src.indexOf(split);
            if (index >= 0) {
                return src.substring(0, index);
            }
        }
        return src;
    }

    /**
     * 通过规格切割一个字符返回一个字符数组
     *
     * @param src   要切割的字符
     * @param split 分割的规则
     * @return
     */
    public static String[] subStrArray(String src, String split) {
        String[] str = null;
        if (!isEmpty(src)) {
            str = src.split(split);
        }
        return str;
    }

    /**
     * 去除页面的非法字符检查
     *
     * @param str
     * @return
     */
    @Contract("null -> null")
    public static String replaceStr(String str) {
        if (str != null && str.length() > 0) {
            str = str.replaceAll("~", "");
            str = str.replaceAll(" ", "");
            str = str.replaceAll("　", "");
            str = str.replaceAll(" ", "");
            str = str.replaceAll("`", "");
            str = str.replaceAll("!", "");
            str = str.replaceAll("@", "");
            str = str.replaceAll("#", "");
            str = str.replaceAll("\\$", "");
            str = str.replaceAll("%", "");
            str = str.replaceAll("\\^", "");
            str = str.replaceAll("&", "");
            str = str.replaceAll("\\*", "");
            str = str.replaceAll("\\(", "");
            str = str.replaceAll("\\)", "");
            str = str.replaceAll("-", "");
            str = str.replaceAll("_", "");
            str = str.replaceAll("=", "");
            str = str.replaceAll("\\+", "");
            str = str.replaceAll("\\{", "");
            str = str.replaceAll("\\[", "");
            str = str.replaceAll("\\}", "");
            str = str.replaceAll("\\]", "");
            str = str.replaceAll("\\|", "");
            str = str.replaceAll("\\\\", "");
            str = str.replaceAll(";", "");
            str = str.replaceAll(":", "");
            str = str.replaceAll("'", "");
            str = str.replaceAll("\\\"", "");
            str = str.replaceAll("<", "");
            str = str.replaceAll(">", "");
            str = str.replaceAll("\\.", "");
            str = str.replaceAll("\\?", "");
            str = str.replaceAll("/", "");
            str = str.replaceAll("～", "");
            str = str.replaceAll("`", "");
            str = str.replaceAll("！", "");
            str = str.replaceAll("＠", "");
            str = str.replaceAll("＃", "");
            str = str.replaceAll("＄", "");
            str = str.replaceAll("％", "");
            str = str.replaceAll("︿", "");
            str = str.replaceAll("＆", "");
            str = str.replaceAll("×", "");
            str = str.replaceAll("（", "");
            str = str.replaceAll("）", "");
            str = str.replaceAll("－", "");
            str = str.replaceAll("＿", "");
            str = str.replaceAll("＋", "");
            str = str.replaceAll("＝", "");
            str = str.replaceAll("｛", "");
            str = str.replaceAll("［", "");
            str = str.replaceAll("｝", "");
            str = str.replaceAll("］", "");
            str = str.replaceAll("｜", "");
            str = str.replaceAll("＼", "");
            str = str.replaceAll("：", "");
            str = str.replaceAll("；", "");
            str = str.replaceAll("＂", "");
            str = str.replaceAll("＇", "");
            str = str.replaceAll("＜", "");
            str = str.replaceAll("，", "");
            str = str.replaceAll("＞", "");
            str = str.replaceAll("．", "");
            str = str.replaceAll("？", "");
            str = str.replaceAll("／", "");
            str = str.replaceAll("·", "");
            str = str.replaceAll("￥", "");
            str = str.replaceAll("……", "");
            str = str.replaceAll("（", "");
            str = str.replaceAll("）", "");
            str = str.replaceAll("——", "");
            str = str.replaceAll("-", "");
            str = str.replaceAll("【", "");
            str = str.replaceAll("】", "");
            str = str.replaceAll("、", "");
            str = str.replaceAll("”", "");
            str = str.replaceAll("’", "");
            str = str.replaceAll("《", "");
            str = str.replaceAll("》", "");
            str = str.replaceAll("“", "");
            str = str.replaceAll("。", "");
        }
        return str;
    }

    /**
     * 移除html标签
     *
     * @param htmlstr
     * @return
     */
    public static String removeHtmlTag(String htmlstr) {
        Pattern pat = Pattern.compile("\\s*<.*?>\\s*", Pattern.DOTALL | Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);
        Matcher m = pat.matcher(htmlstr);
        String rs = m.replaceAll("");
        rs = rs.replaceAll("&nbsp", " ");
        rs = rs.replaceAll("&lt;", "<");
        rs = rs.replaceAll("&gt;", ">");
        return rs;
    }

    /**
     * 判断两个字符串是否相等 如果等为null 则判断相等，一个为null另一个not null则判断不相等 否则如果s1=s2则相等
     *
     * @param s1
     * @param s2
     */
    public static boolean equals(String s1, String s2) {
        if (isEmpty(s1) && isEmpty(s2)) {
            return true;
        } else if (!isEmpty(s1) && !isEmpty(s2)) {
            return s1.equals(s2);
        }
        return false;
    }

    /**
     * 判断一个字符串是否为数字
     *
     * @param src
     * @return
     */
    public static boolean isNumeric(String src) {
        boolean return_value = false;
        if (src != null && src.length() > 0) {
            Matcher m = numericPattern.matcher(src);
            if (m.find()) {
                return_value = true;
            }
        }
        return return_value;
    }

    /**
     * 把字符串转换为html代码
     *
     * @param str
     * @return
     */
    @Nullable
    public static String replaceHtml(String str) {
        try {
            str = str.trim();
            str = str.replaceAll("&", "&amp;");
            str = str.replaceAll("<", "&lt;");
            str = str.replaceAll(">", "&gt;");
            str = str.replaceAll(" ", "&nbsp;");
            str = str.replace("'", "&#39;");
            str = str.replaceAll("\"", "&quot;");
            str = str.replace("\r\n", "<br />");
            str = str.replace("\n", "<br />");
            str = str.replace("\r", "<br />");
            return str;
        } catch (NullPointerException e) {
            return null;
        }
    }

    /**
     * 转换NULL为""
     *
     * @param src
     * @return
     */
    @Contract(value = "null -> !null", pure = true)
    public static String changeNull(String src) {
        return src == null || src.equals("null") ? "" : src;
    }

    /**
     * 只从源字符串中移除指定开头子字符串.
     * StringUtils.removeStart(null, *)      = null
     * StringUtils.removeStart("", *)        = ""
     * StringUtils.removeStart(*, null)      = *
     * StringUtils.removeStart("www.baidu.com", "www.")   = "baidu.com"
     * StringUtils.removeStart("www.baidu.com", "domain") = "www.baidu.com"
     * StringUtils.removeStart("abc", "")    = "abc"
     *
     * @param str    源字符串
     * @param remove 将要被移除的子字符串，移除从左向右开始
     * @return String
     */
    public static String removeStart(String str, String remove) {
        if (isEmpty(str) || isEmpty(remove)) {
            return str;
        }
        if (str.startsWith(remove)) {
            return str.substring(remove.length());
        }
        return str;
    }

    /**
     * 只从源字符串中移除指定结尾的子字符串.
     * StringUtils.removeEnd(null, *)      = null
     * StringUtils.removeEnd("", *)        = ""
     * StringUtils.removeEnd(*, null)      = *
     * StringUtils.removeEnd("www.baidu.com", ".com.")  = "www.baidu.com"
     * StringUtils.removeEnd("www.baidu.com", ".com")   = "www.baidu"
     * StringUtils.removeEnd("abc", "")    = "abc"
     *
     * @param str    源字符串
     * @param remove 将要被移除的子字符串,移除从右向左
     * @return String
     */
    public static String removeEnd(String str, String remove) {
        if (isEmpty(str) || isEmpty(remove)) {
            return str;
        }
        if (str.endsWith(remove)) {
            return str.substring(0, str.length() - remove.length());
        }
        return str;
    }

    /**
     * 将一个字符串重复N次
     * StringUtils.repeat(null, 2) = null
     * StringUtils.repeat("", 0)   = ""
     * StringUtils.repeat("", 2)   = ""
     * StringUtils.repeat("a", 3)  = "aaa"
     * StringUtils.repeat("ab", 2) = "abab"
     * StringUtils.repeat("a", -2) = ""
     *
     * @param str    源字符串
     * @param repeat 重复的次数
     * @return String
     */
    @Contract("null, _ -> null")
    public static String repeat(String str, int repeat) {
        if (str == null) {
            return null;
        }
        if (repeat <= 0) {
            return EMPTY;
        }
        int inputLength = str.length();
        if (repeat == 1 || inputLength == 0) {
            return str;
        }
        if (inputLength == 1 && repeat <= PAD_LIMIT) {
            return repeat(str.charAt(0), repeat);
        }

        int outputLength = inputLength * repeat;
        switch (inputLength) {
            case 1:
                return repeat(str.charAt(0), repeat);
            case 2:
                char ch0 = str.charAt(0);
                char ch1 = str.charAt(1);
                char[] output2 = new char[outputLength];
                for (int i = repeat * 2 - 2; i >= 0; i--, i--) {
                    output2[i] = ch0;
                    output2[i + 1] = ch1;
                }
                return new String(output2);
            default:
                StringBuilder buf = new StringBuilder(outputLength);
                for (int i = 0; i < repeat; i++) {
                    buf.append(str);
                }
                return buf.toString();
        }
    }


    /**
     * 将一个字符串重复N次，并且中间加上指定的分隔符
     * StringUtils.repeat(null, null, 2) = null
     * StringUtils.repeat(null, "x", 2)  = null
     * StringUtils.repeat("", null, 0)   = ""
     * StringUtils.repeat("", "", 2)     = ""
     * StringUtils.repeat("", "x", 3)    = "xxx"
     * StringUtils.repeat("?", ", ", 3)  = "?, ?, ?"
     *
     * @param str       源字符串
     * @param separator 分隔符
     * @param repeat    重复次数
     * @return String
     */
    public static String repeat(String str, String separator, int repeat) {
        if (str == null || separator == null) {
            return repeat(str, repeat);
        } else {
            String result = repeat(str + separator, repeat);
            return removeEnd(result, separator);
        }
    }

    /**
     * 将某个字符重复N次.
     *
     * @param ch     某个字符
     * @param repeat 重复次数
     * @return String
     */
    @NotNull
    @Contract(pure = true)
    public static String repeat(char ch, int repeat) {
        char[] buf = new char[repeat];
        for (int i = repeat - 1; i >= 0; i--) {
            buf[i] = ch;
        }
        return new String(buf);
    }

    /**
     * 字符串长度达不到指定长度时，在字符串右边补指定的字符.
     * StringUtils.rightPad(null, *, *)     = null
     * StringUtils.rightPad("", 3, 'z')     = "zzz"
     * StringUtils.rightPad("bat", 3, 'z')  = "bat"
     * StringUtils.rightPad("bat", 5, 'z')  = "batzz"
     * StringUtils.rightPad("bat", 1, 'z')  = "bat"
     * StringUtils.rightPad("bat", -1, 'z') = "bat"
     *
     * @param str     源字符串
     * @param size    指定的总长度
     * @param padChar 进行补充的字符
     * @return String
     */
    @Contract("null, _, _ -> null")
    public static String rightPad(String str, int size, char padChar) {
        if (str == null) {
            return null;
        }
        int pads = size - str.length();
        if (pads <= 0) {
            return str;
        }
        if (pads > PAD_LIMIT) {
            return rightPad(str, size, String.valueOf(padChar));
        }
        return str.concat(repeat(padChar, pads));
    }

    /**
     * 扩大字符串长度，从左边补充指定字符
     * StringUtils.rightPad(null, *, *)      = null
     * StringUtils.rightPad("", 3, "z")      = "zzz"
     * StringUtils.rightPad("bat", 3, "yz")  = "bat"
     * StringUtils.rightPad("bat", 5, "yz")  = "batyz"
     * StringUtils.rightPad("bat", 8, "yz")  = "batyzyzy"
     * StringUtils.rightPad("bat", 1, "yz")  = "bat"
     * StringUtils.rightPad("bat", -1, "yz") = "bat"
     * StringUtils.rightPad("bat", 5, null)  = "bat  "
     * StringUtils.rightPad("bat", 5, "")    = "bat  "
     *
     * @param str    源字符串
     * @param size   指定的总长度
     * @param padStr 在右边补充的字符串
     * @return String
     */
    @Contract("null, _, _ -> null")
    public static String rightPad(String str, int size, String padStr) {
        if (str == null) {
            return null;
        }
        if (isEmpty(padStr)) {
            padStr = " ";
        }
        int padLen = padStr.length();
        int strLen = str.length();
        int pads = size - strLen;
        if (pads <= 0) {
            return str;
        }
        if (padLen == 1 && pads <= PAD_LIMIT) {
            return rightPad(str, size, padStr.charAt(0));
        }

        if (pads == padLen) {
            return str.concat(padStr);
        } else if (pads < padLen) {
            return str.concat(padStr.substring(0, pads));
        } else {
            char[] padding = new char[pads];
            char[] padChars = padStr.toCharArray();
            for (int i = 0; i < pads; i++) {
                padding[i] = padChars[i % padLen];
            }
            return str.concat(new String(padding));
        }
    }

    /**
     * 扩大字符串长度，从左边补充空格
     * StringUtils.leftPad(null, *)   = null
     * StringUtils.leftPad("", 3)     = "   "
     * StringUtils.leftPad("bat", 3)  = "bat"
     * StringUtils.leftPad("bat", 5)  = "  bat"
     * StringUtils.leftPad("bat", 1)  = "bat"
     * StringUtils.leftPad("bat", -1) = "bat"
     *
     * @param str  源字符串
     * @param size 指定的总长度
     * @return String
     */
    @Contract("null, _ -> null")
    public static String leftPad(String str, int size) {
        return leftPad(str, size, ' ');
    }

    /**
     * 扩大字符串长度，从左边补充指定的字符
     * StringUtils.leftPad(null, *, *)     = null
     * StringUtils.leftPad("", 3, 'z')     = "zzz"
     * StringUtils.leftPad("bat", 3, 'z')  = "bat"
     * StringUtils.leftPad("bat", 5, 'z')  = "zzbat"
     * StringUtils.leftPad("bat", 1, 'z')  = "bat"
     * StringUtils.leftPad("bat", -1, 'z') = "bat"
     *
     * @param str     源字符串
     * @param size    扩大后的长度
     * @param padChar 补充的字符
     * @return String
     */
    @Contract("null, _, _ -> null")
    public static String leftPad(String str, int size, char padChar) {
        if (str == null) {
            return null;
        }
        int pads = size - str.length();
        if (pads <= 0) {
            return str;
        }
        if (pads > PAD_LIMIT) {
            return leftPad(str, size, String.valueOf(padChar));
        }
        return repeat(padChar, pads).concat(str);
    }

    /**
     * 扩大字符串长度，从左边补充指定的字符
     * StringUtils.leftPad(null, *, *)      = null
     * StringUtils.leftPad("", 3, "z")      = "zzz"
     * StringUtils.leftPad("bat", 3, "yz")  = "bat"
     * StringUtils.leftPad("bat", 5, "yz")  = "yzbat"
     * StringUtils.leftPad("bat", 8, "yz")  = "yzyzybat"
     * StringUtils.leftPad("bat", 1, "yz")  = "bat"
     * StringUtils.leftPad("bat", -1, "yz") = "bat"
     * StringUtils.leftPad("bat", 5, null)  = "  bat"
     * StringUtils.leftPad("bat", 5, "")    = "  bat"
     *
     * @param str    源字符串
     * @param size   指定的总长度
     * @param padStr 补充的字符串
     * @return String
     */
    @Contract("null, _, _ -> null")
    public static String leftPad(String str, int size, String padStr) {
        if (str == null) {
            return null;
        }
        if (isEmpty(padStr)) {
            padStr = " ";
        }
        int padLen = padStr.length();
        int strLen = str.length();
        int pads = size - strLen;
        if (pads <= 0) {
            return str;
        }
        if (padLen == 1 && pads <= PAD_LIMIT) {
            return leftPad(str, size, padStr.charAt(0));
        }

        if (pads == padLen) {
            return padStr.concat(str);
        } else if (pads < padLen) {
            return padStr.substring(0, pads).concat(str);
        } else {
            char[] padding = new char[pads];
            char[] padChars = padStr.toCharArray();
            for (int i = 0; i < pads; i++) {
                padding[i] = padChars[i % padLen];
            }
            return new String(padding).concat(str);
        }
    }

    /**
     * 扩大字符串长度并将现在的字符串居中，被扩大部分用空格填充。
     * StringUtils.center(null, *)   = null
     * StringUtils.center("", 4)     = "    "
     * StringUtils.center("ab", -1)  = "ab"
     * StringUtils.center("ab", 4)   = " ab "
     * StringUtils.center("abcd", 2) = "abcd"
     * StringUtils.center("a", 4)    = " a  "
     *
     * @param str  源字符串
     * @param size 指定后的总长度
     * @return String
     */
    @Contract("null, _ -> null")
    public static String center(String str, int size) {
        return center(str, size, ' ');
    }

    /**
     * 将字符串长度修改为指定长度，并进行居中显示。
     * StringUtils.center(null, *, *)     = null
     * StringUtils.center("", 4, ' ')     = "    "
     * StringUtils.center("ab", -1, ' ')  = "ab"
     * StringUtils.center("ab", 4, ' ')   = " ab"
     * StringUtils.center("abcd", 2, ' ') = "abcd"
     * StringUtils.center("a", 4, ' ')    = " a  "
     * StringUtils.center("a", 4, 'y')    = "yayy"
     *
     * @param str     源字符串
     * @param size    指定的总长度
     * @param padChar 长度不够时补充的字符串
     * @return String
     * @throws IllegalArgumentException 如果被补充字符串为 null或者 empty
     */
    @Contract("null, _, _ -> null")
    public static String center(String str, int size, char padChar) {
        if (str == null || size <= 0) {
            return str;
        }
        int strLen = str.length();
        int pads = size - strLen;
        if (pads <= 0) {
            return str;
        }
        str = leftPad(str, strLen + pads / 2, padChar);
        str = rightPad(str, size, padChar);
        return str;
    }

    /**
     * 将字符串长度修改为指定长度，并进行居中显示。
     * StringUtils.center(null, *, *)     = null
     * StringUtils.center("", 4, " ")     = "    "
     * StringUtils.center("ab", -1, " ")  = "ab"
     * StringUtils.center("ab", 4, " ")   = " ab"
     * StringUtils.center("abcd", 2, " ") = "abcd"
     * StringUtils.center("a", 4, " ")    = " a  "
     * StringUtils.center("a", 4, "yz")   = "yayz"
     * StringUtils.center("abc", 7, null) = "  abc  "
     * StringUtils.center("abc", 7, "")   = "  abc  "
     *
     * @param str    源字符串
     * @param size   指定的长度
     * @param padStr 长度不够时补充的字符串
     * @return String
     * @throws IllegalArgumentException 如果被补充字符串为 null或者 empty
     */
    @Contract("null, _, _ -> null")
    public static String center(String str, int size, String padStr) {
        if (str == null || size <= 0) {
            return str;
        }
        if (isEmpty(padStr)) {
            padStr = " ";
        }
        int strLen = str.length();
        int pads = size - strLen;
        if (pads <= 0) {
            return str;
        }
        str = leftPad(str, strLen + pads / 2, padStr);
        str = rightPad(str, size, padStr);
        return str;
    }

    /**
     * 检查字符串是否全部为小写.
     * StringUtils.isAllLowerCase(null)   = false
     * StringUtils.isAllLowerCase("")     = false
     * StringUtils.isAllLowerCase("  ")   = false
     * StringUtils.isAllLowerCase("abc")  = true
     * StringUtils.isAllLowerCase("abC") = false
     *
     * @param cs 源字符串
     * @return String
     */
    @Contract("null -> false")
    public static boolean isAllLowerCase(String cs) {
        if (cs == null || isEmpty(cs)) {
            return false;
        }
        int sz = cs.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isLowerCase(cs.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查是否都是大写.
     * StringUtils.isAllUpperCase(null)   = false
     * StringUtils.isAllUpperCase("")     = false
     * StringUtils.isAllUpperCase("  ")   = false
     * StringUtils.isAllUpperCase("ABC")  = true
     * StringUtils.isAllUpperCase("aBC") = false
     *
     * @param cs 源字符串
     * @return String
     */
    public static boolean isAllUpperCase(String cs) {
        if (isEmpty(cs)) {
            return false;
        }
        int sz = cs.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isUpperCase(cs.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * 反转字符串.
     * StringUtils.reverse(null)  = null
     * StringUtils.reverse("")    = ""
     * StringUtils.reverse("bat") = "tab"
     *
     * @param str 源字符串
     * @return String
     */
    @Nullable
    public static String reverse(String str) {
        if (isEmpty(str)) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }

    /**
     * 字符串达不到一定长度时在右边补空白.
     * StringUtils.rightPad(null, *)   = null
     * StringUtils.rightPad("", 3)     = "   "
     * StringUtils.rightPad("bat", 3)  = "bat"
     * StringUtils.rightPad("bat", 5)  = "bat  "
     * StringUtils.rightPad("bat", 1)  = "bat"
     * StringUtils.rightPad("bat", -1) = "bat"
     *
     * @param str  源字符串
     * @param size 指定的长度
     * @return String
     */
    @Contract("null, _ -> null")
    public static String rightPad(String str, int size) {
        return rightPad(str, size, ' ');
    }

    /**
     * 从右边截取字符串.
     * StringUtils.right(null, *)    = null
     * StringUtils.right(*, -ve)     = ""
     * StringUtils.right("", *)      = ""
     * StringUtils.right("abc", 0)   = ""
     * StringUtils.right("abc", 2)   = "bc"
     * StringUtils.right("abc", 4)   = "abc"
     *
     * @param str 源字符串
     * @param len 长度
     * @return String
     */
    @Contract("null, _ -> null")
    public static String right(String str, int len) {
        if (str == null) {
            return null;
        }
        if (len < 0) {
            return EMPTY;
        }
        if (str.length() <= len) {
            return str;
        }
        return str.substring(str.length() - len);
    }

    /**
     * 截取一个字符串的前几个.
     * StringUtils.left(null, *)    = null
     * StringUtils.left(*, -ve)     = ""
     * StringUtils.left("", *)      = ""
     * StringUtils.left("abc", 0)   = ""
     * StringUtils.left("abc", 2)   = "ab"
     * StringUtils.left("abc", 4)   = "abc"
     *
     * @param str 源字符串
     * @param len 截取的长度
     * @return the String
     */
    @Nullable
    public static String left(String str, int len) {
        if (isEmpty(str)) {
            return null;
        }
        if (len < 0) {
            return EMPTY;
        }
        if (str.length() <= len) {
            return str;
        }
        return str.substring(0, len);
    }

    /**
     * 得到tag字符串中间的子字符串，只返回第一个匹配项。
     * StringUtils.substringBetween(null, *)            = null
     * StringUtils.substringBetween("", "")             = ""
     * StringUtils.substringBetween("", "tag")          = null
     * StringUtils.substringBetween("tagabctag", null)  = null
     * StringUtils.substringBetween("tagabctag", "")    = ""
     * StringUtils.substringBetween("tagabctag", "tag") = "abc"
     *
     * @param str 源字符串。
     * @param tag 标识字符串。
     * @return String 子字符串, 如果没有符合要求的，返回{@code null}。
     */
    @Contract("null, _ -> null; !null, null -> null")
    public static String substringBetween(String str, String tag) {
        return substringBetween(str, tag, tag);
    }

    /**
     * 得到两个字符串中间的子字符串，只返回第一个匹配项。
     * StringUtils.substringBetween("wx[b]yz", "[", "]") = "b"
     * StringUtils.substringBetween(null, *, *)          = null
     * StringUtils.substringBetween(*, null, *)          = null
     * StringUtils.substringBetween(*, *, null)          = null
     * StringUtils.substringBetween("", "", "")          = ""
     * StringUtils.substringBetween("", "", "]")         = null
     * StringUtils.substringBetween("", "[", "]")        = null
     * StringUtils.substringBetween("yabcz", "", "")     = ""
     * StringUtils.substringBetween("yabcz", "y", "z")   = "abc"
     * StringUtils.substringBetween("yabczyabcz", "y", "z")   = "abc"
     *
     * @param str   源字符串
     * @param open  起字符串。
     * @param close 末字符串。
     * @return String 子字符串, 如果没有符合要求的，返回{@code null}。
     */
    @Contract("null, _, _ -> null; !null, null, _ -> null; !null, !null, null -> null")
    public static String substringBetween(String str, String open, String close) {
        if (str == null || open == null || close == null) {
            return null;
        }
        int start = str.indexOf(open);
        if (start != INDEX_NOT_FOUND) {
            int end = str.indexOf(close, start + open.length());
            if (end != INDEX_NOT_FOUND) {
                return str.substring(start + open.length(), end);
            }
        }
        return null;
    }

    /**
     * 得到两个字符串中间的子字符串，所有匹配项组合为数组并返回。
     * StringUtils.substringsBetween("[a][b][c]", "[", "]") = ["a","b","c"]
     * StringUtils.substringsBetween(null, *, *)            = null
     * StringUtils.substringsBetween(*, null, *)            = null
     * StringUtils.substringsBetween(*, *, null)            = null
     * StringUtils.substringsBetween("", "[", "]")          = []
     *
     * @param str   源字符串
     * @param open  起字符串。
     * @param close 末字符串。
     * @return String 子字符串数组, 如果没有符合要求的，返回{@code null}。
     */
    @Contract("null, _, _ -> null")
    public static String[] substringsBetween(String str, String open,String close){
        if (str == null || isEmpty(open) || isEmpty(close)) {
            return null;
        }
        int strLen = str.length();
        if (strLen == 0) {
            return new String[0];
        }
        int closeLen = close.length();
        int openLen = open.length();
        List<String> list = new ArrayList<String>();
        int pos = 0;
        while (pos < strLen - closeLen) {
            int start = str.indexOf(open, pos);
            if (start < 0) {
                break;
            }
            start += openLen;
            int end = str.indexOf(close, start);
            if (end < 0) {
                break;
            }
            list.add(str.substring(start, end));
            pos = end + closeLen;
        }
        if (list.isEmpty()) {
            return null;
        }
        return list.toArray(new String[list.size()]);
    }

    /**
     * 切换字符串中的所有字母为大小写(就是大小写互换)
     * StringUtils.swapCase(null)                 = null
     * StringUtils.swapCase("")                   = ""
     * StringUtils.swapCase("The dog has a BONE") = "tHE DOG HAS A bone"
     *
     * @param str 源字符串
     * @return String
     */
    public static String swapCase(String str) {
        if (isEmpty(str)) {
            return str;
        }
        char[] buffer = str.toCharArray();

        boolean whitespace = true;

        for (int i = 0; i < buffer.length; i++) {
            char ch = buffer[i];
            if (Character.isUpperCase(ch)) {
                buffer[i] = Character.toLowerCase(ch);
                whitespace = false;
            } else if (Character.isTitleCase(ch)) {
                buffer[i] = Character.toLowerCase(ch);
                whitespace = false;
            } else if (Character.isLowerCase(ch)) {
                if (whitespace) {
                    buffer[i] = Character.toTitleCase(ch);
                    whitespace = false;
                } else {
                    buffer[i] = Character.toUpperCase(ch);
                }
            } else {
                whitespace = Character.isWhitespace(ch);
            }
        }
        return new String(buffer);
    }

    /**
     * 截取出最后一个标志位之后的字符串
     * 如果sourceStr为empty或者expr为null，直接返回源字符串。
     * 如果expr长度为0，直接返回sourceStr。
     * 如果expr在sourceStr中不存在，直接返回sourceStr。
     *
     * @param sourceStr 被截取的字符串
     * @param expr      分隔符
     * @return String
     */
    public static String substringAfterLast(String sourceStr, String expr) {
        if (isEmpty(sourceStr) || expr == null) {
            return sourceStr;
        }
        if (expr.length() == 0) {
            return sourceStr;
        }
        int pos = sourceStr.lastIndexOf(expr);
        if (pos == INDEX_NOT_FOUND) {
            return sourceStr;
        }
        return sourceStr.substring(pos + expr.length());
    }

    /**
     * 截取出最后一个标志位之前的字符串
     * 如果sourceStr为empty或者expr为null，直接返回源字符串。
     * 如果expr长度为0，直接返回sourceStr。
     * 如果expr在sourceStr中不存在，直接返回sourceStr。
     *
     * @param sourceStr 被截取的字符串
     * @param expr      分隔符
     * @return String
     */
    public static String substringBeforeLast(String sourceStr, String expr) {
        if (isEmpty(sourceStr) || expr == null) {
            return sourceStr;
        }
        if (expr.length() == 0) {
            return sourceStr;
        }
        int pos = sourceStr.lastIndexOf(expr);
        if (pos == INDEX_NOT_FOUND) {
            return sourceStr;
        }
        return sourceStr.substring(0, pos);
    }

    /**
     * 截取出第一个标志位之后的字符串
     * 如果sourceStr为empty或者expr为null，直接返回源字符串
     * 如果expr长度为0，直接返回sourceStr。
     * 如果expr在sourceStr中不存在，直接返回sourceStr。
     *
     * @param sourceStr 被截取的字符串
     * @param expr      分隔符
     * @return String
     */
    public static String substringAfter(String sourceStr, String expr) {
        if (isEmpty(sourceStr) || expr == null) {
            return sourceStr;
        }
        if (expr.length() == 0) {
            return sourceStr;
        }
        int pos = sourceStr.indexOf(expr);
        if (pos == INDEX_NOT_FOUND) {
            return sourceStr;
        }
        return sourceStr.substring(pos + expr.length());
    }

    /**
     * 截取出第一个标志位之前的字符串
     * 如果sourceStr为empty或者expr为null，直接返回源字符串。
     * 如果expr长度为0，直接返回sourceStr。
     * 如果expr在sourceStr中不存在，直接返回sourceStr。
     * 如果expr在sourceStr中存在不止一个，以第一个位置为准。
     *
     * @param sourceStr 被截取的字符串
     * @param expr      分隔符
     * @return String
     */
    public static String substringBefore(String sourceStr, String expr) {
        if (isEmpty(sourceStr) || expr == null) {
            return sourceStr;
        }
        if (expr.length() == 0) {
            return sourceStr;
        }
        int pos = sourceStr.indexOf(expr);
        if (pos == -1) {
            return sourceStr;
        }
        return sourceStr.substring(0, pos);
    }

    /**
     * 如果字符串没有超过最长显示长度返回原字符串，否则从开头截取指定长度并加...返回。
     *
     * @param str    原字符串
     * @param length 字符串最长显示的长度
     * @return 转换后的字符串
     */
    @Contract("null, _ -> !null")
    public static String trimString(String str, int length) {
        if (str == null) {
            return "";
        } else if (str.length() > length) {
            return str.substring(0, length - 3) + "...";
        } else {
            return str;
        }
    }

    /**
     * 编码为Unicode，格式 '\u0020'.
     * CharUtils.unicodeEscaped(' ') = "\u0020"
     * CharUtils.unicodeEscaped('A') = "\u0041"
     *
     * @param ch 源字符串
     * @return 转码后的字符串
     */
    @NotNull
    public static String unicodeEscaped(char ch) {
        if (ch < 0x10) {
            return "\\u000" + Integer.toHexString(ch);
        } else if (ch < 0x100) {
            return "\\u00" + Integer.toHexString(ch);
        } else if (ch < 0x1000) {
            return "\\u0" + Integer.toHexString(ch);
        }
        return "\\u" + Integer.toHexString(ch);
    }


    /**
     * 下标为 -1
     */
    private static final int INDEX_NOT_FOUND = -1;
    /**
     * 空字符串
     */
    private static final String EMPTY = "";
    /**
     * 填充常量 可以扩展的最大大小
     */
    private static final int PAD_LIMIT = 8192;

    /**
     * 判断是否为数字
     */
    private static Pattern numericPattern = Pattern.compile("^[0-9\\-]+$");
}
