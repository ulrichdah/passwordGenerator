import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileSystem {

	public void write(String fileName, String content) {

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {
			
			fw = new FileWriter(fileName, true);
			// bw = new BufferedWriter(fw);
			fw.append(content);
			System.out.println("Done");
		} catch (IOException e) {
			
			e.printStackTrace();
		} finally {
			
			try {
				
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				
				ex.printStackTrace();
			}
		}
	}
}
