package cscd211LinkedList;

import java.util.NoSuchElementException;

public class LinkedList<E extends Comparable<E>> {

	private Node<E> head;
	private static int size = 1;

	/**
	 * Constructs an empty list
	 */
	public LinkedList() {
		head = new Node<E>(null,head);
	}

	// This method add the element of first postion of list
	public void addFirst(final E item) {
		// add element on top of list
			head.next = new Node<E>(item, head.next);
		size++;
	}

	// This method check if the elments in available on list or not
	public boolean contains(final E o) {
		// check if the location of element and return it if the element if
		// available , otherwise it will return -1 to represent that element is
		// not found
		return indexOf(o) != -1;
	}

	// This method add element on the last poistion of list
	public void addLast(final E item) {
		// First it check if there is any other element or not if not the its
		// create element on first position ,
		// otherwise it add the element on the last positon of list
		if (head.next == null) {
			addFirst(item);

		} else
	      {
	         Node<E> tmp = head.next;
	         while(tmp.next != null) tmp = tmp.next;

	         tmp.next = new Node<E>(item, null);
	      }

		size++;
	}
	
	//0				1		2		3			4
	//Chemistry  , physics, maths , english , arts
	//Chemistry  , physics, maths , programming , english , arts
	// This method add elmeent based on user input
	
	//  						3			programming
	public void add(final int index, final E data) {
		// create a node which hold the value of first element of list
		Node<E> temp = head.next;
		// create empty Node name holder
		Node<E> holder;

		// This is looping the till the location where the user wanna add the
		// element
		//				 < 3-1=2
		for (int i = 0; i < index - 1 && temp.next != null; i++) {
			// this will hold the last element value of the specified lcation
			// where the user wanna store the element
			
			//physics , maths
			temp = temp.next;
		}
		
		// temp = maths
		
		//holder = empty
		// this do some swapping
		
		holder = temp.next;
		temp.next = new Node<E>(data);
		//holder = english
		//Chemistry  , physics, maths , programming , arts
		//art = enlgish
		temp.next.next = holder;
		//
		
		size++;
	}

	// This method retrieve element on specified index
	public Node<E> get(final int index) {
		return entry(index);
	}

	// This method check the element and retrieve the last location of element
	public int lastIndexOf(final E obj) {
		//chemistry , phsycis , maths , english , arts, programming,maths
		// result hold the first value of list
		Node<E> result = head.next;

		// initialize variable name lastIndex to -1
		int lastIndex = -1;

		// loop to the list of elements
		for (int i = 1; result != null; i++, result = result.next) {
			// if element is found then keep add 1 the value of lastIndex until
			// the last location of element found
			if (result.data.equals(obj)) {
				lastIndex = i;
			}
		}

		// return the location last lcation of the element
		return lastIndex;
	}

	// This method retrive the element the element on specified index
	private Node<E> entry(final int index) {
		// check if the index is greater than 0 and less then total size of list
		// ,
		// if its greater than then total size of list and less then 0 , its
		// mean that the element can't be find it the list an dit will return
		// exception
		// we can't check the element outside boundries of list
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		
		//chemistry , phsycis , maths , english , arts, programming,maths
		Node<E> e = head.next;
		System.out.println("Entry head :" + head.next.data);

		// if index value is less then total size of the list , then this code
		// will be execute to find the element on given location
		
			//2
		if (index < size) {
			for (int i = 0; i <= index; i++) {
				if (i == index) {
					return e;
				}
				//physics, maths
				e = e.next;
				System.out.println("Entry e next :" + e.data);
			}
		} else {
			for (int i = size; i > index; i--) {
				if (index == i) {
					return e;
				}
				while(e.next!=null){ 
				e = e.next;
				}
			}

		}
		return e;
	}

	// This method clear all the elements on list
	public void clear() {
		head.next = null;
		size = 0;
	}

	// This method retreive the first element on list
	public E getFirst() {
		if (head.next == null)
			throw new NoSuchElementException();

		return head.next.data;
	}

	// This method retreive the location of specified element
	//chemistry , phsycis , maths , english , arts, programming,maths
	
