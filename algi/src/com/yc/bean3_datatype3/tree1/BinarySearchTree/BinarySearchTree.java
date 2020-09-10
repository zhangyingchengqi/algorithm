package com.yc.bean3_datatype3.tree1.BinarySearchTree;

/**
 * ����������
 * <br />
 * public void insert( Comparable element )       //����½ڵ㵽���У�ע�⣬���������ͬԪ��.<br />
 * private BinaryNode insert(Comparable element, BinaryNode root)<br />
 * public void remove( Comparable element)     //������ɾ��ָ��Ԫ��. <br />
 * private BinaryNode remove(Comparable element, BinaryNode root)<br />
 * <p>
 * public boolean isEmpty()<br />
 * public void makeEmpty()<br />
 * <p>
 * <br />*********************��ѯ����*********************<br />
 * public Comparable  find( x)      //�ݹ�ʵ�ֲ������� ��ֵΪ x��Ԫ��<br />
 * private BinaryNode find(  Comparable element, BinaryNode t  );<br />
 * public Comparable  iterativeFind( x)      //�ǵݹ�ʵ�ֲ������� ��ֵΪ x��Ԫ��<br />
 * private BinaryNode iterativeFind(  Comparable element, BinaryNode t  );<br />
 * public Comparable findMin()   //����������Сֵ<br />
 * private BinaryNode findMin(  BinaryNode root  )<br />
 * public Comparable findMax()   //�����������ֵ<br />
 * private BinaryNode findMax(  BinaryNode root  )<br />
 * <p>
 * <br />*********************�������*********************<br />
 * public void printTreePreOrder()         //ǰ�����<br />
 * private void printTreePreOrder(   BinaryNode root    )<br />
 * public void printTreeInOrder()         //�������<br />
 * private void printTreeInOrder(   BinaryNode root    )<br />
 * public void printTreePostOrder()         //�������<br />
 * private void printTreePostOrder(   BinaryNode root    )<br />
 * <p>
 * public void print();      //����������Ĳ�νṹ<br />
 * private void print(BinaryNode root, Comparable element,int side);    <br />
 */
public class BinarySearchTree {
    protected BinaryNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    /**
     * �ж��Ƿ�Ϊ����
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * �����ÿ�
     */
    public void makeEmpty() {
        root = null;
    }

    /**
     * �������е����ֵ
     *
     * @return
     */
    public Comparable findMax() {
        BinaryNode maxNode = findMax(root);
        return maxNode.element;
    }

    /**
     * ���ڵݹ�������������ֵ�ķ���.  ���ֵ���ڵĽڵ���ص�: ����ڵ���û���ҽڵ��
     *
     * @param t:Ҫ���ҵ�����
     * @return:���ֵ���ڵĽڵ�
     */
    protected BinaryNode findMax(BinaryNode root) {
        if (root != null) {
            while (root.right != null) {
                root = root.right;
            }
        }
        return root;
    }

    /**
     * �������е���Сֵ
     *
     * @return
     */
    public Comparable findMin() {
        BinaryNode minNode = findMin(root);
        return minNode.element;
    }

    /**
     * ���ڵݹ������������Сֵ�ķ���.  ��Сֵ���ڵĽڵ���ص�: ����ڵ���û����ڵ��
     *
     * @param t:Ҫ���ҵ�����
     * @return:��Сֵ���ڵĽڵ�
     */
    private BinaryNode findMin(BinaryNode t) {
        if (t != null) {
            while (t.left != null) {
                t = t.left;
            }
        }
        return t;
    }


    /**
     * �ݹ�ʵ�ֲ���Ԫ�������еĽڵ��Ԫ��
     */
    public Comparable find(Comparable element) {
        BinaryNode node = find(element, root);
        return node == null ? null : node.element;
    }

    protected BinaryNode find(Comparable element, BinaryNode root) {
        if (root == null) {
            return null;
        }
        if (element.compareTo(root.element) < 0) {
            return find(element, root.left);   //���element�ȵ�ǰ��t�ڵ��elementֵС�����������
        } else if (element.compareTo(root.element) > 0) {
            return find(element, root.right);
        } else {
            return root;
        }
    }

    /**
     * �ǵݹ�ʵ�ֲ���Ԫ�������еĽڵ��Ԫ��(Ч�ʸ���)
     */
    public Comparable iterativeFind(Comparable element) {
        BinaryNode node = iterativeFind(element, root);
        return node == null ? null : node.element;
    }

    private BinaryNode iterativeFind(Comparable element, BinaryNode root) {
        while (root != null) {
            int cmp = element.compareTo(root.element);
            if (cmp < 0) {
                root = root.left;
            } else if (cmp > 0) {
                root = root.right;
            } else {
                return root;
            }
        }
        return root;
    }

