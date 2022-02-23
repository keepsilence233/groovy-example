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
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
