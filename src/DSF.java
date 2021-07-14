package com.company;

public class DSF {
    int[] set;
    int[] rnk;

    public DSF(int size) {
        set = new int [size];
        rnk = new int [size];
        for (int i = 0; i < size; i++)
            set[i] = i;
    }

    int set(int x) {
        if (x == set[x]) {
            return x;
        } else {
            set[x] = set(set[x]);
        }
        return set[x];
    }

    public boolean union(int u, int v) {
        if ((u = set(u)) == (v = set(v)))
            return false;
        if (rnk[u] < rnk[v]) {
            set[u] = v;
        } else {
            set[v] = u;
            if (rnk[u] == rnk[v])
                rnk[u]++;
        }
        return true;
    }
}
