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
    ArrayStack和LinkedListStack的时间复杂度都是O(1)。 两者效率很难比较， 原因是：
    数组栈时不时要resize
    数据量大的时候链表栈要经常new空间， 所以效率不一定比数组栈高
      
* Queue
     
    数组队列dequeue复杂度为O(n)，取出队头元素，后面元素都要向前移动。
    可以使用循环队列解决这个问题(移动front 和 tail指针， fornt == tail队列为空，
    (front + 1)%capacity = tail队列满了， 浪费一个队列空间)

    链表实现队列， 利用改进的链表， 增加一个tail提高效率， 队首head删除元素， 队尾tail添加元素
* List
    
    真正的动态数据结构，
    给链表头添加元素和给其他位置添加不一样， 因为不用找到头一个元素。
    为了和给其他位置加元素统一起来， 可以设立虚拟头结点（dummy head）， 头结点不存元素。
    头结点为dummyhead.next
    只对链表头进行操作： O(1)， 所以可以用链表来实现栈

* 二分搜索树

    局限性： 存储的节点必须有可比较性，
    使用递归插入元素时候， 如果add函数有返回值Node， 则在外面调用时候不用考虑根节点为空的情况。
    不然先要保证根节点不为空（调用之前先判断一下）， 否则会丢失根节点指针！！！

    后续遍历： 应用在内存释放
    前中后续遍历本质上都是：深度优先
    二分搜索树层续遍历： 广度优先， 队列实现， 可能会更有效的访问到想要的对象。常用于算法设计的无权图最短路径

    删除元素： 删除最大最小元素比较容易， 删除任意元素可以用到Hibbard deletion。 找到要删除节点的右子树的最小节点代替该节点。
    相关更多问题：求任意元素floor cell
    求任意元素的rank， select找到某一排名的元素
       
* 集合 Set

    时间复杂度分析：
        LinkedListSet    BSTSet
    增       O(n)          O(h)  高度 O(log2n)
    查       O(n)          O(h)
    删       O(n)          O(h)

    log2n和n的算法复杂度相差很大很大， 100万数据时候， log2n 1s跑完， n要14小时跑完！！
    同理nlogn和n平方差距可想而知！！

    有序集合基于搜索树
    无序集合基于哈希表---增删查更快
    多重集合----允许重复元素的二分查找树上包装

* 映射（字典） Map

    同样的key可以覆盖， 这是个设计问题， 也可以不覆盖抛异常。
    有序映射中键具有顺序性  ---- 基于搜索树实现
    无序映射中键没有顺序性 ----- 基于哈希表实现

* 堆和优先队列

    通过最大堆实现优先队列是极其简单， 所有接口都能复用
    普通队列： 先进先出
    优先队列： 出队顺序和入队顺序无关， 和优先级有关， 谁优先级高谁先出队
                              入队                 出队(拿出最大元素)
    普通线性结构              O(1)                       O(n)
    顺序线性结构              O(n)                       O(1)
        堆                    O(logn)                    O(logn)

    二叉堆是一棵完全二叉树， 不一定是一棵满二叉树
    二叉堆的性质， 堆中的某个节点的值总是不大于其父节点的值
    添加元素， 元素需要sift up（上浮）
    删除元素， 先把数组最后的元素交换到数组头再删除最后元素来保持完全二叉树， 然后数组头元素Sift down。

    Replace操作：可以先extractMax， 再add， 两次O(logn)的 操作
    也可以直接将堆顶元素替换后Sift down

    Heapify操作：将任意数组整理成堆的形状。
    Heapify算法复杂度： 将n个元素逐一插入到一个空堆中， 算法复杂度为O(nlogn);
    通过heapify的过程（找到最后一个非叶子节点， sift down）， 算法复杂度为O(n)

    优先队列经典问题， 在N个元素中选出前M个元素(m << n)； 用归并和快速排序效率为（nlogn); 优先队列效率为(nlogm)
    D叉堆
    索引堆， 不止可以访问堆首的元素

# 线段树（区间树 segment tree）
    区间查询， 不考虑添加，删除元素。 区间长度是固定的。线段树每个节点都是一个区间内的信息
    不一定是满二叉树， 也不一定是完全二叉树， 但是是平衡二叉树（最大最低深度差最大为1）

### 使用泛型
* 让数据结构能放置“任何”数据类型
* 不可以是基本数据类型， 只能是类对象
* 每个基本数据类型都有对应的包装类（wrapper class）
* 基本数据类型和包装类可以自动装换， 自动加包， 解包    
           
## 联系作者
406507715@qq.com / tianhong229@gmail.com