import java.util.List;

public class DeletionProcessor extends RequestProcessor{

	@Override
	public void process() {
		
		System.out.println("Password identifier:");
		String id = this.scan.nextLine();
			
		List<String> lines = this.fs.readToArray(FILENAME);
		boolean found = false;
		for (int i = 0; i <lines.size() && !found; i++) {
			if(this.getId(lines.get(i)).equals(id)) {
				lines.remove(i);
				found = true;
			}
		}
		this.fs.write(lines, FILENAME);
		System.out.println("Password deleted!");
	}
	
	private String getId(String line) {
		
		return line.split(": ")[0];
	}

}
