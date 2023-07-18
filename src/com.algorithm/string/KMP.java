package com.algorithm.string;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    16/07/23,
 * Time:    8:50 am
 */
public class KMP {
  public static void main(String[] args) {
    KMP kmp = new KMP();
    String str = "abcxabcdabcdabcy";
    String pattern = "abcdabcy";
    System.out.println(kmp.subStringSearchKmp(str, pattern));
  }

  private boolean subStringSearchKmp(String str, String pattern) {
    char[] strArray = str.toCharArray();
    char[] patternArray = pattern.toCharArray();
    int[] lps = computeLpsArray(patternArray);
    int i = 0, j = 0;
    while (i < str.length() && j < pattern.length()) {
      if (strArray[i] == patternArray[j]) {
        i++;
        j++;
      } else {
        if (j != 0) {
          j = lps[j - 1];
        } else {
          i++;
        }
      }
    }
    if (j == patternArray.length) {
      return true;
    }
    return false;
  }

  private int[] computeLpsArray(char[] patternArray) {
    int length = patternArray.length;
    int[] lps = new int[length];
    int index = 0;
    for (int i = 1; i < length; ) {
      if (patternArray[i] == patternArray[index]) {
        lps[i] = index + 1;
        index++;
        i++;
      } else {
        if (index != 0) {
          index = lps[index - 1];
        } else {
          lps[i] = 0;
          i++;
        }
      }
    }
    return lps;
  }
}