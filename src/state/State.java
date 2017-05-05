package state;

public interface State {
	/**
     * 状态对应的处理
     */
    public void connect();
    public void off();
}
