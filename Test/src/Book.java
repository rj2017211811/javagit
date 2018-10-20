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
	public void sortContracts() {//��ϵ�˰���������
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
	public int findContracts(Contract c) {//������ϵ��
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
	public void displayBook() throws GenderException,NullPointerException {//��ʾ��ϵ��
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
	public Contract[]findContractByName(String name)//ͨ������������ϵ��
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
	public boolean delVal(Contract c)//ɾ��(ֵ)��ϵ��
	{
		if(c==null)
			return false;
		
		int index=findContracts(c);
		if(index==-1)
			return false;
		else
		{//ɾ����i��Ԫ��
			/*Contract[]contractsDel=new Contract[contracts.length-1];
			System.arraycopy(contracts, 0,contractsDel, 0, index-1);//����contracts1ǰindex��Ԫ����contractsDel
			System.arraycopy(contracts, index+1, contractsDel,index , contracts.length-1-index);//����index�����Ԫ��������contractsDel
			contracts=contractsDel;*/
			
			System.arraycopy(contracts, index+1,contracts, index, contracts.length-1-index);//��contracts��index+1����ֵ��index��
			//�������һ��Ԫ�ؾͻ�������
			
			contracts[contracts.length-1]=null;//�����һ��Ԫ�ظ�ֵΪ��
			
			
			
			return true;
		}
		
	}
	public boolean delRef(Contract c)//ɾ��(����)��ϵ��
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
		{//ɾ����i��Ԫ��
			
			System.arraycopy(contracts, index+1,contracts, index, contracts.length-1-index);
			contracts[contracts.length-1]=null;
			
			
			
			return true;
		}
		
	}
	public boolean updateContract(String name, String gender,String[] phones, String emails) throws GenderException //������ϵ��
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
	public void clearContracts()//�����ϵ��
	{
		contracts=null;
		
	}
	public boolean add(Contract c) throws GenderException {//�����ϵ��
		//ͨѶ¼Ϊ��
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
			
				if(k==-1)	//ͨѶ¼��û�д���ϵ��
					
				{
					
					Contract []contractAdded=Arrays.copyOf(contracts, contracts.length+1);//����Arrays���copyof������������
					contractAdded[contracts.length]=c;
					this.setContracts(contractAdded);
					
					contracts=contractAdded;
					/*contracts=Arrays.copyOf(contracts, contracts.length+1);//����Arrays���copyof������������
					contracts[contracts.length]=c;*/
				}
				else//ͨѶ¼���д���ϵ��
				{
					
					//�ϲ�������ϵ��
					contracts[k].mergeContracts(c);
					
				}
				return true;
		}
			
		
		
	
		
		
	}
	

}
