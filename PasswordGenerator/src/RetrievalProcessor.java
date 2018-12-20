import java.util.Map;

public class RetrievalProcessor extends RequestProcessor{
	
	@Override
	public void process() {
		
		System.out.println("Password identifier:");
		String id = scan.nextLine();
		String password = this.getPassword(id, FILENAME);
		if (password != null)
			System.out.println("Here is your password: " + password);
		else
			System.out.println("There is no password with the identifier: " + id);
	}
	
	
	private String getPassword(String id, String fileName) {
		
		Map<String, String> passwords = this.fs.readToMap(fileName);
		if (passwords.containsKey(id))
			return passwords.get(id);
		return null;
	}

}
