package ex1.src;

import ex1.node_info;
import ex1.weighted_graph;
import ex1.weighted_graph_algorithms;

import java.io.*;
import java.util.*;
// this class is about the weighted graph algo that have a method that check if the graph connected , return  my graph
//that i built in the graph class , in this class i will chech the shortest path from the src to the dest (key node)
// and print/return the shortest path that i get , also  have method that save my graph in file and load graph from file.
public class WGraph_Algo implements weighted_graph_algorithms, Serializable {
    private weighted_graph g1;// this graph are build in wgraph ds class that all the method are in wgraph ds class
    private int key = 0;//


    @Override
    //this method copy the addres of teh graph to another graph
    public void init(weighted_graph g) {
        this.g1 = g;
    }

    @Override
    //this method return the graph variables like teh hash map mc and the edgenum in my graph class that i built .
    public weighted_graph getGraph() {
        return g1;
    }

    @Override
    //this method copy the graph in my field (copy al the variables) do deep copying.

    public weighted_graph copy() {
        weighted_graph g = new WGraph_DS();
        Collection<node_info> b = g1.getV();
        Iterator<node_info> i = b.iterator();
        while (i.hasNext()) {
            WGraph_DS.NodeInfo v = new WGraph_DS.NodeInfo(0);
            node_info n = i.next();
            v.setTag(n.getTag());
            v.setKey(n.getKey());
            v.setInfo(n.getInfo());
            g.addNode(v.getKey());
            Iterator<node_info> j = b.iterator();
            while (j.hasNext()) {
                WGraph_DS.NodeInfo z = new WGraph_DS.NodeInfo(0);
                node_info l = j.next();
                z.setTag(n.getTag());
                z.setInfo(n.getInfo());
                z.setKey(n.getKey());
                if (g1.getNode(l.getKey()) == null) {
                    g1.connect(n.getKey(), l.getKey(), g1.getNode(l.getKey()).getTag());
                }
            }
        }
        return null;
    }

    @Override
    //this method chech if my graph that i built are connected( all the nodes in the collection are connected).
    //i use the bfs algo to check if tha graph are connected.
    public boolean isConnected() {
        if (g1.nodeSize() == 1) return true;
        if (g1.nodeSize() == 0) return true;
        Collection<node_info> c1 = g1.getV();
        Iterator<node_info> i1 = c1.iterator();
        while (i1.hasNext()) {

            node_info mj = i1.next();
            if (mj != null) {
                bfs1(mj);
                break;
            }
        }

        boolean flag = true;
        Collection<node_info> c = g1.getV();
        Iterator<node_info> i = c.iterator();
        while (i.hasNext()) {
            node_info n = i.next();
            if (n.getTag() == 0) flag = false;
        }
        if (flag == false) return false;
        return true;
    }


    @Override
    //this method return double number that mean the shortest path between to nodes key src and dest.
    public double shortestPathDist(int src, int dest) {
        int max = maxnode(g1);
        double dist[] = new double[max + 1];
        double priv[] = new double[max+1];
        return Dijkstra(g1, src, dest, dist, priv,max+1);

    }

    public double Dijkstra(weighted_graph g, int src, int dest, double dist[], double priv[],int max) {
        Queue<node_info> q = new LinkedList<node_info>();
        double sum = 0;
        for (int i = 0; i < max; i++) {
            dist[i] = Integer.MAX_VALUE;
            priv[i] = -1;
        }

        for (node_info v : this.g1.getV()) {
            q.add(v);
        }
        dist[src] = 0;
        while (!q.isEmpty()) {
            int var = compare(dist, q);
            node_info v = g1.getNode(var);
            q.remove(v);
            for (node_info v1 : this.g1.getV(var)) {
                if (q.contains(v1)) {
                    sum = g1.getEdge(var, v1.getKey()) + dist[var];
                    if (sum < dist[v1.getKey()]) {
                        dist[v1.getKey()] = sum;
                        priv[v1.getKey()] = var;

                    }
                }
            }
        }
        return dist[dest];
    }

