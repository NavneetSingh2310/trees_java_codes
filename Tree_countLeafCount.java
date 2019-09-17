/*package whatever //do not write package name here */

import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int d)
    {
        data=d;
        left=null;
        right=null;
    }
}

class GFG {
    
    public static Node treeInsertion(Node root,int a[])
    {
        int n=a.length;

        for(int i=0;i<n;i++)
        {
            Node node=new Node(a[i]);
            
            if(root==null)
            root=node;
            else{
                Node ptr=root;
                Node preptr=ptr;
                
                while(ptr!=null)
                {
                   preptr=ptr;
                    
                    if(ptr.data>node.data)
                    ptr=ptr.left;
                    else ptr=ptr.right;
                    
                }
                  if(preptr.data>node.data)
                    preptr.left=node;
                    else preptr.right=node;
                
                
            }
            
        }
        
        return root;
    }
    
public static void inPrint(Node root )
  {
      if(root == null) return;
      inPrint(root.left);
      System.out.print(root.data+" ");
      inPrint(root.right);
  }
  
      
public static void postPrint(Node root )
  {
      if(root == null) return;
      postPrint(root.left);
    
      postPrint(root.right);
      System.out.print(root.data+" ");
  }
  
      
public static void prePrint(Node root )
  {
      if(root == null) return;
        System.out.print(root.data+" ");
      prePrint(root.left);
    
      prePrint(root.right);
  }
  
  public static int count=0;
  
  public static int countLeafNodes(Node root)
  {
     
      if(root==null) return 0;
      else {
           if(root.left==null && root.right==null) count++;
          countLeafNodes(root.left);
         
          countLeafNodes(root.right);
      }
      
      return count;
      }
 
    
	public static void main (String[] args) {
	   Scanner sc=new Scanner(System.in);
	   int n=sc.nextInt();
	   int a[]=new int[n];
	   for(int i=0;i<n;i++)
	   a[i]=sc.nextInt();
	   
	   Node root=null;
	   
	   root=treeInsertion(root,a);
	   
	   System.out.print("Inorder: ");
	   inPrint(root);
	   System.out.println();
	   
	   System.out.print("Postorder: ");
	  postPrint(root);
	    System.out.println();
	    
	   System.out.print("Preorder: ");
	   prePrint(root);
	   System.out.println();
	   
	   System.out.println("Leaf Nodes count: "+countLeafNodes(root));
	 
	}
}