import java.lang.reflect.Array;
import java.util.Collection;

public class CustomArrayList<T extends Comparable<T>> {
	private T[] myCustomList;
	private Class<T> cl;
	private int index;
	
	
	@SuppressWarnings("unchecked")
	public CustomArrayList(Class<T> cl) {
		this.cl = cl;
		this.myCustomList = (T[]) Array.newInstance(this.cl, 8);
		this.index = 0;	
		
	}
	
	
	@SuppressWarnings("unchecked")
	public void addElement(T element) {
		//check if the current array has a place for a new element
		if(this.index < this.myCustomList.length) {
			this.myCustomList[this.index] = element;
			this.index++;
		}else {
			//if there is no place for the new element then copy current array
			//and create new bigger array
			T[] oldArray = this.myCustomList;
			this.myCustomList = (T[])Array.newInstance(cl, oldArray.length*2);
			
			//copy values from the old array to the new one.
			for(int i = 0; i < oldArray.length; i++) {
				this.myCustomList[i] = oldArray[i];
			}
			
			//And, in the end put the new element in the new created array
			this.myCustomList[this.index] = element;
			
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public void addElement(int index, T element) throws Exception {
		if(index < 0) {
			throw new Exception("Invalid index. Cannot be less than zero.");
		}
		
		//check if the index is in size of the array
		if(index <= this.myCustomList.length - 1) {
			this.myCustomList[index] = element;
			this.index++;
		}else {
			
			T[] oldArray = this.myCustomList;
			int size = oldArray.length;
			
			//if the index is bigger of the array size then increase number of size
			//until size become bigger than the user's index and then I use size to
			//make new array with that new size. 
			while(index >= size) {
				size *= 2;
			}
			
			//create new array with the new calculated size bigger than the user's index
			this.myCustomList = (T[])Array.newInstance(cl, size);	
			
			//copy values from the old array to the new one
			for(int i = 0; i < this.myCustomList.length; i++) {
				if(i < oldArray.length) {
					this.myCustomList[i] = oldArray[i];
				}
				
			}
			
			//And, in the end put the user's element on the given index.
			this.myCustomList[index] = element;
		}
	}
	
	
	public T getElement(int position) {
		if(position < 0 || position > this.myCustomList.length) {
			throw new IndexOutOfBoundsException("No such position");
		}
		
		return this.myCustomList[position];
	}
	
	
	@SuppressWarnings("unchecked")
	public void addAll(Collection<? extends T> c) {
		T[] oldArray = this.myCustomList;
		int size = c.size() + this.index;
		
		this.myCustomList = (T[])Array.newInstance(cl, size);
		
		int currentIndex = 0;
		for(T element : c)
			{
				this.myCustomList[currentIndex] = element;
				
				currentIndex++;
			}
//		for(T element : oldArray)
//		{
//			if(currentIndex == size) break;
//			this.myCustomList[currentIndex] = element;
//			
//			currentIndex++;
//		}
		
//		currentIndex = this.index;
		for(T element : oldArray)
			{
				if(currentIndex == size) break;
				this.myCustomList[currentIndex] = element;
				
				currentIndex++;
			}
//		for(T element : c)
//		{
//			this.myCustomList[currentIndex] = element;
//			
//			currentIndex++;
//		}
		
		
		this.index = currentIndex - 1;
		
	}
	
	
	@SuppressWarnings("unchecked")
	public void removeAll(Collection<? extends T> c) {

		//find the count of the repeating elements in user collection and myList.
		int repeatedElementsCount = 0;
//		
		
		for(T myListEl : this.myCustomList) {
			if(c.contains(myListEl)) {
				repeatedElementsCount++;
			}
		}
		
		
		T[] oldArray = this.myCustomList;
		T[] userCollArray = (T[])Array.newInstance(this.cl,c.size());
		T[] bothCollections = (T[])Array.newInstance(this.cl, oldArray.length + c.size());
		Integer[] indices = (Integer[])Array.newInstance(Integer.class, userCollArray.length);
		int newArraySize = this.myCustomList.length - repeatedElementsCount;
		this.myCustomList = (T[])Array.newInstance(this.cl, newArraySize);
		int currIndex = 0;
		
		
		//fill out user collection in array
		int userCollCurrIndex = 0;
		
		for(T userElementCol : c) {
			userCollArray[userCollCurrIndex] = userElementCol;
			indices[userCollCurrIndex] = userCollCurrIndex;
			userCollCurrIndex++;
		}
		
		
		//fill bothCollections array with my current list elements
		for(int i = 0; i < oldArray.length; i++) {
			bothCollections[i] = oldArray[i];
			if(oldArray[i] != null) {
				currIndex++;
			}
		}
		
//		System.out.println(currIndex);
//		System.out.println(oldArray.length);
//		System.out.println(userCollArray.length);
		
		int ind = 0;
		
//		fill bothCollections array with elements of user collection
		for(int u = currIndex; u < oldArray.length; u++) {
		
			if(ind < userCollArray.length) {
				bothCollections[u] = userCollArray[ind];
			}
			
			ind++;
		}
		
		
		//copy non-repeating elements from oldArray to the new one.
		boolean reapeated = false;
		
		for(int i = 0; i < oldArray.length; i++) {
			
			if(oldArray[i] == null) {
				break;
			}
			
			for(int a = 0; a < userCollArray.length; a++) {
				if(oldArray[i] == userCollArray[a]) {
					reapeated = true;
					break;
				}
			}
			
			if(!reapeated) {
				this.myCustomList[i] = oldArray[i];
			}
			
			reapeated = false;
			
		}
		
		
		
//		for(int i = 0; i < userCollArray.length; i++) {
//			for(int a = 0; a < oldArray.length; a++) {
//				if(i < userCollArray.length) {
//					if(oldArray[i] != userCollArray[i]) {
//						this.myCustomList[i] = oldArray[i];
//					}
//				}else {
//					if(oldArray[i] != userCollArray[userCollArray.length - 1 - i]) {
//						this.myCustomList[i] = oldArray[i];
//					}
//				}
//				
//			}
//		}
		
		
		//fill the new myCustomListArray with no repeating elements
//		boolean repeatedNumber = false;
//		
//		for(int i = 0; i < this.myCustomList.length; i++) {
//			T el1 = oldArray[i];
//			for(int a = 0; a < bothCollections.length; a++) {
//				
//				T el2 = bothCollections[a];
//				
//				if(oldArray[i] == bothCollections[a]) {
//					repeatedNumber = true;
//					break;
//				}
//				else {
//					repeatedNumber = false;
////					this.myCustomList[i] = bothCollections[a];
//				}
//				
//				
//			}
//			
//			if(!repeatedNumber) {
//				this.myCustomList[i] = bothCollections[i];
//			}
//			
//			repeatedNumber = false;
//			
//		}
		System.out.println("debug");
		
		
		
		
//		//searching in small array to the big for repeating elements
//		for(int i = 0; i < userCollArray.length; i++) {
//			for(int a = 0; a < oldArray.length; a++) {
//				if(oldArray[i] != userCollArray[i]) {
//					this.myCustomList[i] = oldArray[i];
//				}
//			}
//			
//			currIndex = i;
//			
//		}
//		
//		//searching from the big array to the small for repeating elements
//		
//		for(int i = currIndex; i < oldArray.length; i++) {
//			for(int a = 0; a < userCollArray.length; i++) {
//				if(oldArray[i] != userCollArray[a]) {
//					this.myCustomList[i] = oldArray[i];
//				}
//			}
//		}
//		
//		System.out.println(currentIndex);
		
		
//		for(int i = 0; i < oldArray.length; i++) {
//			for(int a = 0; i < indices.length; i++) {
//				if(i != indices[a]) {
//					this.myCustomList[i] = oldArray[i];
//				}
//			}
//			
//			if(i < this.myCustomList.length) {
//				this.myCustomList[i] = oldArray[i];
//			}
//		}
		
//		for(int i = 0; i < this.myCustomList.length; i++) {
//			
//			for(int a = 0; a < userCollArray.length; a++) {
//				
//				T v1 = oldArray[i];
//				T v2 = userCollArray[a];
//				
//				if(oldArray[i] == userCollArray[a]) {
//					contains = true;
//					break;
//				}
//			}
//			
//			if(!contains) {
//				this.myCustomList[i] = oldArray[i];
//			}
//			
//			contains = false;
//			
//			
//		}
		
///////////////////////////////////////////////////////////////////////////////////		

		
//		for(T oldElement : oldArray) {
//			
//			T prevEl = oldElement;
//			
//			if(currIndex < this.myCustomList.length) {
//				if(oldArray[currIndex] != userCollArray[currIndex]) {
//					this.myCustomList[currIndex] = oldArray[currIndex];
//				}
//			
////				for (T userElement: c) {
////					if(prevEl != userElement) {
////						this.myCustomList[currentIndex] = oldArray[currentIndex];
////					}
////					
//////						if(oldArray[currentIndex].compareTo(userElement) == 0 && prevEl == oldElement ) {
//////							continue;
//////						}else {
//////							this.myCustomList[currIndex] = oldArray[currentIndex];
//////						}
////						currIndex++;
////					}
//				
//				
//
//				
//				
//			  }
//			
//			
//			
//			
//		}
		
		
///////////////////////////////////////////////////////////////////////////////		
		
		
		
		
//		for(T userCollectionEl : c) {
//			if(c.contains(this.myCustomList)) {
//				repeatedElementsCount++;
//			}
//		}
		
//		int newArraySize = this.myCustomList.length - repeatedElementsCount;
//		T[] repeatedElements = (T[])Array.newInstance(this.cl, newArraySize);
//		
//		for(T myListEl : this.myCustomList) {
//			for(T userColl : c) {
//				if(c == userColl) {
//					repeatedElements[currentIndex] = userColl;
//				}
//				
//			}
//			currentIndex++;
//		}
//		
//		T[] oldArray = this.myCustomList;
//		int size = this.myCustomList.length - repeatedElements.length;
//		this.myCustomList = (T[])Array.newInstance(cl, size);
//		int index = 0;
//		
//		for(T oldEl : oldArray) {
//			for(T repeatEl : repeatedElements) {
//				if(oldEl != repeatEl) {
//					this.myCustomList[index] = oldEl;
//				}
//				
//			}
//			
//			this.myCustomList[index] = oldEl;
//			index++;
//		}
		
		
		
	}
	
	
	public Boolean contains (T element) {
		
		boolean found = false;
		
		for(T el : this.myCustomList) {
			if(el == element) {
				found = true;
			}
		}
		
		return found;
	}
	
	
	@SuppressWarnings("unchecked")
	public void removeElement(int position) {
		if(position < 0 || position > this.myCustomList.length) {
			throw new IndexOutOfBoundsException("No such position");
		}
		
		//copy the current array in oldArray variable and then create new array with
		//one element less
		T[] oldArray = this.myCustomList;
		this.myCustomList = (T[])Array.newInstance(cl, oldArray.length - 1);
		
		//copy the values from oldArray to the new one without the unnecessary element
		//on the position given by the user.
		for(int i = 0; i < oldArray.length - 1; i++) {
			if(i == position) {
				continue;
			}else {
				this.myCustomList[i] = oldArray[i];
			}
		}
		
		
	}
	
	
	@SuppressWarnings("unchecked")
	public void clear() {
		int sizeOfCollection = this.myCustomList.length;
		
		this.myCustomList = (T[])Array.newInstance(this.cl, sizeOfCollection);
	}
	
	
	public int size() {
		return this.myCustomList.length;
	}
	
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < this.myCustomList.length; i++) {
			if(i == this.myCustomList.length - 1) {
				if(this.myCustomList[i] != null) {
					sb.append(this.myCustomList[i]);
				}
				
			}else {
				if(this.myCustomList[i] != null) {
					sb.append(this.myCustomList[i] + ", ");
				}
				
			}
		}
		
		return sb.toString();
	}
	
}
