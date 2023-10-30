package employeeJspProject;

public class Department extends DeclareVar{
	
	public Department() {
	}

	public Department(int did, String dname, String dlocation) {
		this.did = did;
		this.dname = dname;
		this.dlocation = dlocation;
	}

	public Department(String dname, String dlocation) {
		this.dname = dname;
		this.dlocation = dlocation;
	}

	public String toString() {
			return "Department[did=" + did + ", dname=" + dname+", dlocation=" + dlocation +"]\n";
		}
	}