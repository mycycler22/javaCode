package lab12;

public class Box implements Storage<String>{
	
	private String [] items;
	private int count;
	

	public Box(int capacity) {
		items = new String[capacity];
		this.count = 0;
	}
	
	
	public void store(String item) {
		if(count >= items.length){
			System.out.println("Storage is at capacity. Unable to add item");
			return;
		}
		items[count] = item;
		count++;
	}
	
	@Override
	public String retrieve() {
		if(count == 0) {
			System.out.println("Nothing to retrieve. Storage is empty");
			return null;
		}
		count--;
		String lastItem = items[count];
		items[count] = null;
		return lastItem;
	}


}
