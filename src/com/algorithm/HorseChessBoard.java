package com.algorithm;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * 马踏棋盘算法
 */
public class HorseChessBoard {

    private static int X;   //棋盘的列数
    private static int Y;   //棋盘的行数
    private static boolean visited[];       //使用一个数组来保存=
    private static boolean finished;     //是否棋盘的所有位置都被访问


     public static void main(String[] args) {
         System.out.println("骑士周游算法");
        X=8;
        Y=8;
        int row=1;
        int column=1;
        int [][]chessborad=new int[X][Y];
        visited=new boolean[X*Y];       //初始化都是false
         long start = System.currentTimeMillis();
         traversalChessboard(chessborad,row-1,column-1,1);
         long end = System.currentTimeMillis();
         System.out.println("共耗时："+(end-start)+"ms");
         for (int []rows:chessborad){
             for (int step:rows){
                 System.out.print(step+"\t");
             }
             System.out.println();
         }

     }

    /**
     *
     * @param chessborad
     * @param row       行，从0开始
     * @param column    列，从0开始
     * @param step      第几步,初始第1步
     */
    public static void traversalChessboard(int[][] chessborad,int row,int column,int step){
         chessborad[row][column]=step;
         visited[row*X+column]=true;
        ArrayList<Point> ps = next(new Point(column, row));
        //对ps进行排序,排序的规则就是对ps的所有的Point对象的下一步的位置数目，进行非递减排序
        sort(ps);
        while (!ps.isEmpty()){
            Point p = ps.remove(0); //取出下一个可以走的位置
            if (!visited[p.y*X+p.x]){       //还没有被访问过
                traversalChessboard(chessborad,p.y,p.x,step+1);
            }
        }
        //判断马儿是否完成了任务，使用step和应该走的步数比较
        if (step<X*Y&&!finished){
            chessborad[row][column]=0;
            visited[row*X+column]=false;
        }else {
            finished=true;
        }
    }

    /**
     * 根据当前位置，计算马儿还能走哪些位置并放入到一个集合中，最多有8个位置
     * @param curPoint
     * @return
     */
    public static ArrayList<Point> next(Point curPoint) {
        ArrayList<Point> ps=new ArrayList<Point>();
        Point p1=new Point();
        //马儿可以走5这个点
        if ((p1.x=curPoint.x-2)>=0&&(p1.y=curPoint.y-1)>=0){
            ps.add(new Point(p1));
        }
        //马儿可以走6这个点
        if ((p1.x=curPoint.x-1)>=0&&(p1.y=curPoint.y-2)>=0){
            ps.add(new Point(p1));
        }
        //马儿可以走7这个点
        if ((p1.x=curPoint.x+1)<X&&(p1.y=curPoint.y-2)>=0){
            ps.add(new Point(p1));
        }
        //马儿可以走0这个点
        if ((p1.x=curPoint.x+2)<X&&(p1.y=curPoint.y-1)>=0){
            ps.add(new Point(p1));
        }
        //马儿可以走1这个点
        if ((p1.x=curPoint.x+2)<X&&(p1.y=curPoint.y+1)<Y){
            ps.add(new Point(p1));
        }
        //马儿可以走2这个点
        if ((p1.x=curPoint.x+1)<X&&(p1.y=curPoint.y+2)<Y){
            ps.add(new Point(p1));
        }
        //马儿可以走3这个点
        if ((p1.x=curPoint.x-1)>=0&&(p1.y=curPoint.y+2)<Y){
            ps.add(new Point(p1));
        }
        //马儿可以走4这个点
        if ((p1.x=curPoint.x-2)>=0 && (p1.y=curPoint.y+1)<Y){
            ps.add(new Point(p1));
        }
        return ps;
    }

    /**
     * 根据当前这个一步的所有下一步的选择位置,进行非递减排序,减少回溯的次数
     * @param ps
     */
    public static void sort(ArrayList<Point> ps){
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                //获取到01的下一步的所有位置个数
                int count1 = next(o1).size();
                int count2 = next(o2).size();
                if (count1<count2){
                    return -1;
                }else if (count1==count2){
                    return 0;
                }else {
                    return 1;
                }
            }
        });
    }

}
