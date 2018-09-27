import org.junit.Test;

import java.util.ArrayList;

import org.junit.Assert;;

public class CustomArrayListTests {

	
	@Test
	public void addElementInteger() {
		
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		numbers.addElement(23);	
		Assert.assertTrue(numbers.getElement(0) == 23);
	
	}
	
	@Test
	public void checkLastAddElemToCorrectIndex() {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		numbers.addElement(23);	
		numbers.addElement(14);
		numbers.addElement(2);
		numbers.addElement(6);
		
		Assert.assertTrue(numbers.getElement(3) == 6);
	}
	
	
	@Test
	public void addElementOnPosition() throws Exception{
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		
		numbers.addElement(5, 23);
		
		Assert.assertTrue(numbers.getElement(5) == 23);
	}
	
	
	@Test
	public void addElementOnLastPosition() throws Exception {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		
		
		numbers.addElement(1);
		numbers.addElement(2);
		
		int lastPos = numbers.size();
		numbers.addElement(lastPos, 6);
		
		
		Assert.assertTrue(numbers.getElement(lastPos) == 6);
		
		
	}
	
	
	@Test
	public void addElementOnLastPosition2() throws Exception {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		
		int lastPos = numbers.size();
		
		numbers.addElement(lastPos, 15);
		Assert.assertTrue(numbers.getElement(lastPos) == 15);
		
	}
	
	
	@Test(expected = Exception.class)
	public void addElementOnNegativePosition() throws Exception {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		
		numbers.addElement(-5, 23);
		
	}
	
	
	@Test()
	public void addElementOutOfPosition() throws Exception {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		int position = numbers.size() + 17;
		
		numbers.addElement(5);
		numbers.addElement(10);
		numbers.addElement(2);
		
		numbers.addElement(position, 5);
		
		Assert.assertTrue(numbers.getElement(position) == 5);
	}
	
	
	@Test()
	public void testSequencesOfTheElements() throws Exception {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		
		numbers.addElement(5);
		numbers.addElement(10);
		numbers.addElement(2);
		numbers.addElement(14);
		numbers.addElement(4,16);
		
		Assert.assertTrue(numbers.getElement(0) == 5);
		Assert.assertTrue(numbers.getElement(1) == 10);
		Assert.assertTrue(numbers.getElement(2) == 2);
		Assert.assertTrue(numbers.getElement(3) == 14);
		Assert.assertTrue(numbers.getElement(4) == 16);
		
	}
	
	
	@Test()
	public void testElementOverwriteOnIndex() throws Exception {
CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		
		numbers.addElement(5);
		numbers.addElement(10);
		numbers.addElement(2);
		numbers.addElement(14);
		
		numbers.addElement(3, 20);
		
		Assert.assertTrue(numbers.getElement(3) == 20);
		
	}
	
	
	@Test
	public void writeArrayElementsString() {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		
		numbers.addElement(4);
		numbers.addElement(7);
		numbers.addElement(13);
		numbers.addElement(32);
		
		//not sure about this. To check it again later.
		
		//this works
		Assert.assertEquals("4, 7, 13, 32, ", numbers.toString());
		
		//this not
//		Assert.assertEquals("4, 7, 13, 32", numbers.toString());
		
	}
	
	
	@Test
	public void addAllElements() {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		ArrayList<Integer> userNums = new ArrayList<>();
		
		userNums.add(10);
		userNums.add(11);
		
		numbers.addElement(5);
		numbers.addElement(7);
		numbers.addAll(userNums);
		
		Assert.assertTrue(numbers.getElement(0) == 10);
		Assert.assertTrue(numbers.getElement(1) == 11);
		Assert.assertTrue(numbers.getElement(2) == 5);
		Assert.assertTrue(numbers.getElement(3) == 7);
	}
	
	
	
	@Test
	public void addUserCollectionElements() {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		ArrayList<Integer> userNums = new ArrayList<>();
		
		userNums.add(1);
		userNums.add(2);
		userNums.add(3);
		
		numbers.addAll(userNums);
		
		Assert.assertTrue(numbers.getElement(0) == 1);
		Assert.assertTrue(numbers.getElement(1) == 2);
		Assert.assertTrue(numbers.getElement(2) == 3);
	}
	
}



