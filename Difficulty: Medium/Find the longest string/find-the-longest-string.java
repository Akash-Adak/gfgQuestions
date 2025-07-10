import java.util.*;

class Solution {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEnd = false;
        String word = "";
    }

    private TrieNode root = new TrieNode();
    private String result = "";

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
        }
        node.isEnd = true;
        node.word = word;
    }

    public String longestString(String[] arr) {
        for (String word : arr) {
            insert(word);
        }

        dfs(root);
        return result;
    }

    private void dfs(TrieNode node) {
        for (char ch : node.children.keySet()) {
            TrieNode child = node.children.get(ch);
            if (child.isEnd) {
                if (child.word.length() > result.length() ||
                    (child.word.length() == result.length() && child.word.compareTo(result) < 0)) {
                    result = child.word;
                }
                dfs(child);
            }
        }
    }
}
