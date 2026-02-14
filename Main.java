
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        //Hard Code two values for testing pupose
        students.add(new Student(1, "Paul", "75"));
        students.add(new Student(2, "peter", "65"));

        Dao studentDao = new Dao(students);
        Scanner sc = new Scanner(System.in);
        System.out.println("************************");
        System.out.println("*Student Records Center*");
        System.out.println("************************");

        boolean flag = true;
        while (flag) {
            System.out.println("------------------------------");
            System.out.println("Enter a choice ");
            System.out.println("1.To add Student ");
            System.out.println("2.To view Student details ");
            System.out.println("3.To view all Students details ");
            System.out.println("4.To update Student details ");
            System.out.println("5.To delete Student details ");
            System.out.println("6. TO EXIT !! ");
            System.out.println("------------------------------");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the student details (id , name and marks using enter)");
                    int studentid = sc.nextInt();
                    String studentName = sc.next();
                    String studentMarks = sc.next();
                    studentDao.addStudent(studentid, studentName, studentMarks);
                    break;
                case 2:
                    System.out.println("Enter student id ");
                    int studentid1 = sc.nextInt();
                    Student s1 = studentDao.getStudent(studentid1);
                    if (s1 == null) {
                        System.out.println("No Such Student Exists");
                    } else {
                        System.out.println(s1);
                    }

                    break;
                case 3:
                    ArrayList<Student> susers = studentDao.getStudents();
                    for (Student suser : susers) {
                        System.out.println(suser);
                    }

                    break;
                case 4:
                    System.out.println("Enter id of student to update");
                    int sid = sc.nextInt();
                    System.out.println("Enter name and marks to Update");
                    String sname = sc.next();
                    String smarks = sc.next();
                    Student updatedStudent = studentDao.updateStudent(sid, sname, smarks);
                    if (updatedStudent == null) {
                        System.out.println("Enter Valid Id");
                    } else {
                        System.out.println(updatedStudent);
                    }

                    break;
                case 5:
                    System.out.println("Enter id of student to update");
                    int student_id = sc.nextInt();
                    ArrayList<Student> listStudents = studentDao.deleteStudent(student_id);
                    if (listStudents == null) {
                        System.out.println("Enter Valid Id");
                    } else {
                        for (Student list : listStudents) {
                            System.out.println(list);
                        }

                    }

                    break;
                case 6:
                    flag = false;

                    break;

                default:
                    System.out.println("Please Enter valid choice");
                    break;
            }

        }

        System.out.println("Thanks for your time !!");

    }

}
