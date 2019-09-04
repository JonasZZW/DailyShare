package src.main.java.algo;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**l
 * 字符串全组合(满足一定条件)
 * ["Ckl","xvc", "", "C", "ClC"] ->
 * ["CklxvcC", "CklCClC", "CCklClc" ....]
 */
public class StrCombinate {

    @Test
    public void test() {
        String[] a = new String[]{"Ckl","xvc", "", "C", "ClC"};
        List<String> newList = getNewArrayStr(a);
        for (int i = 0; i < newList.size(); i++) {
            System.out.println(newList.get(i));
        }
    }

    public List<String> getNewArrayStr(String[] strArray) {
        List<String> newList = new ArrayList<>();

        for (int i = 0; i < strArray.length; i++) {
            String str = strArray[i];
            if (StringUtils.isNotBlank(str)) {
                legalStr(i, str, newList, strArray);
            }
        }

        return newList;
    }

    public void legalStr(int sameIndex, String str, List<String> newList, String[] strArray) {
        if (str.length() == 7 && isStartC(str) && isEndC(str)) {
            newList.add(str);
            return;
        }

        if (str.length() > 7) {
            return;
        }

        if (str.length() < 7 && isStartC(str)) {
            for (int i = 0; i < strArray.length; i++) {
                String str1 = strArray[i];
                if (i == sameIndex || StringUtils.isBlank(str1)) { continue; }
                String newStr = str + str1;
                if (newStr.length() == 7 && isStartC(newStr) && isEndC(newStr)) {
                    newList.add(newStr);
                } else if (newStr.length() < 7 && isStartC(newStr)) {
                    legalStr(i, newStr, newList, strArray);
                }
            }
        }
    }

    public boolean isStartC(String str) {
        if (StringUtils.isNotBlank(str)) {
            return "C".equals(str.charAt(0) + "");
        }
        else {
            return false;
        }
    }

    public boolean isEndC(String str) {
        if (StringUtils.isNotBlank(str)) {
            return "C".equals(str.charAt(str.length() - 1) + "");
        }
        else {
            return false;
        }
    }
}