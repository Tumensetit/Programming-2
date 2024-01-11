//package dev.m3s.programming2.homework3;
public class StudentCourse {

    private Course course = new Course();
    private int gradeNum;
    private int yearCompleted;

    public StudentCourse(){
        this.course = getCourse();
        this.gradeNum = getGradeNum();
        this.yearCompleted = getYear();
    }

    public StudentCourse(Course course, final int gradeNum, final int yearCompleted){
        setCourse(course);
        setGrade(gradeNum);
        setYear(yearCompleted);
    }

    

    public Course getCourse(){
        return this.course;
    }

    public void setCourse(Course course){
        this.course = course;
    }

    public int getGradeNum(){
        return this.gradeNum;
    }

    protected void setGrade(int gradeNum){
        if (checkGradeValidity(gradeNum) == true) {
            if (yearCompleted < 2000) {
                this.yearCompleted = 2023;
            }
            this.gradeNum = gradeNum;
        }
    }

    private boolean checkGradeValidity(final int gradeNum){
        if (course.isNumericGrade() == true) {
            if ((gradeNum  <= 5 && gradeNum >= 0 )){
                return true;
            }
        }
        if (course.isNumericGrade() == false) {
            if ((gradeNum == 'F' || gradeNum == 'A')) {
                return true;
            }
        }
        return false;
    }

    public boolean isPassed(){
        if (course.isNumericGrade() == true) {
            if ((gradeNum  <= 5 && gradeNum > 0 )){
                return true;
            }
        }
        if (course.isNumericGrade() == false) {
            if (gradeNum == 'A') {
                return true;
            }
        }
        return false;
    }

    public int getYear(){
        return this.yearCompleted;
    }

    public void setYear(final int year){
        if(year > 2000 && year <= 2023){
            this.yearCompleted = year;
        }
    }

    public String toString(){
        if (checkGradeValidity(gradeNum) == false) {
            return "["+ course.getCourseCode() +" ("+ course.getCredits() +" cr), "+'"'+ course.getName() +'"'+". "+ course.getCourseTypeString() +", period: "+ course.getPeriod() +".] Year: "+ getYear() +", Grade: "+'"'+"Not graded"+'"'+".]";
        }
        if (course.isNumericGrade() == true) {
            return "["+ course.getCourseCode() +" ("+ course.getCredits() +" cr), "+'"'+ course.getName() +'"'+". "+ course.getCourseTypeString() +", period: "+ course.getPeriod() +".] Year: "+ getYear() +", Grade: "+ getGradeNum() +".]";
        }
        if (course.isNumericGrade() == false && isPassed() == true) {
            return "["+ course.getCourseCode() +" ("+ course.getCredits() +" cr), "+'"'+ course.getName() +'"'+". "+ course.getCourseTypeString() +", period: "+ course.getPeriod() +".] Year: "+ getYear() +", Grade: A.]";
        }
        if (course.isNumericGrade() == false && isPassed() == false) {
            return "["+ course.getCourseCode() +" ("+ course.getCredits() +" cr), "+'"'+ course.getName() +'"'+". "+ course.getCourseTypeString() +", period: "+ course.getPeriod() +".] Year: "+ getYear() +", Grade: F.]";
        }
        return "false";
    }
}