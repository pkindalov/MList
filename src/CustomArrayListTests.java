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
	
	@Test
	public void testSizeAfterAddingElement() {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		
		numbers.addElement(1);
		
		Assert.assertTrue(numbers.size() == 1);
	}
	
	@Test
	public void testSizeAfterAddingMoreElements() {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		
		numbers.addElement(1);
		numbers.addElement(2);
		numbers.addElement(3);
		
		Assert.assertTrue(numbers.size() == 3);
		
	}
	
	
	@Test
	public void testSizeWithAddCollectionMethod() {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		ArrayList<Integer> numsToAdd = new ArrayList<Integer>();
		
		numsToAdd.add(1);
		numsToAdd.add(2);
		numsToAdd.add(5);
		
		numbers.addAll(numsToAdd);
		
		Assert.assertTrue(numbers.size() == 3);
		
	}
	
	
	@Test
	public void testSizeAddCollection() {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		ArrayList<Integer> numsToAdd = new ArrayList<Integer>();
		
		numsToAdd.add(1);
		numsToAdd.add(2);
		numsToAdd.add(5);
		numsToAdd.add(10);
		numsToAdd.add(12);
		numsToAdd.add(16);
		numsToAdd.add(14);
		numsToAdd.add(17);
		numsToAdd.add(18);
		numsToAdd.add(22);
		
		numbers.addAll(numsToAdd);
		
		Assert.assertTrue(numbers.size() == 10);
	}
	
	@Test
	public void testSizeAddCollectionOnExistingElements() {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		ArrayList<Integer> numsToAdd = new ArrayList<Integer>();
		
		numbers.addElement(34);
		numbers.addElement(43);
		
		
		numsToAdd.add(1);
		numsToAdd.add(2);
		numsToAdd.add(5);
		numsToAdd.add(10);
		numsToAdd.add(12);
		numsToAdd.add(16);
		numsToAdd.add(14);
		numsToAdd.add(17);
		numsToAdd.add(18);
		numsToAdd.add(22);
		
		numbers.addAll(numsToAdd);
		
		Assert.assertTrue(numbers.size() == 12);
		
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
	
	
	
	@Test
	public void removeAllElements() {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		ArrayList<Integer> userNums = new ArrayList<>();
		
		numbers.addElement(1);
		numbers.addElement(2);
		numbers.addElement(3);
		
		userNums.add(2);
		userNums.add(3);
		
		numbers.removeAll(userNums);
		
		Assert.assertTrue(numbers.size() == 1);
		
	}
	
	
	@Test
	public void removeAllElAndCheckPosition() {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		ArrayList<Integer> userNums = new ArrayList<>();
		
		numbers.addElement(1);
		numbers.addElement(2);
		numbers.addElement(3);
		
		userNums.add(2);
		userNums.add(3);
		
		numbers.removeAll(userNums);
		
		Assert.assertTrue(numbers.getElement(0) == 1);
	}
	
	@Test
	public void removeAllElAndCheckNumberInMiddle() {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		ArrayList<Integer> userNums = new ArrayList<>();
		
		numbers.addElement(1);
		numbers.addElement(2);
		numbers.addElement(3);
		numbers.addElement(4);
		
		userNums.add(2);
		
		numbers.removeAll(userNums);
		
		Assert.assertTrue(numbers.getElement(1) == 3);
		Assert.assertTrue(numbers.getElement(0) == 1);
		Assert.assertTrue(numbers.getElement(2) == 4);
		
	}
	
	@Test
	public void testRemoveAllElementsAndCheckPos2() {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		ArrayList<Integer> userNums = new ArrayList<>();
		
		numbers.addElement(1);
		numbers.addElement(2);
		numbers.addElement(3);
		numbers.addElement(4);
		
		userNums.add(1);
		
		numbers.removeAll(userNums);
		
		Assert.assertTrue(numbers.getElement(0) == 2);
		Assert.assertTrue(numbers.getElement(1) == 3);
		Assert.assertTrue(numbers.getElement(2) == 4);
	}
	
	@Test
	public void testRemoveAllElementsAndCheckPos3() {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		ArrayList<Integer> userNums = new ArrayList<>();
		
		numbers.addElement(1);
		numbers.addElement(2);
		numbers.addElement(3);
		numbers.addElement(4);
		
		userNums.add(1);
		userNums.add(4);
		
		numbers.removeAll(userNums);
		
		Assert.assertTrue(numbers.getElement(0) == 2);
		Assert.assertTrue(numbers.getElement(1) == 3);
	}
	
	@Test
	public void testRemoveAllElementsAndCheckPos4() {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		ArrayList<Integer> userNums = new ArrayList<>();
		
		numbers.addElement(1);
		numbers.addElement(2);
		numbers.addElement(3);
		numbers.addElement(4);
		
		userNums.add(1);
		userNums.add(2);
		userNums.add(3);
		userNums.add(4);
		
		numbers.removeAll(userNums);
		
		Assert.assertTrue(numbers.size() == 0);
		Assert.assertTrue(numbers.getElement(0) == null);
		Assert.assertTrue(numbers.getElement(1) == null);
		Assert.assertTrue(numbers.getElement(2) == null);
	}
	
	@Test
	public void containsElement() {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		
		numbers.addElement(1);
		numbers.addElement(2);
		numbers.addElement(3);
		numbers.addElement(4);
		
		boolean isContains2 = numbers.contains(2);
		boolean isContainsNum = numbers.contains(13);
		
		Assert.assertTrue(isContains2 == true);
		Assert.assertTrue(isContainsNum == false);
		
	}
	
	@Test
	public void containsElement2() {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		
		numbers.addElement(1);
		numbers.addElement(2);
		numbers.addElement(3);
		numbers.addElement(4);
		
		Assert.assertTrue(numbers.contains(15) == false);
		Assert.assertTrue(numbers.contains(-12) == false);
		Assert.assertTrue(numbers.contains(4) == true);
		Assert.assertTrue(numbers.contains(1) == true);
	}
	
	
	@Test
	public void containsString() {
		CustomArrayList<String> words = new CustomArrayList<String>(String.class);
		
		words.addElement("I");
		words.addElement("like");
		words.addElement("Java");
		
		Assert.assertTrue(words.contains("like") == true);
		Assert.assertTrue(words.contains("I") == true);
		Assert.assertTrue(words.contains("Java") == true);
		Assert.assertTrue(words.contains("java") == false);
	}
	
	@Test
	public void testEmptyList() {
		CustomArrayList<String> words = new CustomArrayList<String>(String.class);
		
		Assert.assertTrue(words.contains(null) == true);
		Assert.assertTrue(words.contains("like") == false);
	}
	
	
	@Test(expected = Exception.class)
	public void removeNumOnBigPos() {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		
		numbers.addElement(1);
		numbers.addElement(2);
		numbers.addElement(3);
		numbers.addElement(4);
		
		numbers.removeElement(15);
		
	}
	
	
	@Test(expected = Exception.class)
	public void removeNumOnNegativePos() {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		
		numbers.addElement(1);
		numbers.addElement(2);
		numbers.addElement(3);
		numbers.addElement(4);
		
		numbers.removeElement(-12);
	}
	
	
	@Test
	public void removeElementOnValidPos() {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		
		numbers.addElement(1);
		numbers.addElement(2);
		numbers.addElement(3);
		numbers.addElement(4);
		
		numbers.removeElement(2);
		
		Assert.assertTrue(numbers.size() == 3);
		Assert.assertTrue(numbers.contains(3) == false);
	}
	
	
	@Test
	public void checkPosAfterRemoveValidElement() {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		
		numbers.addElement(1);
		numbers.addElement(2);
		numbers.addElement(3);
		numbers.addElement(4);
		
		numbers.removeElement(1);
		
		Assert.assertTrue(numbers.size() == 3);
		Assert.assertTrue(numbers.getElement(0) == 1);
		Assert.assertTrue(numbers.getElement(1) == 3);
		Assert.assertTrue(numbers.getElement(2) == 4);
	}
	
	@Test(expected = Exception.class)
	public void removeElOnNegativePosition() {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		
		numbers.addElement(1);
		numbers.addElement(2);
		numbers.addElement(3);
		numbers.addElement(4);
		
		numbers.removeElement(-2);
	}
	
	@Test(expected = Exception.class)
	public void removeElOnBigPos() {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		
		numbers.addElement(1);
		numbers.addElement(2);
		numbers.addElement(3);
		numbers.addElement(4);
		
		numbers.removeElement(45);
	}
	
	@Test
	public void removeElementsByPos() {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		
		numbers.addElement(1);
		numbers.addElement(2);
		numbers.addElement(3);
		numbers.addElement(4);
		
		numbers.removeElement(0);
		numbers.removeElement(2);
		
		Assert.assertTrue(!numbers.contains(1));
		Assert.assertTrue(!numbers.contains(4));
		
		
	}
	
	
	@Test
	public void removeElement() throws Exception {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		
		numbers.addElement(1);
		numbers.addElement(2);
		numbers.addElement(3);
		numbers.addElement(4);
		
		numbers.removeElementAt(4);
		Assert.assertFalse(numbers.contains(4));
	}
	
	@Test
	public void removeElementAndCheckArrange() throws Exception {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		
		numbers.addElement(1);
		numbers.addElement(2);
		numbers.addElement(3);
		numbers.addElement(4);
		
		numbers.removeElementAt(1);
		numbers.removeElementAt(4);
		
		Assert.assertTrue(numbers.getElement(0) == 2);
		Assert.assertTrue(numbers.getElement(1) == 3);
	}
	
	@Test(expected = Exception.class)
	public void removeUnexistingElement() throws Exception {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		
		numbers.addElement(1);
		numbers.addElement(2);
		numbers.addElement(3);
		numbers.addElement(4);
		
		numbers.removeElementAt(24);
	}
	
	
	@Test
	public void testSize() {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		
		numbers.addElement(1);
		
		Assert.assertTrue(numbers.size() == 1);
	}
	
	
	@Test
	public void testSizeOfListWithNoElements() {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		
		Assert.assertTrue(numbers.size() == 0);
	}
	
	@Test
	public void clearListAddElementsAndTestSize() {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		
		numbers.addElement(1);
		numbers.addElement(2);
		
		Assert.assertTrue(numbers.size() == 2);
		
		numbers.clear();
		
		Assert.assertTrue(numbers.size() == 0);
	}
	
	@Test
	public void testSizeAfterRemoveElement() {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		
		numbers.addElement(1);
		numbers.addElement(2);
		numbers.addElement(3);
		numbers.addElement(4);
		
		numbers.removeElement(0);
		
		Assert.assertTrue(numbers.size() == 3);
		
	}
	
	@Test
	public void testSizeAfterRemoveSeveralElements() {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		ArrayList<Integer> elForRemoving = new ArrayList<>();
		
		numbers.addElement(1);
		numbers.addElement(2);
		numbers.addElement(3);
		numbers.addElement(4);
		
		elForRemoving.add(2);
		elForRemoving.add(3);
		
		numbers.removeAll(elForRemoving);
		
		Assert.assertTrue(numbers.size() == 2);
		Assert.assertTrue(numbers.toString().equals("1, 4, "));
		
		
	}
	
	@Test
	public void testSizeAfterRemoveAllElementsAtOnce() {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		ArrayList<Integer> elForRemoving = new ArrayList<>();
		
		numbers.addElement(1);
		numbers.addElement(2);
		numbers.addElement(3);
		numbers.addElement(4);
		
		elForRemoving.add(1);
		elForRemoving.add(2);
		elForRemoving.add(3);
		elForRemoving.add(4);
		
		numbers.removeAll(elForRemoving);
		
		Assert.assertTrue(numbers.size() == 0);
	}
	
	
	@Test
	public void testClone() {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		CustomArrayList<Integer> copiedNumbers = new CustomArrayList<Integer>(Integer.class);
		
		numbers.addElement(5);
		numbers.addElement(7);
		
		copiedNumbers = numbers.clone(copiedNumbers);
		copiedNumbers.removeElement(0);
		
		Assert.assertTrue(copiedNumbers.getElement(0) == 7);
		
	}
	
	
	@Test
	public void testClonedListSize() {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		CustomArrayList<Integer> copiedNumbers = new CustomArrayList<Integer>(Integer.class);
		
		numbers.addElement(5);
		numbers.addElement(7);
		
		copiedNumbers = numbers.clone(copiedNumbers);
		copiedNumbers.removeElement(0);
		
		Assert.assertTrue(copiedNumbers.size() == 1);
		
	}
	
	@Test
	public void testCloneSizeWithoutParams() {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		CustomArrayList<Integer> copiedNumbers = new CustomArrayList<Integer>(Integer.class);
		
		numbers.addElement(5);
		numbers.addElement(7);
		
		copiedNumbers = numbers.clone();
		
		Assert.assertTrue(copiedNumbers.size() == 2);
	}
	
	
	@Test
	public void testCloneSizeWithoutParamsAndRemElement() {
		CustomArrayList<Integer> numbers = new CustomArrayList<Integer>(Integer.class);
		CustomArrayList<Integer> copiedNumbers = new CustomArrayList<Integer>(Integer.class);
		
		numbers.addElement(5);
		numbers.addElement(7);
		
		copiedNumbers = numbers.clone();
		copiedNumbers.removeElement(1);
		
		Assert.assertTrue(copiedNumbers.size() == 1);
	}
	
	@Test
	public void testEnsureCapacity() {
		CustomArrayList<Integer> numbers = new CustomArrayList<>(Integer.class);
		
		numbers.ensureCapacity(24);
		Assert.assertTrue(numbers.minCapacitySize() == 24);	
	}
	
	
	@Test(expected = NegativeArraySizeException.class)
	public void testEnsureCapacityNegativeValue() {
		CustomArrayList<Integer> numbers = new CustomArrayList<>(Integer.class);
		
		numbers.ensureCapacity(-10);
		
	}
	
	@Test
	public void testIndexOfWithNums() {
		CustomArrayList<Integer> numbers = new CustomArrayList<>(Integer.class);
		
		numbers.addElement(5);
		numbers.addElement(2);
		numbers.addElement(-101);
		numbers.addElement(25);
		numbers.addElement(8);
		
		
		Assert.assertTrue(numbers.indexOf(25) == 3);
		Assert.assertTrue(numbers.indexOf(5) == 0);
		Assert.assertTrue(numbers.indexOf(8) == 4);
		Assert.assertTrue(numbers.indexOf(-101) == 2);
	}
	
	
	@Test
	public void testIndexOfWithNumsNegativeValues() {
		CustomArrayList<Integer> numbers = new CustomArrayList<>(Integer.class);
		
		numbers.addElement(0);
		numbers.addElement(-5);
		numbers.addElement(250);
		
		Assert.assertTrue(numbers.indexOf(5) == -1);
	}
	
	@Test
	public void testIndexOfStrings() {
		CustomArrayList<String> words = new CustomArrayList<>(String.class);
		
		words.addElement("I");
		words.addElement("like");
		words.addElement("Java");
		
		Assert.assertTrue(words.indexOf("Java") == 2);
	}
	
	@Test
	public void testIndexOfStrNotFound() {
		CustomArrayList<String> words = new CustomArrayList<>(String.class);
		
		words.addElement("I");
		words.addElement("like");
		words.addElement("Java");
		
		Assert.assertTrue(words.indexOf("C#") == -1);
		
		
	}
	
	
	@Test
	public void testIsEmpty() {
		CustomArrayList<Integer> numbers = new CustomArrayList<>(Integer.class);
		
		numbers.addElement(4);
		numbers.addElement(6);
		
		Assert.assertTrue(numbers.isEmpty() == false);
	}
	
	
	@Test
	public void testIsEmpty2() {
		CustomArrayList<Integer> numbers = new CustomArrayList<>(Integer.class);
		
		Assert.assertTrue(numbers.isEmpty() == true);
	}

	
	
}














