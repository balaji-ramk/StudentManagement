package res.data;

public class AttendanceData {
    protected final Integer serialNumber;
    protected final String subject;
    protected final Double percentage;

    public AttendanceData(Integer serialNumber, String subject, Double percentage) {
        this.serialNumber = serialNumber;
        this.subject = subject;
        this.percentage = percentage;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public String getSubject() {
        return subject;
    }

    public Double getPercentage() {
        return percentage;
    }
}
