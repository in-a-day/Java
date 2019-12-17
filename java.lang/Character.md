### final class Character

```java 
public final class Character implements Serializable, Comparable(Character)
```

> MIN_VALUE = '\u0000'  
> MAX_VALUE = '\uFFFF'  

> Unicode规定码位范围为U+0000 - U+10FFFF. BMP字符集范围为U+0000 - U+FFFF. 大于U+FFFF的码位称为`supplementary characters`. Java使用UTF-16编码标准. 在该标准中, supplementary characters 代表一对`char`值, 首位是`high-surrogates`(\uD800-\uDBFF), 次位是`low-surrogates`(\uDC00-\uDFFF)
