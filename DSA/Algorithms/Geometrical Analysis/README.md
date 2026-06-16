# Geometry Formulas for DSA and Competitive Programming

## **1. Point and Distance**

### **Distance Between Two Points**
$$
\text{Distance} = \sqrt{(x_2 - x_1)^2 + (y_2 - y_1)^2}
$$

### **3D Distance Between Two Points**
$$
\text{Distance} = \sqrt{(x_2 - x_1)^2 + (y_2 - y_1)^2 + (z_2 - z_1)^2}
$$

### **Squared Distance (to avoid square root)**
$$
\text{Distance}^2 = (x_2 - x_1)^2 + (y_2 - y_1)^2
$$

### **Weighted Euclidean Distance**
$$
\text{Distance} = \sqrt{w_x(x_2 - x_1)^2 + w_y(y_2 - y_1)^2}
$$

**LeetCode Problems:**
1. [973. K Closest Points to Origin](https://leetcode.com/problems/k-closest-points-to-origin/)
2. [1037. Valid Boomerang](https://leetcode.com/problems/valid-boomerang/)
3. [1401. Circle and Rectangle Overlapping](https://leetcode.com/problems/circle-and-rectangle-overlapping/)

### **Manhattan Distance**
$$
\text{Manhattan Distance} = |x_2 - x_1| + |y_2 - y_1|
$$

### **Chebyshev Distance (L∞ norm)**
$$
\text{Chebyshev Distance} = \max(|x_2 - x_1|, |y_2 - y_1|)
$$

### **Minkowski Distance (Lp norm)**
$$
\text{Minkowski Distance} = \left(|x_2 - x_1|^p + |y_2 - y_1|^p\right)^{1/p}
$$

### **Hamming Distance (for binary strings)**
$$
\text{Hamming Distance} = \sum_{i=1}^{n} [s_1[i] \neq s_2[i]]
$$

**LeetCode Problems:**
1. [1030. Matrix Cells in Distance Order](https://leetcode.com/problems/matrix-cells-in-distance-order/)
2. [1131. Maximum of Absolute Value Expression](https://leetcode.com/problems/maximum-of-absolute-value-expression/)

---

## **2. Triangle**

### **Area of Triangle (Given Vertices)**
Given vertices $(x_1, y_1)$, $(x_2, y_2)$, $(x_3, y_3)$:
$$
\text{Area} = \frac{|x_1(y_2 - y_3) + x_2(y_3 - y_1) + x_3(y_1 - y_2)|}{2}
$$

### **Area Using Cross Product**
$$
\text{Area} = \frac{1}{2} \left| \vec{AB} \times \vec{AC} \right|
$$

### **Perimeter of Triangle**
$$
\text{Perimeter} = a + b + c
$$

**LeetCode Problems:**
1. [812. Largest Triangle Area](https://leetcode.com/problems/largest-triangle-area/)
2. [1037. Valid Boomerang](https://leetcode.com/problems/valid-boomerang/)
3. [469. Convex Polygon](https://leetcode.com/problems/convex-polygon/) (Premium)

---

## **3. Line and Slope**

### **Slope of Line**
$$
\text{Slope} = \frac{y_2 - y_1}{x_2 - x_1}
$$

### **Line Equation (Point-Slope Form)**
$$
y - y_1 = m(x - x_1)
$$

### **Distance from Point to Line**
Line: $ax + by + c = 0$, Point: $(x_0, y_0)$
$$
\text{Distance} = \frac{|ax_0 + by_0 + c|}{\sqrt{a^2 + b^2}}
$$

**LeetCode Problems:**
1. [149. Max Points on a Line](https://leetcode.com/problems/max-points-on-a-line/)
2. [356. Line Reflection](https://leetcode.com/problems/line-reflection/) (Premium)

---

## **4. Circle**

### **Circle Equation**
$$
(x - h)^2 + (y - k)^2 = r^2
$$

### **Area of Circle**
$$
\text{Area} = \pi r^2
$$

### **Circumference**
$$
\text{Circumference} = 2\pi r
$$

### **Point Inside Circle Check**
Point $(x, y)$ is inside circle with center $(h, k)$ and radius $r$ if:
$$
(x - h)^2 + (y - k)^2 < r^2
$$

**LeetCode Problems:**
1. [1232. Check If It Is a Straight Line](https://leetcode.com/problems/check-if-it-is-a-straight-line/)
2. [1401. Circle and Rectangle Overlapping](https://leetcode.com/problems/circle-and-rectangle-overlapping/)
3. [1453. Maximum Number of Darts Inside of a Circular Dartboard](https://leetcode.com/problems/maximum-number-of-darts-inside-of-a-circular-dartboard/)

---

## **5. Parallelogram**

### **Area of Parallelogram**
Given adjacent sides $\vec{a}$ and $\vec{b}$:
$$
\text{Area} = |\vec{a} \times \vec{b}|
$$

### **Area Using Base and Height**
$$
\text{Area} = \text{base} \times \text{height}
$$

### **Area Using Coordinates**
Given vertices $(x_1, y_1)$, $(x_2, y_2)$, $(x_3, y_3)$, $(x_4, y_4)$:
$$
\text{Area} = |(x_1 - x_3)(y_2 - y_4) - (x_2 - x_4)(y_1 - y_3)|/2
$$

### **Perimeter of Parallelogram**
$$
\text{Perimeter} = 2(a + b)
$$

**LeetCode Problems:**
1. [593. Valid Square](https://leetcode.com/problems/valid-square/)
2. [963. Minimum Area Rectangle II](https://leetcode.com/problems/minimum-area-rectangle-ii/)

---

## **6. Rhombus**

### **Area of Rhombus (Using Diagonals)**
$$
\text{Area} = \frac{d_1 \times d_2}{2}
$$

### **Area of Rhombus (Using Side and Angle)**
$$
\text{Area} = a^2 \sin \theta
$$

### **Perimeter of Rhombus**
$$
\text{Perimeter} = 4a
$$

### **Diagonal Relationship**
For rhombus with side $a$ and diagonals $d_1$, $d_2$:
$$
d_1^2 + d_2^2 = 4a^2
$$

**LeetCode Problems:**
1. [593. Valid Square](https://leetcode.com/problems/valid-square/)
2. [963. Minimum Area Rectangle II](https://leetcode.com/problems/minimum-area-rectangle-ii/)

---

## **7. Trapezoid**

### **Area of Trapezoid**
$$
\text{Area} = \frac{(a + b) \times h}{2}
$$
Where $a$ and $b$ are parallel sides, $h$ is height.

### **Area Using Coordinates**
For trapezoid with vertices in order:
$$
\text{Area} = \frac{1}{2} \left| \sum_{i=0}^{3} (x_i \cdot y_{(i+1) \bmod 4} - x_{(i+1) \bmod 4} \cdot y_i) \right|
$$

### **Median of Trapezoid**
$$
\text{Median} = \frac{a + b}{2}
$$

**LeetCode Problems:**
1. [963. Minimum Area Rectangle II](https://leetcode.com/problems/minimum-area-rectangle-ii/)
2. [1030. Matrix Cells in Distance Order](https://leetcode.com/problems/matrix-cells-in-distance-order/)

---

## **8. Rectangle**

### **Area of Rectangle**
$$
\text{Area} = \text{length} \times \text{width}
$$

### **Rectangle Overlap Area**
For rectangles with bottom-left $(x_1, y_1)$ and top-right $(x_2, y_2)$:
$$
\text{Overlap Area} = \max(0, \min(x_2^{(1)}, x_2^{(2)}) - \max(x_1^{(1)}, x_1^{(2)})) \times \max(0, \min(y_2^{(1)}, y_2^{(2)}) - \max(y_1^{(1)}, y_1^{(2)}))
$$

**LeetCode Problems:**
1. [223. Rectangle Area](https://leetcode.com/problems/rectangle-area/)
2. [836. Rectangle Overlap](https://leetcode.com/problems/rectangle-overlap/)
3. [85. Maximal Rectangle](https://leetcode.com/problems/maximal-rectangle/)

---

## **9. Ellipse**

### **Standard Form of Ellipse**
$$
\frac{(x - h)^2}{a^2} + \frac{(y - k)^2}{b^2} = 1
$$
Where $(h, k)$ is center, $a$ is semi-major axis, $b$ is semi-minor axis.

### **Area of Ellipse**
$$
\text{Area} = \pi \times a \times b
$$

### **Perimeter of Ellipse (Approximation)**
Ramanujan's approximation:
$$
\text{Perimeter} \approx \pi \left[ 3(a + b) - \sqrt{(3a + b)(a + 3b)} \right]
$$

### **Eccentricity**
$$
e = \sqrt{1 - \frac{b^2}{a^2}} \quad \text{(when } a > b \text{)}
$$

### **Point Inside Ellipse Check**
Point $(x, y)$ is inside ellipse if:
$$
\frac{(x - h)^2}{a^2} + \frac{(y - k)^2}{b^2} < 1
$$

**LeetCode Problems:**
1. [1401. Circle and Rectangle Overlapping](https://leetcode.com/problems/circle-and-rectangle-overlapping/)
2. [1453. Maximum Number of Darts Inside of a Circular Dartboard](https://leetcode.com/problems/maximum-number-of-darts-inside-of-a-circular-dartboard/)

---

## **10. Sector of Circle**

### **Area of Sector**
Given central angle $\theta$ (in radians):
$$
\text{Area} = \frac{1}{2} r^2 \theta
$$

Given central angle $\theta$ (in degrees):
$$
\text{Area} = \frac{\pi r^2 \theta}{360°}
$$

### **Arc Length**
$$
\text{Arc Length} = r \times \theta \quad \text{(θ in radians)}
$$
$$
\text{Arc Length} = \frac{\pi r \theta}{180°} \quad \text{(θ in degrees)}
$$

### **Area of Segment**
Area between chord and arc:
$$
\text{Area of Segment} = \frac{r^2}{2}(\theta - \sin \theta)
$$

### **Chord Length**
$$
\text{Chord Length} = 2r \sin\left(\frac{\theta}{2}\right)
$$

**LeetCode Problems:**
1. [1401. Circle and Rectangle Overlapping](https://leetcode.com/problems/circle-and-rectangle-overlapping/)
2. [1453. Maximum Number of Darts Inside of a Circular Dartboard](https://leetcode.com/problems/maximum-number-of-darts-inside-of-a-circular-dartboard/)
3. [1275. Find Winner on a Tic Tac Toe Game](https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/)

---

## **11. Polygon**

### **Area of Simple Polygon (Shoelace Formula)**
Given vertices $(x_1, y_1), (x_2, y_2), \ldots, (x_n, y_n)$:
$$
\text{Area} = \frac{1}{2} \left| \sum_{i=0}^{n-1} (x_i \cdot y_{(i+1) \bmod n} - x_{(i+1) \bmod n} \cdot y_i) \right|
$$

### **Point in Polygon (Ray Casting)**
Cast a ray from point to infinity and count intersections with polygon edges.

**LeetCode Problems:**
1. [469. Convex Polygon](https://leetcode.com/problems/convex-polygon/) (Premium)
2. [587. Erect the Fence](https://leetcode.com/problems/erect-the-fence/)

---

## **12. Convex Hull**

### **Graham Scan Algorithm**
1. Find bottom-most point (or left-most in case of tie)
2. Sort points by polar angle with respect to start point
3. Process points and maintain convex hull

### **Cross Product for Orientation**
For points $p$, $q$, $r$:
$$
\text{Cross Product} = (q.x - p.x)(r.y - p.y) - (q.y - p.y)(r.x - p.x)
$$
- Positive: Counter-clockwise
- Negative: Clockwise  
- Zero: Collinear

**LeetCode Problems:**
1. [587. Erect the Fence](https://leetcode.com/problems/erect-the-fence/)

---

## **13. Vector Operations**

### **Dot Product**
$$
\vec{a} \cdot \vec{b} = a_x \cdot b_x + a_y \cdot b_y
$$

### **Cross Product (2D)**
$$
\vec{a} \times \vec{b} = a_x \cdot b_y - a_y \cdot b_x
$$

### **Vector Magnitude**
$$
|\vec{v}| = \sqrt{v_x^2 + v_y^2}
$$

### **Angle Between Vectors**
$$
\cos \theta = \frac{\vec{a} \cdot \vec{b}}{|\vec{a}| \cdot |\vec{b}|}
$$

**LeetCode Problems:**
1. [1037. Valid Boomerang](https://leetcode.com/problems/valid-boomerang/)
2. [593. Valid Square](https://leetcode.com/problems/valid-square/)

---

## **14. Coordinate Transformations**

### **Rotation by Angle θ**
$$
\begin{pmatrix}
x' \\
y'
\end{pmatrix} = 
\begin{pmatrix}
\cos\theta & -\sin\theta \\
\sin\theta & \cos\theta
\end{pmatrix}
\begin{pmatrix}
x \\
y
\end{pmatrix}
$$

### **Reflection Across Line y = mx**
$$
\begin{pmatrix}
x' \\
y'
\end{pmatrix} = 
\frac{1}{1+m^2}
\begin{pmatrix}
(1-m^2)x + 2my \\
2mx + (m^2-1)y
\end{pmatrix}
$$

**LeetCode Problems:**
1. [1030. Matrix Cells in Distance Order](https://leetcode.com/problems/matrix-cells-in-distance-order/)
2. [356. Line Reflection](https://leetcode.com/problems/line-reflection/) (Premium)

---

## **15. Special Formulas for Competitive Programming**

### **Pick's Theorem** (Area with Integer Coordinates)
$$
\text{Area} = I + \frac{B}{2} - 1
$$
Where $I$ = interior points, $B$ = boundary points

### **GCD of Coordinates for Lattice Points**
Number of lattice points on line segment from $(0,0)$ to $(x,y)$:
$$
\text{Points} = \gcd(|x|, |y|) + 1
$$

### **Circumcenter of Triangle**
For triangle with vertices $A(x_1, y_1)$, $B(x_2, y_2)$, $C(x_3, y_3)$:
$$
O_x = \frac{D_x}{2D}, \quad O_y = \frac{D_y}{2D}
$$
Where:
$$
D = 2(x_1(y_2 - y_3) + x_2(y_3 - y_1) + x_3(y_1 - y_2))
$$
$$
D_x = (x_1^2 + y_1^2)(y_2 - y_3) + (x_2^2 + y_2^2)(y_3 - y_1) + (x_3^2 + y_3^2)(y_1 - y_2)
$$
$$
D_y = (x_1^2 + y_1^2)(x_3 - x_2) + (x_2^2 + y_2^2)(x_1 - x_3) + (x_3^2 + y_3^2)(x_2 - x_1)
$$

### **Circumradius of Triangle**
$$
R = \frac{abc}{4 \cdot \text{Area}}
$$
Where $a$, $b$, $c$ are side lengths.

### **Incenter and Inradius**
**Incenter coordinates:**
$$
I_x = \frac{ax_1 + bx_2 + cx_3}{a + b + c}, \quad I_y = \frac{ay_1 + by_2 + cy_3}{a + b + c}
$$

**Inradius:**
$$
r = \frac{\text{Area}}{s}
$$
Where $s = \frac{a + b + c}{2}$ is the semi-perimeter.

### **Centroid of Triangle**
$$
G_x = \frac{x_1 + x_2 + x_3}{3}, \quad G_y = \frac{y_1 + y_2 + y_3}{3}
$$

### **Orthocenter of Triangle**
For triangle with vertices $A$, $B$, $C$, orthocenter $H$ satisfies:
$$
\vec{OH} = \vec{OA} + \vec{OB} + \vec{OC}
$$
Where $O$ is the circumcenter.

### **Heron's Formula**
Area of triangle with sides $a$, $b$, $c$:
$$
\text{Area} = \sqrt{s(s-a)(s-b)(s-c)}
$$
Where $s = \frac{a + b + c}{2}$.

### **Bretschneider's Formula** (Quadrilateral Area)
For quadrilateral with sides $a$, $b$, $c$, $d$ and diagonals $p$, $q$:
$$
\text{Area} = \sqrt{(s-a)(s-b)(s-c)(s-d) - abcd \cdot \cos^2\left(\frac{A+C}{2}\right)}
$$

### **Brahmagupta's Formula** (Cyclic Quadrilateral)
For cyclic quadrilateral with sides $a$, $b$, $c$, $d$:
$$
\text{Area} = \sqrt{(s-a)(s-b)(s-c)(s-d)}
$$

### **Ptolemy's Theorem** (Cyclic Quadrilateral)
For cyclic quadrilateral with sides $a$, $b$, $c$, $d$ and diagonals $p$, $q$:
$$
pq = ac + bd
$$

### **Law of Cosines**
$$
c^2 = a^2 + b^2 - 2ab\cos C
$$

### **Law of Sines**
$$
\frac{a}{\sin A} = \frac{b}{\sin B} = \frac{c}{\sin C} = 2R
$$

### **Stewart's Theorem**
For triangle with cevian of length $d$ dividing side $a$ into segments $m$ and $n$:
$$
b^2m + c^2n = a(d^2 + mn)
$$

### **Area of Triangle using Sin**
$$
\text{Area} = \frac{1}{2}ab\sin C
$$

### **Angle Bisector Length**
Length of angle bisector from vertex $A$ to opposite side:
$$
t_a = \frac{2bc \cos(A/2)}{b + c} = \frac{\sqrt{bc \cdot s(s-a)}}{b + c}
$$

### **Median Length**
Length of median from vertex $A$ to midpoint of opposite side:
$$
m_a = \frac{1}{2}\sqrt{2b^2 + 2c^2 - a^2}
$$

### **Power of a Point**
For point $P$ and circle with center $O$ and radius $r$:
$$
\text{Power} = |OP|^2 - r^2
$$

### **Radical Axis**
For two circles, the locus of points having equal power with respect to both circles.

### **Apollonius Circle**
Locus of points $P$ such that $\frac{|PA|}{|PB|} = k$ (constant) is a circle.

### **Monge's Theorem**
For three circles, the three lines connecting centers of similitude are concurrent.

### **Euler Line**
In any triangle, the circumcenter, centroid, and orthocenter are collinear.
The centroid divides the segment from circumcenter to orthocenter in ratio 1:2.

### **Nine-Point Circle**
Circle passing through:
- Midpoints of three sides
- Feet of three altitudes  
- Midpoints of segments from vertices to orthocenter

Radius = $\frac{R}{2}$ where $R$ is circumradius.

### **Morley's Theorem**
The intersections of adjacent angle trisectors of any triangle form an equilateral triangle.

### **Complex Number Representation**
Point $(x, y)$ as complex number $z = x + iy$:
- Rotation by angle $\theta$: $z' = z \cdot e^{i\theta}$
- Distance: $|z_1 - z_2|$
- Midpoint: $\frac{z_1 + z_2}{2}$

### **Shoelace Formula Extended**
For polygon with $n$ vertices $(x_1, y_1), \ldots, (x_n, y_n)$:
$$
\text{Area} = \frac{1}{2} \left| \sum_{i=1}^{n} (x_i y_{i+1} - x_{i+1} y_i) \right|
$$
(where $x_{n+1} = x_1$, $y_{n+1} = y_1$)

### **Green's Theorem for Area**
$$
\text{Area} = \oint_C x \, dy = -\oint_C y \, dx = \frac{1}{2} \oint_C (x \, dy - y \, dx)
$$

### **Parallel Line Distance**
Distance between parallel lines $ax + by + c_1 = 0$ and $ax + by + c_2 = 0$:
$$
d = \frac{|c_1 - c_2|}{\sqrt{a^2 + b^2}}
$$

### **Angle Between Two Lines**
For lines with slopes $m_1$ and $m_2$:
$$
\tan \theta = \left|\frac{m_1 - m_2}{1 + m_1 m_2}\right|
$$

### **Reflection of Point Across Line**
To reflect point $(x_0, y_0)$ across line $ax + by + c = 0$:
$$
x' = x_0 - \frac{2a(ax_0 + by_0 + c)}{a^2 + b^2}
$$
$$
y' = y_0 - \frac{2b(ax_0 + by_0 + c)}{a^2 + b^2}
$$

**LeetCode Problems:**
1. [1453. Maximum Number of Darts Inside of a Circular Dartboard](https://leetcode.com/problems/maximum-number-of-darts-inside-of-a-circular-dartboard/)
2. [149. Max Points on a Line](https://leetcode.com/problems/max-points-on-a-line/)
3. [812. Largest Triangle Area](https://leetcode.com/problems/largest-triangle-area/)
4. [593. Valid Square](https://leetcode.com/problems/valid-square/)
5. [963. Minimum Area Rectangle II](https://leetcode.com/problems/minimum-area-rectangle-ii/)
6. [587. Erect the Fence](https://leetcode.com/problems/erect-the-fence/)
7. [356. Line Reflection](https://leetcode.com/problems/line-reflection/) (Premium)

---

## **Common Implementation Tips**

1. **Use `long long` for coordinates** to avoid overflow
2. **Handle edge cases**: collinear points, identical points
3. **Precision handling**: Use `eps = 1e-9` for floating-point comparisons
4. **Integer arithmetic**: Prefer integer operations when possible to avoid precision errors
5. **Coordinate compression**: For large coordinate ranges, compress coordinates to smaller ranges