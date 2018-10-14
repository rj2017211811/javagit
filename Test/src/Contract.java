import java.text.ParseException;

public class Contract {
	private String name;
	private String gender;
	private  String[] phones;
	private String emails;
	public Contract(){
		
	}
	public Contract(String name,String gender,String[] phones,String emails)
	{
		super();
		setName(name);
		setGender(gender);
		setPhones(phones);
		setEmails(emails);
		//��Ҫֱ�Ӹ�ֵ
		
	}
	public Contract(String n,String[] p)
	{
		this(n,"",p,"");
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name==null||name.equals(""))
			return ;
			
		this.name = name;
		
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String[] getPhones() {
		return phones;
	}
	public void setPhones(String[] phones) {
		this.phones = phones;
	}
	public String getEmails() {
		return emails;
	}
	public void setEmails(String emails) {
		this.emails = emails;
	}
	public String toString(){
		return String.format("name:%s,gender:%s,phones:%s,email:%s",name,gender,phones,emails);
		
	}
	public void display(){
		
		System.out.println("name:"+this.getName()+"\t"
		+"gender:"+this.getGender()+"\t"+"email:"+this.getEmails());
		
			//System.out.println("phones:"+this.getPhones());
	  System.out.print("phoneNums:"+"\t");
		for(String p:this.getPhones())
		{
			System.out.print(p+"\t");
		}
		System.out.println();
		
	}
	public static void main(String[] args)  {
		Contract contract1=new Contract("zhangsan","male",
				new String[]{"1786223442","1783435"},"fetretr");
		contract1.display();
	}
	


}