package Game;

public class Text {
/*

///-\\\ 
|^   ^|  
|O   O|  
|  ~  |  |
 \ O /   |
  | |    |

  */

    public static <T> void print(T a){
        String s = "" + a;
        try{
            for(int i = 0;i< s.length();i++){
                char c = s.charAt(i);
                System.out.print(c);
                if(c == ' '){
                    Thread.sleep(70);
                    continue;
                }
                Thread.sleep(7);
            }
        }
        catch(InterruptedException e){
            System.out.print(s);
        }
    }

    public static <T> void printf(T a){
        String s = "" + a;
        try{
            for(int i = 0;i< s.length();i++){
                char c = s.charAt(i);
                System.out.print(c);
                if(c == ' '){
                    Thread.sleep(70);
                    continue;
                }
                Thread.sleep(7);
            }
        }
        catch(InterruptedException e){
            System.out.print(s);
        }
        System.out.println("");
    }

    public static <T> void facep(T x){
        String s = "" + x;
        String [] m = {
            "///-\\\\\\   ",
            "|^   ^|   ",
            "|O   O|   ",
            "|  ~  |   ",
            " \\ O /    ",
            "  | |     ",
            "          "
        };
        int z = s.length();
        int i,p = 100,y = 0,l = (z%100 == 0)? z/100: (z/100)+1;
        for(i = 0; i< Math.max(7,l);i++){
            if(i < 7){
                System.out.print(m[i]);
            }
            else{
                System.out.print(m[6]);
            }
            String sub = "";
            if(y>z){
                continue;
            }
            else if(y+100 > z){
                sub = s.substring(y,z);
            }
            else{
                p = 100;
                while(s.charAt(y+p) != ' '){
                   p++; 
                }
                sub = s.substring(y,y+p);
            }
            y = y +p;
            Text.printf(sub);
        }
    }

    public static void main(String args[]){
        String a = "In the heart of the ancient forest, where the trees whispered secrets to those who would listen, there was a small, hidden glade. This glade was unlike any other, bathed in perpetual twilight and filled with the fragrance of blooming flowers. A gentle stream meandered through, its waters sparkling like liquid crystal. In this serene sanctuary, creatures of the forest gathered each evening, drawn by the harmonious sounds that filled the air. It was a place where time seemed to stand still, and the worries of the outside world melted away.";
        String b = a+a;
        System.out.println(b);
        printf(b);
        facep(b);
    }
}
