//package dev.m3s.programming2.homework3;
public class Course {

    private String name = ConstantValues.NO_TITLE;
    private String courseCode = ConstantValues.NOT_AVAILABLE;
    private Character courseBase = ' ';
    private int courseType;
    private int period;
    private double credits;
    private boolean numericGrade;

    public Course(){
        this.name = getName();
        this.courseCode = getCourseCode();
        this.courseBase = getCourseBase();
        this.courseType = getCourseType();
        this.period = getPeriod();
        this.credits = getCredits();
        this.numericGrade = isNumericGrade();
    }

    public Course(String name, final int code, Character courseBase, final int type, final int period, final double credits, boolean numericGrade){
        setName(name);
        setCourseCode(code, courseBase);
        setCourseType(type);
        setPeriod(period);
        setCredits(credits);
        setNumericGrade(numericGrade);
    }

    public Course(Course course){
        this.name = course.getName();
        this.courseCode = course.getCourseCode();
        this.courseBase = course.getCourseBase();
        this.courseType = course.getCourseType();
        this.period = course.getPeriod();
        this.credits = course.getCredits();
        this.numericGrade = course.isNumericGrade();
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        if(name != null && name != ""){
            this.name = name;
        }
    }

    public String getCourseTypeString(){
        if (courseType == 1) {
            return "Mandatory";
        } 
        else {
            return "Optional";
        }
    }

    public int getCourseType(){
        if (courseType == 1) {
            return 1;
        } 
        else {
            return 0;
        }
    }

    public void setCourseType(final int type){
        if (type == 1 || type == 0) {
            this.courseType = type;
        }
    }

    public String getCourseCode(){
        return this.courseCode;
    }

    public void setCourseCode(final int courseCode1, Character courseBase){
        if ((0 < courseCode1 && courseCode1 < 1000000) && (courseBase == 'A' || courseBase == 'P' || courseBase == 'S')) {
            this.courseCode = "" + courseCode1 + courseBase ;
            this.courseBase = courseBase;
        }
    }

    public Character getCourseBase(){
        return this.courseBase;
    }

    public int getPeriod(){
        return this.period;
    }

    public void setPeriod(final int period){
        if (period >= ConstantValues.MIN_PERIOD && period <= ConstantValues.MAX_PERIOD) {
            this.period = period;
        }
    }

    public double getCredits(){
        return this.credits;
    }

    private void setCredits(final double credits){
        if (credits >= ConstantValues.MIN_CREDITS && credits <= ConstantValues.MAX_COURSE_CREDITS) {
            this.credits = credits;
        }
    }

    public boolean isNumericGrade(){
        return this.numericGrade;
    }

    public void setNumericGrade(boolean numericGrade){
        this.numericGrade = numericGrade;
    }

    public String toString() {
        return "["+ getCourseCode() +" ( "+ getCredits() +" cr), "+'"'+ getName() +'"'+"'. "+ getCourseTypeString() +", period: "+ getPeriod() +".]        ";
    }
    
}