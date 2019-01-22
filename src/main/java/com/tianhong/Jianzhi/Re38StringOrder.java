package com.tianhong.Jianzhi;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author TianhongWang
 * @since 2018/12/18
 */

// 输入一个字符串，按字典序打印出该字符串中字符的所有排列。
// 例如输入字符串 abc，则打印出由字符 a, b, c 所能排列出来的所有字符串 abc, acb, bac, bca, cab 和 cba。
public class Re38StringOrder {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<String>();
        char[] ch = str.toCharArray();
        Permu(ch, 0, list);
        Collections.sort(list);
        return  list;
    }

    public void Permu(char[] str, int i, ArrayList<String> list) {
        if (str == null) {
            return;
        }
        if (i == str.length - 1) {
            if(list.contains(String.valueOf(str))){
                return;
            }
            list.add(String.valueOf(str));
        } else {
            for (int j = i; j < str.length; j++) {
                char temp = str[j];
                str[j] = str[i];
                str[i] = temp;

                Permu(str, i + 1, list);

                temp = str[j];
                str[j] = str[i];
                str[i] = temp;
            }
        }

    }

    public static void main(String[] args) {
        Re38StringOrder test = new Re38StringOrder();
        ArrayList<String> ret = test.Permutation("dfa");
        for(String a : ret){
            System.out.println(a);
        }
    }
}
