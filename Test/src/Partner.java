

public class Partner extends Contract {
	public String title;//职务
	private Company company;
	public Partner(){
		
	}
   public Partner(String name,String gender,String[] phones,
		   String emails,String title,Company company){
	   super(name,gender,phones,emails);
	   this.setTitle(title);	
	   this.setCompany(company);
	}
    
	public Company getCompany() {
	return company;
    }
    public void setCompany(Company company) {
	this.company=company;
  }
	public String getTitle() {
		return title;
	}
	public String toString() {
		return "Partner [title=" + title + ", company=" + company + "]";
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void display(){
		super.display();
		System.out.println("title:"+title);
		System.out.println("company:"+getCompany());
		//System.out.println("company"+company);
	}
public static void main(String[] args)  {
	Company company=new Company("zhangsan","male",
			new String[]{"1786223442","178344535"},"fetretr",
			"腾讯","深圳","10002。qq。com","189995656");
				company.display();
				
				Partner partner=new Partner("zhangsan","male",
						new String[]{"1786223442","178344535"},"fetretr",
						"manager",company);
				
				partner.display();
		
		
	}

}