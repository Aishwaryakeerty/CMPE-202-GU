public class InvokerImpl implements Invoker {
	
    private Command theCommand ;
    
	public void setCommand(Command cmd) {
	    theCommand = cmd ;
	}

	public void invoke() {
	    theCommand.execute();
	}
	 
}