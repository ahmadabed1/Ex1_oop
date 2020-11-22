package ex1.src;
import ex1.node_info;
import ex1.weighted_graph;

import java.util.*;

//this class till use how to use in weighted graph and all the collection that it have like his nighers his
//distance (distance between two nodes ) and how i can connect nodes and ask if thay have an edge between two nodes in the graph
//i put the node info class in my class graph like an internal department to do all the method and to use in node class in the graph class
public class WGraph_DS implements weighted_graph {
    private HashMap<Integer, node_info> mygraph;// this variable collection tell me the collection node in my graph
    // i put it in hashmap to enable to catch al the nodes in the collection that have integer key and node info val
    private int MC=0;// this variable count the changes in my graph like add nodes and remove nodes in the graph .
    private int edgenum=0;// this variable tell me number of the edges between all the nodes in my graph (collection).

    public WGraph_DS()
    {
        //this method are constructor to initialization all the variable in my graph.
        this.mygraph = new HashMap<Integer, node_info>();// i have an empty hashmap now .
        this.MC=0;// no changes in my graph now
        this.edgenum=0;//no egdes between the nodes now.
    }

    @Override
    //this method return the node that i tipe hs key in this method.
    public node_info getNode(int key) {
        return this.mygraph.get(key);
    }

    @Override
    //this method return true two nodes have an edge bewteen, nad false if havenot.
    public boolean hasEdge(int node1, int node2) {
        if(mygraph.get(node1)!=null && mygraph.get(node2)!=null) {
           NodeInfo n1=(NodeInfo) this.mygraph.get(node1);
           NodeInfo n2=(NodeInfo) this.mygraph.get(node2);
           if(n1.hasNi(node2)) return true;
        }
        return false;
    }

    @Override
    //this method return the weighte between two nodes (the distance).
    public double getEdge(int node1, int node2) {
        if (node1 == node2) return 0;
        if (!hasEdge(node1, node2)) return -1;
        return ((NodeInfo)mygraph.get(node1)).weighth.get(node2);
        }


    @Override
    //this method add node to tha graph(collection) by the key that i have .
    public void addNode(int key) {
        node_info node=new NodeInfo(key);
        this.mygraph.put(key,node);
        ++this.MC;
    }

    @Override
    //this method connect between tow nodes that i till use in tha graph that they wasnot connected.
    public void connect(int node1, int node2, double w) {
        if (node1 != node2 && this.mygraph.containsKey(node1) && this.mygraph.containsKey(node2)) {
            NodeInfo node11 =(NodeInfo) this.mygraph.get(node1);
            NodeInfo node22 = (NodeInfo)this.mygraph.get(node2);
            if (node11 != null && node22 != null) {
                if (hasEdge(node1, node2) == false) {
                    node11.addNi(node22);
                    node22.addNi(node11);
                    ++edgenum;
                }
                node22.weighth.put(node1,w);
                node11.weighth.put(node2,w);
            }
            ++MC;
        }
    }
    @Override
    //this methd return all the nodes in collection that i have in my graph
    public Collection<node_info> getV() {
        return this.mygraph.values();
    }

    @Override
    //this method return all the neighbors of specific node.
    public Collection<node_info> getV(int node_id) {
        return (((NodeInfo)this.mygraph.get(node_id)).getNi());
    }

    @Override
    // this method remove a node by his key , find it and vemove after that he return it(the removed node).
    public node_info removeNode(int key) {
        List<Integer> lis=new ArrayList<>();
        NodeInfo n = (NodeInfo) getNode(key);
        if (n!=null) {
            Collection<node_info>mo=getV(key);
            Iterator<node_info> i= mo.iterator();
            while(i.hasNext()) {
                NodeInfo m = (NodeInfo)i.next();
                lis.add(m.getKey());
            }
            for(int x=0 ; x< lis.size();x++){
                removeEdge(lis.get(x),key);
            }
            this.mygraph.remove(key);
            edgenum-=n.getNi().size();
        }
        return n;
    }

    @Override
    // this method remove the edge between two nodes that i tell .
    public void removeEdge(int node1, int node2) {
        NodeInfo n1= (NodeInfo)this.mygraph.get(node1);
        NodeInfo n2= (NodeInfo)this.mygraph.get(node2);
        n1.removeNode(n2);
        n2.removeNode(n1);
        edgenum--;
    }

    @Override
    // this method return the numbers of node in my graph(collection/hashmap).
    public int nodeSize() {
        return this.mygraph.size();
    }

    @Override
    //this method return number of the edges in my graph that i count in all the methods that change the edges number.
    public int edgeSize() {
        return this.edgenum;
    }

    @Override
    //this method return number of the changes that i do in my graph
    public int getMC() {
        return this.MC;
    }

//    this class tell me the info of the node and his neighbors that i put all the info that i need in this class
//    like a key node tag and info and i added a hashmap of tha neighbors that have the weighte between two and more nodes
//    this class an internal class in wgraph ds that the teacher ask .
    public static class NodeInfo implements node_info {
        private int key;//this is the key of the node that if we want a specific this is her name .
        private double tag;// this double number can help us to get tha weighte between two nodes.
        private String info;//this info use like rename the node like color.
        private double weight=0;// this var help us to get weighte but we dont have to use it .
        private HashMap<Integer,node_info> hmp;//this hash map are for the neighbors
        private HashMap<Integer,Double> weighth;//this hashmap use between two nodes or more that have the weighte between .

        // this method are constructor all the var in my field.
        public NodeInfo(int key) {
            this.key = key;
            this.tag = 0;
            this.info = "";
            this.weight=0;
            this.hmp = new HashMap<Integer, node_info>();
            this.weighth=new HashMap<Integer, Double>();
        }

        //this method i added that she tell me all the nodes in collection (the neighbors).
        public Collection<node_info> getNi() {
            return this.hmp.values();
        }
        //this method ask if have a neighbors to specific key that i have + i put the key in the node and ask .
        public boolean hasNi(int key) {
            if(this.hmp.containsKey(key)) return true ;
            return false;
        }
        //this method add the node to the neighbors in tha hash mao neighbors.
        public void addNi(node_info t) {
            if(t!=null)
                this.hmp.put(t.getKey(),t);
        }
        // this method remode node from the hash map by tell her the node info finde it and delete it from the graph .
        public void removeNode(node_info node) {
            if(node !=null) this.hmp.remove(node.getKey(),node);
        }


        @Override
        // this method are very simple that retun the key of specific node (my node).
        public int getKey() {
            return this.key;
        }

        @Override
        //this method return the string nfo that i have in my node.
        public String getInfo() {
            return this.info;
        }

        @Override
        //this method set a string info in the appropriate field.
        public void setInfo(String s) {
            this.info=s;
        }
        @Override
        //this method return the double number of the weighte in two nodes.
        public double getTag() {
            return this.tag;
        }
        @Override
        // this method reset the tag (double number) weighte between the nodes
        public void setTag(double t) {
            this.tag=t;
        }
        // this method reset the key in specific node.
        public void setKey(int key) {
            this.key=key;
        }
    }
}
