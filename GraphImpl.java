import java.util.LinkedList;
public class GraphImpl {
    private LinkedList<LinkedList<Boolean>> adjMatrix;
    private int numVertices;

    public GraphImpl(){
        this.adjMatrix = new LinkedList<>();
        this.numVertices = 0;
    }

    public void addVertex(){
        for(LinkedList<Boolean> row : adjMatrix){
            row.add(false);
        }
        adjMatrix.add(new LinkedList<>());
        for(int i = 0; i <= numVertices; i++) {
            adjMatrix.get(numVertices).add(false);
        }
        numVertices++;
    }

    public void removeVertex(int index){
        if(index < numVertices){
            adjMatrix.remove(index);
            for(LinkedList<Boolean> row : adjMatrix){
                row.remove(index);
            }
            numVertices--;
        }
    }

    public void addEdge(int i, int j){
        if(i < numVertices && j < numVertices){
            adjMatrix.get(i).set(j,true);
            adjMatrix.get(j).set(j,true);
        }
    }

    public void removeEdge(int i, int j){
        if(i < numVertices && j < numVertices){
            adjMatrix.get(i).set(j,false);
            adjMatrix.get(j).set(j,false);
        }
    }

    public boolean isEdge(int i, int j){
        if(i < numVertices && j < numVertices){
            return adjMatrix.get(i).get(j);
        }
        return false;
    }

    public void printGraph(){
        for(int i = 0; i < numVertices; i++){
            for(Boolean j : adjMatrix.get(i)){
                System.out.print((j ? 1 : 0) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        GraphImpl g = new GraphImpl();
        g.addVertex();
        g.addVertex();
        g.addVertex();
        g.addVertex();
        g.addVertex();

        g.addEdge(0,1);
        g.addEdge(0,4);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        g.addEdge(2,3);
        g.addEdge(3,4);

        g.printGraph();
        System.out.println("*************");
        System.out.println("Is there an edge between 1 and 3? " + g.isEdge(1,3));
        g.removeEdge(1,3);
        g.printGraph();
        System.out.println("Is there an edge between 1 and 3? " + g.isEdge(1,3));
        System.out.println("**************");
        g.removeVertex(2);
        g.printGraph();
    }
}
