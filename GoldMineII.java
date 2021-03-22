import java.io.*;
import java.util.*;
public class GoldMineII
{
    public static void main(String[]args){
        Scanner s=new Scanner(System.in);
        int r=s.nextInt();
        int c=s.nextInt();
        int [][]arr=new int[r][c];
        for(int i=0;i< arr.length;i++){
            for(int j=0;j< arr[0].length;j++){
                arr[i][j]=s.nextInt();
            }
        }
        getmaxgold(arr);
        System.out.println(max);
    }
    static int max=0;

    public static void getmaxgold(int [][]arr) {
        boolean[][]visited=new boolean[arr.length][arr[0].length];  //marking whether visted or not
        for (int i=0;i<arr.length;i++){               //checking each and every shell of row
            for (int j=0;j<arr[0].length;j++){        //checking each and every shell of columns
                if(arr[i][j]!=0 && visited[i][j]==false){     //whether that shell have 0 or not ;and whether it is visited earlier or not
                ArrayList<Integer>bag=new ArrayList<>();  //if it is not 0 and not visited then created bag
                travelleandcollectgold(arr,i,j,visited,bag); //make function to check each and every row and col

                int sum=0;  //after visiting add all gold present in bag
                for(int val:bag){
                    sum+=val;
                }
                if(sum>max){   //added every value then updated max=0 to sum after evry call
                    max=sum;
                }
                }
            }
        }
    }
    public static void travelleandcollectgold(int [][]arr,int i,int j,boolean[][]visited,ArrayList<Integer>bag)
    {
        //base case shell should be visited once , shell should not have 0 , row and col boundaries
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j]==0 || visited[i][j]==true){
            return;
        }
        //we will travell in every direction
        visited[i][j]=true;
        bag.add(arr[i][j]);
        travelleandcollectgold(arr,i-1,j,visited,bag);//north
        travelleandcollectgold(arr,i,j+1,visited,bag);//east
        travelleandcollectgold(arr,i,j-1,visited,bag);//west
        travelleandcollectgold(arr,i+1,j,visited,bag);//south
    }
}
