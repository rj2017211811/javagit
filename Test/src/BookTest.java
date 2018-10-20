
public class BookTest {

	
	 
	public static void main(String[] args) throws GenderException, NameException {
		Contract []contract= {new Contract("name1","女",new String[]{"1786223442","178344535"},"243325@qq.com"),
				new Contract("name2","男",new String[]{"1786223442","178344535"},"243325@qq.com"),
				new Contract("name3","男",new String[]{"223442","344535"},"2325@qq.com")};
		Book book=new Book(contract);
		 System.out.println("打印初始通讯录:");
		book.displayBook();
		
		
		
		if(book.delRef(contract[1]))
		{
			System.out.println("deleted1");
			 System.out.println("引用删除成功后打印:");
			book.displayBook();
			
		}
			
		
		if(book.delVal(new Contract("name1","女",new String[]{"1786223442","178344535"},"243325@qq.com")))
		{
			System.out.println("deleted2");
			 System.out.println("值删除成功后打印:");
			book.displayBook();
			
			
		}
			
       if(book.updateContract("name3","女",new String[]{"223442","344535"},"2325@qq.com"))
       {
    	   System.out.println("updated");
           System.out.println("更新成功后打印:");
    		book.displayBook();
    	   
       }
       else
       {
    	   System.out.println("unupdated");
    	   
       }
		
		
	
		
	   if( book.add(new Contract("name3","女",new String[] {"122","33"},"343")))
	   {

		    System.out.println("合并后打印:");
			book.displayBook();
	   }

		if( book.add(new Contract("name1","女",new String[] {"122","33"},"343")))
		{
			 System.out.println("添加后打印:");
			 book.displayBook();
			
		}
		
		 

		book.clearContracts();
		System.out.println("清除后打印:");
		 book.displayBook();
		
	}
	



}
