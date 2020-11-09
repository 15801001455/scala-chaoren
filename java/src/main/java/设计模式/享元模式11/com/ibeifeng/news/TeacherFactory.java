package 设计模式.享元模式11.com.ibeifeng.news;

import java.util.HashMap;
import java.util.Map;

public class TeacherFactory {
	private Map<String,Teacher> pool;
	
	public TeacherFactory() {
		pool = new HashMap<>();
	}
	
	public Teacher getTeacher(String number) {
		Teacher teacher = pool.get(number);
		if(teacher == null) {
			teacher = new Teacher();
			teacher.setNumber(number);
			pool.put(number, teacher);
		}
		return teacher;
	}
}