    public int maxnode(weighted_graph g) {
        int maxindex = 0;
        for (node_info n : this.g1.getV()) {
            if (n.getKey() > maxindex) {
                maxindex = n.getKey();
            }
        }
        return maxindex;
    }

    public int compare(double dist[], Queue<node_info> q) {
        int min=0 ;
        double v=Double.MAX_VALUE;
        for (int i = 0; i < dist.length; i++) {
            if (dist[i]<v && q.contains(g1.getNode(i))) {
               v=dist[i];
                min=i;
            }
        }
        return min;
    }

    @Override
    //this method return/print list that have the shortest path from src to dest.(helping method are the dijkstra algo)
    //that i built in this method get the shortest path by the weighte between the nodes.
    public List<node_info> shortestPath(int src, int dest) {

        int max = maxnode(g1);
        double dist[] = new double[max + 1];
        double priv[] = new double[max+1];
        return Dijkstra2(g1, src, dest, dist, priv,max+1);

    }

    // this method return a lis that have the shortest path that i gave hir the src and the dest
    //dijkstra algo that i explane in the readme.
    public List<node_info> Dijkstra2(weighted_graph g, int src, int dest, double dist[], double priv[],int max) {
        List<node_info> lis=new ArrayList<node_info>();
        Queue<node_info> q = new LinkedList<node_info>();
        double sum = 0;
        for (int i = 0; i < max; i++) {
            dist[i] = Integer.MAX_VALUE;
            priv[i] = -1;
        }

        for (node_info v : this.g1.getV()) {
            q.add(v);
        }
        dist[src] = 0;
        while (!q.isEmpty()) {
            int var = compare(dist, q);
            node_info v = g1.getNode(var);
            q.remove(v);
            for (node_info v1 : this.g1.getV(var)) {
                if (q.contains(v1)) {
                    sum = g1.getEdge(var, v1.getKey()) + dist[var];
                    if (sum < dist[v1.getKey()]) {
                        dist[v1.getKey()] = sum;
                        priv[v1.getKey()] = var;

                    }
                }
            }
        }
        WGraph_DS.NodeInfo n= (WGraph_DS.NodeInfo) this.g1.getNode(dest);
        if(priv[n.getKey()]!=-1 && n.getKey()==src){
            while(n!=null){
                lis.add(n);
                n= (WGraph_DS.NodeInfo) this.g1.getNode((int)priv[n.getKey()]);
            }
        }
        return lis;
    }

    @Override
    //this method save my graph in file that i will load the graph in the file
    public boolean save(String file) {
        try {
            FileOutputStream myfile = new FileOutputStream(new File(file));
            ObjectOutputStream out = new ObjectOutputStream(myfile);
            out.writeObject(this.g1);
            out.close();
            myfile.close();
            System.out.println("serialized");
        } catch (FileNotFoundException b) {
            System.out.println("IOException is caught");
        } catch (IOException b) {
            System.out.println("IOException is caught");
        }
        return true;
    }

    @Override
    // this method load an a graph to my plan.
    public boolean load(String file) {
        FileInputStream f = null;
        try {
            f= new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(f);
            this.g1 = (weighted_graph)in.readObject();
            in.close();
            f.close();
        }
        catch (IOException ex) {
            System.out.println("IOException is caught");
            return false;
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
            return  false;
        }
        return true;
    }
    //this helping method help me to check if the graph is connected by use tha tag of specific node .
    public void bfs1 (node_info n ){
        Collection<node_info> c = g1.getV();
        Iterator<node_info> i = c.iterator();
        while (i.hasNext()) {
            node_info node = i.next();
            node.setTag(0);
        }
        Queue<node_info> q = new LinkedList<node_info>();
        q.add(n);
        while (!q.isEmpty()) {
            node_info v = q.remove();
            Collection<node_info> cv = g1.getV(v.getKey());
            Iterator<node_info> rc = cv.iterator();

            while (rc.hasNext()) {
                node_info a = rc.next();
                if (a.getTag() == 0) {
                    q.add(a);
                    a.setTag(1);
                }
            }
        }
    }
}
