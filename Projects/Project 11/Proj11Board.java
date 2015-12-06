import java.util.Arrays;
import java.util.Random;

public class Proj11Board{
    private int[][] board = new int[4][4];
    private Random rand = new Random();

    //Defition for fixed size board
    public Proj11Board(){
        this.board = new int[4][4];
        this.board[3][0] = 4;
        this.board[3][1] = 2;
        this.board[3][2] = 2;
        this.board[3][3] = 2;
        this.board[2][0] = 4;
        this.board[2][1] = 4;
        this.board[2][2] = 2;
        this.board[1][0] = 2;
        this.board[1][2] = 4;
        this.board[0][0] = 2;
    }
    
    //Defition for varibal sized board
    public Proj11Board(int size){
        this.board = new int[size][size];
    }
    
    public String toString(){
        return Arrays.deepToString(this.board);
    }
    
    public void draw(){
        StdDraw.clear();
        //Draw stuff
        StdDraw.setCanvasSize(255,255);
        StdDraw.setScale(0,255);
        StdDraw.setYscale(255,0);
        for(int y = 0; y < this.board.length; y++){
            //Draw Horisontal lines
            StdDraw.line(0 , (255/(this.board.length))*y, 255, (255/(this.board.length))*y);
            //Draw Vertical Lines
            StdDraw.line((255/(this.board.length))*y, 0, (255/(this.board.length))*y, 255);
            //Draw numbers
            for(int x = 0; x < this.board.length; x++){
                StdDraw.text((255/(this.board.length))*x+(255/(this.board.length)/2), 
                             (255/(this.board.length))*y+(255/(this.board.length)/2), 
                             String.valueOf(this.board[y][x]));
            }
        }
    }
    
    public void addOne(){
        for (int y = 0; y < this.board.length; y++){
            for (int x = 0; x < this.board.length; x++){
                if (this.board[y][x] == 0){
                    while(true){
                        int i = rand.nextInt(this.board.length*this.board.length);
                        if (this.board[i/this.board.length][i % this.board.length] == 0){
                            if (rand.nextInt(4) == 3){
                                this.board[i/this.board.length][i % this.board.length] = 2;
                                return;
                            }
                            this.board[i/this.board.length][i % this.board.length] = 1;
                            return;
                        }
                    }
                }
            }
        }
    }
    
    public boolean shiftLeft(){
        boolean change = false;
        for (int y = 0; y < this.board.length; y++){
            int[] row = new int[this.board.length];
            int index = 0;
            for (int x = 0; x < this.board.length; x++){
                if (this.board[y][x] != 0){
                    row[index] = this.board[y][x];
                    index++;
                }
            }
            if (!Arrays.equals(this.board[y],row)){
                System.out.println(Arrays.toString(this.board[y])+"\n"+Arrays.toString(row));
                this.board[y] = row;
                change = true;
            }
        }
        return change;
    }
    
    public boolean shiftRight(){
        boolean change = false;
        for (int y = 0; y < this.board.length; y++){
            int[] row = new int[this.board.length];
            int index = this.board.length-1;
            for (int x = this.board.length - 1; x >= 0; x--){
                if (this.board[y][x] != 0){
                    row[index] = this.board[y][x];
                    index--;
                }
            }
            if (!Arrays.equals(this.board[y],row)){
                System.out.println(Arrays.toString(this.board[y])+"\n"+Arrays.toString(row));
                this.board[y] = row;
                change = true;
            }
        }
        return change;
    }
    
    public boolean shiftUp(){
        boolean change = false;
        for (int x = 0; x < this.board.length; x++){
            int[] col = new int[this.board.length];
            int index = 0;
            int[] bor_col = new int[this.board.length];
            for (int y = 0; y < this.board.length; y++){
                if (this.board[y][x] != 0){
                    bor_col[y] = this.board[y][x];
                    col[index] = this.board[y][x];
                    index++;
                }
            }
            if (!Arrays.equals(bor_col,col)){
                System.out.println(Arrays.toString(bor_col)+"\n"+Arrays.toString(col));
                for (int y = 0; y < this.board.length; y++){
                    this.board[y][x] = col[y];
                }
                change = true;
            }
        }
        return change;
    }
    
    public boolean shiftDown(){
        boolean change = false;
        for (int x = 0; x < this.board.length; x++){
            int[] col = new int[this.board.length];
            int index = this.board.length - 1;
            int[] bor_col = new int[this.board.length];
            for (int y = this.board.length - 1; y >= 0; y--){
                if (this.board[y][x] != 0){
                    bor_col[y] = this.board[y][x];
                    col[index] = this.board[y][x];
                    index--;
                }
            }
            if (!Arrays.equals(bor_col,col)){
                System.out.println(Arrays.toString(bor_col)+"\n"+Arrays.toString(col));
                for (int y = this.board.length - 1; y >= 0; y--){
                    this.board[y][x] = col[y];
                }
                change = true;
            }
        }
        return change;
    }
    
    public boolean collapseLeft(){
        boolean change = false;
        for (int y = 0; y < this.board.length; y++){
            int x = 0;
            while (x < this.board.length-1){
                if (this.board[y][x] == this.board[y][x+1]){
                    this.board[y][x] = this.board[y][x]*2;
                    this.board[y][x+1] = 0;
                    change = true;
                    x += 2;
                }
                else {
                    x++;
                }
            }
        }
        shiftLeft();
        return change;
    }
    
    public boolean collapseRight(){
        boolean change = false;
        for (int y = 0; y < this.board.length; y++){
            int x = this.board.length - 1;
            while (x > 0){
                if (this.board[y][x] == this.board[y][x-1]){
                    this.board[y][x] = this.board[y][x]*2;
                    this.board[y][x-1] = 0;
                    change = true;
                    x -= 2;
                }
                else {
                    x--;
                }
            }
        }
        shiftRight();
        return change;
    }
    
    public boolean collapseUp(){
        boolean change = false;
        for (int x = 0; x < this.board.length; x++){
            int y = this.board.length - 1;
            while (y > 0){
                if (this.board[y][x] == this.board[y-1][x]){
                    this.board[y][x] = this.board[y][x]*2;
                    this.board[y-1][x] = 0;
                    change = true;
                    y -= 2;
                }
                else {
                    y--;
                }
            }
        }
        shiftUp();
        return change;
    }
    
    public boolean collapseDown(){
                boolean change = false;
        for (int x = 0; x < this.board.length; x++){
            int y = 0;
            while (y < this.board.length - 1){
                if (this.board[y][x] == this.board[y+1][x]){
                    this.board[y][x] = this.board[y][x]*2;
                    this.board[y+1][x] = 0;
                    change = true;
                    y += 2;
                }
                else {
                    y++;
                }
            }
        }
        shiftDown();
        return change;
    }
}