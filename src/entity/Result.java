package entity;

public class Result {
    private Integer id;
    private Double mark;
    private Integer studentId;
    private Integer subjectId;

    public Result() {
    }

    public Result(Integer id, Double mark, Integer studentId, Integer subjectId) {
        this.id = id;
        this.mark = mark;
        this.studentId = studentId;
        this.subjectId = subjectId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMark() {
        return mark;
    }

    public void setMank(Double mank) {
        this.mark = mark;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public void showInfo() {
        System.out.printf("ID: %d | Mark: %.2f | Student ID: %d | Subject ID: %d\n",
                id, mark, studentId, subjectId);
    }
}
