public class School {
    private java.util.List<Person> members;

    public School() {
        members = new java.util.ArrayList<>();
    }

    public void addMember(Person person) {
        members.add(person);
    }

    public void sortMembersBySurname() {
        members.sort((p1, p2) -> p1.getSurname().compareToIgnoreCase(p2.getSurname()));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("School Members:\n");
        for (Person member : members) {
            sb.append(member).append("\n");
        }
        return sb.toString();
    }
}
