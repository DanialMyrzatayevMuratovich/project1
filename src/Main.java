
import java.io.File; // Для работы с файлами
import java.util.Scanner; // Для чтения файлов

public class Main {
    public static void main(String[] args) {
        School school = new School();
        loadMembers("students.txt", true, school);
        loadMembers("teachers.txt", false, school);

        school.sortMembersBySurname();
        System.out.println(school);
    }

    private static void loadMembers(String filePath, boolean isStudent, School school) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(filePath));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty()) {
                    String[] data = line.split(" ");
                    if (isStudent) {
                        Student student = parseStudent(data);
                        school.addMember(student);
                    } else {
                        Teacher teacher = parseTeacher(data);
                        school.addMember(teacher);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading file: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    private static Student parseStudent(String[] data) {
        String name = data[0];
        String surname = data[1];
        int age = Integer.parseInt(data[2]);
        boolean gender = data[3].equalsIgnoreCase("Male");
        Student student = new Student(name, surname, age, gender);
        for (int i = 4; i < data.length; i++) {
            student.addGrade(Integer.parseInt(data[i]));
        }
        return student;
    }

    private static Teacher parseTeacher(String[] data) {
        String name = data[0];
        String surname = data[1];
        int age = Integer.parseInt(data[2]);
        boolean gender = data[3].equalsIgnoreCase("Male");
        String subject = data[4];
        int yearsOfExperience = Integer.parseInt(data[5]);
        int salary = Integer.parseInt(data[6]);
        Teacher teacher = new Teacher(name, surname, age, gender, subject, yearsOfExperience, salary);
        if (yearsOfExperience > 10) teacher.giveRaise(10);
        return teacher;
    }
}
