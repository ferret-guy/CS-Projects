//import Thread;
public class test{
    public static void main(String[] args) {
        Proj11Board board = new Proj11Board();
        //System.out.println(""+(9/5));
        //board.addOne();
        //board.addOne();
        //board.draw();
        //System.out.println(board.shiftDown()+"");
        //board.shiftLeft();
        board.collapseDown();
        board.draw();
    }
}