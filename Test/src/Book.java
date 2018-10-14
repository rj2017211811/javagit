import java.util.Arrays;

public class Book {
	private Contract[]contracts;
	public Contract[]getContracts()
	{
		return contracts;
	}
	public void setContracts(Contract[]contracts)
	{
		this.contracts=contracts;
		sortContracts();
	}
	public Book() {
		
	}
	public Book(Contract []contracts) {
		super();
		this.contracts=contracts;
	}
	public void sortContracts() {
		for(int i=0;i<contracts.length-1;i++) {
			int temp=i;
			for( int j=i+1;j<contracts.length;j++) {
				if(contracts[temp].compareto(contracts[j])>0)
					temp=j;
				
			}
			if(temp!=i)
			{
				Contract t=contracts[temp];
				contracts[temp]=contracts[i];
				contracts[i]=t;
				
			}
			
			
		}
		
	}
	public int findContracts(Contract c) {
		for(Contract contract:contracts) {
			if(contract.getName().equals(c.getName()))
			{
				return 1;
			}
		}
		return 0;
		
		
	}
	public void displayBook() {
		for(Contract c:this.getContracts())
		{
			c.display();
		}
		
		
	}
	public void add(Contract c) {
		//通讯录为空
		if(contracts.length==0)
		{
			contracts=new Contract[1];
			contracts[0]=c;
			
			
		}
		else
			
		{
			if(findContracts(c)==0)	//通讯录里没有此联系人
				
			{
				
				Contract []contractAdded=Arrays.copyOf(contracts, contracts.length+1);//利用Arrays类的copyof方法扩充数组
				contractAdded[contracts.length-1]=c;
				this.setContracts(contractAdded);
			}
			else//通讯录里有此联系人
			{
				//合并两个联系人
				//mergeContract(c);
				
			}
		}
			
		
		
	
		
		
	}
	

}
