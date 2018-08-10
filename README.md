# 数据结构算法学习
包含了平时数据结构学习和写的算法题
## 自己实现的数据结构类
见DIYDataStructure目录
* Array
      
      数组删除引用类型元素会产生loitering objects, 但不等于memory leak
      动态数组resize会导致时间复杂度增加， 但是不是每次都触发resize， 可以
      用均摊复杂度分析。 但是还是要防止复杂度震荡。  缩容采取Lazy的方式。
      
* Stack

      撤销操作
      程序调用的系统栈
      括号匹配
      
* Queue
     
       数组队列dequeue复杂度为O(n)，取出队头元素，后面元素都要向前移动。
       可以使用循环队列解决这个问题(移动front 和 tail指针， fornt == tail队列为空，
       (front + 1)%capacity = tail队列满了， 浪费一个队列空间)    
       
* List
    
       真正的动态数据结构，  
       给链表头添加元素和给其他位置添加不一样， 因为不用找到头一个元素。
       为了和给其他位置加元素统一起来， 可以设立虚拟头结点（dummy head）， 头结点不存元素。
       头结点为dummyhead.next
       
       
          
### 使用泛型
* 让数据结构能放置“任何”数据类型
* 不可以是基本数据类型， 只能是类对象
* 每个基本数据类型都有对应的包装类（wrapper class）
* 基本数据类型和包装类可以自动装换， 自动加包， 解包    
           
## 联系作者
406507715@qq.com / tianhong229@gmail.com