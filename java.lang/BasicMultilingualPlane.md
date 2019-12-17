> Wiki: https://zh.wikipedia.org/zh-cn/Unicode%E5%AD%97%E7%AC%A6%E5%B9%B3%E9%9D%A2%E6%98%A0%E5%B0%84

> 当前Unicoce字符分为17组编排, 每组称为平面(Plane),每个平面有65536(2^16)个码位(code point).

### 5层编码模型

> 抽象字符表(Abstract character repertoire): 一个系统支持的所有抽象字符的集合.  

> 编码字符集(CCS: Coded Character Set): 将字符集中每个字符映射到一个坐标或是非负的整数. 不同的字符集可以表示相同的字符表(不同字符集可能将相同的字符表映射为不同的整数). 编码空间: 包含所有字符的表的维度(可以是一对整数, 也可以是一个整数). 编码空间也可以用其子集描述, 如行, 列, 面(plane). 编码空间中的一个位置称为码位(code pointer). 一个字符占用的码位称为码位值. 一个编码字符集就是把抽象字符映射为码位值.  

> 字符编码表(CEF: Character Encoding Form): 也称"storage format", 将编码字符集的非负整数值(即码位值)转换为有限比特长度的整型值(称为码元code units)的序列. 对于定长编码来说是自身到自身的映射(null mapping), 但对于变长编码来说, 把一些码位映射到另一个码位, 另一些码位映射到有多个码元组成的序列.

> 字符编码方案(CES:Character Encoding Scheme): 也称"serialization format", 将定长的整形值(即码元)映射到8位字节序列, 以便编码后的数据的文件存储或网络传输.

> 传输编码方案(transfer encoding syntax): 用于处理上一层此的字符编码方案提供的字节序列. 
