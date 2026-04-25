class WordDictionary {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Add word
    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    // Search word
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int i, TrieNode node) {
        if (i == word.length()) {
            return node.isEnd;
        }

        char ch = word.charAt(i);

        // Case 1: normal character
        if (ch != '.') {
            int index = ch - 'a';
            if (node.children[index] == null) return false;
            return dfs(word, i + 1, node.children[index]);
        }

        // Case 2: wildcard '.'
        for (TrieNode child : node.children) {
            if (child != null && dfs(word, i + 1, child)) {
                return true;
            }
        }

        return false;
    }
}