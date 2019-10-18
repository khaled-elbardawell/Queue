
package queuedata;

class queueNode{
    Object item;
    queueNode link;
    public queueNode(){
        this(null,null);
    }
    
    public queueNode(Object item, queueNode link) {
        this.item = item;
        this.link = link;
    }
}

class queue{
    queueNode front , rear;
    int length;
    public int size(){
        return length;
    }
    
     public boolean isEmpty(){
         if(front == null){
           return true;  
         }
        return false;
    }
     
     
       public boolean isFull(){
         if(this.size() == 5){
           return true;  
         }
        return false;
    }
     
    public void print(){
        queueNode n=front;
        if(front == null){
            System.out.println("The Queue is empty !! ");
        }else{
            while( n != null){
                System.out.println(n.item);
                n = n.link;
            }
        }
    }
    
    public void enqueue(Object item){
        queueNode newNode=new queueNode(item,null);
        if( front == null ){
            front=rear=newNode;
            ++length;
        }else if(this.isFull()){
              return;
            }else{
             rear.link=newNode;
             rear=rear.link;
            ++length;
        }
    }
    
      public Object dequeue(){
        if( front == null ){
            return "The Queue is empty !! "; 
        }else{
            Object itemDel=front.item;
            front=front.link; 
            --length;
            return itemDel;
        }
    }
}

public class QueueData {

    public static void main(String[] args) {
     queue q = new queue();
        System.out.println("*********** Queue After push ****************");
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);//full >> enqueue nothing to do , becuse the queue size = 5  
        q.print();
         
         System.out.println( "The size >> "+q.size() ); 
         System.out.println( "Queue is full ? >> "+q.isFull() ); 
          
          
        System.out.println("*********** Queue After Delete ****************");
       
        q.dequeue();
        q.print();
        
         System.out.println( "The size >> "+q.size() ); 
         System.out.println( "Queue is full ? >> "+q.isFull() );
    }
    
}
