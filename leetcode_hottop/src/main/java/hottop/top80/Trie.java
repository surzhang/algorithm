package hottop.top80;

/**
 * @FileName: No208
 * @Description: 前缀树的实现
 * @Author: zyk
 * @createTime: 2021/12/26 16:07
 * @version: 1.0
 */
public class Trie {
    private hot_top.c70.Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new hot_top.c70.Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        hot_top.c70.Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new hot_top.c70.Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        hot_top.c70.Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    //前缀开始
    public boolean startWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    //查找前缀
    public hot_top.c70.Trie searchPrefix(String prefix) {
        hot_top.c70.Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}
