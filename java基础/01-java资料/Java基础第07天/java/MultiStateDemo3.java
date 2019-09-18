class MultiStateDemo3 {
	public static void main(String[] args) {
		Jing8 jing8 = new Jing8();
		jing8.cry();
		Dog dog = jing8 ;
		dog.cry();
		System.out.println("=============");
		System.out.println("jing8.name" + jing8.name);
		System.out.println("dog.name" + dog.name);
	}
}
abstract class Animal{
	abstract public void cry();
}
class Dog extends Animal{
	private String name = "´ó»Æ";
	public void cry(){
		System.out.println("ÍôÍô~~");
	}
}
class Jing8 extends Dog{
	public String name = "´óÂÌ" ;
	public void cry(){
		System.out.println("ºÙºÙ~~" + super.name);
	}
}
/**
 *
 * class Dog{
     public String name = "´ó»Æ";
	 public String getName(){
		return name ;
	 }

	 public void setName(String name){
		this.name = name ;
	 }
   }

   class Jing8 extends Dog{
	public String name = "´óÂÌ";
	public String getName(){
		return super.name ;
	}
   }

   main(){
	Jing8 jing8 = new Jing8();
	jing8.getName();
   }
 */