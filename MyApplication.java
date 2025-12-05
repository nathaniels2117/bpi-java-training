package ph.com.bpi.hello;


public class MyApplication {

	public static void main(String[] args) {
		MSExcel excel = new MSExcel();
		MSWord word = new MSWord();
		
		runProgram(excel);
		runProgram(word);
		
		stopProgram(excel);
		stopProgram(word);
	}
	
	private static void runProgram(Executable executableProgram) {
		executableProgram.run();
	}
	private static void stopProgram(Executable executableProgram) {
		executableProgram.stop();
	}


}
