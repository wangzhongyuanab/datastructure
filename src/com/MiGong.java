package com;

/**
 * 迷宫回溯问题
 */
public class MiGong {
    public static void main(String[] args) {
        int map[][]=new int[8][7];

        //使用1表示墙
        //上下所有置为1
        for (int i=0;i<7;i++){
            map[0][i]=1;
            map[7][i]=1;
        }

        //左右置为1
        for (int i=0;i<8;i++){
            map[i][0]=1;
            map[i][6]=1;
        }

        //设置挡板,1表示不能走
        map[3][1]=1;
        map[3][2]=1;
//        map[1][2]=1;
//        map[2][2]=1;

        //输出地图
        for (int i=0;i<8;i++){
            for (int j=0;j<7;j++){
                System.out.print(map[i][j]+"");
            }
            System.out.println();
        }

        //使用递归回溯给小球找路
        setWay2(map,1,1);
        System.out.println("小球走过，并标识过的地图:");
        //输出新的地图，小球走过，并标识过的地图
        for (int i=0;i<8;i++){
            for (int j=0;j<7;j++){
                System.out.print(map[i][j]+"");
            }
            System.out.println();
        }
    }

    /**
     * 使用递归回溯来给小球找路
     *  i,j表示从地图得哪个位置开始出发(1,1)
     *  如果小球能到map【6】【5】则说明通路找到
     *  约定：当map[i][j]为0时表示该点没有走过，当为1时表示墙，当为2时表示通路可以走，当为3时表示该点已经走过，但是走不通
     *  在走迷宫得时候，需要遵守一个策略， 下-》右-》上-》左 如果走不通，再回朔
     * @param map
     * @param i
     * @param j
     * @return  如果找到通路，就返回true，否则就返回false
     */
    public static boolean setWay(int[][] map, int i,int j){
        if (map[6][5]==2){  //通路已经找到
            return true;
        }else {
            if (map[i][j]==0){  //如果当前这个点还没有走过
                map[i][j]=2;        //假定该点开可以走通
                if (setWay(map, i+1, j)){     //向下走
                    return true;
                }else if (setWay(map, i, j+1)){  //向右走
                    return true;
                }else if (setWay(map, i-1, j)){     //向上走
                    return true;
                }else if (setWay(map, i, j-1)){ //向左走
                    return true;
                }else {
                    //说明该点是走不通的
                    map[i][j]=3;
                    return false;
                }
            }else { //如果map[i][j]！=0，可能是1，2，3
                return false;
            }
        }
    }


    /**
     * 修改找路的策略，改成上-》右-》下-》左
     * @param map
     * @param i
     * @param j
     * @return
     */
    public static boolean setWay2(int[][] map, int i,int j){
        if (map[6][5]==2){  //通路已经找到
            return true;
        }else {
            if (map[i][j]==0){  //如果当前这个点还没有走过
                map[i][j]=2;        //假定该点开可以走通
               // 上-》右-》下-》左
                if (setWay2(map, i-1, j)){     //向上走
                    return true;
                }else if (setWay2(map, i, j+1)){  //向右走
                    return true;
                }else if (setWay2(map, i+1, j)){     //向下走
                    return true;
                }else if (setWay2(map, i, j-1)){ //向左走
                    return true;
                }else {
                    //说明该点是走不通的
                    map[i][j]=3;
                    return false;
                }
            }else { //如果map[i][j]！=0，可能是1，2，3
                return false;
            }
        }
    }
}
