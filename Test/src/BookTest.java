
public class BookTest {

	
	 
	public static void main(String[] args) throws GenderException, NameException {
		Contract []contract= {new Contract("name1","Ů",new String[]{"1786223442","178344535"},"243325@qq.com"),
				new Contract("name2","��",new String[]{"1786223442","178344535"},"243325@qq.com"),
				new Contract("name3","��",new String[]{"223442","344535"},"2325@qq.com")};
		Book book=new Book(contract);
		 System.out.println("��ӡ��ʼͨѶ¼:");
		book.displayBook();
		
		
		
		if(book.delRef(contract[1]))
		{
			System.out.println("deleted1");
			 System.out.println("����ɾ���ɹ����ӡ:");
			book.displayBook();
			
		}
			
		
		if(book.delVal(new Contract("name1","Ů",new String[]{"1786223442","178344535"},"243325@qq.com")))
		{
			System.out.println("deleted2");
			 System.out.println("ֵɾ���ɹ����ӡ:");
			book.displayBook();
			
			
		}
			
       if(book.updateContract("name3","Ů",new String[]{"223442","344535"},"2325@qq.com"))
       {
    	   System.out.println("updated");
           System.out.println("���³ɹ����ӡ:");
    		book.displayBook();
    	   
       }
       else
       {
    	   System.out.println("unupdated");
    	   
       }
		
		
	
		
	   if( book.add(new Contract("name3","Ů",new String[] {"122","33"},"343")))
	   {

		    System.out.println("�ϲ����ӡ:");
			book.displayBook();
	   }

		if( book.add(new Contract("name1","Ů",new String[] {"122","33"},"343")))
		{
			 System.out.println("��Ӻ��ӡ:");
			 book.displayBook();
			
		}
		
		 

		book.clearContracts();
		System.out.println("������ӡ:");
		 book.displayBook();
		
	}
	



}
