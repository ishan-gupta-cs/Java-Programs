# 🔢 Power Function using Recursion (`x^n`)

## 🧠 Problem Goal

Implement `x^n` (x raised to the power n) efficiently using **recursion**.

The goal is to reduce the number of multiplications from **O(n)** to **O(log n)** using a method called **Exponentiation by Squaring**.

---

## 🔍 How Exponentiation by Squaring Works

Let’s suppose you want to calculate `x^n`:

### 🔹 Case 1: When `n` is Even

If `n` is even (like 4, 10, 100), you can use:

```
x^n = (x^2)^(n/2)
```

This works because:

- Squaring the base `x → x²`
- Halving the exponent `n → n/2`
- Repeating the process recursively

#### 🧮 Example:
```
x = 2, n = 4
2^4 = (2^2)^2 = (4)^2 = 16
```

Instead of computing `2 * 2 * 2 * 2`, we do:

- 2² = 4  
- 4² = 16

#### 🔸 Code:
```java
return pow(x * x, n / 2);
```

---

### 🔹 Case 2: When `n` is Odd

If `n` is odd (like 3, 5, 11), you use:

```
x^n = x * (x^2)^((n - 1) / 2)
```

Why?

- Any odd number can be written as `n = 2k + 1`
- We "pull out" one `x`, making the rest of the exponent even
- Now we can apply the even rule on `(n - 1)`

#### 🧮 Example:
```
x = 2, n = 5
2^5 = 2 * (2^4)
2^4 = (2^2)^2 = 4^2 = 16
2^5 = 2 * 16 = 32
```

Recursive Breakdown:
```
pow(2, 5) → 2 * pow(4, 2)
pow(4, 2) → pow(16, 1)
pow(16, 1) → 16 * pow(256, 0) = 16
Final = 2 * 16 = 32
```

#### 🔸 Code:
```java
return x * pow(x * x, (n - 1) / 2);
```

---

## 🔁 Why Use `x * x` in Both Cases?

To reduce the power efficiently:

- Without squaring `x`, recursion would shrink linearly (`O(n)`).
- By squaring, we cut the problem size in half on each step → `O(log n)`.

---

## ✅ Java Code Implementation

```java
class Solution {
    public double myPow(double x, int n) {
        // Cast to long to handle Integer.MIN_VALUE safely
        return pow(x, (long) n);
    }

    private double pow(double x, long n) {
        if (n == 0) return 1;
        if (n < 0) return 1.0 / pow(x, -n);

        if (n % 2 == 0) {
            return pow(x * x, n / 2); // Even case
        } else {
            return x * pow(x * x, (n - 1) / 2); // Odd case
        }
    }
}
```

---

## 🚀 Time and Space Complexity

- **Time Complexity:** `O(log n)`
- **Space Complexity:** `O(log n)` (due to recursion stack)