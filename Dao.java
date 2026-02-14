import java.util.ArrayList;

public class Dao {
    ArrayList<Student> students;

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public Dao(ArrayList<Student> students) {
        this.students = students;
    }



    public void addStudent(int id , String name, String marks){
       students.add(new Student(id,name,marks));
         System.out.println("Student added succesfully");     
    }

    public Student getStudent(int id){
        ArrayList<Student> s=getStudents();
        for(Student student1 : s){
                if(id==student1.getId()){
                    return student1;
                }
             } 

             return null;
            
    }

   

    public Student updateStudent(int id , String name, String marks){
        Student suser=getStudent(id);
        if(suser==null){
            return null;
        }
        suser.setName(name);
        suser.setMarks(marks);
        return suser;       

    }

    public ArrayList<Student> deleteStudent(int id){
        Student suer=getStudent(id);
        if(suer==null){
            return null;
        }
        this.students.remove(suer);
        return students;
    }


    

}
