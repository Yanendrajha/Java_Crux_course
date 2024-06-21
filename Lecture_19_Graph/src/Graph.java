import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Graph {

    // It's the Value of the main HashMap & also used to link neighbors.
    private class Vertex{
        HashMap<String ,Integer> nbrs = new HashMap<>();
    }

    // Main HashMap - Stores Vertices string as Key, & Vertex as value
    HashMap<String, Vertex> vertices;

    public Graph(){
        vertices = new HashMap<>();
    }

    public int numVertex(){
        return this.vertices.size();
    }

    public boolean containsVertex(String vname){
        return (this.vertices.containsKey(vname));
    }

    public void addVertex(String vname){
        // It allocates space to the data members of class vertex. (Here it's a HashMap called nbrs);
        Vertex vtx = new Vertex();
        vertices.put(vname,vtx);

    }
    public void removeVertex(String vname){
        Vertex vtx = vertices.get(vname);
        ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());
        for(String key : keys){
            Vertex nbrsVtx =vertices.get(key);
            nbrsVtx.nbrs.remove(vname);
        }
        vertices.remove(vname);
    }

    public int numEdges(){
        /* Get the total sum of hashmap of each of the vertices values (nbrs).Since, each edge get counted twice
        the total sum will be twice the size of actual edges. I.e., sum_nbrs_size = 2*total_edges.
         */

        int count = 0;
        ArrayList<String> keys = new ArrayList<>(vertices.keySet());
        for(String key : keys){
            Vertex vtx = vertices.get(key);
            count += vtx.nbrs.size();
        }
        return count/2;
    }

    public boolean containsEdge(String vname1, String vname2){
        // Got the Value at vertices HashMap
        Vertex vtx1 = vertices.get((vname1));
        Vertex vtx2 = vertices.get(vname2);

        if((vtx1 == null) || (vtx2 == null) || !vtx1.nbrs.containsKey(vname2)){
            return false;
        }
        return true;
    }

    public void addEdge(String vname1, String vname2, int cost){
        // Got the Value at vertices HashMap
        Vertex vtx1 = vertices.get((vname1));
        Vertex vtx2 = vertices.get(vname2);
        if(vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2)){
            return;
        }
        vtx1.nbrs.put(vname2,cost);// 2k nbrs put C with a given Cost
        vtx2.nbrs.put(vname1,cost); // 4k nbrs put A with a given cost

    }

    public void removeEdge(String vname1, String vname2){
        Vertex vtx1 = vertices.get(vname1); //2k
        Vertex vtx2 = vertices.get(vname2); //4k

        if(vtx1 == null || vtx2 ==null|| !vtx1.nbrs.containsKey(vname2)){
            return;
        }
        vtx1.nbrs.remove(vname2); //2k nbrs remove C
        vtx2.nbrs.remove(vname1); //4k nbrs remove A
    }


    public void display(){

        System.out.println("------------------------------");
        ArrayList<String> keys= new ArrayList<>(vertices.keySet());
        for(String key : keys){
            Vertex vtx = vertices.get(key);
            System.out.println(key+" : " + vtx.nbrs);
        }
    }

    public boolean hasPath(String vname1,  String vname2, HashMap<String, Boolean> processed){

        processed.put(vname1,true);
         // Direct Edge
        if(containsEdge(vname1,vname2)){
            return true;
        }
        Vertex vtx = vertices.get(vname1);
        ArrayList<String>  nbrs = new ArrayList<>(vtx.nbrs.keySet());
        for(String nbr : nbrs) {
            if(!processed.containsKey(nbr) && hasPath(nbr, vname2, processed)){
                return true;
            }
        }
        return false;
    }


    private class Pair{
        String vname;
        String psf;

    }

    public boolean bfs(String src, String dst){
        LinkedList<Pair> queue = new LinkedList<>();

        HashMap<String,Boolean> processed = new HashMap<>();
        // Creating New Pair
        Pair sp = new Pair();
        sp.vname = src;
        sp.psf = src;

        // Put the new Pair in the queue
        queue.addLast(sp);

        // While the queue is not Empty, keep on doing the work
        while(!queue.isEmpty()){

            // Remove a pair from queue
            Pair rp = queue.removeFirst();
            if(processed.containsKey(rp.vname)){
                // Skip all the statement below it & move directly to the next iteration of the loop.
                continue;
            }

            // Processed put
            processed.put(rp.vname, true);

            //Direct Name
            if(containsEdge(rp.vname,dst)){
                System.out.println(rp.psf + dst);
                return true;
            }
            // nbrs
            Vertex rpvtrx = vertices.get(rp.vname);
            ArrayList<String> nbrs = new ArrayList<>(rpvtrx.nbrs.keySet());

            for(String nbr : nbrs){
                if(!processed.containsKey(nbr)){
                    //Make a new Pair of nbr & put in queue
                    Pair np = new Pair();
                    np.vname = nbr;
                    np.psf = rp.psf+nbr;
                    queue.addLast(np);
                }
            }
        }
        return false;
    }

    public boolean dfs(String src, String dst){

        LinkedList<Pair> stack = new LinkedList<>();

        HashMap<String,Boolean> processed = new HashMap<>();
        // Creating New Pair
        Pair sp = new Pair();
        sp.vname = src;
        sp.psf = src;

        // Put the new Pair in the stack
        stack.addFirst(sp);

        // While the stack is not Empty, keep on doing the work
        while(!stack.isEmpty()){

            // Remove a pair from stack
            Pair rp = stack.removeFirst();
            if(processed.containsKey(rp.vname)){
                // Skip all the statement below it & move directly to the next iteration of the loop.
                continue;
            }

            // Processed put
            processed.put(rp.vname, true);

            //Direct Name
            if(containsEdge(rp.vname,dst)){
                System.out.println(rp.psf + dst);
                return true;
            }
            // nbrs
            Vertex rpvtrx = vertices.get(rp.vname);
            ArrayList<String> nbrs = new ArrayList<>(rpvtrx.nbrs.keySet());

            for(String nbr : nbrs){
                if(!processed.containsKey(nbr)){
                    //Make a new Pair of nbr & put in stack
                    Pair np = new Pair();
                    np.vname = nbr;
                    np.psf = rp.psf+nbr;
                    stack.addFirst(np);
                }
            }
        }
        return false;
    }

    public void bft() {

        LinkedList<Pair> queue = new LinkedList<>();

        HashMap<String, Boolean> processed = new HashMap<>();

        ArrayList<String> keys = new ArrayList<>(vertices.keySet());

        // For every node, repeat the process.

        for (String key : keys) {

            if(processed.containsKey(key)){
                continue;
            }
            // Creating New Pair
            Pair sp = new Pair();
            sp.vname = key;
            sp.psf = key;

            // Put the new Pair in the queue
            queue.addLast(sp);

            // While the queue is not Empty, keep on doing the work
            while (!queue.isEmpty()) {

                // Remove a pair from queue
                Pair rp = queue.removeFirst();
                if (processed.containsKey(rp.vname)) {

                // Skip all the statement below it & move directly to the next iteration of the loop.
                    continue;
                }

                 // Processed put
                processed.put(rp.vname, true);

                //Direct Name
                System.out.println(rp.vname + " via " + rp.psf);
                // nbrs
                Vertex rpvtrx = vertices.get(rp.vname);
                ArrayList<String> nbrs = new ArrayList<>(rpvtrx.nbrs.keySet());

                for (String nbr : nbrs) {
                    if (!processed.containsKey(nbr)) {
                        //Make a new Pair of nbr & put in queue
                        Pair np = new Pair();
                        np.vname = nbr;
                        np.psf = rp.psf + nbr;
                        queue.addLast(np);
                    }
                }
            }
        }
    }


    public void dft() {

        LinkedList<Pair> stack = new LinkedList<>();

        HashMap<String, Boolean> processed = new HashMap<>();

        ArrayList<String> keys = new ArrayList<>(vertices.keySet());

        // For every node, repeat the process.

        for (String key : keys) {

            if(processed.containsKey(key)){
                continue;
            }
            // Creating New Pair
            Pair sp = new Pair();
            sp.vname = key;
            sp.psf = key;

            // Put the new Pair in the stack
            stack.addFirst(sp);

            // While the stack is not Empty, keep on doing the work
            while (!stack.isEmpty()) {

                // Remove a pair from stack
                Pair rp = stack.removeFirst();
                if (processed.containsKey(rp.vname)) {

                    // Skip all the statement below it & move directly to the next iteration of the loop.
                    continue;
                }

                // Processed put
                processed.put(rp.vname, true);

                //Direct Name
                System.out.println(rp.vname + " via " + rp.psf);
                // nbrs
                Vertex rpvtrx = vertices.get(rp.vname);
                ArrayList<String> nbrs = new ArrayList<>(rpvtrx.nbrs.keySet());

                for (String nbr : nbrs) {
                    if (!processed.containsKey(nbr)) {
                        //Make a new Pair of nbr & put in stack
                        Pair np = new Pair();
                        np.vname = nbr;
                        np.psf = rp.psf + nbr;
                        stack.addFirst(np);
                    }
                }
            }
        }
    }

    public boolean isCyclic() {

        LinkedList<Pair> stack = new LinkedList<>();

        HashMap<String, Boolean> processed = new HashMap<>();

        ArrayList<String> keys = new ArrayList<>(vertices.keySet());

        // For every node, repeat the process.

        for (String key : keys) {

            if(processed.containsKey(key)){
                return true;
            }
            // Creating New Pair
            Pair sp = new Pair();
            sp.vname = key;
            sp.psf = key;

            // Put the new Pair in the stack
            stack.addFirst(sp);

            // While the stack is not Empty, keep on doing the work
            while (!stack.isEmpty()) {

                // Remove a pair from stack
                Pair rp = stack.removeFirst();
                if (processed.containsKey(rp.vname)) {
                    // Skip all the statement below it & move directly to the next iteration of the loop.
                    continue;
                }

                // Processed put
                processed.put(rp.vname, true);

                // nbrs
                Vertex rpvtrx = vertices.get(rp.vname);
                ArrayList<String> nbrs = new ArrayList<>(rpvtrx.nbrs.keySet());

                for (String nbr : nbrs) {
                    if (!processed.containsKey(nbr)) {
                        //Make a new Pair of nbr & put in stack
                        Pair np = new Pair();
                        np.vname = nbr;
                        np.psf = rp.psf + nbr;
                        stack.addFirst(np);
                    }
                }
            }
        }
        return false;
    }

    public boolean isConnected() {

        int flag = 0;

        LinkedList<Pair> queue = new LinkedList<>();

        HashMap<String, Boolean> processed = new HashMap<>();

        ArrayList<String> keys = new ArrayList<>(vertices.keySet());

        // For every node, repeat the process.

        for (String key : keys) {
            if(processed.containsKey(key)){
                continue;
            }
            flag++;
            // Creating New Pair
            Pair sp = new Pair();
            sp.vname = key;
            sp.psf = key;

            // Put the new Pair in the queue
            queue.addLast(sp);

            // While the queue is not Empty, keep on doing the work
            while (!queue.isEmpty()) {

                // Remove a pair from queue
                Pair rp = queue.removeFirst();
                if (processed.containsKey(rp.vname)) {

                    // Skip all the statement below it & move directly to the next iteration of the loop.
                    continue;
                }

                // Processed put
                processed.put(rp.vname, true);

                // nbrs
                Vertex rpvtrx = vertices.get(rp.vname);
                ArrayList<String> nbrs = new ArrayList<>(rpvtrx.nbrs.keySet());

                for (String nbr : nbrs) {
                    if (!processed.containsKey(nbr)) {
                        //Make a new Pair of nbr & put in queue
                        Pair np = new Pair();
                        np.vname = nbr;
                        np.psf = rp.psf + nbr;
                        queue.addLast(np);
                    }
                }
            }
        }
        return flag <= 1;
    }

    public boolean isTree(){
        // Tree is an acyclic graph.
        return !isCyclic() && isConnected();
    }

    public ArrayList<ArrayList<String>> getConnectedComponents() {

        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        LinkedList<Pair> queue = new LinkedList<>();

        HashMap<String, Boolean> processed = new HashMap<>();

        ArrayList<String> keys = new ArrayList<>(vertices.keySet());

        // For every node, repeat the process.

        for (String key : keys) {
            if(processed.containsKey(key)){
                continue;
            }

            // For new Component Create A new ArrayList.
            ArrayList<String> sub_ans = new ArrayList<>();
            // Creating New Pair
            Pair sp = new Pair();
            sp.vname = key;
            sp.psf = key;

            // Put the new Pair in the queue
            queue.addLast(sp);

            // While the queue is not Empty, keep on doing the work
            while (!queue.isEmpty()) {
                // Remove a pair from queue
                Pair rp = queue.removeFirst();

                if (processed.containsKey(rp.vname)) {
                    // Skip all the statement below it & move directly to the next iteration of the loop.
                    continue;
                }

                // Processed put
                processed.put(rp.vname, true);

                //Direct Name
                sub_ans.add(rp.vname);
                // nbrs

                Vertex rpvtrx = vertices.get(rp.vname);
                ArrayList<String> nbrs = new ArrayList<>(rpvtrx.nbrs.keySet());

                for (String nbr : nbrs) {
                    if (!processed.containsKey(nbr)) {
                        //Make a new Pair of nbr & put in queue
                        Pair np = new Pair();
                        np.vname = nbr;
                        np.psf = rp.psf + nbr;
                        queue.addLast(np);
                    }
                }
            }

            // Put sub_ans in final answer
            ans.add(sub_ans);
        }

        return ans;

    }

    public class PrimsPair implements Comparable<PrimsPair> {
        String vname;
        String acq_vname;
        int cost;

        @Override
        public int compareTo(PrimsPair o) {
            return o.cost - this.cost;
        }
    }

    public Graph prims(){
        Graph mst = new Graph();
        HashMap<String,PrimsPair> map = new HashMap<>();
        HashMap<String,Integer> index_map = new HashMap<>();
        Heap_Generic<PrimsPair> heap = new Heap_Generic<>();

        // Make a Pair and put in heap & map.
        for(String key : vertices.keySet()){
             PrimsPair np = new PrimsPair();
            np.vname = key;
            np.acq_vname = null;
            np.cost = Integer.MAX_VALUE;

            heap.add(np);
            map.put(key,np);
        }

        // Till the heap is not empty, keep on removing the pairs
         while(!heap.isEmpty()){

             // remove a pair
              PrimsPair rp = heap.remove();
             map.remove(rp.vname);

             if(rp.acq_vname == null){
                 mst.addVertex(rp.vname);
             }else {
                 mst.addVertex(rp.vname);
                 mst.addEdge(rp.vname,rp.acq_vname,rp.cost);
             }

             // DO the work for neighbor which is in the heap.
             //Getting the nbrs vname
             for(String nbr : vertices.get(rp.vname).nbrs.keySet()){
                 if(map.containsKey(nbr)){
                     // Get the old cost & new cost.
                     int oc = map.get(nbr).cost;
                     int nc = vertices.get(rp.vname).nbrs.get(nbr);
                    // Update the pair only when nc < oc.
                     if(nc<oc){
                        PrimsPair  gp = map.get(nbr);
                         gp.acq_vname = rp.vname;
                         gp.cost = nc;
                         heap.updatePriority(gp);
                     }
                 }
             }
         }

        return mst;
    }

    public class DijkstraPair implements Comparable<DijkstraPair> {
        String vname;
        String psf;
        int cost;

        @Override
        public int compareTo(DijkstraPair o) {
            return o.cost - this.cost;
        }
    }

    public HashMap<String,Integer> dijkstra(String src){
        Graph mst = new Graph();
        HashMap<String,DijkstraPair> map = new HashMap<>();
        HashMap<String,Integer> ans = new HashMap<>();
        Heap_Generic<DijkstraPair> heap = new Heap_Generic<>();

        // Make a Pair and put in heap & map.
        for(String key : vertices.keySet()){
            DijkstraPair np = new DijkstraPair();
            np.vname = key;
            np.psf = "";
            np.cost = Integer.MAX_VALUE;

            if(key.equals((src))){
                np.psf = key;
                np.cost = 0;
            }
            heap.add(np);
            map.put(key,np);
        }

        // Till the heap is not empty, keep on removing the pairs
        while(!heap.isEmpty()){

            // remove a pair
            DijkstraPair rp = heap.remove();
            map.remove(rp.vname);

            //add to ans
            ans.put(rp.vname,rp.cost);

            // DO the work for neighbor which is in the heap.
            //Getting the nbrs vname
            for(String nbr : vertices.get(rp.vname).nbrs.keySet()){
                if(map.containsKey(nbr)){
                    // Get the old cost & new cost.
                    int oc = map.get(nbr).cost;
                    int nc = rp.cost + vertices.get(rp.vname).nbrs.get(nbr);
                    // Update the pair only when nc < oc.
                    if(nc<oc){
                        DijkstraPair gp = map.get(nbr);
                        gp.psf = rp.psf + nbr;
                        gp.cost = nc;
                        heap.updatePriority(gp);
                    }
                }
            }
        }
        return ans;
    }
}
