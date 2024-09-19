package org.example.student;

public class Student implements Printable {
    private String name;
    private String marksTable;
    private float averageMark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarksTable() {
        return marksTable;
    }

    public void setMarksTable(String marksTable) {
        this.marksTable = marksTable;
    }

    public float getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(float averageMark) {
        this.averageMark = averageMark;
    }

    @Override
    public void print() {
        System.out.println("Student name: " + name + ", marksTable number: " +
                marksTable + ", average mark: " + averageMark);
    }
}
