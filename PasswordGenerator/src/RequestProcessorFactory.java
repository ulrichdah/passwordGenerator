
public class RequestProcessorFactory {
	public RequestProcessor createRequestProcessor(int mode) throws Exception {
		
		switch(mode) {
		case 1:
			return new RetrievalProcessor();
		
		case 2:
			return new GenerationProcessor();
			
		case 3:
			return new DeletionProcessor();
		
		default:
			throw new Exception("This option do not exist");
		}
		
	}
}
