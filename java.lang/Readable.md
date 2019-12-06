### public interface Readable

> Readable是一个字符源. Readable通过CharBuffer的read方法提供字符给调用者.
---

```java 
int read(CharBuffer cb) throws IOExcption
```
> 尝试读取字符到给定的字符缓冲区中. 该缓冲区被用作字符的仓库: 只有使用put操作才会使结果发生改变.不执行缓冲区的回滚和翻转.
##### Parameters:
> cb - 将字符读入的缓冲区
##### Returns:
> 添加到缓冲区的字符值的数量, 如果读取到字符源末尾则返回-1
##### Throws:
> IOException - if an I/O error occurs  
> NullPointerException - if cb is null  
> ReadOnlyBufferException - if cb is a read only buffer