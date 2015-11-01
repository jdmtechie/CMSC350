import java.util.concurrent.ThreadLocalRandom;

public class Project1Driver {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		//Instantiate stack and queue objects
		StackUMUC testStack = new StackUMUC();
		QueueUMUC testQueue = new QueueUMUC();
		
		//Stack Test
		System.out.println("Stack Empty: " + testStack.isEmpty());
		
		//Populate stack
		for(int n = 0; n <= 4; n++) {
			testStack.push(strGen(n));
			testStack.push(pointGen());
			testStack.push(numGen());
		}
		
		//Test stack methods
		System.out.println("Whole Stack: " + testStack);
		System.out.println("Stack Empty: " + testStack.isEmpty());
		System.out.println("Popped: " + testStack.pop());
		System.out.println("Peek: " + testStack.peek());
		System.out.println("Whole Stack Now: " + testStack);
		System.out.println("Popped: " + testStack.pop());
		System.out.println("Popped: " + testStack.pop());
		System.out.println("Popped: " + testStack.pop());
		System.out.println("Peek: " + testStack.peek());
		System.out.println("Stack Testing Complete");
		
		//empty the stack for exception test
		/*for(int i = testStack.size()-1; i >= 0; i--) {
			testStack.pop();
		}
		System.out.println("Stack Empty: " + testStack.isEmpty());
		testStack.pop();
		*/
		
		System.out.println("");
		
		//Queue Test
		System.out.println("Queue Empty: " + testQueue.isEmpty());
		//populate queue
		for(int n = 0; n <= 4; n++) {
			testQueue.put(strGen(n));
			testQueue.put(pointGen());
			testQueue.put(numGen());
		}
		
		//Test queue methods
		System.out.println("Whole Queue: " + testQueue);
		System.out.println("Queue Empty: " + testQueue.isEmpty());
		System.out.println("Get: " + testQueue.get());
		System.out.println("Peek: " + testQueue.peek());
		System.out.println("Whole Queue Now: " + testQueue);
		System.out.println("Get: " + testQueue.get());
		System.out.println("Get: " + testQueue.get());
		System.out.println("Get: " + testQueue.get());
		System.out.println("Peek: " + testQueue.peek());
		System.out.println("Queue Testing Complete");
	
		//empty the stack for exception test
		/*for(int i = testQueue.size()-1; i >= 0; i--) {
			testQueue.get();
		}
		System.out.println("Queue Empty: " + testQueue.isEmpty());
		testQueue.get();
		*/
	}
	
	//Helper Methods
	public static int numGen() {
		return ThreadLocalRandom.current().nextInt(-100, 100 +1);
	}
	
	public static Point pointGen() {
		return new Point(ThreadLocalRandom.current().nextInt(-100, 100 +1), 
				ThreadLocalRandom.current().nextInt(-100, 100 +1));
	}
	
	private static String s = "This is the test string";
	private static String[] ss = s.split(" ");
	
	public static String strGen(int x) {
		return ss[x];
	}
}
