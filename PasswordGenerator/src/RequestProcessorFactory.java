
public class RequestProcessorFactory {
	public RequestProcessor createRequestProcessor(int mode) throws Exception {
		
		switch(mode) {
		case 1:
			return new RetrievalProcessor();
		
		case 2:
			return new GenerationProcessor();
		
		default:
			throw new Exception("This option do not exist");
		}
		
	}
}
