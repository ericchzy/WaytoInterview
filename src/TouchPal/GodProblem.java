package TouchPal;

import java.util.Scanner;

public class GodProblem {
/*    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();  // heigth for axis=0
        int width = sc.nextInt();  // width for axis=1
        int waterLevel = sc.nextInt();
        int[][] altitude = new int[height][width];
        boolean[][] floodMarked = new boolean[height][width];
        int ans = 0, x;

        System.out.println("height: " + height + "width: " + width + "waterLevel: " + waterLevel);

        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                altitude[i][j] = sc.nextInt();
                if (waterLevel > altitude[i][j]) {
                    floodMarked[i][j] = true;
                } else {
                    floodMarked[i][j] = false;
                }
            }
        }

        process2(altitude, floodMarked, height, width);

    }

    // Check whether there is loop in `floodMarked` matrix
    public static void process2(int[][] altitude, boolean[][] floodMarked, int height, int width) {
        // The bowl shape is constructed by at least 3x3 in each dimension
        if (height < 3 || width < 3) {
            System.out.println("0");
        }

        boolean[] canGoDownPostionInLine = new boolean[width];
        Stack<Integer> canGoDownPostionInLineStack = new Stack<Integer>();

        // We can stop early for the last 3 elements
        for (int i = 0; i < (height - 3); i++) {
            for (int jForWidth = 0; jForWidth < width; jForWidth++) {

                int goDown = i + 1;
                if (floodMarked[goDown][jForWidth]) {
                    canGoDownPostionInLine[i] = true; // Forward
                    canGoDownPostionInLineStack.add(jForWidth);
                }
            }

            // We try to go down when position in line is permitted
            int currentjForWidth = canGoDownPostionInLineStack.pop();

        }
    }*/

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int height=in.nextInt();
        int width=in.nextInt();
        int waterLevel=in.nextInt();
        int [][]map=new int[height][width];
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                map[i][j]=in.nextInt();
            }
        }
        boolean [][]isVisited=new boolean[height][width];

        //处理洪水从地图的四周开始涨起
        for(int i=0;i<height;i++){
            if(!isVisited[i][0])
                dfs(map,isVisited,i,0,waterLevel);
            if(!isVisited[i][width-1])
                dfs(map,isVisited,i,width-1,waterLevel);
        }
        for(int j=1;j<width-1;j++){
            if(!isVisited[0][j])
                dfs(map,isVisited,0,j,waterLevel);
            if(!isVisited[height-1][j])
                dfs(map,isVisited,height-1,j,waterLevel);
        }
        int countExist=0;
        for(int i=0;i<height;i++)
            for(int j=0;j<width;j++)
                if(map[i][j]!=0) countExist++;
        System.out.println(countExist);
        in.close();
    }

    //对一个位置的四个方向分别进行深度优先搜索
    private static void dfs(int [][]map,boolean [][]isVisited,int i,int j,int waterLevel){
        if(i<0||i>=map.length||j<0||j>=map[0].length||isVisited[i][j]) return ;
        isVisited[i][j]=true;
        if(waterLevel<map[i][j]) return ;
        else map[i][j]=0;  //将其摧毁
        dfs(map,isVisited,i+1,j,waterLevel);
        dfs(map,isVisited,i-1,j,waterLevel);
        dfs(map,isVisited,i,j+1,waterLevel);
        dfs(map,isVisited,i,j-1,waterLevel);
    }
}

/* Output:
3 3 3
5 5 5
5 1 5
5 1 1
输出： 6
 *///:~