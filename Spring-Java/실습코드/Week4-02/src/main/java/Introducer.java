public class Introducer {
    private String format;
    private String name;
    private String age;

    public String introduce() {
        return String.format(format, name, age);
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}
