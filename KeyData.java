/**
 * 
 * @author Stefan Quintana
 *
 * @param <K>
 * @param <T>
 */
public class KeyData<K, T> implements IKeyCalculator<K, T> {

	@Override
	public K GetKey(T value) {
		// TODO Auto-generated method stub
		Data datos = (Data)value;
		return (K)datos.getPalabra();
	}

}
