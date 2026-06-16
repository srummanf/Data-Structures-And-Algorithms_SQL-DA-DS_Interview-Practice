/**
 * Problem statement
Given an array ‘arr’ of integer numbers, ‘arr[i]’ represents the number of pages in the ‘i-th’ book.



There are ‘m’ number of students, and the task is to allocate all the books to the students.



Allocate books in such a way that:

1. Each student gets at least one book.
2. Each book should be allocated to only one student.
3. Book allocation should be in a contiguous manner.


You have to allocate the book to ‘m’ students such that the maximum number of pages assigned to a student is minimum.



If the allocation of books is not possible, return -1.



Example:
Input: ‘n’ = 4 ‘m’ = 2 
‘arr’ = [12, 34, 67, 90]

Output: 113

Explanation: All possible ways to allocate the ‘4’ books to '2' students are:

12 | 34, 67, 90 - the sum of all the pages of books allocated to student 1 is ‘12’, and student two is ‘34+ 67+ 90 = 191’, so the maximum is ‘max(12, 191)= 191’.

12, 34 | 67, 90 - the sum of all the pages of books allocated to student 1 is ‘12+ 34 = 46’, and student two is ‘67+ 90 = 157’, so the maximum is ‘max(46, 157)= 157’.

12, 34, 67 | 90 - the sum of all the pages of books allocated to student 1 is ‘12+ 34 +67 = 113’, and student two is ‘90’, so the maximum is ‘max(113, 90)= 113’.

We are getting the minimum in the last case.

Hence answer is ‘113’.

Sample Input 2:
5 4
25 46 28 49 24
Sample Output 2:
71
Explanation of sample input 2:
All possible ways to allocate the ‘5’ books to '4' students are:

25 | 46 | 28 | 49 24 - the sum of all the pages of books allocated to students 1, 2, 3, and 4 are '25', '46', '28', and '73'. So the maximum is '73'.

25 | 46 | 28 49 | 24 - the sum of all the pages of books allocated to students 1, 2, 3, and 4 are '25', '46', '77', and '24'. So the maximum is '77'.

25 | 46 28 | 49 | 24 - the sum of all the pages of books allocated to students 1, 2, 3, and 4 are '25', '74', '49', and '24'. So the maximum is '74'.

25 46 | 28 | 49 | 24 - the sum of all the pages of books allocated to students 1, 2, 3, and 4 are '71', '28', '49', and '24'. So the maximum is '71'.

We are getting the minimum in the last case.

Hence answer is ‘71’.
 */

// -----------------------------------------------------------------------------------------------
// -----------------------------------------------------------------------------------------------
// -----------------------------------------------------------------------------------------------
// -----------------------------------------------------------------------------------------------

/**
  * First Intuition

    int maxPages = max(books[]) ---> max val in books array
    int sumPages = sum(books[]) ---> sum of all pages in books array

    if m > n, return -1

    for( i = maxPages to SumPages):
        if isPossible(books, i) == m:
            return i

    isPossible(books, maxPages):
        int students = 0;
        int pages = 0;
        for i = 0 to n:
            if pages + books[i] <= maxPages:
                
                pages += books[i]; 
            else:
                students++;
                pages = books[i];
        return students;


    Explanation:
    The given code is an approach to solve the "Book Allocation" problem, where we need to allocate a set of books to a given number of students such that the maximum number of pages assigned to a student is minimized.

Here's an explanation of the code:

1. `maxPages` and `sumPages` are calculated to obtain the maximum number of pages in any book and the total number of pages in all books, respectively.

2. If the number of students (`m`) is greater than the number of books (`n`), it returns `-1` because it's impossible to allocate books in this case.

3. The code then iterates from `maxPages` to `sumPages` using a loop. This range is considered because the minimum possible maximum number of pages assigned to a student is the maximum number of pages in any single book, and the maximum possible is the sum of all pages.

4. For each value of `i` in the loop, the `isPossible` function is called with `i` as the maximum number of pages allowed per student. If `isPossible` returns `m` (the desired number of students), it means that the current value of `i` is the minimum maximum number of pages that can be assigned to a student while allocating books to `m` students. In this case, the function returns `i`.

5. The `isPossible` function takes the array of book page counts (`books`) and the maximum number of pages allowed per student (`maxPages`). It initializes two variables: `students` (representing the number of students required) and `pages` (representing the current number of pages assigned to the current student).

6. The function then iterates through the `books` array. For each book `i`, it checks if adding the current book's page count (`books[i]`) to the `pages` variable would exceed the `maxPages` limit. If it doesn't exceed, it adds the book's page count to `pages`.

7. If adding the current book's page count would exceed `maxPages`, it increments the `students` count by 1 (signifying the need for a new student) and resets `pages` to the current book's page count (`books[i]`).

8. After iterating through all books, the function returns the final value of `students`, which represents the minimum number of students required to allocate all books within the given `maxPages` limit.

The overall algorithm works by performing a binary search-like approach, iterating from `maxPages` to `sumPages` and checking if a particular value of `maxPages` allows allocating books to the desired number of students (`m`). The minimum value of `maxPages` that satisfies this condition is the answer.

Note that this algorithm assumes that the input is valid (e.g., `m` is not greater than `n`, and the arrays are non-empty).



  */

public class BookAllocation {

  public int sumVal(int[] books) {
    int maxi = 0;
    for (int i : books) {
      maxi += i;
    }
    return maxi;
  }

  public int maxVal(int[] books) {
    int maxi = 0;
    for (int i : books) {
      maxi = Math.max(maxi, i);
    }
    return maxi;
  }

  public int PossibleNumberOfStudents(int[] books, int maxPages) {
    int students = 0;
    int pages = 0;
    for (int i = 0; i < books.length; i++) if (
      pages + books[i] <= maxPages
    ) pages += books[i]; else {
      students++;
      pages = books[i];
    }
    return students;
  }

  public int splitArray(int[] books, int k) {
    if (k > books.length) {
      return -1;
    }

    int maxval = maxVal(books);
    int sumval = sumVal(books);
    int low = maxval;
    int high = sumval;

    while (low <= high) {
      int mid = (low + high) / 2;
      int noOfStudents = PossibleNumberOfStudents(books, mid);
      if (noOfStudents >= k) low = mid + 1; else high = mid - 1;
    }
    return low;
  }
}
