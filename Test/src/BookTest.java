
public class BookTest {

	
	 
	public static void main(String[] args) {
		Contract []contract= {new Contract("name","sdgd",new String[]{"1786223442","178344535"},"243325@qq.com"),
				new Contract("name","sdgd",new String[]{"1786223442","178344535"},"243325@qq.com")};
		Book book=new Book(contract);
		book.displayBook();
	}



}
