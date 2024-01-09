import java.util.*;

class Call{
    String name, origin;
    long num;
    
    Call(String name, String origin, long num){
        this.name = name;
        this.origin = origin;
        this.num = num;
    }
}

class Pair{
    String name;
    long num;
    
    Pair(String name, long num){
        this.name = name;
        this.num = num;
    }
}

class CallLog{
    Scanner sc = new Scanner(System.in);
    HashMap<Long, Call> calls = new HashMap<>();
    ArrayList<Pair> mc = new ArrayList<>();
    
    void addNums(){
        Call c1 = new Call("ABC", "India", 123);
        Call c2 = new Call("DEF", "US", 124);
        Call c3 = new Call("GHI", "UK", 125);
        
        calls.put(c1.num, c1);
        calls.put(c2.num, c2);
        calls.put(c3.num, c3);
    }
    
    void addMissedCall(){
        System.out.println("Enter number");
        long n = sc.nextLong();
        
        if(calls.containsKey(n)){
            Call c = calls.get(n);
            mc.add(new Pair(c.name, n));
        }
        else{
            mc.add(new Pair("Private number", n));
        } 
    }
    
    void display(){
        for(Pair p: mc){
            System.out.println("Number: " + p.num + " Name: " + p.name);
        }
    }
    
    void deleteMC(long num){
        for(int i=0; i<mc.size(); i++){
            Pair p = mc.get(i);
            if(p.num == num){
                mc.remove(i);
                System.out.println("Deleted successfully!");
                break;
            }
        }
    }
    
    public static void main(String arg[]){
        CallLog cs = new CallLog();
        cs.addNums();
        
        cs.addMissedCall();
        cs.addMissedCall();
        
        cs.display();
        
        cs.deleteMC(123);
        cs.display();
    }
}
