import java.util.Scanner;  
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Task {

  static void returnLadderMoves(int [] moves){
    Scanner sc = new Scanner(System.in); 

    int [] ladder= new int [2];

    int ladNumber ;

    System.out.println("Enter the number of ladders");

    ladNumber = sc.nextInt();

    String [] totalLadder = new String[ladNumber];

    for(int i = 0; i < ladNumber; i++){
        System.out.println("Enter " +  (i+1) +  " ladder start and end coordinates");

        ladder[0] =  sc.nextInt();
        ladder[1] = sc.nextInt();
        
        moves[ladder[0]] = ladder[1];

        totalLadder[i] = Arrays.toString(ladder);
    }      

    System.out.println("Inputted Ladder Coordinates are: " + Arrays.toString(totalLadder));
  }

  static void returnSnakeMoves(int [] moves){
    Scanner sc = new Scanner(System.in); 

    int [] snake= new int [2];

    int snakeNumber ;

    System.out.println("Enter the number of snakes");

    snakeNumber = sc.nextInt();

    String [] totalSnake = new String[snakeNumber];

    for(int i = 0; i < snakeNumber; i++){
        System.out.println("Enter " +  (i+1) +  " snake head and end tail");

        snake[0] =  sc.nextInt();
        snake[1] = sc.nextInt();
        
        moves[snake[0]] = snake[1];

        totalSnake[i] = Arrays.toString(snake);
    }      

    System.out.println("Inputted Snake Coordinates are: " + Arrays.toString(totalSnake));
  }

  static class cell{
    int position;
    int hops;
  }

  static int getMinDiceThrows(int move[], int totalBlocks){
    int visited[] = new int[totalBlocks];
    Queue<cell> q = new LinkedList<>();
    cell firstCell = new cell();
    firstCell.position = 0;
    firstCell.hops = 0;

    visited[0] = 1;
    q.add(firstCell);


    while(!q.isEmpty())
    {
      firstCell = q.remove();
      int index = firstCell.position;

      if(index == totalBlocks - 1)
        break;

      for(int i = index + 1; i <= (index + 6) && i < totalBlocks ; i++ ){
        if(visited[i] == 0){
          cell newCell = new cell();
          newCell.hops = (firstCell.hops+1);
          visited[i] = 1; 

          if(move[i] != -1)
            newCell.position = move[i];
          else
            newCell.position = i;

          q.add(newCell);
        }
      }
    }
    return firstCell.hops;
  }



  public static void main(String[] args) {

    int totalBlocks = 100;

    int [] moves = new int[totalBlocks];

    for( int i=0; i<totalBlocks; i++){
      moves[i] = -1;
    }   

    returnLadderMoves(moves);

    returnSnakeMoves(moves);

    System.out.println("Min Dice throws required is " + getMinDiceThrows(moves,totalBlocks));

  }
}