    /**
     * ��Ӳ���: 1.����Ҫ��ӵ�λ��     2. ��ӽ�ȥ
     */
    public void insert(Comparable element) {
        root = insert(element, root);
    }

    //���������ǲ����ظ�.
    private BinaryNode insert(Comparable element, BinaryNode root) {
        // ��������Ϊ�ա������ȵ������ɸ���㡣
        if (root == null) {
            root = new BinaryNode(element, null, null);
        } else if (element.compareTo(root.element) < 0) {    //���ǿ���������Ҫ��ӵ�����������������
            BinaryNode newNode = insert(element, root.left);
            root.left = newNode;
        } else if (element.compareTo(root.element) > 0) {
            BinaryNode newNode = insert(element, root.right);
            root.right = newNode;
        }
        return root;
    }

    //TODO: �������õݹ鷽��ʵ�ֵ���ӣ�Ҳ���Կ�����ѭ��������ʵ��(�ڴ����ݳ�����Ч�ʸ���)

    /**
     * ɾ������:   1. ��λ��
     */
    public void remove(Comparable element) {
        root = remove(element, root);
    }

    private BinaryNode remove(Comparable element, BinaryNode root) {
        if (root == null) {
            return root;
        }
        if (element.compareTo(root.element) < 0) {
            BinaryNode newNode = remove(element, root.left);
            root.left = newNode;
        } else if (element.compareTo(root.element) > 0) {
            BinaryNode newNode = remove(element, root.right);
            root.right = newNode;
        } else if (root.left != null && root.right != null) {     //root�ǵ�ǰҪɾ���Ľڵ�,��������������������Ϊ��
            //���������в�����С��ֵ
            root.element = (findMin(root.right)).element;
            root.right = remove(root.element, root.right);
        } else {
            root = root.left != null ? root.left : root.right;
        }
        return root;
    }

    /**
     * �������: �ȷ��ʸ����Ȼ����������������������������ڱ�����������ʱ����Ȼ�ȷ��ʸ���㣬Ȼ�������������������������
     */
    public void printTreePreOrder() {
        printTreePreOrder(this.root);
    }

    private void printTreePreOrder(BinaryNode root) {
        if (root != null) {
            System.out.print(root.element + " ");
            printTreePreOrder(root.left);
            printTreePreOrder(root.right);
        }
    }

    /**
     * ��������������ȱ�����������Ȼ����ʸ���㣬���������������ڱ�����������ʱ����Ȼ�ȱ������������ٷ��ʸ���㣬������������, ��������Ϊ�����������
     */
    public void printTreeInOrder() {
        printTreeInOrder(this.root);
    }

    private void printTreeInOrder(BinaryNode root) {
        if (root != null) {
            printTreeInOrder(root.left);
            System.out.print(root.element + " ");
            printTreeInOrder(root.right);
        }
    }

    /**
     * �������: �ȱ�����������Ȼ������������������ʸ���㣬�ڱ�����������ʱ����Ȼ�ȱ�����������Ȼ�����������������������㡣��������Ϊ�����������
     */
    public void printTreePostOrder() {
        printTreePostOrder(this.root);
    }

    private void printTreePostOrder(BinaryNode root) {
        if (root != null) {
            printTreePostOrder(root.left);
            printTreePostOrder(root.right);
            System.out.print(root.element + " ");
        }
    }

    /**
     * ����������Ĳ�νṹ
     */
    public void print() {
        if (root != null) {
            print(root, root.element, 0);
        }
    }

    /**
     * @param root
     * @param element
     * @param side:   0��ʾ�ýڵ��Ǹ��ڵ�    -1��ʾ�������ĸ��ڵ������,     1 ��ʾ�������ĸ��ڵ���Һ���
     */
    private void print(BinaryNode root, Comparable element, int side) {
        if (root != null) {
            if (side == 0) {
                System.out.println(root.element + " �Ǹ��ڵ� \n");
            } else {
                System.out.println(root.element + "��" + element + "��" + (side == 1 ? "��" : "��") + "����");
            }
            print(root.left, root.element, -1);
            print(root.right, root.element, 1);
        }
    }


    public static void main(String[] args) {
        BinarySearchTree root = new BinarySearchTree();
        root.insert(3);
        root.insert(4);
        root.insert(10);

        root.insert(15);
        root.insert(15);

        root.insert(1);

        root.insert(7);
        root.insert(11);
        root.insert(12);
        root.insert(14);
        root.insert(9);

        root.insert(6);


        root.printTreePreOrder();
        System.out.println();
        root.printTreeInOrder();
        System.out.println();
        root.printTreePostOrder();
        System.out.println();

        root.print();
    }


}
