class Student {

    private String name;

    private Integer age;

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    Integer getAge() {
        return age
    }

    void setAge(Integer age) {
        this.age = age
//        throw new RuntimeException("setAge exception ...")
    }

    public Student createStu(String name,Integer age){
        Student student = new Student();
         student.setName(name)
         student.setAge(age)
         return student;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
