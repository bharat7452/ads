import java.util.*;
// program for finding biconnected components in a graph

class BiconnectedGraph {

    private int V;  
    private LinkedList<Integer>[] adj;

    int time = 0;

    
    BiconnectedGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }

    
    void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    void BCCUtil(int u, int disc[], int low[],
                 LinkedList<int[]> stack, int parent[]) {

        disc[u] = low[u] = ++time;
        int children = 0;

        for (int v : adj[u]) {

            
            if (disc[v] == -1) {
                children++;
                parent[v] = u;

                stack.add(new int[]{u, v});

                BCCUtil(v, disc, low, stack, parent);

                low[u] = Math.min(low[u], low[v]);

                
                if ((disc[u] == 1 && children > 1) ||
                        (disc[u] > 1 && low[v] >= disc[u])) {

                    System.out.print("Biconnected Component: ");
                    while (true) {
                        int[] edge = stack.removeLast();
                        System.out.print("(" + edge[0] + "-" + edge[1] + ") ");
                        if (edge[0] == u && edge[1] == v)
                            break;
                    }
                    System.out.println();
                }
            }

            
            else if (v != parent[u] && disc[v] < disc[u]) {
                low[u] = Math.min(low[u], disc[v]);
                stack.add(new int[]{u, v});
            }
        }
    }

    void findBCC() {

        int disc[] = new int[V];
        int low[] = new int[V];
        int parent[] = new int[V];

        LinkedList<int[]> stack = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            disc[i] = -1;
            low[i] = -1;
            parent[i] = -1;
        }

        for (int i = 0; i < V; i++) {
            if (disc[i] == -1) {
                BCCUtil(i, disc, low, stack, parent);

                
                if (!stack.isEmpty()) {
                    System.out.print("Biconnected Component: ");
                    while (!stack.isEmpty()) {
                        int[] edge = stack.removeLast();
                        System.out.print("(" + edge[0] + "-" + edge[1] + ") ");
                    }
                    System.out.println();
                }
            }
        }
    }

    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        BiconnectedGraph g = new BiconnectedGraph(V);

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        System.out.println("Enter edges (u v):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            g.addEdge(u, v);
        }

        System.out.println("\nBiconnected Components are:");
        g.findBCC();

        sc.close();
    }
}

