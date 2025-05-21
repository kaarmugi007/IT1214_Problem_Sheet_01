class Student{
	private String name;
	private int exam1;
	private int exam2;
	private int exam3;
	
	boolean validateMarks(int marks){
		if (marks<=100 && marks>=0){
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	Student(){
		
	}
	
	Student(String name, int e1, int e2, int e3)throws Exception{
		this.name=name;
		
		if (validateMarks(e1)&& validateMarks(e2)&& validateMarks(e3)){
			exam1=e1;
			exam2=e2;
			exam3=e3;
		}
		else
		{
			System.out.println("Setting the marks value to 0");
			throw new Exception("Invalid Marks!");
		}
		
	}
	
	String getName(){
		return name;	
	}
	
	int getExam1(){
		return exam1;
	}
	
	int getExam2(){
		return exam2;
	}
	
	int getExam3(){
		return exam3;
	}
	
	
}


class GradeCalculator{
	public static void main (String[] args){
		try{
			
		Student s2=new Student("Eve",99,88,75);
		System.out.println("Name of the Student 1 is " + s2.getName());
		System.out.println("Marks of the Student 2 for Exam 1 is " + s2.getExam1());
		System.out.println("Marks of the Student 2 for Exam 2 is " + s2.getExam2());
		System.out.println("Marks of the Student 2 for Exam 3 is " + s2.getExam3());
		
		Student s1=new Student("Adam",99,102,-55);
		System.out.println("Name of the Student 1 is " + s1.getName());
		System.out.println("Marks of the Student 1 for Exam 1 is " + s1.getExam1());
		System.out.println("Marks of the Student 1 for Exam 2 is " + s1.getExam2());
		System.out.println("Marks of the Student 1 for Exam 3 is " + s1.getExam3());
		
		
		
		
		} catch (Exception e){
			System.out.println("Exception is " + e.getMessage());
		}
		
		
	}
}