import java.util.*;   
class Item{ 
    int wei,prof; 
    double rato; 
    Item(int wei,int prof){ 
        this.wei=wei; 
        this.prof=prof; 
        this.rato=(double) prof/wei;
    }
} 
public class greedys{  
    public static double getmaxp(Item[] item,int m){  
        Arrays.sort(item, (a,b) -> Double.compare(b.rato, a.rato)); 
        double maxpro =0.0; 
        System.out.println("fill the bag"); 
        for(Item iteem : item){
            if(iteem.wei<= m){  
                maxpro+=iteem.prof; 
                System.out.println("item weight :"+ iteem.wei+" profit"+iteem.prof); 
                m=m-iteem.wei; 


            } 
            else{ 
                double fra = (double) m/iteem.wei; 
                maxpro = maxpro + iteem.prof*fra; 
                break;
            }
        } 

    return maxpro;
    
}
    public static void main(String[] args) { 
        int m=15;
        Item[] item ={ new Item(2,10), new Item(3,5), new Item(5,15),new Item(7,7),new Item(1,6),new Item(4,18),new Item(1,3)}; 
        double maxp= getmaxp(item,m);  
        System.out.println("max weight"+maxp);

        }
    }


