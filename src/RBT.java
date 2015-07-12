public class RBT {

	private RBTNode root;
	private RBTNode sentinel;

	public RBT(RBTNode r) {
		this.root = r;
		this.sentinel = new RBTNode();
		this.sentinel.color = "BLACK"; 
	}

	public RBT() {
		this(new RBTNode());
	}

	public void RBTRightRotate(RBTNode x){
		RBTNode y = x.leftChild;
		x.leftChild = y.rightChild;
		if (y.rightChild != sentinel) {
			y.rightChild.parent = x;
		}
		y.parent = x.parent;
		if (x.parent == sentinel) {
			this.root = y;
		} else if (x == x.parent.rightChild) {
			x.parent.rightChild = y;
		} else {
			x.parent.leftChild = y;
		}
		y.rightChild = x;
		x.parent = y;
	} 

	public void RBTLeftRotate(RBTNode x){
		RBTNode y = x.rightChild;
		x.rightChild = y.leftChild;
		if (y.leftChild != sentinel) {
			y.leftChild.parent = x;
		}
		y.parent = x.parent;
		if (x.parent == sentinel) {
			this.root = y;
		} else if (x == x.parent.leftChild) {
			x.parent.leftChild = y;
		} else {
			x.parent.rightChild = y;
		}
		y.leftChild = x;
		x.parent = y;
	} 

	public boolean insert(int d) {
		RBTNode z = new RBTNode(d);
        z.setLeftChild(sentinel);
        z.setRightChild(sentinel);
        z.setParent(sentinel);
        z.setColor("BLACK");
        if(this.root == sentinel) {
            this.root = z;
            return true;
        }
		RBTNode y = sentinel;
		RBTNode x = this.root;
		while (x != sentinel) {
			y = x;
			if (z.getData() < x.getData()) {
				x = x.getLeftChild();
			} else {
				x = x.getRightChild();
			}
		}

		z.setParent(y);
		if (y == sentinel) {
			this.root = z;
		} else if (z.getData() < y.getData()) {
			y.setLeftChild(z);
		} else {
			y.setRightChild(z);
		}
		z.setLeftChild(sentinel);
		z.setRightChild(sentinel);
		z.setColor("RED");

		// RB-Insert-FIXUP
		while (z.getParent().color == "RED") {
			if (z.parent == z.parent.parent.getLeftChild()) {
				y = z.parent.parent.getRightChild();
				
				if (y.color == "RED") {
					z.parent.color = "BLACK";
					y.color = "BLACK";
					z.parent.parent.color = "RED";
					z = z.parent.parent;
				} else if (z == z.parent.rightChild) {
					z = z.parent;

					// Left Rotate
					RBTLeftRotate(x); 
				}
				z.parent.color = "BLACK";
				z.parent.parent.color = "RED";
				//RIGHT ROTATE
                RBTRightRotate(x);
			} else {
				y = z.parent.parent.getLeftChild();
				
				if (y.color == "RED") {
					z.parent.color = "BLACK";
					y.color = "BLACK";
					z.parent.parent.color = "RED";
					z = z.parent.parent;
				} else if (z == z.parent.leftChild) {
					z = z.parent;

					// Right Rotate
					RBTRightRotate(x); 
				}
				z.parent.color = "BLACK";
				z.parent.parent.color = "RED";
				//RIGHT ROTATE
                RBTLeftRotate(x);
			}
		}
        this.root.color = "BLACK";
		return true;
	}

	public void printTree() {

	}

}
