import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
//import edu.princeton.cs.algs4.Graph;
//import edu.princeton.cs.algs4.SymbolGraph;
//import Graph;


/**
 * 间隔的度数 ： 向交和 加 1
 *
 *  ../algs4-data/movies.txt "/"  "Bacon, Kevin"
 *  ../algs4-data/movies.txt "/"  "Animal House (1978)"
 *  ../algs4-data/routes.txt " " "JFK"

 */


public class DegreesOfSeparation {

    public static void main(String[] args) {

        String filename  = args[0];
        String delimiter = args[1];
        String source    = args[2];


        SymbolGraph sg = new SymbolGraph(filename, delimiter);
        Graph G = sg.G();

        if (!sg.contains(source)) {
            StdOut.println(source + " not in database.");
            return;
        }

        int s = sg.index(source);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);

        while (!StdIn.isEmpty()) {
            String sink = StdIn.readLine();
            StdOut.println(sink);
            if (sg.contains(sink)) {
                int t = sg.index(sink);

                if (bfs.hasPathTo(t)) {
                    for (int v : bfs.pathTo(t)) {
                        StdOut.println(" " + sg.name(v));
                    }
                } else {
                    StdOut.println("Not in databases. ");
                }
            }
        }
    }
}
