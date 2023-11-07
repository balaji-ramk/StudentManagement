package p2;
public class MarksData {
        private int serialNo;
        private String subject;
        private int midSemesterMarks;
        private int internalMarks;
        private int endSemesterMarks;

        public MarksData(int serialNo, String subject, int midSemesterMarks, int internalMarks, int endSemesterMarks) {
            this.serialNo = serialNo;
            this.subject = subject;
            this.midSemesterMarks = Math.min(midSemesterMarks, 30);
            this.internalMarks = Math.min(internalMarks, 20);
            this.endSemesterMarks = Math.min(endSemesterMarks, 50);
        }

        public int getSerialNo() {
            return serialNo;
        }

        public String getSubject() {
            return subject;
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
        }}