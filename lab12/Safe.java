package lab12;

public class Safe implements Storage<Integer> {
	
	private Integer[] items;
	private int count;
	

	public Safe(int capacity) {
		// TODO Auto-generated constructor stub
		items = new Integer[capacity];
		count = 0;
	}
	
	@Override
	public void store(Integer item) {
		if(count >= items.length) {
			System.out.println("Storage is full. Unable to add item");
			return;
		}
		items[count] = item;
		count++;
	}
	
	@Override
	public Integer retrieve(){
		if(count == 0) {
			System.out.println("Storage is empty. Nothing to retrieve");
			return null;
		}
		
		count--;
		Integer lastItem = items[count];
		items[count] = null;
		return lastItem;
	}

}
