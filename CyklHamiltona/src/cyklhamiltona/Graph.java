/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cyklhamiltona;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.commons.collections15.Transformer;

/**
 *
 * @author nazar
 */
public class Graph extends javax.swing.JFrame {

    int numGraf = 1;
    JFrame mainFrame = new JFrame("Vizualizacja grafu");
    /**
     * Creates new form one
     */
    public Graph() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        VertxCount = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        area = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cykł Hamiltona");

        jLabel1.setText("Podaj iloszcz wierzcholkow: ");

        jButton1.setText("OK");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        area.setEditable(false);
        area.setColumns(20);
        area.setRows(5);
        jScrollPane1.setViewportView(area);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(VertxCount, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VertxCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        DoIt();
    }//GEN-LAST:event_jButton1MouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Graph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Graph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Graph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Graph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Graph().setVisible(true);
            }
        });
    }

    class Edge {

        Vertex mFrom;
        Vertex mTo;
        int mID = 0;

        public Edge(int ID, Vertex from, Vertex to) {
            mID = ID;
            mFrom = from;
            mTo = to;
        }

        public Vertex getDestination() {
            return mTo;
        }

        public Vertex getSource() {
            return mFrom;
        }

        public int getID() {
            return mID;
        }
    }

    class Vertex implements Comparable {

        int mID = 0;

        ArrayList<Edge> mOutputEdges = new ArrayList<Edge>();
        ArrayList<Edge> mInputEdges = new ArrayList<Edge>();

        public Vertex(int ID) {
            mID = ID;
        }

        public int getID() {
            return mID;
        }

        @Override
        public int compareTo(Object o) {
            if (o instanceof Vertex) {
                return Integer.compare(((Vertex) o).getID(), this.getID());
            } else {
                return -1;
            }
        }
    }

    private class HamiltonianPathFinder {

        private class Node {

            private TreeSet<Vertex> mPassedVertex = new TreeSet<Vertex>();

            public boolean isPassed(Vertex vertex) {
                return mPassedVertex.contains(vertex);
            }

            public void markAsPassed(Vertex vertex) {
                mPassedVertex.add(vertex);
            }
        }

        public class Path {

            private ArrayList<Vertex> mNodes = new ArrayList<Vertex>();
        }

        private Path mPath = new Path();
        private TreeSet<Vertex> mPathSet = new TreeSet<Vertex>();
        private ArrayList<Node> mAttendedVertex = new ArrayList<Node>();
        private Vertex mCurrent;
        private Vertex mRoot;
        private int mCurrentIndex;

        private Node getCurrentNode() {
            return mAttendedVertex.get(mCurrentIndex);
        }

        private void stepToNextNode(Vertex vertex) {
            mPath.mNodes.add(vertex);
            mPathSet.add(vertex);
            getCurrentNode().markAsPassed(vertex);
            mAttendedVertex.add(new Node());
            mCurrent = vertex;
            mCurrentIndex++;
        }

        private void returnToPrevNode() {
            mPath.mNodes.remove(mCurrentIndex);
            mPathSet.remove(mCurrent);
            mAttendedVertex.remove(mCurrentIndex);
            mCurrentIndex--;
            mCurrent = mPath.mNodes.get(mCurrentIndex);
        }

        private Vertex getNextVertex() {
            for (Edge e : mCurrent.mOutputEdges) {
                Vertex adjustVertex = e.getDestination();
                if (!getCurrentNode().isPassed(adjustVertex) && !mPathSet.contains(adjustVertex)) {
                    return e.getDestination();
                }
            }
            return null;
        }

        public HamiltonianPathFinder(Vertex root) {
            mRoot = root;
            mPath.mNodes.add(root);
            mPathSet.add(root);
            mAttendedVertex.add(new Node());
            mCurrent = root;
            mCurrentIndex = 0;
        }

        public int[] find() {
            boolean inProcess = true;
            int[] result = null;

            while (inProcess) {
                Vertex nextVertex = getNextVertex();
                if (nextVertex != null) {
                    stepToNextNode(nextVertex);
                } else {

                    if (mCurrentIndex == 0) {
                        inProcess = false;
                    } else if (mCurrentIndex == mVerticesCount - 1 && hasEdgeBetween(mCurrent, mRoot)) {
                        result = new int[mVerticesCount];
                        for (int i = 0; i < mVerticesCount; i++) {
                            result[i] = mPath.mNodes.get(i).getID();
                        }
                        inProcess = false;
                    } else {
                        returnToPrevNode();
                    }
                }
            }
            return result;
        }
    }

    public List<Vertex> vertices() {
        return Collections.unmodifiableList(mVertices);
    }

    public List<Edge> edges() {
        return Collections.unmodifiableList(mEdges);
    }

    ArrayList<Vertex> mVertices = new ArrayList<Vertex>();
    private ArrayList<Edge> mEdges = new ArrayList<Edge>();
    boolean mAdjacencyMatrix[][];
    private int mVerticesCount = 0;

    private void setVertexCount(int count) {
        if (count > 0) {
            mVertices.clear();
            for (int i = 0; i < count; i++) {
                mVertices.add(new Vertex(i));
            }
            mAdjacencyMatrix = new boolean[count][count];
            mVerticesCount = count;
        }
    }

    public boolean hasEdgeBetween(Vertex from, Vertex to) {
        int row = from.getID();
        int col = to.getID();
        if (row >= 0 && row < mVerticesCount && col >= 0 && col < mVerticesCount) {
            return mAdjacencyMatrix[row][col];
        } else {
            return false;
        }
    }

    public void addEdge(int from, int to) {
        Vertex pFrom = mVertices.get(from);
        Vertex pTo = mVertices.get(to);
        Edge newEdge = new Edge(mEdges.size(), pFrom, pTo);
        mEdges.add(newEdge);
        pFrom.mOutputEdges.add(newEdge);
        pTo.mInputEdges.add(newEdge);
    }

    public void SetGraph() {
        Random rand = new Random();
        try {
            int vertexCount = Integer.parseInt(VertxCount.getText());
            setVertexCount(vertexCount);
            for (int row = 0; row < vertexCount; row++) {
                for (int col = 0; col < row; col++) {
                    boolean value1 = rand.nextBoolean();
                    boolean value2 = rand.nextBoolean();
                    mAdjacencyMatrix[row][col] = value1;
                    mAdjacencyMatrix[col][row] = value2;
                    if (value1) {
                        addEdge(row, col);
                    }
                    if (value2) {
                        
                        addEdge(col, row);
                    }

                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(getContentPane(),
                    "Proszę wprowadzać wyłącznie liczby.");
            VertxCount.setText("");
        }
    }

    public void print() {
        area.setText("Macierz sąsiedztwa: \n \n");
        for (boolean[] aMAdjacencyMatrix : mAdjacencyMatrix) {
            for (int col = 0; col < mAdjacencyMatrix[0].length; col++) {
                String tmp = aMAdjacencyMatrix[col] ? " 1" : " 0";
                area.setText(area.getText() + tmp);
            }
            area.setText(area.getText() + "\n");
        }
    }

    public void findHamiltonianPath() {
        int[] result = new HamiltonianPathFinder(mVertices.get(0)).find();
        if (result == null) {
            area.setText(area.getText() + "\nW tym grafie nie ma cykłu Hamiltona");
        } else {
            area.setText(area.getText() + "\nCykł Hamiltona: \n");
            for (int ID : result) {
                area.setText(area.getText() + ID + " -> ");
            }
            area.setText(area.getText() + 0);
        }
    }

    public void clearList() {
        mVertices.clear();
        mEdges.clear();
    }

    public BasicVisualizationServer<Integer, Integer> getGraphVisualisation(Graph graf) {
        edu.uci.ics.jung.graph.Graph<Integer, Integer> view = new SparseMultigraph<Integer, Integer>();
        for (Vertex v : vertices()) {
            view.addVertex(v.getID());
        }
        for (Edge e : edges()) {
            view.addEdge(e.getID(), e.getSource().getID(), e.getDestination().getID(), EdgeType.DIRECTED);
        }
        Layout<Integer, Integer> layout = new CircleLayout<Integer, Integer>(view);
        layout.setSize(new Dimension(450, 450));
        BasicVisualizationServer<Integer, Integer> visualisation = new BasicVisualizationServer<Integer, Integer>(
                layout);
        visualisation.setPreferredSize(new Dimension(460, 460));
        visualisation.getRenderContext().setVertexFillPaintTransformer(new Transformer<Integer, Paint>() {
            @Override
            public Paint transform(Integer integer) {
                return Color.WHITE;
            }
        });
        visualisation.getRenderContext().setVertexShapeTransformer(new Transformer<Integer, Shape>() {
            @Override
            public Shape transform(Integer integer) {
                return new Ellipse2D.Double(-20, -20, 40, 40);
            }
        });
        visualisation.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<Integer>());
        visualisation.getRenderer().getVertexLabelRenderer().setPosition(Renderer.VertexLabel.Position.CNTR);
        return visualisation;
    }

    public void DoIt() {
        Graph graf = new Graph();
        SetGraph();
        System.out.println(numGraf + ". Graf został skutecznie załadowany.");
        numGraf++;

        mainFrame.add(getGraphVisualisation(graf));
        mainFrame.pack();
        mainFrame.setVisible(true);

        print();
        findHamiltonianPath();
        clearList();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField VertxCount;
    private javax.swing.JTextArea area;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
