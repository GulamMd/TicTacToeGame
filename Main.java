import java.lang.String;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Main {

	static ArrayList<Integer> al1=new ArrayList<Integer>();
	static ArrayList<Integer> al2=new ArrayList<Integer>();

	public static void main(String[] args){
		System.out.println("WELCOME TO TIC TAC TOE");
		System.out.println("    by Gulam Md");

		char [][] gameBoard={
				{' ','+','-','+','-','+','-','+'},
				{' ','|',' ','|',' ','|',' ','|'},
				{' ','+','-','+','-','+','-','+'},
				{' ','|',' ','|',' ','|',' ','|'},
				{' ','+','-','+','-','+','-','+'},
				{' ','|',' ','|',' ','|',' ','|'},
				{' ','+','-','+','-','+','-','+'}
		};

		printboard(gameBoard);
		Scanner sc=new Scanner(System.in);
		while(true){
			System.out.println("Enter the Position for PLAYER 1(X)");
			int pos=sc.nextInt();
			while(al1.contains(pos)||al2.contains(al1)){
				System.out.println("Postion taken please enter correct pos");
				pos=sc.nextInt();
			}
			placePiece(gameBoard,pos,"Player1");
			String whoWin= checkWinner();
			if(whoWin.length()>0){
				System.out.println(whoWin);
				break;
			}
			System.out.println("Enter the position for PLAYER 2(O)");
			int pos2=sc.nextInt();
			while(al2.contains(pos2)||al1.contains(al2)){
				System.out.println("Postion taken please enter correct pos");
				pos2=sc.nextInt();
			}
			placePiece(gameBoard,pos2,"Player2");

			whoWin=checkWinner();
			if(whoWin.length()>0){
				System.out.println(whoWin);
				break;
			}

		}

	}
	public static void printboard(char[][]gameBoard){
		for(int i=0;i< gameBoard.length;i++){
			for(int j=0;j<gameBoard[i].length;j++){
				System.out.print(" "+gameBoard[i][j]);
			}
			System.out.println("");
		}
	}

	public static void placePiece(char[][]gameBoard,int pos,String user){
		char symbol=' ';
		if(user.equals("Player1")){
			symbol='X';
			al1.add(pos);
		}
		else{
			symbol='O';
			al2.add(pos);
		}
		switch (pos){
			case 1:gameBoard[1][2]=symbol;
			break;
			case 2:gameBoard[1][4]=symbol;
			break;
			case 3:gameBoard[1][6]=symbol;
			break;
			case 4:gameBoard[3][2]=symbol;
			break;
			case 5:gameBoard[3][4]=symbol;
			break;
			case 6:gameBoard[3][6]=symbol;
			break;
			case 7:gameBoard[5][2]=symbol;
			break;
			case 8:gameBoard[5][4]=symbol;
			break;
			case 9:gameBoard[5][6]=symbol;
			break;

			default:System.out.println("Enter Proper choice");
		}
		printboard(gameBoard);
	}
	public static String checkWinner(){
		List top =Arrays.asList(1,2,3);
		List mid =Arrays.asList(4,5,6);
		List bot =Arrays.asList(7,8,9);
		List left =Arrays.asList(1,4,7);
		List midc=Arrays.asList(2,5,8);
		List right =Arrays.asList(3,6,9);
		List c1 =Arrays.asList(1,5,9);
		List c2 =Arrays.asList(3,5,9);
		List<List> winner =new ArrayList<List>();
		winner.add(top);
		winner.add(mid);
		winner.add(bot);
		winner.add(left);
		winner.add(midc);
		winner.add(right);
		winner.add(c1);
		winner.add(c2);
		for(List l:winner){
			if(al1.containsAll(l)){
				return "Player 1 WIN";
			}
			else if(al2.containsAll(l)){
				return "Player 2 WIN";
			}
			else if(al1.size()+al2.size()==9){
				return "TIE";
			}
		}
		return "";
	}


}
