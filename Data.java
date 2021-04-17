/**
 * 
 * @author Stefan Quintana
 *
 */
public class Data {
	
	private String palabra;
	private String ingles;
	private String esp;
	private String frances;
	
	
	public Data(String palabra, String ingles, String esp, String frances) {
		super();
		this.palabra = palabra;
		this.ingles = ingles;
		this.frances = frances;
		this.esp = esp;
	}
	
	/**
	 * @return the palabra
	 */
	public String getPalabra() {
		return palabra;
	}



	/**
	 * @param palabra the palabra to set
	 */
	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}
	
	/**
	 * @return the ingles
	 */
	public String getIngles() {
		return ingles;
	}

	/**
	 * @param ingles the ingles to set
	 */
	public void setIngles(String ingles) {
		this.ingles = ingles;
	}

	/**
	 * @return the frances
	 */
	public String getFrances() {
		return frances;
	}

	/**
	 * @param frances the frances to set
	 */
	public void setFrances(String frances) {
		this.frances = frances;
	}

	/**
	 * @return the esp
	 */
	public String getEsp() {
		return esp;
	}

	/**
	 * @param esp the esp to set
	 */
	public void setEsp(String esp) {
		this.esp = esp;
	}


}
