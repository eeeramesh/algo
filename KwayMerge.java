import java.util.*;

class KwayMerge {
	public static List<Integer> merge(List<List<Integer>> sortedLists) {
		// estimate length
		int size = 0;
		for (List<Integer> list: sortedLists) {
			size += list.size();
		}
		List<Integer> output = new ArrayList<Integer> (size);
		Queue<Entry> queue = new PriorityQueue<Entry> (sortedLists.size());

		// read first entry from each source
		for (List<Integer> list: sortedLists) {
			Iterator<Integer> it = list.iterator();
			if (it.hasNext()) {
				queue.add(new Entry(it.next(), it));
			}
		}

		// process until queue becomes empty
		while (!queue.isEmpty()) {
			Entry entry = queue.poll();
			Integer value = entry.getValue();

			output.add(value);

			if (entry.readNext()) queue.add(entry);
		}

		return output;
	}

	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(new Integer[] {
			1, 3, 5, 7, 9
		});
		List<Integer> list2 = Arrays.asList(new Integer[] {
			2, 4, 6, 8, 10
		});
		List<Integer> list3 = Arrays.asList(new Integer[] {
			0, 1, 2, 3, 4, 5
		});

		List<List<Integer>> lists = new ArrayList<List<Integer>> ();
		lists.add(list1);
		lists.add(list2);
		lists.add(list3);

		List<Integer> output = merge(lists);
		System.out.println(output);
	}
}

class Entry implements Comparable<Entry> {
	private Integer value;
	private Iterator<Integer> it;

	public Entry(Integer value, Iterator<Integer> it) {
		this.value = value;
		this.it = it;
	}

	public Integer getValue() {
		return this.value;
	}

	public boolean readNext() {
		if (it.hasNext()) {
			value = it.next();
			return true;
		} else {
			return false;
		}
	}

	public int compareTo(Entry entry) {
		return this.value - entry.value;
	}
}