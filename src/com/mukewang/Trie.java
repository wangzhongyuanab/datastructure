package com.mukewang;

import java.util.TreeMap;
/**
 *字典树(前缀树)，同时为了解决空间的浪费出现了压缩字典树。同时还有Ternary Search Trie,后缀树，
 * 对字符串的问题：字串问题 KMP Boyer-Moore   Rabin-Karp.
 *                 文件压缩,模式匹配。
 */
public class Trie {
    private class Node{
        public boolean isWord;
        public TreeMap<Character,Node> next;

        public Node(boolean isWord){
            this.isWord=isWord;
            next=new TreeMap<>();
        }

        public Node(){
            this(false);
        }
    }
    private Node root;
    private int size;
    public Trie(){
        root=new Node();
        size=0;
    }

    public int getSize(){
        return size;
    }

    /**
     * 向字典树中添加元素,通过拆分word
     * @param word
     */
    public void add(String word){
        Node cur=root;
        for (int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(cur.next.get(c)==null){
                cur.next.put(c,new Node());
            }
            cur=cur.next.get(c);
        }
        if (!cur.isWord){
            cur.isWord=true;
            size++;
        }
    }

    /**
     * 查询单词word是否在Trie中
     * @param word
     * @return
     */
    public boolean contains(String word){
        Node cur=root;
        for(int i= 0;i<word.length();i++){
            char c=word.charAt(i);
            if (cur.next.get(c)==null){
                return false;
            }
            cur=cur.next.get(c);
        }
        return cur.isWord;
    }

    /**
     * 查询在trie中是否有以prefix为前缀的单词
     * @param prefix
     * @return
     */
    public boolean isPrefix(String prefix){
        Node cur=root;
        for(int i= 0;i<prefix.length();i++){
            char c=prefix.charAt(i);
            if (cur.next.get(c)==null){
                return false;
            }
            cur=cur.next.get(c);
        }
        return true;
    }
}
