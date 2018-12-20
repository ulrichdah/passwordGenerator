import java.util.Scanner;

public abstract class RequestProcessor {

	static final String FILENAME = "C:\\Users\\User\\Documents\\password.txt";
	
	protected FileSystem fs;
	protected Scanner scan;
	
	RequestProcessor() {
		fs = new FileSystem();
		scan = new Scanner(System.in);
	}
	
	public abstract void process();

}
