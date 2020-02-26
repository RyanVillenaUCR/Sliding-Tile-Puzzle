import java.lang.Cloneable;

public interface IHeuristic extends Cloneable {

	int getHeuristic();
	
//	@Override
	Object clone() /*throws CloneNotSupportedException*/;
	
	
}
