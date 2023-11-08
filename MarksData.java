package res.data;

import res.data.AttendanceData;

public class MarksData extends AttendanceData {
    // private int serialNo;
    // private String subject;
    private int midSemesterMarks;
    private int internalMarks;
    private int endSemesterMarks;

    public MarksData(Integer serialNumber, String subject, int midSemesterMarks, int internalMarks,
            int endSemesterMarks) {
        super(serialNumber, subject, 100.0);
        this.midSemesterMarks = Math.min(midSemesterMarks, 30);
        this.internalMarks = Math.min(internalMarks, 20);
        this.endSemesterMarks = Math.min(endSemesterMarks, 50);
    }

    public int getMidSemesterMarks() {
        return midSemesterMarks;
    }

    public int getInternalMarks() {
        return internalMarks;
    }

    public int getEndSemesterMarks() {
        return endSemesterMarks;
    }

    public int getTotalMarks() {
        return midSemesterMarks + internalMarks + endSemesterMarks;
    }
}