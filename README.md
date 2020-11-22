This task is a continuation of the past task ex0 , this tack is about weighted graph .
all the method in tha tack is specific to weighted graph that have a nodes collection and between have and edges that have double value
this as a linke about the weighted grap :
https://en.wikipedia.org/wiki/Graph_(discrete_mathematics)
in this tack i use a publish method like dijkstra algo:
https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm
and BFS algo:https://en.wikipedia.org/wiki/Breadth-first_search
that have many implementaion that you can match to your requirements. 
clasess explanation:
. nodeinfo:    this class tell me the info of the node and his neighbors that i put all the info that i need in this class
    like a key node tag and info and i added a hashmap of tha neighbors that have the weighte between two and more nodes
    this class an internal class in wgraph ds that the teacher ask .
the methodes in this class:
contractour :this method are constructor all the var in my field.
getNi:this method i added that she tell me all the nodes in collection (the neighbors).
hasNi:this method ask if have a neighbors to specific key that i have + i put the key in the node and ask .
addNi:this method add the node to the neighbors in tha hash mao neighbors.
removeNode:this method remode node from the hash map by tell her the node info finde it and delete it from the graph .
getKey:this method are very simple that retun the key of specific node (my node).
getInfo:this method return the string nfo that i have in my node.
setInfo:this method set a string info in the appropriate field.
getTag:this method return the double number of the weighte in two nodes.
setTag:this method reset the tag (double number) weighte between the nodes
setKey:this method reset the key in specific node.

.grapg_ds:this class till use how to use in weighted graph and all the collection that it have like his nighers his
distance (distance between two nodes ) and how i can connect nodes and ask if thay have an edge between two nodes in the graph
i put the node info class in my class graph like an internal department to do all the method and to use in node class in the graph class
WGraph_DS:this method are constructor to initialization all the variable in my graph.
getNode:this method return the node that i tipe hs key in this method.
hasEdge:this method return true two nodes have an edge bewteen, nad false if havenot.
getEdge:this method return the weighte between two nodes (the distance).
addNode:this method add node to tha graph(collection) by the key that i have .
connect:this method connect between tow nodes that i till use in tha graph that they wasnot connected.
getV:this methd return all the nodes in collection that i have in my graph
getV:this method return all the neighbors of specific node.
removeNode:this method remove a node by his key , find it and vemove after that he return it(the removed node).
removeEdge:this method remove the edge between two nodes that i tell .
nodeSize:this method return the numbers of node in my graph(collection/hashmap).
edgeSize:this method return number of the edges in my graph that i count in all the methods that change the edges number.
getMC:this method return number of the changes that i do in my graph

.wgraph_algo: this class is about the weighted graph algo that have a method that check if the graph connected , return  my graph
that i built in the graph class , in this class i will chech the shortest path from the src to the dest (key node)
 and print/return the shortest path that i get , also  have method that save my graph in file and load graph from file.
init:this method copy the addres of teh graph to another graph
getGraph:this method return the graph variables like teh hash map mc and the edgenum in my graph class that i built .
copy:this method copy the graph in my field (copy al the variables) do deep copying.
isConnected:this method chech if my graph that i built are connected( all the nodes in the collection are connected).i use the bfs algo to check if tha graph are connected.
shortestPathDist:this method return double number that mean the shortest path between to nodes key src and dest.
Dijkstra:this algo eplaining up
shortestPath:this method return/print list that have the shortest path from src to dest.(helping method are the dijkstra algo) that i built in this method get the shortest path by the weighte between the nodes.
Dijkstra2:this method return a lis that have the shortest path that i gave hir the src and the dest dijkstra algo that i explane in the readme.
save:this method save my graph in file that i will load the graph in the file
load:this method load an a graph to my plan.


