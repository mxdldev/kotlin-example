import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * 1.允许在单线程模式下模拟一个多线程的并发效果
 * 2.程序运行时的执行和挂起是由应用程序控制的，和操作系统无关
 */
fun main(args: Array<String>) {
    //创建了顶级协程，
    GlobalScope.launch {
        //这里是协程的作用域
        println("hello world")
    }
    println("main game over")

    //类似java中的静态成员变量和成员方法
    Person.eat()
    Person.name

    //一个类中部分方法或部分变量是静态的那么我们就可以使用伴生对象
    Person1.eat()

    //3.作为一个对象表达式
    Thread(object :Runnable{
        override fun run() {
            println("run start")
        }

    }).start()
    Thread.sleep(1000 * 5)
}
//object关键字的使用，在Java中他是所有类的超类，而kotlin中她是一个关键字
//1.声明一个对象
object Person{
    val name:String = ""
    val age:Int = 0
    fun eat(){}
    fun work(){}
}
//2.伴生对象
class Person1{
    fun work(){}
    companion object{
        fun eat(){}
    }
}