import java.util.*;
import java.util.stream.*;;


public class BinaryTreeOperations {

    public static<T> String levelOrder(BTNode<T> root) {
    
        if (root == null) {
            return "";
        }
        
        Queue<BTNode<T>> queue = new LinkedList<>();
        ArrayList<T> result = new ArrayList<T>();
        
        queue.add(root);
        
        while (!queue.isEmpty()) {
            BTNode<T> node = queue.poll();
            
            result.add(node.value);
        
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        
        return result.stream().map(Object::toString).collect(Collectors.joining(","));
    }
    public static <T extends Comparable<T>> BTNode<T> bstFromPreorder(T[] nodeArray) {

        if (nodeArray == null) {
            return null;
        }

        BTNode<T> root = new BTNode(nodeArray[0],null,null);
        Stack<BTNode<T>> stack = new Stack<BTNode<T>>();

        stack.push(root);
        int i=1;

        while (i < nodeArray.length) {

            BTNode<T> node = new BTNode(nodeArray[i],null,null);
            BTNode<T> currentParent = stack.peek();
        

            while (!stack.isEmpty() && nodeArray[i].compareTo(stack.peek().value) == 1) {
                currentParent = stack.pop();
            }
            
            if (nodeArray[i].compareTo(currentParent.value) == -1) {
                currentParent.left = node;
            }
            else {
                currentParent.right = node;
            }
            
            stack.push(node);
            i++;
        }

        return root;
    }
}
