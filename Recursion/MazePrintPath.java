import java.util.ArrayList;

class MazePrintPath{

    private static ArrayList<String> paths = new ArrayList<>(); 

    public static void main(String[] args) {
        buildAllPaths(3, 3, new String());
        System.err.println(paths);
    }

    private static void buildPaths(int r, int c, String path){
        if (r==1&&c == 1){
            paths.add(path);
            return;
        }

        //traverse row
        if (r>1){
            buildPaths(r-1, c, path+"D");
        }
        if(c>1){
            //traverse col
            buildPaths(r, c-1, path+"R");
        }
    }

    private static void buildAllPaths(int r, int c, String path){
        if (r==1&&c == 1){
            paths.add(path);
            return;
        }

        if (r>1 && c>1){
            buildAllPaths(r-1, c-1, path+"(DAG)");
        }
        //traverse row
        if (r>1){
            buildAllPaths(r-1, c, path+"D");
        }

        //traverse col
        if(c>1){
            buildAllPaths(r, c-1, path+"R");
        }
    }

}