package com.shushi.spring.blog.common;

import com.shushi.spring.blog.models.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author anhbt 7/10/2018
 * com.shushi.spring.blog.common
 */
public class CommonUtils {
    public static void showString(String... temp) {
        Arrays.stream(temp).forEach((x) -> {
            System.out.println(x + "\t");
        });
    }

    public static boolean checkString(String temp, boolean isSingle, String... a) {
        if (isSingle) {
            return temp != null && !temp.isEmpty();
        }else {
            return !Arrays.stream(a).anyMatch(x->!checkString(x,true));
        }
    }
    public static List<Student> buildStudents() {
        List<Student> students = new ArrayList<Student>();
        if (students.isEmpty()) {
            Student student1 = new Student();
            student1.setId(1001);
            student1.setName("John Smith");
            student1.setGender('M');
            student1.setPercentage(Float.valueOf("80.45"));

            students.add(student1);

            Student student2 = new Student();
            student2.setId(1002);
            student2.setName("Jane Williams");
            student2.setGender('F');
            student2.setPercentage(Float.valueOf("60.25"));

            students.add(student2);
        }

        return students;
    }
}
