package interview.ccti.recursionanddp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Boxes {
	
	static class Box implements Comparator<Box> {
		int w;
		int h;
		int d;
		
		@Override
		public int compare(Box o1, Box o2) {
			return -Integer.compare(o1.h, o2.h);
		}
		
		public boolean canStackOn(Box b) {
			if(b == null) {
				return true;
			}
			return w < b.w && h < b.h && d < b.d;
		}
	}

	public static void main(String[] args) {
		ArrayList<Box> boxes = new ArrayList<>();
		
		Box b1 = new Box();
		Box b2 = new Box();
		Box b3 = new Box();
		Box b4 = new Box();
		boxes.add(b1); boxes.add(b2); boxes.add(b3); boxes.add(b4);
		
		b1.h = 1; b1.d = 1; b1.w = 1;
		b2.h = 2; b2.d = 2; b2.w = 2;
		b3.h = 3; b3.d = 3; b3.w = 1;
		b4.h = 4; b4.d = 4; b4.w = 4;
		
		int maxHeight = findMaxHeight(boxes);
		System.out.println(maxHeight);
	}

	private static int findMaxHeight(List<Box> boxes) {
		boxes.sort(new Box());
		return findMaxHeight(boxes, 0, null, new HashMap<>());
	}

	private static int findMaxHeight(List<Box> boxes, int index, Box bottom, HashMap<Box, Integer> cache) {
		
		if(index == boxes.size()) {
			return 0;
		}
		
		if(cache.containsKey(bottom)) {
			return cache.get(bottom);
		}
		
		Box newBottom = boxes.get(index);	
		
		int h1 = 0;
		
		if(newBottom.canStackOn(bottom)) {
			h1 = newBottom.h + findMaxHeight(boxes, index + 1, newBottom, cache);
		}
		int h2 = findMaxHeight(boxes, index + 1, bottom, cache);
		
		int h = Math.max(h1, h2);
		cache.put(bottom, h);
		return h;
	}
}
