# Hashmaps
Data structure that stores key-value pairs and allows
- O(1) average time for put, get, remove
- Unordered storage
- Keys must be unique


How it works:
- COnverting a key int oa integer hash
- Mapping that hash to a bucket index
- Storing that entry in that bucket

Use a HashMap when
1. You need fast lookup
2. You need to count things
3. You need to track frequenc
4. You need to remember seen elements
5. You need key, value relationships

# Internally
1. Hashcode is called on the key
2. hash is spread
3. index is calculated
4. entry is placed in that bucket

and each bucket can contain a linked list or a red-black tree java 8+

# Collisions  
A collision happens when two keys map to the same bucket
and there are multiple collition strategies:
- Separate chaining
- Open addressing


# hashCode and equals
equals() answers the are these two objects logically the same

This is the default behaviour:

``` java
plublic boolean equals(Object obj) {
    return this == obj
}
```


