//package ex1;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//
//class Testgraph_Algo {
//    @Test
//    void isConnected(){
//        weighted_graph graph=new WGraph_DS();
//        graph.addNode(1);
//        graph.addNode(2);
//        graph.addNode(3);
//        graph.addNode(4);
//        graph.addNode(5);
//        graph.addNode(6);
//        graph.addNode(7);
//        graph.addNode(8);
//        graph.addNode(9);
//        graph.addNode(10);
//        graph.addNode(11);
//        graph.addNode(12);
//        graph.addNode(13);
//        graph.addNode(14);
//        graph.addNode(15);
//        graph.addNode(16);
//        graph.addNode(17);
//        graph.addNode(18);
//        graph.connect(1,2,3);
//        graph.connect(3,4,3);
//        graph.connect(4,5,3);
//        graph.connect(5,6,3);
//        graph.connect(6,7,3);
//        graph.connect(7,8,3);
//        graph.connect(8,9,3);
//        graph.connect(9,10,3);
//        graph.connect(10,11,3);
//        graph.connect(11,12,3);
//        graph.connect(12,13,3);
//        graph.connect(13,14,3);
//        graph.connect(14,15,3);
//        graph.connect(15,16,3);
//        graph.connect(16,17,3);
//       weighted_graph_algorithms g1=new WGraph_Algo();
//       g1.init(graph);
//        boolean a=g1.isConnected();
//        assertFalse(a);
//
//    }
//    @Test
//    void shortestPathDist(){
//        weighted_graph graph=new WGraph_DS();
//        weighted_graph_algorithms g1=new WGraph_Algo();
//        g1.init(graph);
//        graph.addNode(1);
//        graph.addNode(2);
//        graph.addNode(3);
//        graph.addNode(4);
//        graph.addNode(5);
//        graph.addNode(6);
//        graph.addNode(7);
//        graph.addNode(8);
//        graph.addNode(9);
//        graph.addNode(10);
//        graph.addNode(11);
//        graph.addNode(12);
//        graph.addNode(13);
//        graph.addNode(14);
//        graph.addNode(15);
//        graph.addNode(16);
//        graph.addNode(17);
//        graph.addNode(18);
//        graph.connect(1,2,3);
//        graph.connect(3,4,3);
//        graph.connect(4,5,3);
//        graph.connect(5,6,3);
//        graph.connect(6,7,3);
//        graph.connect(7,8,3);
//        graph.connect(8,9,3);
//        graph.connect(9,10,3);
//        graph.connect(10,11,3);
//        graph.connect(11,12,3);
//        graph.connect(12,13,3);
//        graph.connect(13,14,3);
//        graph.connect(14,15,3);
//        graph.connect(15,16,3);
//        graph.connect(16,17,3);
//        double v=g1.shortestPathDist(1,4);
//        assertEquals(v,9);
//    }
//
//
//
//
//}
