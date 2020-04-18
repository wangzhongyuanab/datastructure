package com.offer;

public class Solution2 {
    public String replaceSpace(StringBuffer str) {
        return str.toString().replace(" ","%20");
    }

    public String replaceSpace1(StringBuffer str) {
        String s = str.toString();
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)==' '){
                sb.append("%20");
            }else{
                sb.append(s.charAt(i));
            }
        }
        str.delete(0,str.length());
        str.append(sb);
        return str.toString();
    }

    public static  String replaceSpace2(StringBuffer str) {
        int spaceNum=0;
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)==' '){
                spaceNum++;
            }
        }
        int oldLength=str.length();
        str.setLength(oldLength+2*spaceNum);
        for (int i=oldLength-1;i>=0;i--){
            if (str.charAt(i)!=' '){
                str.setCharAt(i+2*spaceNum,str.charAt(i));
            }else{
                spaceNum--;
                int length=i+2*spaceNum;
                str.setCharAt(length,'%');
                str.setCharAt(length + 1, '2');
                str.setCharAt(length + 2, '0');
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("We Are Happy");
        System.out.println(replaceSpace2(stringBuffer));
    }
}
