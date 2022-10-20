import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<int[]> coordonne = new ArrayList<>();


    public static void main(String[] args) {
        coordonne.add(new int[]{-1, -1});
        coordonne.add(new int[]{-1, 0});
        coordonne.add(new int[]{-1, 1});
        coordonne.add(new int[]{0, -1});
        coordonne.add(new int[]{0, 0});
        coordonne.add(new int[]{0, 1});
        coordonne.add(new int[]{1, -1});
        coordonne.add(new int[]{1, 0});
        coordonne.add(new int[]{1, 1});
        List<int[]> firstCell = new ArrayList<>();
        Grid game = new Grid(16, 16);
        //y x
        firstCell.add(new int[]{4, 3});
        firstCell.add(new int[]{4, 4});
        firstCell.add(new int[]{4, 5});

        firstCell.add(new int[]{8,9});
        firstCell.add(new int[]{8,10});
        //Throw an ERROR firstCell.add(new int[]{3,-2});

        game.initFirstCells(firstCell);
        game.printGrid();
        //System.out.println(game.exiteOneCellAlive());
       game(game);
       // System.out.println(1 + 2);

    }

    private static void game(Grid game){

        while(game.exiteOneCellAlive()) {
            for (int i = 0; i < game.height; i++) {
                for (int j = 0; j < game.width; j++) {
                    int numberCellAlive = 0;
                    Cell cell = game.grid[i][j];

                    for (int [] coordonne : coordonne){
                        int y =  i + coordonne[0];
                        int  x = j + coordonne[1];
                        try {
                            if (game.grid[y][x].state){
                                //System.out.println(  "{"+ x + ","+y + "}"  );
                                numberCellAlive ++;
                               // System.out.println( "cellule vivante "+ "{"+y + ","+x+ "}"  );
                                System.out.println("{"+ i  + ","+ j + "}" + "nombre de cellule vivant" +  numberCellAlive);

                            }
                        }catch(Exception e){
                           // System.out.println(x + " "+ y);


                        }

                    }
                    if (numberCellAlive == 3){
                        game.cellsToLive.add(cell);
                    }
                    else if (numberCellAlive < 2  || numberCellAlive > 3)
                        game.cellsToKill.add(cell);
                }
            }
            for (Cell cellalive : game.cellsToLive){
                cellalive.giveBirth();
            }
            for (Cell cell : game.cellsToKill){
                cell.kill();
            }
            game.cellsToKill.clear();
            game.cellsToLive.clear();
            game.printGrid();
        }
    }


}