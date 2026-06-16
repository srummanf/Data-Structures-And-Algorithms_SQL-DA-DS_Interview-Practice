## Ref: https://leetcode.com/discuss/post/5455087/probo-sde-intern-gurugram-jul-2024-offer-2jfo/

## Round 1

**Taken By:** Akash Utreja Sir

### First Question

**Link:** [Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes/description/)
**Problem:** Given an m x n integer matrix, if an element is 0, set its entire row and column to 0's. You must do it in place.

**Follow-up:** Devise a constant space solution.

**Answer:**

```cpp
classSolution{
public:
voidsetZeroes(vector<vector<int>>& matrix){
int n = matrix.size();
int m = matrix[0].size();
bool flag1 =false, flag2 =false;
for(int i=0; i<n; i++){
if(matrix[i][0]==0){
                flag1 =true;
}
}
for(int j=0; j<m; j++){
if(matrix[0][j]==0){
                flag2 =true;
}
}
for(int i=1; i<n; i++){
for(int j=1; j<m; j++){
if(matrix[i][j]==0){
                    matrix[i][0]= matrix[0][j]=0;
}
}
}
for(int i=1; i<n; i++){
for(int j=1; j<m; j++){
if(matrix[i][0]==0|| matrix[0][j]==0){
                    matrix[i][j]=0;
}
}
}
if(flag1 ==true){
for(int i=0; i<n; i++){
                matrix[i][0]=0;
}
}
if(flag2 ==true){
for(int j=0; j<m; j++){
                matrix[0][j]=0;
}
}
}
};
```

### Second Question

**Link:** [Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)
**Problem:** Given an integer array prices where prices[i] is the price of a given stock on the ith day, find and return the maximum profit you can achieve.

**Answer:**

```cpp
classSolution{
public:
intmaxProfit(vector<int>& prices){
int sum =0;
int val = prices[0];
int n = prices.size();
for(int i=1;i<n;i++){
if(prices[i]>val){
                sum +=(prices[i]-val);
                val = prices[i];
}
else{
                val = prices[i];
}
}
return sum;
}
};
```

### Third Question

**Problem:** Design a data structure that supports the following operations in O(1) time.

* `insert(x)`: Inserts an item x to the data structure if not already present.
* `remove(x)`: Removes item x from the data structure if present.
* `search(x)`: Searches an item x in the data structure.
* `getRandom()`: Returns a random element from the current set of elements.

### Fourth Question

**Link:** [Best Time to Buy and Sell Stock III](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/)
**Problem:** Given an array prices where prices[i] is the price of a given stock on the ith day, find the maximum profit you can achieve. You may complete at most two transactions.

**Answer:**

```cpp
classSolution{
public:
intmaxProfit(vector<int>& prices){
int n = prices.size();
        vector<int>suf(n+1,0);
int lr = prices[n-1];
for(int i=n-1;i>=0;i--){
            lr =max(lr,prices[i]);
            suf[i]=max(suf[i+1],lr-prices[i]);
}
int val = prices[0];
int ans =0;
for(int i=1;i<n;i++){
if(prices[i]>val){
                ans =max(ans,prices[i]-val+suf[i+1]);
}
            val =min(val,prices[i]);
}
return ans;
}
};
```

## Round 2

**Taken By:** Karan Varshney Sir

### First Question

**Problem:** Get the data from a given list of APIs, then combine all the data and return that data.

**Answer:**

```javascript
const list =[{},{}];

constapp=async()=>{
const combinedData =[];
    list.map((listItem)=>{
const data =awaitfetch(listItem);
const response =await data.json();
        combinedData =[...combinedData,response];
});
return combinedData;
}
```

**Follow-up Question:** Suppose there are as many as 100 lists of APIs, now what will be your approach?

**Answer:** By using `Promise.all()` we can do this easily and it is also an optimized approach.

### Second Question

**Problem:** Given multiple numbers, you have to find the numbers between 1 and n (inclusive) which are divisible by all the given numbers.

**Answer:**

```cpp
vector<int>fun(int n,int x,int y){
    vector<int> vec;
int gc =__gcd(x, y);
if(gc ==0)return{};
int new_x =((x*y)/ gc);
if(new_x ==0)return{};
    new_x =abs(new_x);
for(int i = new_x; i <= n; i += new_x){
        vec.push_back(i);
}
return vec;
}
```

### Third Question

**Problem:** Explain Inheritance using a Real-Life Example.

**Answer:**

```cpp
classFourWheeler{
int wheels =4; 
}

classCar extends FourWheeler{
intdefine(){
// Car specific functionality
}
}
```

### Fourth Question

**Problem:** Explain Polymorphism.

**Answer:** Polymorphism means many forms. I explained it with a simple example of method overriding and overloading in object-oriented programming.

### Fifth Question

**Problem:** Design a system for the tic-tac-toe game.

**Answer:**

```cpp
vector<vector<int>> vec;

voidassign(){
// For assigning the matrix to the default value
}

voidplay(int player, pair<int,int> ind){
// For assigning the value in the matrix in every turn
}

voidswitch_turn(int&player){
// For switching the turns between players
}

voidcheck(){
// For checking if any player wins the game or not in each and every turn
}
```

### Sixth Question

**Problem:** Design a data structure that can store key-value pairs in cache memory for size 100 and can remove the last inserted key-value pair if the limit is reached or the size of the data structure is reached to 100 and then insert the new value.

**Answer:**

```cpp
set<pair<string,int>> st2;// For storing key with their priority
set<pair<int, pair<string, string>>> st1;// For storing key-value with their priority
```

## Round 3

**Taken By:** Prashant Sir

**Description:** Had a general HR interview and some managerial questions. We also talked about my previous projects and internships.

### Verdict: Offer
