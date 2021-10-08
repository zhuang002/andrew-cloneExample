import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Student st1 = new Student("Andrew");
		st1.setAge(17);
		st1.setGender('M');
		
		Address addr = new Address();
		addr.setNumber(0);
		addr.setStreet("Bayview St.");
		addr.setCity("Richmond Hill");
		
		st1.setAddress(addr);
		
		
		Student st2 = (Student)st1.clone();
		
		st2.getAddress().setCity("Markham");
		
		System.out.println(st1.getAddress().getCity());
		
		
		Student[] ar1 = new Student[10];
		ar1[0] = new Student("student 0");
		
		Student[] ar2 = ar1.clone();
		System.out.println(ar2[0].getName());
		
		ar2[0].setName("changed name");
		System.out.println(ar1[0].getName());
		
		ArrayList<Student> al1 = new ArrayList<>();
		al1.add(new Student("student 00"));
		ArrayList<Student> al2 = (ArrayList<Student>)al1.clone();
		
		System.out.println(al2.get(0).getName());
		al2.get(0).setName("changed name 00");
		
		System.out.println(al1.get(0).getName());
		

	}
	
	
	

}


class Student implements Cloneable {
	String name=null;
	int age=0;
	char gender='M';
	Address address = null;
	
	
	
	public Student(String nm) {
		this.name = nm;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public char getGender() {
		return gender;
	}



	public void setGender(char gender) {
		this.gender = gender;
	}



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}
	
	/*@Override
	protected Object clone() {
		Student rt = new Student(this.name);
		rt.setAge(this.age);
		rt.setGender(this.gender);
		rt.setAddress(this.address);
		
		return rt;
	}*/
	
	
	@Override
	protected Object clone() {
		Student rt = new Student(this.name);
		rt.setAge(this.age);
		rt.setGender(this.gender);
		rt.setAddress((Address)this.address.clone());
		
		return rt;
	}
	
	
	
}

class Address implements Cloneable {
	int number=0;
	String street=null;
	String city=null;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	protected Object clone() {
		Address rt = new Address();
		rt.setNumber(this.number);
		rt.setStreet(this.street);
		rt.setCity(this.city);
		
		return rt;
	}
}
