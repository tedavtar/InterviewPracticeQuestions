import java.util.*;

public class BinaryTree{

    public BinaryTree left;
    public BinaryTree right;
    public int val;
    
    public BinaryTree(int val){
        this.val = val;
    }
    
    //this serializes the tree
    //format: BFS order, split with commas, null = "n"
    public static String Serialize(BinaryTree r){
        String rtn = "";
        if(r==null){return "n";}
        Queue<BinaryTree> q = new LinkedList<BinaryTree>();
        q.offer(r);
        while(!q.isEmpty()){
            
            BinaryTree t = q.poll();
            
            //is it null? or has a value?
            if(t!=null){//has a value-write it
                int val = t.val;
                rtn += val;
                rtn += ",";
            } else {
                rtn += "n,";
                continue;
            }
            q.offer(t.left);
            q.offer(t.right);
        }
        return rtn;
    }
    
    //deserialize
    public static BinaryTree Deserialize(String s){
        if(s==null || s.length() == 0){return null;}
        String[] nodes = s.split(",");
        /*
        for(String test: nodes){
            System.out.println(test);
        }*/
        //make sure no leading "n"
        if(nodes[0].equals("n")){return null;}
        int index = 1;
        int rval = Integer.parseInt(nodes[0]);
        
        BinaryTree r = new BinaryTree(rval);
        Queue<BinaryTree> q = new LinkedList<BinaryTree>();
        q.offer(r);
        
        while(index < nodes.length){
            BinaryTree prev = q.poll();
            //System.out.println("prev" + prev.val);
            //do left
            String tstr = nodes[index];
            if(tstr.equals("n")){
                prev.left = null;
                index++;
                //continue;
            } else {
                int tval = Integer.parseInt(tstr);
                BinaryTree t = new BinaryTree(tval);
                index++;
                
                //System.out.println(t.val);
                prev.left = t;
                q.offer(t);
            }
            //do right
            String t1str = nodes[index];
            if(t1str.equals("n")){
                prev.right = null;
                index++;
                //continue;
            } else {
                int t1val = Integer.parseInt(t1str);
                BinaryTree t1 = new BinaryTree(t1val);
                index++;
                //System.out.println(t1.val);
                prev.right = t1;
                q.offer(t1);
            }
            
        }
        
        return r;
    }

    public static void main (String[] args){
        //BinaryTree n = null;
        BinaryTree r = new BinaryTree(1);
        BinaryTree rl = new BinaryTree(2);
        BinaryTree rr = new BinaryTree(3);
        BinaryTree rrl = new BinaryTree(4);
        r.left = rl;
        r.right = rr;
        rr.left = rrl;
        String test = Serialize(r);
        System.out.println("serialized: " + test);

        
        BinaryTree res = Deserialize(test);//should get r
        
        System.out.println("reserialized: " + Serialize(res));
    }

}