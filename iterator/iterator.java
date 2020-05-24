//iterator
public interface Iterator {
   public boolean hasNext();
   public Object next();
}
//Container
public interface Container {
   public Iterator getIterator();
}
//name Repo
public class NameRepository implements Container {
   public String names[] = {"Robert" , "John" ,"Julie" , "Lora"}; //4
   //Aggregation -> class $$ object
   //compostion -> class && object -> new object -> constructor
   @Override
   public Iterator getIterator() {
      return new NameIterator();
   }
private class NameIterator implements Iterator {

      int index=0;

      @Override
      public boolean hasNext() {
      
         if(index < names.length){
            return true;
         }
         return false;
      }
        //for loop -> has next->false
      @Override
      public Object next() {
        
         if(this.hasNext()){
            return names[index++];
         }
         return null;
      }		
   }
}
//traverse
public class IteratorPatternDemo {
	
   public static void main(String[] args) {
      NameRepository namesRepository = new NameRepository();
      //foreach(string str:names)
      for(Iterator iter = namesRepository.getIterator(); iter.hasNext();){
         String name = (String)iter.next();
         System.out.println("Name : " + name);
      } 	
   }
}