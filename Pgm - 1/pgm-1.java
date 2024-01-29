import java.util.*;

class Student{
    String name, usn, dept;
    char section;
    double cgpa;
    
    Student(String name, String usn, String dept, char section, double cgpa){
        this.name = name;
        this.usn = usn;
        this.dept = dept;
        this.section = section;
        this.cgpa = cgpa;
    }
    
    public String toString(){
        return name + "\t" + usn + "\t" + dept + "\t" + section + "\t" +cgpa;
    }
}
class Main {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("Anirudh", "IS018", "ISE", 'A', 9.31));
        list.add(new Student("Amith", "IS017", "ISE", 'C', 9.01));
        list.add(new Student("Likhith", "IS033", "CSE", 'A', 9.81));
        list.add(new Student("Sai Bhuvan", "IS001", "ISE", 'C', 9.41));
        
        System.out.println("1");
        Iterator<Student> it = list.iterator();
        while(it.hasNext()){
            Student s = it.next();
            if(s.cgpa > 8.5)
                System.out.println(s);
        }
        
        System.out.println("2");
        Iterator<Student> it1 = list.iterator();
        while(it1.hasNext()){
            Student s = it1.next();
            if(s.section == 'C')
                System.out.println(s);
        }
        
        System.out.println("3");
        Iterator<Student> it2 = list.iterator();
        while(it2.hasNext()){
            Student s = it2.next();
            if(s.dept.compareTo("ISE") == 0)
                System.out.println(s);
        }
        
    }
}
