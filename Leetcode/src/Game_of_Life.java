public class Game_of_Life {
    public void gameOfLife(int[][] board) {

        int n=board.length;
        int m=board[0].length;

        int dx[]={1,-1,0,0,1,1,-1,-1};
        int dy[]={0,0,1,-1,1,-1,-1,1};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) {
                board[i][j]*=10;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int live=0,dead=0;
                for(int z=0;z<8;z++){
                    int x=i+dx[z];
                    int y=j+dy[z];

                    if(x>=0 && x<n && y>=0 && y<m){
                        if(board[x][y]/10==1){
                            live++;
                        }
                        else{
                            dead++;
                        }
                    }
                }

                if(board[i][j]==10){
                    if(live==2 || live ==3 ){
                        board[i][j]=11;
                    }
                    else{
                        board[i][j]=10;
                    }
                }
                else{
                    if(live==3)
                        board[i][j]=01;
                    else{
                        board[i][j]=00;
                    }
                }

            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                board[i][j]%=10;
            }
        }


    }
    public static void main(String []args){
        Game_of_Life g=new Game_of_Life();
        int arr[][]={{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        g.gameOfLife(arr);
    }
}
