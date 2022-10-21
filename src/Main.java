import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame {
    static List<int[]> coordonne = new ArrayList<>();

    static JFrame frame = new JFrame();
    Graphics graphics;
    static DisplayGrid dpgrid;

    static JButton nexGen = new JButton();

    public static void main(String[] args) throws InterruptedException {
        frame.setBounds(100,100,600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        coordonne.add(new int[]{-1, -1});
        coordonne.add(new int[]{-1, 0});
        coordonne.add(new int[]{-1, 1});
        coordonne.add(new int[]{0, -1});
        //coordonne.add(new int[]{0, 0});
        coordonne.add(new int[]{0, 1});
        coordonne.add(new int[]{1, -1});
        coordonne.add(new int[]{1, 0});
        coordonne.add(new int[]{1, 1});
        List<int[]> firstCell = new ArrayList<>();
        Grid grid = new Grid(100, 100);

        //y x
        //Carre gauche
        firstCell.add(new int[]{5, 0});
        firstCell.add(new int[]{6, 0});
        firstCell.add(new int[]{5, 1});
        firstCell.add(new int[]{6, 1});
        //carre droit
        firstCell.add(new int[]{5-2, 34});
        firstCell.add(new int[]{6-2, 34});
        firstCell.add(new int[]{5-2, 35});
        firstCell.add(new int[]{6-2, 35});
        //Vaissau 1
        firstCell.add(new int[]{3, 12+1});
        firstCell.add(new int[]{3, 11+1});
        firstCell.add(new int[]{4, 10+1});
        firstCell.add(new int[]{5, 9+1});
        firstCell.add(new int[]{6, 9+1});
        firstCell.add(new int[]{7, 9+1});
        firstCell.add(new int[]{8, 10+1});
        firstCell.add(new int[]{9, 11+1});
        firstCell.add(new int[]{9, 12+1});

        firstCell.add(new int[]{6, 13+1});

        firstCell.add(new int[]{4, 14+1});
        firstCell.add(new int[]{8, 14+1});
        firstCell.add(new int[]{5, 15+1});
        firstCell.add(new int[]{6, 15+1});
        firstCell.add(new int[]{7, 15+1});
        firstCell.add(new int[]{6, 16+1});

        //vaissau 2
        firstCell.add(new int[]{5, 19+1});
        firstCell.add(new int[]{4, 19+1});
        firstCell.add(new int[]{3, 19+1});
        firstCell.add(new int[]{5, 20+1});
        firstCell.add(new int[]{4, 20+1});
        firstCell.add(new int[]{3, 20+1});
        firstCell.add(new int[]{2, 21+1});
        firstCell.add(new int[]{6, 21+1});
        firstCell.add(new int[]{2, 23+1});
        firstCell.add(new int[]{1, 23+1});
        firstCell.add(new int[]{6, 23+1});
        firstCell.add(new int[]{7, 23+1});

        //firstCell.add(new int[]{8,9});
        //firstCell.add(new int[]{8,10});
        //Throw an ERROR firstCell.add(new int[]{3,-2});


       // frame.getContentPane().add(grid);
        grid.initFirstCells(firstCell);
        dpgrid = new DisplayGrid(grid);
        nexGen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                newGen(dpgrid.grid);
            }
        });
        nexGen.setBounds(600, 10, 90, 60);
        nexGen.setText("Next Gen");
        nexGen.setVisible(true);
        frame.add(nexGen);
        //dpgrid.setLocation( 150, 10);
        frame.getContentPane().add(dpgrid);
        frame.setVisible(true);
        grid.printGrid();
        game(dpgrid.grid);
        //System.out.println(game.exiteOneCellAlive());

       // System.out.println(1 + 2);

    }

    private static void game(Grid game) throws InterruptedException {

        while(game.exiteOneCellAlive()) {
            Thread.sleep(100);
            newGen(game);
        }

    }

    public static void newGen(Grid game){
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
                            //System.out.println("la cellule "+"{" + i +", "+ j +"}"+  "cellule vivante "+ "{"+y + ","+x+ "}"  );
                            //System.out.println("{"+ i  + ","+ j + "}" + "nombre de cellule vivant" +  numberCellAlive);
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
        dpgrid.repaint();
    }

}