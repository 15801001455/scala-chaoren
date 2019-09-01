package 中介者模式18.ex1;

/**
 * 这个是不好的方式
 */
public class MainClass {
	public static void main(String[] args) {
		Person zhangsan = new Man("张三",5);
		Person lisi = new Man("李四",6);
		
		Person xiaofang = new Woman("小芳", 6);
		
		zhangsan.getPartner(xiaofang);
		lisi.getPartner(xiaofang);
		zhangsan.getPartner(lisi);
		
	}
}	
