import java.text.Collator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
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
	public Contract(String n,String[] p) throws NameException, GenderException
	{
		this(n,"",p,"");
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
		if(this.getName().equals(c.getName()))
		{
			if(this.getGender().equals(""))
			{
				this.setGender(c.getGender());
				
			}
			if(this.getEmails().equals(""))
			{
				this.setGender(c.getEmails());
				
			}
			//合并电话
			boolean flag=true;
			int count=0;
			String[]newPhones=new String[c.getPhones().length];
			for(int i=0;i<this.getPhones().length;i++)
			{
				if(this.getPhones()[i].equals(c.getPhones()[i]))
				{
					flag=false;
					break;
				}
				if(flag)//如果电话号码为新的
				{
					newPhones[count++]=c.getPhones()[i];
					
				}
			}
			int position=phones.length;
			phones=Arrays.copyOf(phones,phones.length+count);
			System.arraycopy(newPhones, 0, phones, position, count);	
		}
		
	}
	 public static void main(String[] args){
	        try {
	            method();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }

	        System.out.println("over over");
	    }
	
	public static void method() throws ParseException {
		
		SimpleDateFormat abc=new SimpleDateFormat("yyyy-MM-dd");
		Date d= abc.parse("1999-01-28");
		//Date d=new Date();
	
		Contract c=new Family("zhangsan","male",
				new String[]{"1786223442","178344535"},"fetretr",d,"shandong");
		c.display();
		
	}
	
	


}