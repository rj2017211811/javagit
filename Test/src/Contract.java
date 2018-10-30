import java.text.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class NameException extends Exception{
	public NameException()
	{
		System.out.println("姓名错误");
		
	}
}
class GenderException extends Exception{
	public GenderException()
	{
		System.out.println("性别错误");
		
	}
}

public  class Contract extends Object implements Comparable<Contract>{
	private String name;
	private String gender;
	//private  String[] phones;
	private List<String> phones;
	private String emails;
	public Contract(){
		
	}
	public Contract(String name,String gender,List <String> phones,String emails) 
	{
		super();

			try {
				setGender(gender);
			} catch (GenderException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				setName(name);
			} catch (NameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		setPhones(phones);
		setEmails(emails);
		//不要直接赋值
		
	}
	public Contract(String n,List <String> p) throws NameException, GenderException
	{
		this(n,"",p,"");
	}
     public boolean equals(Object o)
     {
    	 if(o!=null&&o.getClass()==Contract.class)
    		
    		 return this.getName().equals(((Contract)o).getName());
    	 else
    		return false;
     }
     
     public String getName() {
		return name;
	}
	public void setName(String name) throws NameException {
		if(name==null||name.equals(""))
			throw new NameException();
			
		this.name = name;
		
	}
	public String getGender()  {
		
		return gender;
	}
	public void setGender(String gender)throws GenderException {
		if(gender==null)
			throw new GenderException();
		if(gender.equals("男")||gender.equals("女"))

		this.gender = gender;
	}
	public  List <String> getPhones() {
		return phones;
	}
	public void setPhones( List <String> phones) {
		
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
	public void display(){//显示联系人信息
		if(this!=null)
		{
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
		
		
		
	}
	public int compareto(Contract c) {
		Collator instance=Collator.getInstance(java.util.Locale.CHINA);
		return instance.compare(this.getName(),c.getName());
				
	}
	public void mergeContracts(Contract c) throws GenderException//合并两个联系人
	{
		if(c!=null)
		{
			if(this.getName().equals(c.getName()))
			{
				if(this.getGender()!=null&&this.getGender().equals(""))
				{
					this.setGender(c.getGender());
					
				}
				if(this.getEmails().equals(""))
				{
					this.setGender(c.getEmails());
					
				}
				//合并电话
				List<String> src=this.getPhones();
				src.removeAll(c.getPhones());
				src.addAll(c.getPhones());
				//this.setPhones(src);
				
			}
			
		}
		
		
	}
	 public static void main(String[] args) throws ParseException, GenderException{
		 SimpleDateFormat abc=new SimpleDateFormat("yyyy-MM-dd");
			Date d= abc.parse("1999-01-28");
			//Date d=new Date();
		   List<String> phone=new ArrayList<String>();
		   phone.add("1786224426");
			phone.add("1786223442");
				 
			Contract c=new Family("zhangsan","male",
					phone,"fetretr",d,"shandong");
			c.display();
			List<String> phone2=new ArrayList();
			phone2.add("1786224424");
			phone2.add("1786223442");
			Contract c2=new Family("zhangsan","male",
					phone2,"fetretr",d,"shandong");
			
			c.mergeContracts(c2);
			c.display();
	    }
	@Override
	public int compareTo(Contract c) {
		Collator instance=Collator.getInstance(java.util.Locale.CHINA);
		return instance.compare(this.getName(),c.getName());
	}
}