# Problem

| Symbol | Value |
| ------ | ----- |
| I      | 1     |
| V      | 5     |
| X      | 10    |
| L      | 50    |
| C      | 100   |
| D      | 500   |
| M      | 1000  |

Numbers are formed by combining symbols from largest to smallest.
Special subtractive forms exist to avoid repeating symbols 4 times:
4 → IV (5 - 1)

9 → IX (10 - 1)

40 → XL (50 - 10)

90 → XC (100 - 10)

400 → CD (500 - 100)

900 → CM (1000 - 100)

Process:
1. Start with the largest Roman numeral possible.
2. Append it to the result.
3. Subtract its value.
4. Repeat until the number becomes 0.

We create arrays for values and symbols, from largest to smallest, including subtractive forms:

int[] values =    {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

Example:

with 1994
Check 1000 (M)
1994 ≥ 1000 
Append "M" → Roman = "M"
Subtract 1000 → num = 1994 - 1000 = 994

check 900 (CM)
994 ≥ 900 
Append "CM" → Roman = "MCM"
Subtract 900 → num = 994 - 900 = 94


Check 500 (D)
94 < 500 → skip

Check 400 (CD)
94 < 400  → skip

Check 100 (C)
94 < 100 → skip

Check 90 (XC)
94 ≥ 90 
Append "XC" → Roman = "MCMXC"
Subtract 90 → num = 94 - 90 = 4
