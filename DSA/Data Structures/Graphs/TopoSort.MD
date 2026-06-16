### Kahns Algo - Topo Sort using BFS

Concise step definition for Kahn's Algorithm (Topological Sorting using BFS):

1. Compute the indegree of each node.
2. Initialize a queue.
3. Enqueue nodes with indegree 0.
4. While the queue is not empty:
   - Dequeue a node, add it to the topological order.
   - Decrease the indegree of its neighbors.
   - Enqueue neighbors with indegree 0.

This condensed version covers the essential steps needed for Kahn's Algorithm.

### When to use Topo Sort - Sort all nodes in order of their finishing time

Topological sorting is a powerful algorithm used in various scenarios where you need to order tasks or items based on their dependencies. Below are some LeetCode problems and intuitive use cases for topological sorting:

### LeetCode Problems on Topological Sorting

1. **Course Schedule (Medium)**

   - **Problem:** [Course Schedule](https://leetcode.com/problems/course-schedule/)
   - **Description:** Determine if you can finish all courses given the prerequisites.
2. **Course Schedule II (Medium)**

   - **Problem:** [Course Schedule II](https://leetcode.com/problems/course-schedule-ii/)
   - **Description:** Find the order in which you should take courses given the prerequisites.
3. **Alien Dictionary (Hard)**

   - **Problem:** [Alien Dictionary](https://leetcode.com/problems/alien-dictionary/)
   - **Description:** Given a list of words sorted lexicographically in an alien language, derive the order of characters in the alien language.
4. **Minimum Height Trees (Medium)**

   - **Problem:** [Minimum Height Trees](https://leetcode.com/problems/minimum-height-trees/)
   - **Description:** Find all the roots of the Minimum Height Trees.
5. **Longest Increasing Path in a Matrix (Hard)**

   - **Problem:** [Longest Increasing Path in a Matrix](https://leetcode.com/problems/longest-increasing-path-in-a-matrix/)
   - **Description:** Given an integer matrix, find the length of the longest increasing path.

### Intuition and Use Cases for Topological Sorting

1. **Task Scheduling:**

   - **Example:** In project management, tasks may depend on the completion of other tasks. Topological sorting helps determine a valid order to complete the tasks without violating any dependencies.
   - **Intuition:** Represent tasks as nodes and dependencies as directed edges. A valid topological sort ensures all tasks are completed in a sequence that respects their dependencies.
2. **Course Prerequisites:**

   - **Example:** In academic course planning, some courses have prerequisites. Topological sorting helps determine a valid sequence to take the courses.
   - **Intuition:** Represent courses as nodes and prerequisites as directed edges. A topological sort provides an order in which all courses can be taken without violating prerequisite constraints.
3. **Build Systems:**

   - **Example:** In software development, some files or modules need to be compiled before others. Topological sorting helps determine the build order.
   - **Intuition:** Represent files/modules as nodes and compilation dependencies as directed edges. A topological sort ensures files/modules are compiled in the correct order.
4. **Dependency Resolution:**

   - **Example:** In package management systems, some packages depend on other packages. Topological sorting helps resolve the order in which packages should be installed.
   - **Intuition:** Represent packages as nodes and dependencies as directed edges. A topological sort provides an installation order that respects dependencies.
5. **Data Serialization:**

   - **Example:** When saving objects to a database, some objects may depend on the existence of other objects. Topological sorting helps determine the order to save objects.
   - **Intuition:** Represent objects as nodes and dependencies as directed edges. A topological sort ensures objects are saved in a sequence that respects their dependencies.
6. **Circuit Design:**

   - **Example:** In electronic circuit design, certain components must be powered on before others. Topological sorting helps determine the power-on sequence.
   - **Intuition:** Represent components as nodes and power-on dependencies as directed edges. A topological sort provides a valid power-on sequence.

Topological sorting is applicable in any scenario where you need to order items based on dependencies. The core intuition is to represent the problem as a directed acyclic graph (DAG) and perform a topological sort to determine a valid order.
