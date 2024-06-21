import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Haffman_Encoder {
    // We will be using the heap we built (Priority queue) & inbuilt HashMap of java.
    HashMap<Character,String> encoder;
    HashMap<String,Character> decoder;
    public Haffman_Encoder(String feeder){
        /* 1.Create a Frequency map of this Feeder String. */
        HashMap<Character,Integer> fmap = new HashMap<>();
        for(int i = 0; i<feeder.length();i++){
           char cc = feeder.charAt(i);
            if(fmap.containsKey(cc)){
                int ov = fmap.get(cc);
                ov = ov+1;
                fmap.put(cc, ov);
            } else {
                fmap.put(cc,1);
            }
        }

        //2.Create the MinHeap of trees;
        Heap_Generic<Node> minHeap = new Heap_Generic<>();
        Set<Map.Entry<Character,Integer>> entrset = fmap.entrySet();
        for(Map.Entry<Character,Integer> entry : entrset){
            Node node = new Node(entry.getKey(), entry.getValue());
            minHeap.add(node);
        }

        // 3. Combine Nodes Until One Node is left in Heap
        while (minHeap.size() !=1) {
            Node minone = minHeap.remove();
            Node mintwo = minHeap.remove();
            Node combined = new Node(minone,mintwo);

            combined.data = '\0';
            combined.cost = minone.cost+mintwo.cost;

            minHeap.add(combined);
        }

        // 4. Step
        Node ft = minHeap.remove(); // ft == full_tree
        this.encoder = new HashMap<>();
        this.decoder = new HashMap<>();

        this.initEncoderDecoder(ft,"");

    }

    // Filling my encoder & Decoder
    private void initEncoderDecoder(Node node, String osf){
        if(node==null){
            return;
        }
        if(node.left == null && node.right==null){
            this.encoder.put(node.data,osf);
            this.decoder.put(osf,node.data);
        }
        this.initEncoderDecoder(node.left,osf+"0");
        this.initEncoderDecoder(node.right, osf+"1");
    }


    // To use Encoder HashMap to encode the source String.
    public String encode(String source){
        String rv = "";
        for(int  i = 0; i< source.length(); i++){
            String code = this.encoder.get(source.charAt(i));
            rv = rv + code;
        }
        return rv;
    }

    //To use Decoder HashMap to decode the Coded String.
    public String decode(String codedString){
        String rv = "";
        String key ="";
        for(int  i = 0; i< codedString.length(); i++){
            key = key + codedString.charAt(i);
            if(this.decoder.containsKey(key)){
               rv = rv + this.decoder.get(key);
               key = "";
            }
        }
        return rv;
    }

    // Making the node for saving the data of the frequency map
    private class Node implements Comparable<Node>{
        Character data;
        int cost;
        Node left;
        Node right;

        Node(char data, int cost){
            this.data = data;
            this.cost = cost;
            this.left = null;
            this.right = null;
        }
        Node(Node left,Node right){
            this.left = left;
            this.right = right;
        }
        @Override
        public int compareTo(Node o) {
            return this.cost-o.cost;
        }
    }

}
