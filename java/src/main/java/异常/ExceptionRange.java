package 异常;

/**
 * update jyc 19/9/25 测试异常父子类的抛出异常,主要看方法的throws后面的异常的范围，子类不能比父类抛出更大范围的异常
 */
public class ExceptionRange {
	public static void main(String[] args) 	{
		Person c = new Chinese();
		try {
			c.setAge(-1);//update jyc 19/9/25 这里是多态,调用的子类的setAge方法
		} catch (AgeInvalidException e) {
			e.printStackTrace();
		}
	}
}

class Person{
	public int age ;
	public void setAge(int age) throws AgeInvalidException{
		if(age < 0 || age > 200){
			throw new AgeTooBigException();
		}
		this.age = age ;
	}
}

//子类
class Chinese extends Person{
	@Override
	public void setAge(int age) throws AgeTooSmallException{
		if(age < 0 ){
			throw new AgeTooSmallException();
		}
		this.age = age ;
	}
}

class AgeInvalidException extends Exception{
}
class AgeTooBigException extends AgeInvalidException{
}
class AgeTooSmallException extends AgeInvalidException{
}

