package command.remote.command;

public interface Command {

    /**
     * 执行方法
     */
    public void execute();

    /**
     * 撤销
     */
    public void undo();
}
