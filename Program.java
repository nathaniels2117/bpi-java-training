package ph.com.bpi.hello;

public abstract class Program {
	
	private String name;
    private boolean isRunning = false;
    
    public Program() { 
    }
    
    public Program(String name) {
        this.name = name;
    }
    
    public abstract void run();
    public abstract void stop();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsRunning() {
        return isRunning;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }
	
	
}
