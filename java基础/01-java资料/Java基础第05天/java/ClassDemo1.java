class ClassDemo1{
	public static void main(String[] args){
		Person p = new Person();//创建对象
		p.name = "坏人" ;
		p.age = 28 ;
		System.out.println(p);
		System.out.println(p.name);
		System.out.println(p.age);
		System.out.println("********************");
		int r = p.run();
		System.out.println(r);
	}
}

class Person{
	//类成员变量
	String name = "好人";
	int age = 10 ;

	//成员函数
	int run(){
		int temp  ;
		System.out.println("run... : " + temp);
		return age ;
	}
}