


public class Company extends Contract {
	private String name;
	
	private String address;
	private String fax;
	private String phone;
	
	public Company(){
		
	}
	public Company(String name,String gender,String[] phones,String emails,String name2,
			String address,String fax,String phone){
		super(name,gender,phones,emails);
		this.setName(name2);
		this.setPhone(phone);
		this.setAddress(address);
		
		this.setFax(fax);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String toString(){
		return String.format("name:%s,address:%s,fax:%s,phone:%s",
				name,address,fax,phone);
	}
	
	public void display(){
		super.display();
		
		System.out.println("address:"+getAddress());
		
		System.out.println("companyName:"+getName());
		System.out.println("fax:"+getFax());
		System.out.println("phone:"+getPhone());
		
	}

	public static void main(String[] args)  {
		Company company=new Company("zhangsan","male",
				new String[]{"1786223442","178344535"},"fetretr",
				"ÌÚÑ¶","ÉîÛÚ","10002¡£qq¡£com","189995656");
					company.display();
		
		
	}
	

}
