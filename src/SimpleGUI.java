package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleGUI extends JFrame {

    private JButton button = new JButton("OK");
    private JTextField ab = new JTextField("", 4);
    private JTextField ac = new JTextField("", 4);
    private JTextField ad = new JTextField("", 4);
    private JTextField ae = new JTextField("", 4);
    private JTextField af = new JTextField("", 4);
    private JTextField bc = new JTextField("", 4);
    private JTextField bd = new JTextField("", 4);
    private JTextField be = new JTextField("", 4);
    private JTextField bf = new JTextField("", 4);
    private JTextField cd = new JTextField("", 4);
    private JTextField ce = new JTextField("", 4);
    private JTextField cf = new JTextField("", 4);
    private JTextField de = new JTextField("", 4);
    private JTextField df = new JTextField("", 4);
    private JTextField ef = new JTextField("", 4);

    private JLabel label = new JLabel("Input:");
    private JLabel v1 = new JLabel("    A");
    private JLabel v2 = new JLabel("    B");
    private JLabel v3 = new JLabel("    C");
    private JLabel v4 = new JLabel("    D");
    private JLabel v5 = new JLabel("    E");
    private JLabel v6 = new JLabel("    F");

    private JLabel v12 = new JLabel("    A");
    private JLabel v22 = new JLabel("    B");
    private JLabel v32 = new JLabel("    C");
    private JLabel v42 = new JLabel("    D");
    private JLabel v52 = new JLabel("    E");
    private JLabel v62 = new JLabel("    F");

    private JLabel AA = new JLabel("  *** ");
    private JLabel BB = new JLabel("  *** ");
    private JLabel CC = new JLabel("  *** ");
    private JLabel DD = new JLabel("  *** ");
    private JLabel EE = new JLabel("  *** ");
    private JLabel FF = new JLabel("  *** ");


    private JLabel AB = new JLabel("  --- ");
    private JLabel AC = new JLabel("  --- ");
    private JLabel AD = new JLabel("  --- ");
    private JLabel AE = new JLabel("  --- ");
    private JLabel AF = new JLabel("  --- ");
    private JLabel BC = new JLabel("  --- ");
    private JLabel BD = new JLabel("  --- ");
    private JLabel BE = new JLabel("  --- ");
    private JLabel BF = new JLabel("  --- ");
    private JLabel CD = new JLabel("  --- ");
    private JLabel CE = new JLabel("  --- ");
    private JLabel CF = new JLabel("  --- ");
    private JLabel DE = new JLabel("  --- ");
    private JLabel DF = new JLabel("  --- ");
    private JLabel EF = new JLabel("  --- ");

    public SimpleGUI(){
        super("Adjacency matrix");
        this.setBounds(250,250,500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(8,8,4,4));
        container.add(label);
        container.add(v1);
        container.add(v2);
        container.add(v3);
        container.add(v4);
        container.add(v5);
        container.add(v6);

        container.add(v12);
        container.add(AA);
        container.add(ab);
        container.add(ac);
        container.add(ad);
        container.add(ae);
        container.add(af);


        container.add(v22);
        container.add(AB);
        container.add(BB);
        container.add(bc);
        container.add(bd);
        container.add(be);
        container.add(bf);

        container.add(v32);
        container.add(AC);
        container.add(BC);
        container.add(CC);
        container.add(cd);
        container.add(ce);
        container.add(cf);

        container.add(v42);
        container.add(AD);
        container.add(BD);
        container.add(CD);
        container.add(DD);
        container.add(de);
        container.add(df);

        container.add(v52);
        container.add(AE);
        container.add(BE);
        container.add(CE);
        container.add(DE);
        container.add(EE);
        container.add(ef);

        container.add(v62);
        container.add(AF);
        container.add(BF);
        container.add(CF);
        container.add(DF);
        container.add(EF);
        container.add(FF);

        button.addActionListener(new ButtonEventListener());
        container.add(button);

    }

       class ButtonEventListener implements ActionListener {
        public void actionPerformed (ActionEvent e){
            String message = "";
            message += "AB = "+ ab.getText() +"\n";
            message += "AC = "+ ac.getText() +"\n";
            message += "AD = "+ ad.getText() +"\n";
            message += "AE = "+ ae.getText() +"\n";
            message += "AF = "+ af.getText() +"\n";
            message += "BC = "+ bc.getText() +"\n";
            message += "BD = "+ bd.getText() +"\n";
            message += "BE = "+ be.getText() +"\n";
            message += "BF = "+ bf.getText() +"\n";
            message += "CD = "+ cd.getText() +"\n";
            message += "CE = "+ ce.getText() +"\n";
            message += "CF = "+ cf.getText() +"\n";
            message += "DE = "+ de.getText() +"\n";
            message += "DF = "+ df.getText() +"\n";
            message += "EF = "+ ef.getText() +"\n";
            JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);

            Edge[] edges = edgeCreate();
            DSF dsf = new DSF(15);
            sort(edges, 15);

            int result = 0;
            String log = "";
            for (Edge ed : edges)
                if (dsf.union(ed.u, ed.v)) {
                    result += ed.w;
                    log += "Added an edge - " + Integer.toString(ed.w)+"\n";
                }

            log += "\nResult = "+Integer.toString(result)+"\n";
            JOptionPane.showMessageDialog(null, log, "Result", JOptionPane.PLAIN_MESSAGE);

        }
    }

    public static void sort(Edge[] edges, int size) {
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false; {
                for (int i = 1; i < size; i++) {
                    if (edges[i].w < edges[i - 1].w) {
                        swap(edges, i, i - 1);
                        needIteration = true;
                    }
                }
            }
        }

    }

    private static void swap(Edge[] array, int ind1, int ind2) {
        Edge tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }

    public Edge[] edgeCreate() {
        Edge[] edges = new Edge[15];
        edges[0] = new Edge(0, 1, Integer.parseInt (ab.getText() ));
        edges[1] = new Edge(0, 2, Integer.parseInt (ac.getText() ));
        edges[2] = new Edge(0, 3, Integer.parseInt (ad.getText() ));
        edges[3] = new Edge(0, 4, Integer.parseInt (ae.getText() ));
        edges[4] = new Edge(0, 5, Integer.parseInt (af.getText() ));
        edges[5] = new Edge(1, 2, Integer.parseInt (bc.getText() ));
        edges[6] = new Edge(1, 3, Integer.parseInt (bd.getText() ));
        edges[7] = new Edge(1, 4, Integer.parseInt (be.getText() ));
        edges[8] = new Edge(1, 5, Integer.parseInt (bf.getText() ));
        edges[9] = new Edge(2, 3, Integer.parseInt (cd.getText() ));
        edges[10] = new Edge(2, 4, Integer.parseInt (ce.getText() ));
        edges[11] = new Edge(2, 5, Integer.parseInt (cf.getText() ));
        edges[12] = new Edge(3, 4, Integer.parseInt (de.getText() ));
        edges[13] = new Edge(3, 5, Integer.parseInt (df.getText() ));
        edges[14] = new Edge(4, 5, Integer.parseInt (ef.getText() ));

        return edges;
    }

}
