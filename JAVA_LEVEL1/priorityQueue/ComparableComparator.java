package PEP.JAVA_LEVEL1.priorityQueue;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ComparableComparator {
    static class Student implements Comparable<Student>{
        int roll;
        String name;
        int height;
        int weight;

        Student(int roll , String name , int height , int weight){
            this.roll = roll;
            this.name = name;
            this.height = height;
            this.weight = weight;
        }


        @Override
        public int compareTo(@NotNull ComparableComparator.Student o) {
            return o.roll-this.roll; // positive if this is greater , negative if this is smalller , equal if both are equal
        }

        @Override
        public String toString() {
            return "Student{" +
                    "roll=" + roll +
                    ", name='" + name + '\'' +
                    ", height=" + height +
                    ", weight=" + weight +
                    '}';
        }


    }

    static class StudentHeightComparator implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2) {
            return o2.height - o1.height;
        }
    }

    static class StudentWeightComparator implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2) {
            return o1.weight - o2.weight;
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Student> st = new PriorityQueue<>(new StudentHeightComparator());
        st.add(new Student(23,"Jyotis",180,80));
        st.add(new Student(20,"Binayak",170,100));
        st.add(new Student(15,"Prakash",150,70));
        st.add(new Student(5,"Sankar",185,840));
        st.add(new Student(23,"Aman",1850,850));

        while(!st.isEmpty()){
            System.out.println(st.peek());
            st.remove();
        }
    }
}
