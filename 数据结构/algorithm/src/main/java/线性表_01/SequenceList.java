package 线性表_01;

public class SequenceList implements List{
    
	//默认的顺序表的最大长度
	final int defaultSize =10;
	//最大长度
	int maxSize;
	//当前长度,会实时变化的
	int size;
	//对象数组
	Object[] listArray;
	
	
	public SequenceList()
	{
		init(defaultSize);
	}
	
	public SequenceList(int size)
	{
		init(size);
	}
	
	//顺序表的初始化方法
	private void init(int size)
	{
		maxSize = size;
		this.size = 0;//初始设置当前长度为0
		listArray = new Object[size];
	}
	
	@Override
	public void delete(int index) throws Exception {
		// TODO Auto-generated method stub
		if(isEmpty())
		{
			throw new Exception("顺序表为空，无法删除！");
		}
		if(index<0||index>size-1)
		{
			throw new Exception("参数错误！");
		}
		//移动元素
		for(int j=index;j<size-1;j++)
		{
			listArray[j]=listArray[j+1];
		}
		size--;
	}

	@Override
	public Object get(int index) throws Exception {
		// TODO Auto-generated method stub
		if(index<0||index>=size)
		{
			throw new Exception("参数错误！");
		}
		return listArray[index];
	}

	@Override
	public void insert(int index, Object obj) throws Exception {
		// TODO Auto-generated method stub
		//线性表已满
		if(size==maxSize)
		{
			throw new Exception("顺序表已满，无法插入！");
		}
		//插入位置编号是否合法
		if(index<0||index>size)
		{
		   throw new Exception("参数错误！");
		}
		//移动元素 update jyc 把大于index的部分的最后一个元素开始向右移动，如果把大于index的第一个元素向右移动的话，会产生覆盖后面的元素的问题
		for(int j=size;j>index;j--)
		{
			listArray[j]=listArray[j-1];
		}
		
		listArray[index]=obj;
		size++;
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

}
