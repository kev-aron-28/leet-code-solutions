# Problem

When converting Roman → Integer:
Most symbols just add their value:
"VI" → V (5) + I (1) = 6
But if a smaller symbol comes before a larger one, it means subtraction:
"IV" → I (1) before V (5) → 5 - 1 = 4
"IX" → I before X → 10 - 1 = 9
Subtractive cases only occur with the allowed forms: IV, IX, XL, XC, CD, CM.

Map<Character, Integer> romanMap = new HashMap<>();
romanMap.put('I', 1);
romanMap.put('V', 5);
romanMap.put('X', 10);
romanMap.put('L', 50);
romanMap.put('C', 100);
romanMap.put('D', 500);
romanMap.put('M', 1000);
