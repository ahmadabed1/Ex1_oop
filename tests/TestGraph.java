package ex1.tests;
import ex1.node_info;
import ex1.src.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class TestGraph {
    private static WGraph_DS graph;
    private static WGraph_Algo graphalgo;

    @BeforeAll
   static void  Setup()
    {
        graph = new WGraph_DS();
        graphalgo =new WGraph_Algo();
    }
    @Test
    void TestAddNode() {
        graph.addNode(0);
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);
        graph.addNode(6);
        assertNotNull(graph.getNode(0));
        assertNotNull(graph.getNode(1));
        assertNotNull(graph.getNode(2));

    }

    @Test
    void hasEdge() {
        graph.addNode(0);
        graph.addNode(1);
        graph.connect(0,1,7);
        assertTrue(graph.hasEdge(0,1));
    }

    @Test
    void getEdge() {
        graph.addNode(0);
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);
        graph.addNode(6);
        graph.connect(1,4,7);
        graph.connect(1,0,2);
        graph.connect(1,5,12);
        graph.connect(3,2,4);
        graph.connect(3,4,7);
        graph.connect(3,6,5);
        graph.connect(0,6,1);
        graph.connect(0,2,9);
        double n=graph.getEdge(1,4);
        assertEquals(n,7);


    }

    @Test
    void addNode() {
        graph.addNode(0);
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);
        graph.addNode(6);
        assertNotEquals(graph.getNode(3),null);
        assertNotEquals(graph.getNode(4),null);
        assertNotEquals(graph.getNode(6),null);
        assertNotEquals(graph.getNode(0),null);
        assertNotEquals(graph.getNode(1),null);
        assertNotEquals(graph.getNode(5),null);
        assertEquals(graph.getNode(7),null);

    }

    @Test
    void connect() {
        graph.addNode(0);
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);
        graph.addNode(6);
        graph.connect(1,4,7);
        graph.connect(1,0,2);
        graph.connect(1,5,12);
        graph.connect(3,2,4);
        graph.connect(3,4,7);
        graph.connect(3,6,5);
        graph.connect(0,6,1);
        graph.connect(0,2,9);

    }

    @Test
    void getV() {
        graph.addNode(0);
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.connect(0,1,3);
        graph.connect(0,2,8);
        graph.connect(0,3,5);
        graph.connect(0,1,21);
        Collection<node_info> v = graph.getV();
        Iterator<node_info> iter = v.iterator();
        while (iter.hasNext()) {
            node_info n = iter.next();
            assertNotNull(n);
        }
    }


    @Test
    void removeNode() {
        graph.addNode(0);
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);
        graph.addNode(6);
        graph.connect(0,1,1);
        graph.connect(0,2,2);
        graph.connect(0,3,3);
        graph.removeEdge(0,3);
        double w = graph.getEdge(0,3);
        assertEquals(w,-1);
    }

    @Test
    void edgeSize() {
        graph.addNode(0);
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.connect(1,3,5);
        graph.connect(1,2,1);
        graph.connect(1,4,7);
        graph.connect(3,4,2);
        graph.connect(2,3,3);
        assertTrue(graph.edgeSize()==5);
    }


}