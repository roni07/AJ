import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Comparator;

@FunctionalInterface
interface ArithmeticOperation {
    int apply(int a, int b);
}

class Operation {
    public int add(int a, int b){
        return a + b;
    }

    public int sub(int a, int b){
        return a - b;
    }
}
public class Main {

    class StudentComparatorByIdAsc implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return (int)(o1.getId() - o2.getId());
        }
    }


    class StudentComparatorByIdDesc implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return (int)(o2.getId() - o1.getId());
        }
    }

    class StudentComparatorByCgpaAsc implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return (int)(o1.getCgpa() * 100 - o2.getCgpa() * 100);
        }
    }


    public Main(){
        /*
        integerArraySorting();
        stringArraySorting();
        studentArraySorting();*/
        operationsDemo();
    }

    public void integerArraySorting(){
        int array[] = {14, 20, 10, 15, 21, 13, 4};
        System.out.println("Integer Before Sort: "+ Arrays.toString(array));
        Arrays.sort(array);
        System.out.println("Integer After Sort: "+Arrays.toString(array));
        System.out.println("\n");
    }

    public void stringArraySorting(){
        String array[] = {"14", "20", "10", "15", "21", "13", "4"};
        System.out.println("String Before Sort: "+Arrays.toString(array));
        Arrays.sort(array);
        System.out.println("String After Sort: "+Arrays.toString(array));
        System.out.println("\n");
    }

    public void studentArraySorting(){
        Student array[] = {
                new Student(1205, "John", LocalDate.of(1995, Month.APRIL, 12), 3.5),
                new Student(1106, "Sebastian", LocalDate.of(1996, Month.APRIL, 20), 3.78),
                new Student(1207, "Archer", LocalDate.of(1998, Month.APRIL, 25), 3.00),
                new Student(1308, "Shakib", LocalDate.of(2000, Month.APRIL, 9), 3.9)
        };

        for (Student student : array)
            System.out.println("Student Before Sort: "+student);
        System.out.println("\n");
    //    Arrays.sort(array, new StudentComparatorByIdAsc());
    //    Arrays.sort(array, new StudentComparatorByIdDesc());
        /*Lambda Expression (Version 1)
        Arrays.sort(array,
           (Student o1, Student o2) -> {
                return (int) (o2.getCgpa() * 100 - o2.getCgpa() * 100);
            }
        ); */

        /*Lambda Expression (Version 2)
        Arrays.sort(array,
                (o1, o2) -> {
                    return (int) (o2.getCgpa() * 100 - o1.getCgpa() * 100);
                }
        ); */

       /* Lambda Expression (Version 3)
        Arrays.sort(array, (o1, o2) -> (int) (o2.getCgpa() * 100 - o1.getCgpa() * 100));
*/
        // Lambda Expression (Version 4)
        Arrays.sort(array, Comparator.comparing(Student::getCgpa).reversed());

        for (Student student : array)
            System.out.println("Student After Sort: "+student);
    }

    public void operationsDemo() {
         Operation operation = new Operation();
        System.out.println("5 + 5 = " + operation.add(5, 5));

        ArithmeticOperation adder = (a, b) -> a + b;
        System.out.println("Functional Programming v1 5 + 5 = " + adder.apply(5, 5));

        int x = 10;
        int y = 5;
        System.out.println("Functional Programming v2 "+calculate(x, y, (a, b) -> a + b));
        System.out.println("Functional Programming v2 "+calculate(x, y, (a, b) -> a - b));
    }

    public int calculate(int a, int b, ArithmeticOperation operation){
        return operation.apply(a, b);
    }

    public static void main(String[] args) {
        new Main();
    }
}

// Lambda Expression = Anonymous Function