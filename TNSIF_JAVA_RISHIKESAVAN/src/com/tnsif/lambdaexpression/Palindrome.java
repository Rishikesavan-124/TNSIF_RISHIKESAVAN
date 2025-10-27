//Program to define generic functional interface Palindrome

package com.tnsif.lambdaexpression;

public interface Palindrome<T> {
	boolean checkPalindrome(T data);
}
