import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		boolean stop = false;
		
		do {
			System.out.println("Select the operation:");
			System.out.println("1. Retrieve password");
			System.out.println("2. Generate password");
			int mode = Integer.parseInt(scan.nextLine());
			
			RequestProcessorFactory processorFactory = new RequestProcessorFactory();
			RequestProcessor processor;
			try {
				processor = processorFactory.createRequestProcessor(mode);
				processor.process();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("\nDo you want to stop the application ?(y/n)");
			String res = scan.nextLine();
			stop = (res.equals("Y") || res.equals("y"));
		} while(!stop);
	}

}
