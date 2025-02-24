package hbmd.ctl.domain;

public class Role {
	public Role(String id,String name,String remakeString,String arearTypeString) {
		this.id=id;
		this.name=name;
		this.remakeString=remakeString;
		this.arearTypeString=arearTypeString;
	}
	private String id ;
	private String name;
	private String remakeString;
	private String arearTypeString;
		public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemakeString() {
		return remakeString;
	}
	public void setRemakeString(String remakeString) {
		this.remakeString = remakeString;
	}
	public String getArearTypeString() {
		return arearTypeString;
	}
	public void setArearTypeString(String arearTypeString) {
		this.arearTypeString = arearTypeString;
	}
}
