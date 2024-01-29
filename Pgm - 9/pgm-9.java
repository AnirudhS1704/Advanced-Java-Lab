import java.util.*;

class Book{
    String title, author, publisher;
    int price;
    
    Book(String title, String author, String publisher, int price){
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
    }
    
    public String toString(){
        return title + "\t" + author + "\t" + publisher + "\t" + price;
    }
}
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("ABC", "IS018", "ISE", 150));
        list.add(new Book("DEF", "IS017", "CSE", 100));
        list.add(new Book("GHI", "IS033", "CSE", 250));
        list.add(new Book("PQR", "IS001", "ISE", 200));
        
        Collections.sort(list, (b1, b2) -> b1.price - b2.price);
        for(Book i: list)
            System.out.println(i);
            
        ArrayList<Book> list1 = new ArrayList<>();
        System.out.println("Enter price range");
        int p = sc.nextInt();
        for(Book i: list){
            if(i.price > p)
                list1.add(i);
            
        }
        
        for(Book i: list1){
            System.out.println(i);
        }
        
        System.out.println("Enter author");
        String a = sc.next();
        for(Book i: list){
            if(i.author.compareTo(a) == 0)
                System.out.println(i);
            
        }
    }
}
