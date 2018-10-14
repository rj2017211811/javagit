import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
public class Family extends Contract {
	private Date birthday;
	private String address;
	public Family(){
		
	}
	
	
	public Family(String name, String gender, String[] phones, String emails,Date birth,String address) {
		super(name,gender,phones,emails);//调用父类构造方法实现子类参数的初始化
		this.setBirthday(birth);
		this.setAddress(address);
	}
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void display(){
		super.display();
		SimpleDateFormat abc=new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("birthday:"+abc.format(this.getBirthday()));
		System.out.println("address:"+this.getAddress());
		
		
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
	
		Family family1=new Family("zhangsan","male",
				new String[]{"1786223442","178344535"},"fetretr",d,"shandong");
		family1.display();
	}
	

}