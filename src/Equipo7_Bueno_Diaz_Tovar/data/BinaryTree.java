package Equipo7_Bueno_Diaz_Tovar.data;

public interface BinaryTree<T> {

    boolean isEmpty();

    T root();

    void preOrder();

    void inOrder();

    void postOrder();

    void levelOrder();
    
}
