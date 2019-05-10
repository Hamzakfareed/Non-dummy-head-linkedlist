package cscd211Lab2;


import java.util.Scanner;

import cscd211LinkedList.LinkedList;
import cscd211Methods.LinkedListMethods;

/**
 * The class that contains main and is used for testing our LinkedList code
 * All preconditions will be checked and all parameters will be passed as final
 */
public class CSCD211Lab2
{
    /**
     * The main method. The information about this method is describe above.
     * 
     * @param args
     * Any command line parameters that are passed in. If there are
     * any they will be ignored by the program
     */
   public static void main(String [] args)
   {
      boolean res =  false;
      String str = null, item = null;
      int choice =0 , result = 0, index = 0;
      
      Scanner kb = new Scanner(System.in);
      
      LinkedList <String> myList = new LinkedList<String>();
 
      do
      {
         choice = LinkedListMethods.menu(kb);
         
         switch(choice)
         {
            case 1:  
            		//myList.show();
            		
            	System.out.println(myList);
                     break;
                     
            case 2:  str = LinkedListMethods.buildAString(kb);
                     myList.addFirst(str);
                     break;
            
            case 3:  str = LinkedListMethods.buildAString(kb);
                     myList.addLast(str);
                     break;
            
            case 4:  str = LinkedListMethods.buildAString(kb);
                     index = LinkedListMethods.readIndex(kb);
                     myList.add(index, str);
                     break;

            case 5:  str = LinkedListMethods.buildAString(kb);
                     res = myList.contains(str);
                     System.out.println("The results of contains " + res);
                     break;

            case 6:  str = LinkedListMethods.buildAString(kb);
                     result = myList.indexOf(str);
                     System.out.println("The results of indexOf " + result);
                     break;

            case 7:  item = myList.removeFirst();
                     System.out.println("The results from remove " + item);
                     break;

            case 8:   item = myList.removeLast();
                     System.out.println("The results from remove " + item);
                     break;

            case 9:  index = LinkedListMethods.readIndex(kb);
                     item = myList.remove(index);
                     System.out.println("The results from remove " + item);
                     break;

            case 10: str = LinkedListMethods.buildAString(kb);
                     res = myList.removeFirstOccurrence(str);
                     System.out.println("The results of contains " + res);
                     break;
                     
            case 11: str = LinkedListMethods.buildAString(kb);
                     res = myList.removeLastOccurrence(str);
                     System.out.println("The results of contains " + res);
                     break;
                     
            case 12: myList.clear();
                     break;
                     
            case 13: System.out.println("List size: " + myList.size());
                     break;            

            case 14: System.out.println("Program ending");
            		 break;
            		 
            default:
            	System.out.println();
            	System.out.println();
            	System.out.println("You choosed invalid option option, Please try again!");
            	System.out.println();
            	System.out.println();
         
         }// end switch
      
      }while(choice != 14);
      
      kb.close();
   
   }// end main

}// end class