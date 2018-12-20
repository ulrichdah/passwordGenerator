import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileSystem {

	public void write(String fileName, String content) {
		
		FileWriter fw = null;

		try {
			
			fw = new FileWriter(fileName, true);
			fw.append(content);
			System.out.println("Done");
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
	
	
	public Map<String, String> readToMap(String fileName) {
		
		Map<String, String> passwords = new HashMap<String, String>();
		File file = new File(fileName);
		BufferedReader b;

		try {
			b = new BufferedReader(new FileReader(file));
            String readLine = "";
            while ((readLine = b.readLine()) != null) {
                String[] lineParts = readLine.split(": ");
                passwords.put(lineParts[0], lineParts[1]);
            }
            b.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return passwords;
	}
}
