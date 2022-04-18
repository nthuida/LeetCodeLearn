package com.maomao.test.tree;

/**
 * 前缀树
 * @author: huida
 * @date: 2022/4/18
 **/
public class Trie {

    private Trie[] children;
    //该节点是否是字符串的结束节点
    private boolean isWordEnd;

    public Trie() {
        children = new Trie[26];
        isWordEnd = false;
    }

    /**
     * 首先从根结点的子结点开始与 word 第一个字符进行匹配，一直匹配到前缀链上没有对应的字符，
     * 这时开始不断开辟新的结点，直到插入完 word 的最后一个字符，同时还要将最后一个结点isEnd = true;，表示它是一个单词的末尾
     *
     * @param word
     */
    public void insert(String word) {
        //根节点
        Trie node = this;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                //创建新的子节点
                node.children[c - 'a'] = new Trie();
            }
            //下一个节点
            node = node.children[c - 'a'];
        }
        //结束
        node.isWordEnd = true;
    }

    /**
     * 从根结点的子结点开始，一直向下匹配即可，如果出现结点值为空就返回 false，
     * 如果匹配到了最后一个字符，那我们只需判断 node->isEnd即可
     * @param word
     * @return
     */
    public boolean search(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            node = node.children[c - 'a'];
            if (node == null) {
                return false;
            }
        }
        return node.isWordEnd;
    }

    /**
     * 和 search 操作类似，只是不需要判断最后一个字符结点的isEnd，
     * 因为既然能匹配到最后一个字符，那后面一定有单词是以它为前缀的。
     * @param prefix
     * @return
     */
    public boolean startsWith(String prefix) {
        Trie node = this;
        for (char c : prefix.toCharArray()) {
            node = node.children[c - 'a'];
            if (node == null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));

    }
}
