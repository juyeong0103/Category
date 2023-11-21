public class GirlsHighSchool {
	
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		this.name = n;
	}
	
	public String toString() {
		return "GirlsHigh[name=" + name + "]";
	}
	
	public static void main(String[] args) {
		
		GirlsHighSchool GirlsHigh1 = new GirlsHighSchool();
		GirlsHighSchool GirlsHigh2 = new GirlsHighSchool();
		GirlsHighSchool GirlsHigh3 = new GirlsHighSchool();
		GirlsHighSchool GirlsHigh4 = new GirlsHighSchool();
		
		GirlsHigh1.setName("상일여고");
		GirlsHigh2.setName("영파여고");
		GirlsHigh3.setName("숙명여고");
		GirlsHigh4.setName("진선여고");
		
		System.out.println(GirlsHigh1);
		System.out.println(GirlsHigh2);
		System.out.println(GirlsHigh3);
		System.out.println(GirlsHigh4);
		
		
		
	}
}