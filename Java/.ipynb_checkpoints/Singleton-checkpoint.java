public class Singleton {

	private static Singleton instance;
	private Singleton(){}
	
	public static Singleton getInstance() {
		if(instance==null) {
			instance=new Singleton();
		}
		return instance;
		
	}
		
	public static void main(String[] args) {
		Singleton singeSingleton2=Singleton.getInstance();
		System.out.println(" Hashcode "+singeSingleton2.hashCode());
		Singleton singeSingleton=Singleton.getInstance();
		System.out.println(" Hashcode "+singeSingleton.hashCode());
	}	
	
}