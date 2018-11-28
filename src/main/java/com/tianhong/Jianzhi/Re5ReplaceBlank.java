package com.tianhong.Jianzhi;

/**
 * @Author: TianhongWang
 * @Date: 2018/11/28
 * @Description
 */

// 将一个字符串中的空格替换成 "%20"。
//
//Input:
//"We Are Happy"
//
//Output:
//"We%20Are%20Happy"
// 1. 遍历一遍字符数组， 遇到空格就扩容2（%20比空格大2）
// p2指向现在数组末尾， p1指向原数组末尾， p2， p1同时向前遍历， p1遇到空格， p2就添加02%， 不然就添加p1的内容
public class Re5ReplaceBlank {
    public static String replaceSpace(StringBuffer str) {
        int length1 = str.length();
        for(int i = 0; i < length1; i++){
            if(str.charAt(i) == ' '){
                str.append("  ");
            }
        }
        int length2 = str.length();
        while(length1 >= 1){
            if(str.charAt(length1 - 1) == ' '){
                str.setCharAt(length2-1, '0');
                str.setCharAt(length2-2, '2');
                str.setCharAt(length2-3, '%');
                length2 = length2 - 3;
            } else {
                str.setCharAt(length2-1, str.charAt(length1-1));
                length1--;
                length2--;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer("this is a test string! ");
        String ret = replaceSpace(buffer);
        System.out.println(ret);
    }
}
