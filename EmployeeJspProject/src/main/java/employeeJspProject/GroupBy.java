package employeeJspProject;

public class GroupBy extends DeclareVar{
	
	public GroupBy() {
	}

	public GroupBy(String name, String dname) {
		this.name = name;
		this.dname = dname;

	}
	
	public String toString(){
		return "Employee_Details[dname=" + dname+", name=" + name+"]\n";
	}
}
