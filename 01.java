class Classroom {
   
    private static class Student {
        private int studentId;
        private String name;
        private int daysAttended;

        public Student(int studentId, String name, int daysAttended) {
            this.studentId = studentId;
            this.name = name;
            this.daysAttended = daysAttended;
        }

        public int getStudentId(){
			return studentId; 
		}
		
        public String getName(){ 
			return name; 
		}
		
        public int getDaysAttended(){ 
			return daysAttended; 
		}
		

        public void setDaysAttended(int days) { 
			daysAttended = days; 
		}
    }
	
	private Student[] students = new Student[10];
	private int count = 0;

	
    public void addStudent(Student student) {
        if (count < 10) {
			students[count++] = student;
		}
    }

    public void updateAttendance(int studentId, int days) {
        for (int i = 0; i < count; i++) {
            if (students[i].getStudentId() == studentId) {
                students[i].setDaysAttended(days);
                return;
            }
        }
		
        System.out.println("Student ID " + studentId + " not found.");
    }

    public void displayAllStudents() {
        for (int i = 0; i < count; i++) {
            Student s = students[i];
            
				System.out.println("ID: " + s.getStudentId());
				System.out.println("Name: " + s.getName());
				System.out.println("Attendance: " + s.getDaysAttended());
        }
    }

    public static void main(String[] args) {
        Classroom classroom = new Classroom();
		
        classroom.addStudent(new Student(101, "Alice Smith", 12));
        classroom.addStudent(new Student(102, "Bob Jones", 15));
        classroom.addStudent(new Student(103, "Carol Lee", 10));

        classroom.updateAttendance(102, 16);
		
        classroom.updateAttendance(104, 5);
		
        classroom.displayAllStudents();
    }
}