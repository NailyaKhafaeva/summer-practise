package com.company;

class Edge implements Comparable<Edge>  {
    int u;
    int v;
    int w;

    Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge edge) {
        if (w != edge.w) return w < edge.w ? -1 : 1;
        return 0;
    }
}
