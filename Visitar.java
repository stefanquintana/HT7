/**
 * 
 * @author Stefan Quintana
 *
 * @param <K>
 * @param <T>
 */
public class Visitar<K, T> implements IVisitar<K, T>{

	@Override
	public void VisitarNodo(NodoArbol<K, T> arbol) {
		// TODO Auto-generated method stub
		Data datos = (Data)arbol._value;
		System.out.println("Ingl�s: " + datos.getIngles() + " Espa�ol: " + datos.getEsp() + " Franc�s: " + datos.getFrances());
	}

}