	//						maths
	public int indexOf(final E o) {
		
        int index = 2;
        
        if(head.next.data.equals(o)) {
        	return 1;
        }
        if (o==null && head.next.next !=null) {
            for (Node<E> e = head.next.next; e != head; e = e.next) {
                if (e.data==null){
                    return index;
                }
                index++;
            }
        } else if(head.next !=null) {
            for (Node<E> e = head.next.next; e != head; e = e.next) {
                if (o.equals(e.data)){
                    return index;
           
                }
                index++;
               
            }
            
        }
        return -1;
    }
	
	
	// This method remove the first element on list
	public E removeFirst() {
		// Node<E> tmp = head.next;
		remove(head.next.data);
		return head.next.data;
	}

	// The method remove the element based on its data
	//chemistry , phsycis , maths , english , arts, programming,maths
	public boolean remove(final E key) {
		if (head.next == null)
			// throw new RuntimeException("cannot delete");
			return false;
		System.out.println("Key :" + key);

		// check the first element of list is equal to the given element by user
		// if it is then the first element of list is replace by the next
		// element to first element
		if (head.next.data.equals(key)) {
			head.next = head.next.next;
			return true;
		}

		// check a current node which is equal to first element of the list
		Node<E> cur = head.next;
		Node<E> prev = null;

		System.out.println("Head :" + cur.data);
		// if the current element isnot initialized or and the current element
		// data is not equal to the given element by user
		while (cur != null && !cur.data.equals(key)) {
			// then the previous element become the current
			prev = cur;
			// current element become the next element to the current until
			// current element is equal to the element given by the user
			cur = cur.next;
		}

		if (cur == null)
			// throw new RuntimeException("cannot delete");
			return false;

		// delete cur node
		prev.next = cur.next;
		size--;
		return true;
	}

	// This method remove element based on its position
	//chemistry , phsycis , maths , english , arts, programming,null
	public E remove(int position) {
		// Complete this method
		Node<E> current = head.next;
		Node<E> parent = null;
		int index = 1;

		while (current != null && index < position) {
			parent = current;
			current = current.next;

			index++;
		}

		if (current != null && parent == null) {
			// Delete head.
			if (current.next != null) {
				// Move head to next value.
				head.next = current.next;
			} else {
				// Just set the head to null.
				head.next = null;
			}
		} else if (current != null) {
			// Delete current, link parent to child..
			
			//programming	maths
			//next value toprogramming which is maths  = next valu e to the current value null
			parent.next = current.next;
		}
		size--;
		return head.data;
	}

	// This method removes the last element on list
	public E removeLast() {
		if(head.next == null) throw new NoSuchElementException();

	      Node<E> tmp = head.next;
	      while(tmp.next != null){ tmp = tmp.next;}
	        remove(tmp.data);
	        return tmp.data;
	}

	// this metho reteive the size of list
	public int size() {
		return size;
	}

	// this method print all all the elements on list
	public void show() {
		if(head.next !=null) {
		Node<E> node = head.next;
			System.out.println(node.data);
			while (node.next != null) {

				node = node.next;
				System.out.println(node.data);
			}
		}else {
		System.out.println("No data found.Please add some data.");
		}
		System.out.println();
	}

	// This method remove the element on its last postion
	//chemistry , phsycis , maths , english , arts, programming,maths
	public boolean removeLastOccurrence(final E o) {
		int index = lastIndexOf(o);
		System.out.println("Index :" + index);
		E temp = remove(index);

		if (temp != null) {
			System.out.println("Temp remove last occurence:" + temp);
			return true;
		}
		return false;

	}
	

	// This method remove the element on its first postion
	public boolean removeFirstOccurrence(final E item) {
		int index = indexOf(item);
		//maths = on second position
		Node<E> node = get(index);
		E temp = remove(index);
		System.out.println("Remove firs toccurence :" + index + "Temp data :" + temp);
		if (temp != null) {
			return true;
		}
		return false;

	}

	@Override
	public String toString() {
		Node<E> current = head.next;
		String str = "";
		System.out.println("Checkpoint 1001");
		if(current !=null) {
			System.out.println("Checkpoint 1002");
		str +=current.data;
		while(current!=head) {
			if(current.next!=null){ 
				current = current.next;
			}else {
				return str;
			}
			System.out.println(current.data+"Iteration");
			str +=" , "+ current.data;
		}}else {
			str = "Please add some data. you have an empty list";
		}
		
		return str;
	}

	// This is Simple Generic node class
	private static class Node<E> {
		private E data;
		private Node<E> next;

		public Node() {

		}

		public Node(final E data) {
			this.data = data;

		}

		public Node(final E data, final Node<E> next) {
			this.data = data;
			this.next = next;
		}

	}

}
