package Lesson9;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HomeWork9 {

    public static void main (String[] args){


        List<Students> result = getStudentsList (3,3);

        //1 задание
        result.stream().flatMap(student -> student.getCourseList().stream()).distinct().collect(Collectors.toList());
        result.stream().flatMap(student -> student.getCourseList().stream()).collect(Collectors.toSet());

        //2 задание
        result.stream().sorted((student1,student2) -> student1.getCourseList().size() - student2.getCourseList().size()).limit(3).collect(Collectors.toList());

        //3 задание
        Course course = new Course("Course1");
        result.stream().filter(student -> student.getCourseList().contains(course)).collect(Collectors.toList());

        System.out.println();

    }



    private static List<Students> getStudentsList (int j, int m){
        ArrayList<Students> result = new ArrayList<>();
        for (int i=0; i<j ;i++){
            ArrayList<Course>courses = new ArrayList<>();
            for (int h=0; h<m ;h++){
                courses.add(new Course("Course"+h));
            }
            result.add(new Students("Student"+i, courses));
        }
        return result;
    }
}


