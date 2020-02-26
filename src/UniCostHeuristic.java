
public class UniCostHeuristic implements IHeuristic {

	@Override
	public int getHeuristic() {
		
		return 0;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		
		return new UniCostHeuristic();
	}
}
