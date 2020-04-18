package com.mukewang;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *  二分搜索树的实现
 * @author Administrator
 * @param <E>
 */
public class BST<E extends Comparable<E>> {
	
	
	private class Node{
		private E e;
		private Node left,right;
		
		public  Node(E e){
			this.e=e;
			left=null;
			right=null;
		}
	}
	
	private Node root;
	private int size;
	
	
	public BST(){
		root=null;
		size=0;
	}
	
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return size==0;
	}
	
	/**
	 * 添加元素
	 */
	public void add(E e){
		root=add(root,e);
	}

	 /**
	  *
	  *向以node为根节点的二分搜索树中添加元素，递归
	  * @param node
	  * @param e
	  */
	private Node add(Node node,E e){
		
		if(node==null){
			size++;
			return new Node(e); 
		}
	
		if(e.compareTo(node.e)<0){
			node.left=add(node.left,e);
		}else if(e.compareTo(node.e)>0){
			node.right=add(node.right,e);
		}
		return node;
	}
	
	/**
	 * 查看二分搜索树中是否含有元素e
	 * @param e
	 * @return
	 */
	public boolean contains(E e){
		return contains(root,e);
	}
	
	/**
	 * 查看二分搜索树中是否含有元素e，递归
	 * @param node
	 * @param e
	 * @return
	 */
	public boolean contains(Node node,E e){
		if(node==null){
			return false;
		}
		if(e.compareTo(node.e)==0){
			return true;
		}else if(e.compareTo(node.e)<0){
			return contains(node.left,e);
		}else{
			return contains(node.right,e);
		}
	}


	/**
	 * 前序遍历
	 */
	public void preOrder(){
		preOrder(root);
	}
	
	/**
	 * 前序遍历递归
	 * @param node
	 */
    private void preOrder(Node node){
		if(node==null){
			return;
		}
		
		System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
	}

    /**
     * 前序遍历的非递归算法
     */
	public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur=stack.pop();
            System.out.println(cur.e);
            if (cur.right!=null) {
                stack.push(cur.right);
            }
            if (cur.left!=null) {
                stack.push(cur.left);
            }
        }
    }

    /**
     * 中序遍历
     */
	public void inOrder(){
	    inOrder(root);
    }

    /**
     * 中序遍历,递归
     * @param node
     */
    private void inOrder(Node node){
	    if (node==null){
	        return;
        }
	    inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 后序遍历
     */
    public void lastOrder(){
        lastOrder(root);
    }

    /**
     * 后序遍历，递归
     * @param node
     */
    private void lastOrder(Node node){
        if (node==null){
            return;
        }
        lastOrder(node.left);
        lastOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * 层序遍历
     */
    public void levelOrder(){
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node cur=q.remove();
            System.out.println(cur.e);
            if (cur.left!=null){
                q.add(cur.left);
            }
            if (cur.right!=null) {
                q.add(cur.right);
            }
        }
    }



    /**
     * 寻找二分搜索树中的最小值
     * @return
     */
    public E minimum(){
        if (size==0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return  minimum(root).e;
    }

    /**
     * 递归寻找最小值
     * @param node
     * @return
     */
    private Node minimum(Node node){
        if (node.left==null){
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 寻找二分搜索树的最大值
     * @return
     */
    public E maximum(){
        if (size==0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return  maximum(root).e;
    }

    /**
     * 递归实现二分搜索树的最大值
     * @param node
     * @return
     */
    private Node maximum(Node node){
        if (node.right==null){
            return node;
        }
        return minimum(node.right);
    }

    /**
     * 删除最小值，并返回这个值
     * @return
     */
    public E removeMin(){
        E ret=minimum();
        root=removeMin(root);
        return ret;
    }

    /**
     * 删除以node为根的二分搜索树的最小值
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @return
     */
    private  Node removeMin(Node node){
        if (node.left==null){
            Node rightNode=node.right;
            node.right=null;
            size--;
            return rightNode;
        }
        node.left=removeMin(node.left);
        return node;
    }



    /**
     * 删除二分搜索树的最大值
     * @return
     */
    public E removeMax(){
        E ret=maximum();
        root=removeMax(root);
        return ret;
    }

    /**
     * 删除以node为根的二分搜索树的最大值
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @return
     */
    private Node removeMax(Node node){
        if (node.right==null){
            Node leftNode=node.left;
            node.left=null;
            size--;
            return leftNode;
        }
        node.right=removeMin(node.right);
        return node;
    }

    @Override
    public String toString(){
        StringBuilder builder=new StringBuilder();
        generateBSTString(root,0,builder);
        return builder.toString();
    }


    /**
     * 生成以node为根节点，深度为depth的描述二叉树的字符串
     * @param node
     * @param depth
     * @param builder
     */
    private void  generateBSTString(Node node,int depth,StringBuilder builder){
        if (node==null){
            builder.append(generateDepthString(depth)+"null\n");
            return;
        }
        builder.append(generateDepthString(depth)+node.e+"\n");
        generateBSTString(node.left,depth+1,builder);
        generateBSTString(node.right,depth+1,builder);
    }

    private String generateDepthString(int depth) {
        StringBuilder builder=new StringBuilder();
        for (int i=0;i<depth;i++){
            builder.append("--");
        }
        return builder.toString();
    }

    /**
     * 删除二分搜索树中的任意一个元素E e
     * @return
     */
    public  void  remove(E e){
        root=remove(root,e);
    }

    /**
     * 删除以node为根的二分搜索树中值为e的节点，递归算法
     * 返回删除节点后的新的二分搜索树的根
     * @param node
     * @param e
     * @return
     */
    private Node remove(Node node,E e){
        if (node==null){
            return null;
        }
        if(e.compareTo(node.e)<0){
            node.left=remove(node.left,e);
            return node;
        }else  if(e.compareTo(node.e)>0){
            node.right=remove(node.right,e);
            return node;
        }else { //e==node.e
            //此时要删除的节点就是这个节点
            //待删除的节点左子树为空
            if (node.left==null){
                Node rightNode= node.right;
                node.right=null;
                size--;
                return rightNode;
            }
            //待删除的节点右子树为空
            if (node.right==null){
                Node leftNode=node.left;
                node.left=null;
                size--;
                return leftNode;
            }
            //待删除的节点左右子树均不为空
            //找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            //用这个节点顶替待删除节点的位置
            //在这里也可以找待删除的节点的前驱，即待删除节点的左子树的最大节点
            Node successor=minimum(node.right);
            successor.right=removeMin(node.right);
            size++;
            successor.left=node.left;
            node.left=node.right=null;
            size--;
            return successor;
        }
    }
}
