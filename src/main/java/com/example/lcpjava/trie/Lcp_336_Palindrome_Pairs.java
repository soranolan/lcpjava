package com.example.lcpjava.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.lcpjava.common.Lcp_336_TrieNode;

public class Lcp_336_Palindrome_Pairs {

	/**
	 * time  : O(n * k ^ 2)
	 * space : O(n * k ^ 2)
	 * 
	 * n : total number of words
	 * 
	 * k : average length of each word
	 * 
	 * https://leetcode.com/problems/palindrome-pairs/solutions/79195/o-n-k-2-java-solution-with-trie-structure/comments/84095
	 */
	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> result = new ArrayList<>();

		int n = words.length;
		Lcp_336_TrieNode root = new Lcp_336_TrieNode();

		for (int i = 0; i < n; i++) {
			buildTrie(root, words[i], i);
		}

		for (int i = 0; i < n; i++) {
			searchPalindrome(words[i], result, root, i);
		}

		return result;
	}

	private void buildTrie(Lcp_336_TrieNode root, String word, int indexInWords) {
		int n = word.length();
		Lcp_336_TrieNode current = root;

		for (int i = n - 1; i >= 0; i--) {
			char c = word.charAt(i);
			int trieIndex = c - 'a';

			if (current.children[trieIndex] == null) {
				current.children[trieIndex] = new Lcp_336_TrieNode();
			}

			if (isPalindrome(word, 0, i)) {
				current.restOfTheWord.add(indexInWords);
			}

			current = current.children[trieIndex];
		}

		current.wordIndex = indexInWords;
	}

	private void searchPalindrome(String word, List<List<Integer>> result, Lcp_336_TrieNode root, int indexInWords) {
		int n = word.length();
		Lcp_336_TrieNode current = root;

		for (int i = 0; i < n; i++) {
			if (current.wordIndex != -1 && current.wordIndex != indexInWords && isPalindrome(word, i, n - 1)) {
				result.add(Arrays.asList(indexInWords, current.wordIndex));
			}

			char c = word.charAt(i);
			int trieIndex = c - 'a';

			current = current.children[trieIndex];

			if (current == null) {
				return;
			}
		}

		if (current.wordIndex != -1) {
			if (indexInWords != current.wordIndex) {
				result.add(Arrays.asList(indexInWords, current.wordIndex));
			}
		}

		for (int candidateIndex : current.restOfTheWord) {
			if (indexInWords == candidateIndex) {
				continue;
			}
			result.add(Arrays.asList(indexInWords, candidateIndex));
		}
	}

	private boolean isPalindrome(String word, int left, int right) {
		while (left < right) {
			if (word.charAt(left) != word.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

}
