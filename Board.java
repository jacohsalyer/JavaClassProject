import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Board{
	
	private int[][] board;
	private int size;
	
	public Board(int size){
		
		this.size = size;
		board = new int[size][size];
		placeShips();
	}
	
	public void placeShips(){
		int[] ship1 = {1,1,1,1,1};
		int[] ship2 = {1,1,1,1};
		int[] ship3 = {1,1,1};
		int[] ship4 = {1,1};
		int[] ship5 = {1};	
			
		List<int[]> ships = new ArrayList<int[]>();
		ships.add(ship1);
		ships.add(ship2);
		ships.add(ship3);
		ships.add(ship4);
		ships.add(ship5);
		
		while (ships.size() >= 0){
			for (int i = 0; i < size; i ++){
				for (int j = 0; j < size; j ++){
					if ( (int) ((Math.random()) * 100) + 1 == 1){
						try{
							putShip(i, j, ships.get(0), "horizontal");
							ships.remove(0);
						}catch(IndexOutOfBoundsException e){
							System.out.println("no");
						}
					}
				}
			}
		}
	}
		
	public void putShip(int x, int y, int[] ship, String orientation){
		if (orientation.equals("vertical")){
			for (int i = 0; i < ship.length; i ++){
				board[x][y + i] = ship[i];
			}
		}
		else{
			for (int i = 0; i < ship.length; i ++){
				board[x + i][y] = ship[i];
			}
		}
	}
	



	public static void main(String [] args){
		Board b = new Board(10);
		for (int i = 0; i < 10; i ++){
			System.out.println(Arrays.toString(b.board[i]));
		}
		
	}
	
	
	
	
}