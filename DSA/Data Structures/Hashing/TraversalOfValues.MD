### 1. Traversing the Keys of a `HashMap`

```java
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        // Iterating over keys
        for (String key : map.keySet()) {
            System.out.println("Key: " + key);
        }
    }
}
```

### 2. Traversing the Values of a `HashMap`

```java
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        // Iterating over values
        for (Integer value : map.values()) {
            System.out.println("Value: " + value);
        }
    }
}
```

### 3. Traversing the Key-Value Pairs of a `HashMap`

```java
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        // Iterating over key-value pairs
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
```

### 4. Traversing the Keys and Values of a `HashMap` Using Java 8 forEach

```java
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        // Iterating over keys and values using Java 8 forEach
        map.forEach((key, value) -> {
            System.out.println("Key: " + key + ", Value: " + value);
        });
    }
}
```

### 5. Traversing the Keys of a `HashMap` Using an Iterator

```java
import java.util.HashMap;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        // Iterating over keys using an iterator
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println("Key: " + key);
        }
    }
}
```

### 6. Traversing the Values of a `HashMap` Using an Iterator

```java
import java.util.HashMap;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        // Iterating over values using an iterator
        Iterator<Integer> iterator = map.values().iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            System.out.println("Value: " + value);
        }
    }
}
```

### 7. Traversing the Key-Value Pairs of a `HashMap` Using an Iterator

```java
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        // Iterating over key-value pairs using an iterator
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
```

These snippets cover various ways to traverse through a `HashMap` in Java.


# To retrieve a key for a particular value or vice versa in a `HashMap`, you can use the following approaches:

### 1. Get Key for a Particular Value

Since a `HashMap` in Java is designed for efficient key-to-value lookups, there's no direct way to look up a key by its value. You need to iterate over the map and compare values:

```java
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        // Get key for a particular value
        Integer targetValue = 2;
        String targetKey = null;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(targetValue)) {
                targetKey = entry.getKey();
                break;
            }
        }

        if (targetKey != null) {
            System.out.println("Key for value " + targetValue + " is: " + targetKey);
        } else {
            System.out.println("Value " + targetValue + " not found in the map.");
        }
    }
}
```

### 2. Get Value for a Particular Key

This is straightforward since `HashMap` is designed to quickly retrieve values using keys:

```java
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        // Get value for a particular key
        String targetKey = "B";
        Integer value = map.get(targetKey);

        if (value != null) {
            System.out.println("Value for key " + targetKey + " is: " + value);
        } else {
            System.out.println("Key " + targetKey + " not found in the map.");
        }
    }
}
```

### 3. Bi-Directional Mapping (Key ↔ Value)

If you need to frequently look up both keys by values and values by keys, consider using two `HashMap`s:

```java
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // HashMap for key-to-value mapping
        HashMap<String, Integer> keyToValueMap = new HashMap<>();
        keyToValueMap.put("A", 1);
        keyToValueMap.put("B", 2);
        keyToValueMap.put("C", 3);

        // HashMap for value-to-key mapping
        HashMap<Integer, String> valueToKeyMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : keyToValueMap.entrySet()) {
            valueToKeyMap.put(entry.getValue(), entry.getKey());
        }

        // Example: Get value for a key
        String key = "B";
        Integer value = keyToValueMap.get(key);
        System.out.println("Value for key " + key + " is: " + value);

        // Example: Get key for a value
        Integer searchValue = 2;
        String foundKey = valueToKeyMap.get(searchValue);
        System.out.println("Key for value " + searchValue + " is: " + foundKey);
    }
}
```

This method ensures that you can efficiently look up keys by values and values by keys, although it requires additional memory to maintain the two `HashMap`s.
