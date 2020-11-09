package 设计模式.工厂模式的应用04;

import lombok.Data;

/**
 * 抽象的运算类 不知道具体要怎么计算
 */
@Data
public abstract class Operation {

	private double num1;
	private double num2;

	public abstract double getResult();
}
