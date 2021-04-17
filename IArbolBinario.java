public interface IArbolBinario<K, T> {

	public void Insert(K key, T value);
	public T Delete(K key);
	public T Find(K key, NodoArbol<K,T> value);
	public int Count();
	public boolean IsEmpty();
	public void InOrder(IVisitar<K, T> visitNode, NodoArbol<K, T> actual);
	public void PreOrder(IVisitar<K, T> visitNode, NodoArbol<K, T> actual);
	public void PostOrder(IVisitar<K, T> visitNode, NodoArbol<K, T> actual);
	
}