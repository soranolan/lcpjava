package com.example.lcpjava.tree;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Lcp_1993_Operations_on_TreeTest {
	
	@Test
	void test_case_1() {
		boolean test = false;
		
		LockingTree lockingTree = new LockingTree(new int[] { -1, 0, 0, 1, 1, 2, 2 });
		
		test = lockingTree.lock(2, 2);
		assertThat(test).isTrue();
		
		test = lockingTree.unlock(2, 3);
		assertThat(test).isFalse();
		
		test = lockingTree.unlock(2, 2);
		assertThat(test).isTrue();
		
		test = lockingTree.lock(4, 5);
		assertThat(test).isTrue();
		
		test = lockingTree.upgrade(0, 1);
		assertThat(test).isTrue();
		
		test = lockingTree.lock(0, 1);
		assertThat(test).isFalse();
	}
	
}
