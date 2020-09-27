package 设计模式.命令模式24.ex3;

public class Waiter {
	private Command command;

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}

	public void sail() {
		command.sail();
	}
}
