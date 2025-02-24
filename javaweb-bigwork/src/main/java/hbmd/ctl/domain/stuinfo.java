package hbmd.ctl.domain;

public class stuinfo {
	
	private int id;
	private String stunum;
	private String stuname;
	private int status;
		public stuinfo(int id, String stunum,String stuname,int status) {
			// TODO Auto-generated constructor stub
			this.id=id;
			this.status=status;
			this.stuname=stuname;
			this.stunum=stunum;
		}
		public int getId() {
			return id;
		}
		public String getStunum() {
			return stunum;
		}
		public String getStuname() {
			return stuname;
		}
		public int getStatus() {
			return status;
		}
		
		
}
