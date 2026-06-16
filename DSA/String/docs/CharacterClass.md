The `Character` class in Java provides a wide range of methods to work with characters, both basic and advanced. Below is a comprehensive list of these methods, categorized by their functionality:

### 1. **Basic Methods**

#### **1.1 Checking Character Properties**

- **`isLetter(char ch)`**: Checks if the character is a letter (A-Z or a-z).
- **`isDigit(char ch)`**: Checks if the character is a digit (0-9).
- **`isLetterOrDigit(char ch)`**: Checks if the character is either a letter or a digit.
- **`isLowerCase(char ch)`**: Checks if the character is a lowercase letter.
- **`isUpperCase(char ch)`**: Checks if the character is an uppercase letter.
- **`isWhitespace(char ch)`**: Checks if the character is a whitespace (space, tab, newline, etc.).
- **`isSpaceChar(char ch)`**: Checks if the character is a space character.
- **`isISOControl(char ch)`**: Checks if the character is an ISO control character.
- **`isAlphabetic(int codePoint)`**: Checks if the character is alphabetic, including non-ASCII letters.

#### **1.2 Character Conversion**

- **`toLowerCase(char ch)`**: Converts a character to lowercase.
- **`toUpperCase(char ch)`**: Converts a character to uppercase.
- **`toTitleCase(char ch)`**: Converts a character to title case, usually for the first letter in a word.
- **`digit(char ch, int radix)`**: Converts a character into a numeric digit based on the specified radix.
- **`forDigit(int digit, int radix)`**: Converts a digit into a character based on the specified radix.

### 2. **Advanced Methods**

#### **2.1 Unicode and Code Points**

- **`charCount(int codePoint)`**: Returns the number of `char` values needed to represent a code point (1 or 2).
- **`codePointAt(CharSequence seq, int index)`**: Returns the Unicode code point at the given index in a `CharSequence`.
- **`codePointBefore(CharSequence seq, int index)`**: Returns the Unicode code point before the given index in a `CharSequence`.
- **`codePointCount(CharSequence seq, int beginIndex, int endIndex)`**: Returns the number of Unicode code points in a text range.
- **`offsetByCodePoints(CharSequence seq, int index, int codePointOffset)`**: Returns the index within a `CharSequence` offset by a specified number of code points.

#### **2.2 Surrogate Pairs**

- **`isSurrogate(char ch)`**: Checks if the character is a surrogate (used for UTF-16 encoding).
- **`isHighSurrogate(char ch)`**: Checks if the character is a high surrogate.
- **`isLowSurrogate(char ch)`**: Checks if the character is a low surrogate.
- **`toCodePoint(char high, char low)`**: Converts a pair of surrogate characters into a single code point.
- **`isValidCodePoint(int codePoint)`**: Checks if the specified code point is a valid Unicode code point.

#### **2.3 Character Types**

- **`getType(char ch)`**: Returns the general category type of the character (e.g., letter, digit, punctuation).
- **`getNumericValue(char ch)`**: Returns the numeric value of a character (e.g., '9' returns 9).
- **`getDirectionality(char ch)`**: Returns the bidirectional character type (e.g., left-to-right, right-to-left).
- **`isMirrored(char ch)`**: Checks if the character is a mirrored character in bidirectional text.

#### **2.4 Miscellaneous**

- **`reverseBytes(char ch)`**: Returns the value obtained by reversing the order of the bytes in the specified `char` value.
- **`hashCode(char ch)`**: Returns the hash code for a character.
- **`compare(char x, char y)`**: Compares two `char` values lexicographically.
- **`toChars(int codePoint)`**: Converts a Unicode code point into a `char` array.
- **`toString(char ch)`**: Returns the `String` representation of a character.
- **`toTitleCase(int codePoint)`**: Converts the code point to title case, if applicable.

### 3. **Deprecated Methods**

Some methods are deprecated and are generally not recommended for use in new code:

- **`isJavaIdentifierStart(char ch)`**: Deprecated since Java 9, use `isUnicodeIdentifierStart`.
- **`isJavaIdentifierPart(char ch)`**: Deprecated since Java 9, use `isUnicodeIdentifierPart`.

### 4. **Examples**

```java
// Checking if a character is a letter or digit
char ch = 'A';
if (Character.isLetterOrDigit(ch)) {
    System.out.println(ch + " is a letter or digit.");
}

// Converting a character to uppercase
char lower = 'a';
char upper = Character.toUpperCase(lower);
System.out.println("Uppercase of " + lower + " is " + upper);

// Getting the numeric value of a character
char digit = '7';
int numericValue = Character.getNumericValue(digit);
System.out.println("Numeric value of " + digit + " is " + numericValue);

// Checking if a character is a whitespace
char space = ' ';
if (Character.isWhitespace(space)) {
    System.out.println("It's a whitespace.");
}

// Working with surrogate pairs
char highSurrogate = '\uD800';
char lowSurrogate = '\uDC00';
int codePoint = Character.toCodePoint(highSurrogate, lowSurrogate);
System.out.println("Code point of the surrogate pair: " + codePoint);
```

This guide covers most of the commonly used methods in the `Character` class, allowing you to handle characters effectively in Java.
