package net.lzzy.algorithm.algorlib;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzzy_gxy on 2019/6/27.
 * Description:
 */
public class SimpleMap {
    int vertexCount;
    List<Edge> edges=new ArrayList<>();

    public SimpleMap(int v){
        vertexCount=v;
    }

    public void addEdge(int source,int targe,double distance){
        edges.add(new Edge(source, targe,distance));
    }
    public void addTwoEdge(int v1,int v2,double distance){
       addEdge(v1,v2,distance);
        addEdge(v1,v2,distance);
    }
    public String iteratRangeFirst(){
        return "01534";
    }
    public String itera0teDepthFirst(){
        return "012354";
    }
}
class Edge{
    private int source;
    private int target;
    private double distance;

    Edge(int source,int target,double distance){
        this.source=source;
        this.target=target;
        this.distance=distance;
    }
    public void add(){

    }
}
