public class Cell {


    boolean state; //vrai cellule vivante,  faux cellule morte

    Cell(boolean b){
        this.state = b;
    }
    public void kill(  ){
        this.state = false;
    }
    public void giveBirth() {
        this.state = true;
    }

}
