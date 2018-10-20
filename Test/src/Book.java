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
		//sortContracts();
	}
	public Book() {
		
	}
	public Book(Contract []contracts) {
		super();
		this.contracts=contracts;
	}
	public void sortContracts() {//联系人按姓名排序
		for(int i=0;i<contracts.length-1;i++) {
			int temp=i;
			for( int j=i+1;j<contracts.length;j++) {
				if(contracts[temp].compareto(contracts[j])!=0)
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
	public int findContracts(Contract c) {//查找联系人
		if(c==null||contracts==null||c.equals("")||contracts.equals(""))
			return -1;
		else
		{
			for(int i=0;i<contracts.length;i++) {
				if(contracts[i]==null)
					return -1;
				
				if(contracts[i].getName().equals(c.getName()))
				{
					
					
					return i;
				}
			}
			return -1;
			
		}
		
		
		
	}
	public void displayBook() throws GenderException,NullPointerException {//显示联系人
		if(contracts!=null)
		{
			for(int i=0;i<contracts.length;i++)
			{
				if(contracts[i]==null)
					break;
				contracts[i].display();
			}
			
			
		}
		else
		{
			
		}
		
		
		
	}
	public Contract[]findContractByName(String name)//通过姓名查找联系人
	{
		Contract[]result=new Contract[contracts.length];
		int num=0;
		for(int i=0;i<contracts.length;i++)
		{
			if(contracts[i].getName().contains(name))
			{
				result[num++]=contracts[i];
			}
		}
		return Arrays.copyOf(result,num);
	}
	public boolean delVal(Contract c)//删除(值)联系人
	{
		if(c==null)
			return false;
		
		int index=findContracts(c);
		if(index==-1)
			return false;
		else
		{//删除第i个元素
			/*Contract[]contractsDel=new Contract[contracts.length-1];
			System.arraycopy(contracts, 0,contractsDel, 0, index-1);//复制contracts1前index个元素至contractsDel
			System.arraycopy(contracts, index+1, contractsDel,index , contracts.length-1-index);//复制index后面的元素至数组contractsDel
			contracts=contractsDel;*/
			
			System.arraycopy(contracts, index+1,contracts, index, contracts.length-1-index);//把contracts从index+1处赋值到index处
			//这样最后一个元素就会有两个
			
			contracts[contracts.length-1]=null;//把最后一个元素赋值为空
			
			
			
			return true;
		}
		
	}
	public boolean delRef(Contract c)//删除(引用)联系人
	{
		int index=-1;
		for(int i=0;i<contracts.length;i++)
		{
			if(contracts[i]==c)
			{
				index=i;
				break;
			}
		}
		if(index==-1)
			return false;
		else
		{//删除第i个元素
			
			System.arraycopy(contracts, index+1,contracts, index, contracts.length-1-index);
			contracts[contracts.length-1]=null;
			
			
			
			return true;
		}
		
	}
	public boolean updateContract(String name, String gender,String[] phones, String emails) throws GenderException //更新联系人
, NameException
	{
		int index=findContracts(new Contract(name,gender,phones,emails));
		
		if(index==-1)
			
			return false;
		else
		{
			
			contracts[index].setEmails(emails);
			contracts[index].setGender(gender);
			contracts[index].setPhones(phones);
			return true;
		}
		
	}
	public void clearContracts()//清空联系人
	{
		contracts=null;
		
	}
	public boolean add(Contract c) throws GenderException {//添加联系人
		//通讯录为空
		if(c==null)
			return false;
		if(contracts.length==0)
		{
			contracts=new Contract[1];
			contracts[0]=c;
			return true;
			
		}
		
		else
			
		{
			int k=findContracts(c);
			
				if(k==-1)	//通讯录里没有此联系人
					
				{
					
					Contract []contractAdded=Arrays.copyOf(contracts, contracts.length+1);//利用Arrays类的copyof方法扩充数组
					contractAdded[contracts.length]=c;
					this.setContracts(contractAdded);
					
					contracts=contractAdded;
					/*contracts=Arrays.copyOf(contracts, contracts.length+1);//利用Arrays类的copyof方法扩充数组
					contracts[contracts.length]=c;*/
				}
				else//通讯录里有此联系人
				{
					
					//合并两个联系人
					contracts[k].mergeContracts(c);
					
				}
				return true;
		}
			
		
		
	
		
		
	}
	

}
