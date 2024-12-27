public class Student extends Person {
    private java.util.List<Integer> grades;

    public Student(String name, String surname, int age, boolean gender) {
        super(name, surname, age, gender);
        this.grades = new java.util.ArrayList<>();
    }

    public void addGrade(int grade) {
        if (grade >= 0 && grade <= 100) grades.add(grade);
    }

    public double calculateGPA() {
        return grades.stream().mapToDouble(this::convertGradeToGPA).average().orElse(0.0);
    }

    private double convertGradeToGPA(int grade) {
        return grade >= 90 ? 4.0 : grade >= 80 ? 3.0 : grade >= 70 ? 2.0 : grade >= 60 ? 1.0 : 0.0;
    }

    @Override
    public String toString() {
        return super.toString() + " GPA: " + String.format("%.1f", calculateGPA());
    }
}

