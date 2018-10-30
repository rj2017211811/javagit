import java.util.*;
public class Book {
	private List<Contract>contracts;
	public List<Contract>getContracts()
	{
		return contracts;
	}
	public void setContracts(List<Contract>contracts)
	{
		Collections.sort(contracts);
		this.contracts=contracts;
		//sortContracts();
	}
	public Book() {
		
	}
	public Book(List<Contract>contracts) {
		super();
		this.contracts=contracts;
	}

	
	public void displayBook() throws GenderException,NullPointerException {//��ʾ��ϵ��
		for(Contract c:this.getContracts())
		{
			System.out.println(c);
		}
		
		
		
	}
	public List<Contract>findContractByName(String name)//ͨ������������ϵ��
	{
		List<Contract> result=new ArrayList<Contract>();
		Iterator<Contract> it=contracts.iterator(); 
		for(;it.hasNext();)
		{
			Contract c=it.next();
			if(c.getName().contains(name))
			{
				result.add(c);
			}
			
		}
		return result;
		
	}
	public boolean deleteContracts(Contract c)//ɾ��(ֵ)��ϵ��
	{
		return this.getContracts().remove(c);
		
	}

	public boolean updateContract(String name,String gender,List <String> phones,String emails) throws GenderException //������ϵ��, NameException
	{
		int index=Collections.binarySearch(this.getContracts(), new Contract(name,gender,phones,emails));
		
		
		if(index<0)
			
			return false;
		else
		{
			
			contracts.get(index).setEmails(emails);
			contracts.get(index).setGender(gender);
			contracts.get(index).setPhones(phones);
			return true;
		}
		
	}
	public void clearContracts()//�����ϵ��
	{
		contracts=null;
		
	}
	
	public void add(Contract c) throws GenderException {//�����ϵ��
		//ͨѶ¼Ϊ��
		if(contracts==null)
		{
			contracts=new ArrayList<Contract>();
			contracts.add(c);
		}
		else
		{
			int index=Collections.binarySearch(this.getContracts(),c);
			if(index<0)
			{
	
				contracts.add(-index-1,c);
				
				
			}
			else{
				contracts.get(index).mergeContracts(c);
			}
		}
		
	
		
		
	
		
		
	}
	

}
