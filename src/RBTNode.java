import java.util.ArrayList;
/**
 * Red Black Tree Node 
 * @author Quiksilvr JThurst3
 *
 */

public class RBTNode {
	
	RBTNode parent; 
	RBTNode leftChild;
	RBTNode rightChild; 
	String color; 
	
	public RBTNode(){
		this.parent = null; 
		this.leftChild = null; 
		this.rightChild = null;
	} 
	
	public void setColor(String c){
		this.color = c; 
	}
   
	public String getColor(){
		return color; 
	}
	
	public void setParent(RBTNode node) {
		parent = node; 
	}
	
	public void setLeftChild(RBTNode node){
		leftChild = node; 
	} 
	
	public void setRightChild(RBTNode node){
		leftChild = node; 
	}
	
	public RBTNode getParent(){
		return parent; 
	}
	
	public RBTNode getLeftChild() {
		return leftChild; 
	} 
	
	public RBTNode getRightChild() {
		return rightChild; 
	}		
}
