import java.util.List;

public class Grid {
    final int width;
    final int height;

     final Cell[][] grid ;

    Grid(int x, int y){
        width = x;
        height = y;
        grid = new Cell[width][height];
        for (int i = 0; i < x; i++){
            for (int j = 0; j < y; j++){
                grid[i][j] = new Cell(false);
            }
        }
    }

    void printGrid(){

        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
                System.out.print( grid[i][j].state ?  "x" : "o" );
            }
            System.out.println( "");
        }
    }

    public void initFirstCells(List<int[]> firstCells){
        try {
            firstCells.forEach(position -> grid[position[0]][position[1]].giveBirth());
        }catch (Exception e){
            System.out.println("la position est incorrect");
        }
    }

    public boolean exiteOneCellAlive() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (grid[i][j].state) {
                    return true;
                }
            }
        }
        return false;
    }
}
