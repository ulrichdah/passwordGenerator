import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileSystem {

	public void append(String fileName, String content) {
		
		FileWriter fw = null;

		try {
			
			fw = new FileWriter(fileName, true);
			fw.append(System.getProperty("line.separator") + content);
		} catch (IOException e) {
			
			e.printStackTrace();
		} finally {
			
			try {
				
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				
				ex.printStackTrace();
			}
		}
	}
	
	
	public void write(List<String> lines, String fileName) {
		
		FileWriter fw = null;
		try {
			fw = new FileWriter(fileName);
			fw.write(lines.get(0));
			fw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		for(int i = 1; i < lines.size(); i++) {
			this.append(fileName, lines.get(i));
		}
	}
	
	
	public Map<String, String> readPasswords(String fileName) {
		
		Map<String, String> passwords = new HashMap<String, String>();
		List<String> lines = this.readToArray(fileName);
		
		for(int i = 0; i < lines.size(); i++) {
			String[] lineParts = lines.get(i).split(": ");
            passwords.put(lineParts[0], lineParts[1]);
		}
		return passwords;
	}
	
	
	public List<String> readToArray(String fileName) {
		
		List<String> lines = new ArrayList<String>();
		File file = new File(fileName);
		BufferedReader b;

		try {
			b = new BufferedReader(new FileReader(file));
            String readLine = "";
            while ((readLine = b.readLine()) != null) {
                lines.add(readLine);
            }
            b.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return lines;
	}
}
