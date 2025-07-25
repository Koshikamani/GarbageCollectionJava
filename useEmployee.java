class Employee{
    private int Id;
    private String name;
    private int age;
    private static int nextId=1;

    public Employee(String name,int age){
        this.name=name;
        this.age=age;
        this.Id=nextId++;
    }
    public void show(){
        System.out.println("Id:"+Id+"\nName:"+name+"\n age:"+age);
    }
    public void showNextId(){
        System.out.println("next employee id is:"+nextId);
    }
    protected void finalize(){
        --nextId;
    }

}

public class useEmployee{
    public static void main(String[] args) {
        Employee a=new Employee("ram", 20);
        Employee b=new Employee("shyam", 21);
        Employee c=new Employee("randheer", 22);

        a.show();
         b.show();
        c.show();

        a.showNextId();
         b.showNextId();
        c.showNextId();

        {
            //interns


            Employee m=new Employee("dhruv", 23);
             Employee n=new Employee("ravan", 23);
             m.show();
             n.show();

             m.showNextId();
             n.showNextId();

             m=n=null;

             System.gc();
             System.runFinalization();

        }
        a.showNextId();
        }


        
    }
