import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Trie {
    private class Node{
        char data;
        HashMap<Character,Node> children;
        Boolean isTerminal;
        Node(char data, boolean isTerminal){
            this.data  = data;
            this.children = new HashMap<>();
            this.isTerminal = isTerminal;
        }
    }

    private int numWords;
    private  Node root;

    Trie(){
        this.root =new Node('\0',false);
        this.numWords = 0;
    }


    public int numWords(){
        return this.numWords;
    }


//Adding Word in Tris
    public void addWord(String word){
        this.addWord(this.root, word);
    }

    private  void addWord(Node parent, String word){
        if (word.isEmpty()){
            if(parent.isTerminal){
                // Word Already exists
            }else{
                parent.isTerminal = true;
                this.numWords++;
            }
            return;
        }
        char cc = word.charAt(0);
        String ros =word.substring(1);
        Node child = parent.children.get(cc);
        if(child == null){
            child = new Node (cc, false);
            parent.children.put(cc,child);
        }
        addWord(child,ros);
    }

// Displaying
    public void display(){
        display(this.root," ");
    }

    private void  display(Node node, String osf){
        if(node.isTerminal){
            String toDisplay = osf.substring(2) + node.data;
            System.out.println(toDisplay);
        }
        Set<Map.Entry<Character, Node>> entries = node.children.entrySet();
        for(Map.Entry<Character,Node> entry : entries){
            this.display(entry.getValue(),osf+node.data);
        }
    }

// Search For a Number
    public boolean searchWord(String word){
        return searchWord(this.root,word);}

    private boolean searchWord(Node parent,String word){
        if(word.isEmpty()){
            return parent.isTerminal;
        }
        char cc = word.charAt(0);
        String ros =word.substring(1);
        Node child = parent.children.get(cc);
        if(child == null){
            return false;
        } else {
            return this.searchWord(child,ros);
        }
    }

// Delete A word From the Trie

    public void remove(String word){
        this.remove(this.root,word);
    }

    private void remove(Node parent, String word){
        if(word.isEmpty()){
            if(parent.isTerminal) {
                parent.isTerminal = false;
                this.numWords--;
            } // Else - Word is part of some other word;
            return;
        }
        char cc = word.charAt(0);
        String ros =word.substring(1);
        Node child = parent.children.get(cc);
        if(child == null){
            return;
        }
        this.remove(child,ros);

        // Work to remove the character of word form memory if it's not a part of other word.
        if(!child.isTerminal && child.children.isEmpty()){
            parent.children.remove(cc);
        }
    }
}
