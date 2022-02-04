public class Student {
    private String name;
    private int age;
    private int grant;
    private int grantGrade;
    private Double averageMark;
    public Student (String name, int age, int grantGrade, Double averageMark) {
        //бурсу grant не стал запрашивать, так как все равно потом она подгоняется под град бурсы grandGrade
        this.name = name;
        if (age < 19 || age > 22) throw new IllegalArgumentException("age");
        else this.age = age;
        if (grantGrade < 1 || grantGrade > 3) throw new IllegalArgumentException("grantGrade");
        else this.grantGrade = grantGrade;
        switch (grantGrade) {
            case 1 -> this.grant = 856;
            case 2 -> this.grant = 1026;
            case 3 -> this.grant = 1200;
        }
        this.averageMark = averageMark;
    }
    public Student(){
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getGrant() {
        return grant;
    }

    public int getGrantGrade() {
        return grantGrade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrant(int grant) {
        this.grant = grant;
    }

    public void setGrantGrade(int grantGrade) {
        this.grantGrade = grantGrade;
    }

    public void setAverageMark(Double averageMark) {
        this.averageMark = averageMark;
    }

    public Double getAverageMark() {
        return averageMark;
    }

}
