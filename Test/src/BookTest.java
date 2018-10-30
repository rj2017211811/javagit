
import java.util.*;

public class BookTest {

	public static void main(String[] args) throws GenderException, NameException {
		List<Contract> cons = new ArrayList<Contract>();
		List<String> phones1 = new ArrayList<String>();
		phones1.add("111");
		phones1.add("222");
		cons.add(new Contract("王小二", phones1));
		List<String> phones2 = new ArrayList<String>();
		phones2.add("333");
		phones2.add("444");
		cons.add(new Contract("李小二", phones2));
		List<String> phones3 = new ArrayList<String>();
		phones3.add("555");
		phones3.add("666");	
		cons.add(new Contract("赵小二", phones3));
		Book book = new Book(cons);
		book.displayBook();
		List<String> phones = new ArrayList<String>();
		phones.add("111");
		phones.add("222");
		phones.add("333");
		book.add(new Contract("王小二","男",phones,"wangxiaoer@163.com"));
		book.displayBook();
		
		for(Contract c:book.findContractByName("小"))
			c.display();
		List<String> phones4 = new ArrayList<String>();
		phones4.add("555");
		phones4.add("666");		
		book.updateContract("王小二","女",phones4,"wangxiaoer@163.com" 
				);
		book.displayBook();		
		if(book. deleteContracts(new Contract("李小二", phones2)))
			System.out.println("deleted.");
		else
			System.out.println("undeleted.");
		book.displayBook();
		
	}

}

