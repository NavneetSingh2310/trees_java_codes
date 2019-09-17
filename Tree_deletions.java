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

class Main {
    
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
  
  
  
  //*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-------------------------*-*-*-*-*-*-*-*--*-*-*-*-*-*-----------------------
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

//*-*-*-*-*-*-*---*-----------------------*-*-*-**----*-------------------------
 public static int countAll=0;

  public static int countInternalNodes(Node root)
  {
     
      if(root==null) return 0;
      else {
          countAll++;
          countInternalNodes(root.left);
          
          countInternalNodes(root.right);
           
      }
      
      
      return (countAll-count-1);
 }
 
 //------------------------------------------------------------------------------------
 public static int inarray[]=new int[1000];
 public static int k=0;
 
 public static void checkInorderAtEveryPosition(Node root)
 {
     if(root==null) return;
     else{
         checkInorderAtEveryPosition(root.left);
         inarray[k++]=root.data;
         checkInorderAtEveryPosition(root.right);
     }
     inarray[k]='\0';
 }
 
 public static int countBST=0;
 public static int countBSTs(Node root)
 {
     
     k=0;
     
     if(root==null) return 0;
     else{
         checkInorderAtEveryPosition(root);
         int flag=0;
         for(int i=0;i<k-1;i++)
         {
             if(inarray[i]>inarray[i+1]) flag=1;
         }
         
         if(flag==0) countBST++;
         
         countBSTs(root.left);
         countBSTs(root.right);
     }
     
     return countBST;
     
     
 }
 
 public static Node parent=null;
 public static Node deleteNode(Node root,int value)
 {
     Node ptr=null;
     if(value>root.data)
     ptr=root.right;
     else ptr=root.left;
     
     parent=ptr;
     
     while(ptr!=null && ptr.data!=value)
     {
         parent=ptr;
         
         if(value>ptr.data) ptr=ptr.right;
         else ptr=ptr.left;
         
     }
     System.out.println("Parent: "+parent.data);
     System.out.println("Node: "+ptr.data);
     
     //leaf node
     
     if(ptr.left==null && ptr.right==null)
     {
         if(ptr.data>parent.data)
         parent.right=null;
         else parent.left=null;
     }
     
     else if(ptr.left!=null && ptr.right==null || ptr.right!=null && ptr.left==null)
     {
         Node x=null;
         if(ptr.left!=null)
         {
             x=ptr.left;
         }
         else{
             x=ptr.right;
         }
         
        if(parent.data<ptr.data)
        parent.right=x;
        else parent.left=x;
     }
     
     else if(ptr.left!=null && ptr.right!=null)
     {
         
         Node ptr2=ptr.left;
         Node parent2=ptr2;
         
         while(ptr2.right!=null )
         {
             parent2=ptr2;
             ptr2=ptr2.right;
         }
         
         
         ptr.data=ptr2.data;
         
         if(parent==parent2)
         parent.left=null;
         else 
         parent2.right=null;
        
         
     }
     return root;
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
	   System.out.println("Internal Nodes count: "+countInternalNodes(root));
	   System.out.println("BST count: "+countBSTs(root));
	   
	   System.out.println("Enter value to be deleted: ");
	   
	   int value=19;
	   root=deleteNode(root,value);
	   
	   inPrint(root);
	   
	   
	 
	}
}
