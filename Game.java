/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Start extends JFrame implements ActionListener{
    JButton btn[]=new JButton[25];
    int b[][]=new int[5][5];
    int ar[][]={{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,0}};
    int main[]={0,24,23,22,21,20,7,8,9,16,15,12,13,14,11,10,17,18,19,6,5,4,3,2,1};
    Container c;
    ArrayList<Integer> arr=new ArrayList<>();
    GridLayout g=new GridLayout(5,5);
    Random rand=new Random();
    int a=1;
    int d=0;
    int k=0;
    int l=0;
    public Start(){
        c=this.getContentPane();
        c.setLayout(g);
        c.setBounds(500,500,50,50);
        btn[0]=new JButton();
        btn[0].setVisible(false);
        btn[0].addActionListener(this);
        //btn[0].setSize(20,20);
        c.add(btn[0]);
        for (int i = 1; i < 25; i++) {
            /*while(true){
                a=rand.nextInt(23)+1;
                System.out.println(a);
                if(arr.contains(a))
                    continue;
                else{
                    arr.add(a);
                    System.out.println(arr);
                    break;
                }
                    
            }*/
            btn[i]=new JButton(Integer.toString(main[i]));
            //btn[i].setSize(20,20);
            btn[i].addActionListener(this);
            c.add(btn[i]);
            
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                b[i][j]=d;
                d++;
            }
        }
  
    }
    @Override
    public void actionPerformed(ActionEvent e){
        int c;
        int d=0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if((e.getSource()==btn[b[i][j]])){
                    c=check(b,i,j);
                    if(c!=-1){
                        String str=btn[b[i][j]].getText();
                        String s=btn[c].getText();
                        btn[c].setVisible(true);
                        btn[c].setText(str);
                        btn[b[i][j]].setVisible(false);
                        btn[b[i][j]].setText(s);
                        d=1;
                        break;
                    }
                }
            }
            if(d!=0)
                break;
        }
        //check for end of game
        if(btn[18].getText().equals(Integer.toString(19))&&
           btn[19].getText().equals(Integer.toString(20))&&
           btn[23].getText().equals(Integer.toString(24))&&
           btn[19].getText().equals(Integer.toString(0))){
            for (int i = 0; i < 5; i++) {
                System.out.println("hi");
                for (int j = 0; j < 5; j++) {
                    if(ar[i][j]==(Integer.parseInt(btn[k].getText())))
                        k++;
                    else{
                        l++;
                        k=0;
                        break;
                    }
                }
                if(l!=0)
                    break;
            }
            if(k==25){
                for (int i = 0; i < 25; i++) {
                    btn[i].setBackground(Color.green);
                }
            }
        }
        
    }
    public int check(int[][] b,int i,int j){
        int ret=-1;
        if(i>=0 && i<=4 && j-1>=0 && j-1<=4 && !btn[b[i][j-1]].isVisible())
            ret=b[i][j-1];
        if(i>=0 && i<=4 && j+1>=0 && j+1<=4 && !btn[b[i][j+1]].isVisible())
            ret=b[i][j+1];
        if(i-1>=0 && i-1<=4 && j>=0 && j<=4 && !btn[b[i-1][j]].isVisible())
            ret=b[i-1][j];
        if(i+1>=0 && i+1<=4 && j>=0 && j<=4 && !btn[b[i+1][j]].isVisible())
            ret=b[i+1][j];
        return ret;
    }
}
public class Game{

    public static void main(String[] args) {
        // TODO code application logic here
        Start frame=new Start();
        frame.setVisible(true);
        frame.setBounds(100,100,500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}
