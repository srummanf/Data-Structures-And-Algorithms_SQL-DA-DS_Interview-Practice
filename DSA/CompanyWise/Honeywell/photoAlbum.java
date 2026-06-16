/** There is a collection of photos to place into an empty photo album, one at a time by order of importance. Each time a photo is inserted, all subsequent photos are shifted toward the right by one position. Given the id's of the photos and the positions where each should be placed, find out the sequence of the photos in the album after all photos have been inserted.

Example

n=5

index = [0, 1, 2, 1, 2]

identity = [0, 1, 2, 3, 4]

The sequence of the photos is as follows:

The photos 0, 1 and 2 keep the same indexes 0. 1 and 2 respectively.

The photo 3 is inserted in index 1 and the subsequent photos 1 and 2 are shifted right by one position.

• The photo 4 is inserted in position 2 and again the photos 1 and 2 are shifted right by one position.

Identity

1

2

3

4

Album

[0]

[0, 1]

[0, 1, 2]

[0, 3, 1, 2]

[0, 3, 4, 1, 2]

2

2

2

2

2

2

25

30

33

33

Function Description

Complete the function photoAlbum in the editor below.

Function Description

Complete the function photoAlbum in the editor below.

photoAlbum has the following parameter(s): int index[n]: the insertion points for each photo int identity[n]: the photograph id numbers

ALL

Lang

1

14

15

16

17

18

19

Function Description

int[n]: the sequence of identity values after all are inserted

20

21

22

23

Constraints

1sn≤2×105

24

25

26

2

Os index[i], identity[i] <n (0s i<n)

Public static list integer photo album( list integer index, list integer identity ) */

import java.util.*;

public class Solution {
    public static List<Integer> photoAlbum(List<Integer> index, List<Integer> identity) {
        // Create a LinkedList to simulate the photo album
        LinkedList<Integer> album = new LinkedList<>();

        // Iterate through each photo
        for (int i = 0; i < index.size(); i++) {
            // Insert the photo identity at the specified index
            album.add(index.get(i), identity.get(i));
        }

        return album; // Return the final album sequence
    }

    public static void main(String[] args) {
        // Example usage:
        List<Integer> index = Arrays.asList(0, 1, 2, 1, 2);
        List<Integer> identity = Arrays.asList(0, 1, 2, 3, 4);

        List<Integer> result = photoAlbum(index, identity);
        System.out.println(result);  // Output should be [0, 3, 4, 1, 2]
    }
}
