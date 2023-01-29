/**
 * 
 */
package com.debajoy.ds.graph;

import java.util.Comparator;
import java.util.List;

/**
 * @author Debajoy
 *
 */
public class ComparatorWeights implements Comparator<WeightByVertices>{
		
	public ComparatorWeights() {
		super();
	}
	public ComparatorWeights(int vertex, int weight) {
		super();
	}
	
	@Override
	public int compare(com.debajoy.ds.graph.WeightByVertices o1, com.debajoy.ds.graph.WeightByVertices o2) {
		// TODO Auto-generated method stub
		return Integer.valueOf(o1.weight).compareTo(Integer.valueOf(o2.weight));
	}

}

class WeightByVertices {
	int vertex;
	int weight;
	public WeightByVertices(int vertex, int weight) {
		super();
		this.vertex = vertex;
		this.weight = weight;
	}
}