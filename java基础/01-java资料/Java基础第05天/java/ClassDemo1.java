class ClassDemo1{
	public static void main(String[] args){
		Person p = new Person();//��������
		p.name = "����" ;
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
	//���Ա����
	String name = "����";
	int age = 10 ;

	//��Ա����
	int run(){
		int temp  ;
		System.out.println("run... : " + temp);
		return age ;
	}
}