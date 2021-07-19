/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symmetryandmidpointcircle;
import java.util.Scanner;
import java.lang.Math;

public class SymmetryAndMidpointCircle {

   
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.println("input x1 : ");
      int X1=input.nextInt();
      System.out.println("input y1 : ");
      int Y1=input.nextInt();
      System.out.println("input x2 : ");
      int X2=input.nextInt();
      System.out.println("input y2 : ");
      int Y2=input.nextInt();
      
      int changedx1=0;
      int changedy1=0;
      int changedx2=0;
      int changedy2=0;
      

     int zone =findZone(X1,Y1,X2,Y2);
     
     
     System.out.println();
     System.out.println();
     System.out.println();
     
     
      changedx1= convertToZoneZeroX(X1,Y1,zone);
      changedy1= convertToZoneZeroY(X1,Y1,zone);
      changedx2= convertToZoneZeroX(X2,Y2,zone);
      changedy2= convertToZoneZeroY(X2,Y2,zone);
      
      
     System.out.println("The Value of coordinate ("+X1+" ,  "+Y1+" ) in zone 0 should be ( "+changedx1 +" , "+changedy1 +" )" );
     System.out.println("The Value of coordinate ("+X2+" ,  "+Y2+" ) in zone 0 should be ( "+changedx2 +" , "+changedy2 +" )" );
    
     
     System.out.println();
     System.out.println();
     System.out.println();
     
     
     DDA(changedx1,changedy1,changedx2,changedy2,zone);
      
    }
    
    
    public static int findZone(int x1,int y1, int x2, int y2){
        int dx = x2-x1;
        int dy = y2 - y1;
        int absdx=Math.abs(dx);
        int absdy=Math.abs(dy);
        
        if(dx > 0 && dy >0){
            if(absdx>absdy){
                System.out.println("Zone = 0");
                return 0;
            }
            else{
               System.out.println("Zone = 1");
               return 1;
            }
        }
        
        else if(dx < 0 && dy >0){
            if(absdx<absdy){
                System.out.println("Zone = 2");
                return 2;
            }
            else{
               System.out.println("Zone = 3");
               return 3;
            }
        }
        
        
        else if(dx < 0 && dy <0){
            if(absdx>absdy){
                System.out.println("Zone = 4");
                return 4;
            }
            else{
               System.out.println("Zone = 5");
               return 5;
            }
        }
        
        
        else if(dx > 0 && dy <0){
            if(absdx>absdy){
                System.out.println("Zone = 7");
                return 7;
            }
            else{
               System.out.println("Zone = 6");
               return 6;
            }
        }
        
        return 10;
    }
    
    
     public static int convertToZoneZeroX(int x1,int y1,int zone){
     if(zone == 0 || zone == 7){
         x1=x1;
         return x1;
     }    
     else if(zone == 1 || zone == 6){
         x1=y1;
         return x1;
     }    
     else if(zone == 2 || zone == 5){
         x1=-y1;
         return x1;
     }    
     else if(zone == 3 || zone == 4){
         x1=-x1;
         return x1;
     }    
     
     
     
     
     return 0;
     }
     
     
     public static int convertToZoneZeroY(int x1,int y1,int zone){
     if(zone == 0 || zone == 3){
         y1=y1;
         return y1;
     }    
     else if(zone == 1 || zone ==2){
         y1=x1;
         return y1;
     }    
         
       
     else if(zone == 4 || zone == 7){
         y1=-y1;
         return y1;
     }    
     else if(zone == 5 || zone == 6){
         y1=-x1;
         return y1;
     }    
             
     return 0;
     }
     
     
     
     
     public static void DDA( int x1,int y1,int x2,int y2,int zone){
      
      float delx=x2-x1;
      float dely=y2-y1;
      float m = (dely/delx);
      float step=Math.max(delx, dely);
      step=Math.abs(step);
      float[] x = new float[(int)step+1]; 
      float[] y = new float[(int)step+1]; 
      
      if(m > 1){
          x[0] = x1;
          y[0] = y1;
      for(int l=1 ; l<x.length;l++){
          x[l] = x[l-1] + (1/m);
          y[l] = y[l-1] + 1;
          
      }
      for(int p=0;p<x.length;p++){
          float rest = x[p]/(int)x[p];
          if(rest>0.500 ){
              x[p] = x[p]+1;
          }
          else{
              x[p]=(int)x[p];
          }
          
      }
      
      }
      
      
      else{
           x[0] = x1;
          y[0] = y1;
      for(int l=1 ; l<x.length;l++){
          y[l] = y[l-1] + m;
          x[l] = x[l-1] + 1;
          
      }
      for(int p=0;p<y.length;p++){
          float rest = y[p]/(int)y[p];
          if(rest>0.5 ){
              y[p] = y[p];
          }
          else{
              y[p]=(int)y[p];
          }
          
      }
      }
      
      
    
    
     System.out.println("The DDL value at ZONE 0  are : ");
 for(int s=0;s<x.length;s++){
         System.out.println(" ( "+x[s] +" , "+(y[s])+" )");
      }
 System.out.println();
 System.out.println();
 System.out.println();
 System.out.println();
 System.out.println("Their original value at their point are : ");
 if(zone == 0){
      for(int s=0;s<x.length;s++){
         System.out.println(" ( "+x[s] +" , "+y[s]+" )");
      }
 }
 if(zone == 1){
      for(int s=0;s<x.length;s++){
         System.out.println(" ( "+y[s]+"," +x[s] + ")");
      }
 }
 if(zone == 2){
      for(int s=0;s<x.length;s++){
         System.out.println(" ( "+y[s]+"," +(-x[s]) + ")");
      }
 }
 if(zone == 3){
      for(int s=0;s<x.length;s++){
         System.out.println(" ( "+(-x[s]) +" , "+y[s]+" )");
      }
 }
 if(zone == 4){
      for(int s=0;s<x.length;s++){
         System.out.println(" ( "+(-x[s]) +" , "+(-y[s])+" )");
      }
 }
 if(zone == 5){
      for(int s=0;s<x.length;s++){
         System.out.println(" ( "+(-y[s])+"," +(-x[s]) + ")");
      }
 }
 if(zone == 6){
      for(int s=0;s<x.length;s++){
         System.out.println(" ( "+(-y[s])+"," +x[s] + ")");
      }
 }
 if(zone == 7){
      for(int s=0;s<x.length;s++){
         System.out.println(" ( "+x[s] +" , "+(-y[s])+" )");
      }
 }

 
    
    
    
    }
    
}
