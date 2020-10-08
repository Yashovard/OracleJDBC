package Variable;

public class Instance {
	int id;
	{
		System.out.println(id);
	}

	public static void main(String[] args) {
		Instance instance = new Instance();
		System.out.println(instance.id);
	}
}
