import java.util.*;

class Student {
    private String id, name;
    private int marks;

    public Student(String id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String getId() { return id; }
    public int getMarks() { return marks; }
    public String getrole() { return "Undergrad"; }

    @Override
    public String toString() {
        return id + " - " + name + " (" + getMarks() + ") " + getrole();
    }
}

class GraduateStudent extends Student {
    private String area;

    public GraduateStudent(String id, String name, int marks, String area) {
        super(id, name, marks);
        this.area = area;
    }

    @Override
    public String getrole() {
        return "Grad (" + area + ")";
    }

    public String getArea() {
        return area;
    }
}

class HonourStudent extends Student {
    private int bonus;

    public HonourStudent(String id, String name, int marks, int bonus) {
        super(id, name, marks);
        this.bonus = bonus;
    }

    @Override
    public int getMarks() {
        return super.getMarks() + bonus;
    }

    @Override
    public String getrole() {
        return "Honours";
    }
}

class Repository<T> {
    private Map<String, T> data = new HashMap<>();

    public void save(String id, T obj) { data.put(id, obj); }
    public T find(String id) { return data.get(id); }
    public void delete(String id) { data.remove(id); }
}

public class Student_Marks {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();

        list.add(new Student("S1", "Priyanka", 75));
        list.add(new Student("S2", "Riya", 85));
        list.add(new GraduateStudent("G1", "Ash", 90, "AI"));
        list.add(new GraduateStudent("G2", "Zara", 88, "AI"));
        list.add(new GraduateStudent("G3", "Mina", 92, "ML"));
        list.add(new HonourStudent("H1", "Sam", 87, 5));

        Repository<Student> repo = new Repository<>();
        for (Student s : list) repo.save(s.getId(), s);

        System.out.println("ALL:");
        list.forEach(System.out::println);

        System.out.println("\nLOOKUP S2:");
        Student s = repo.find("S2");
        System.out.println(s != null ? s : "not found");

        Iterator<Student> it = list.iterator();
        while (it.hasNext()) {
            Student st = it.next();
            if (st.getMarks() < 80) {
                it.remove();
                repo.delete(st.getId());
            }
        }

        System.out.println("\nAfter Removal:");
        list.forEach(System.out::println);

        System.out.println("\nTopper in AI:");
        Student ai = getTopperByArea(list, "AI");
        System.out.println(ai != null ? ai : "none");

        System.out.println("\nTopper in ML:");
        Student ml = getTopperByArea(list, "ML");
        System.out.println(ml != null ? ml : "none");
    }

    public static Student getTopperByArea(List<Student> students, String area) {
        return students.stream()
                .filter(s -> s instanceof GraduateStudent)
                .map(s -> (GraduateStudent) s)
                .filter(g -> g.getArea().equals(area))
                .max(Comparator.comparingInt(Student::getMarks))
                .orElse(null);
    }
}
