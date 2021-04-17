import junit.framework.TestCase;

public class Test extends TestCase{
	
	ArbolBinarioBusqueda arbolIngles = new ArbolBinarioBusqueda<String,Data>(new Comparador<String,Data>(), new KeyData<String,Data>());
	ArbolBinarioBusqueda arbolEsp = new ArbolBinarioBusqueda<String,Data>(new Comparador<String,Data>(), new KeyData<String,Data>());
	ArbolBinarioBusqueda arbolFrances = new ArbolBinarioBusqueda<String,Data>(new Comparador<String,Data>(), new KeyData<String,Data>());
	
	String dic1 = "house,casa,loger\ndog,perro,chien\nhomework,tarea,devoirs\nwoman,mujer,femme\ntown,pueblo,ville\nyes,si,Oui";
	String tex = "The dog house in town has homework";
	
	public void testFind() {
		arbolIngles.Insert("house", new Data("house","house","casa","loger"));
		arbolEsp.Insert("casa", new Data("casa","house","casa","loger"));
		arbolFrances.Insert("loger", new Data("loger","house","casa","loger"));
		Data datos1 = (Data)arbolIngles.Find("house", arbolIngles._raiz);
		Data datos2 = (Data)arbolEsp.Find("casa", arbolEsp._raiz);
		Data datos3 = (Data)arbolFrances.Find("loger", arbolFrances._raiz);
		assertEquals(datos1.getFrances(),"loger");
		assertEquals(datos2.getIngles(),"house");
		assertEquals(datos3.getEsp(),"casa");
	}
	
	public void testInOrder() {
		arbolIngles.Insert("house", new Data("house","house","casa","loger"));
		arbolIngles.Insert("dog", new Data("dog","dog","perro","chien"));
		arbolIngles.Insert("homework", new Data("homework","homework","tarea","devoirs"));
		arbolIngles.InOrder(new Visitar<String, Data>(), arbolIngles._raiz);
	}
	
	
}
