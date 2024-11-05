package service;

import model.Book;

import java.util.Arrays;

public class MergeSortBooks {

    public static void mergeSort(Book[] books, int left, int right, String sortBy) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(books, left, mid, sortBy);
            mergeSort(books, mid + 1, right, sortBy);
            merge(books, left, mid, right, sortBy);
        }
    }

    private static void merge(Book[] books, int left, int mid, int right, String sortBy) {
        Book[] leftArray = Arrays.copyOfRange(books, left, mid + 1);
        Book[] rightArray = Arrays.copyOfRange(books, mid + 1, right + 1);

        int i = 0, j = 0, k = left;
        while (i < leftArray.length && j < rightArray.length) {
            int comparison;
            if ("author".equalsIgnoreCase(sortBy)) {
                comparison = leftArray[i].getAuthor().compareTo(rightArray[j].getAuthor());
            } else {
                comparison = leftArray[i].getTitle().compareTo(rightArray[j].getTitle());
            }

            if (comparison <= 0) {
                books[k++] = leftArray[i++];
            } else {
                books[k++] = rightArray[j++];
            }
        }

        while (i < leftArray.length) {
            books[k++] = leftArray[i++];
        }

        while (j < rightArray.length) {
            books[k++] = rightArray[j++];
        }
    }
}
