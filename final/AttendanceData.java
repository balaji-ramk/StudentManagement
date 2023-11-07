package p2;

public class AttendanceData {
        private final Integer serialNumber;
        private final String subject;
        private final Double percentage;

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
    