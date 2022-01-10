import java.util.*
import com.fasterxml.jackson.dataformat.xml.XmlMapper


class Book(val name: String="", val subtitle: String="", val isbn:String="", val pagecount: Int=0,
           val keywords: String="", val languageID: Int=0, val authors:Author=Author("Puskin", "Alexander")) {
    val id = (0..1000000).random()
    val createdOn = Date()
    fun push(){
        print("")
    }

    fun publish(){
        val xmlMapper = XmlMapper()
        val strObject = xmlMapper.writeValueAsString(this)
        println(strObject)
    }
}

class Language(code: String, name:String){
    val id = (0..1000000).random()
}

class Author(val firstName: String="", val secondName: String="") {
    private val id = (0..1000000).random()
}

open class PublishingBrand(name: String = "empty") {
    val id = (0..1000000).random()
    private val books= mutableListOf<Book>()
    fun addBooks(moreBooks: MutableList<Book>) {
        books += moreBooks
    }
}

class EditorialGroup : PublishingBrand()

class PublishingRetailer(name: String = "empty") {
    val id = (0..1000000).random()
    private val books= mutableListOf<Book>()
    private val countries= mutableListOf<String>()
    fun addBooks(moreBooks: MutableList<Book>) {
        books += moreBooks
    }
    fun addCountry(moreCountries: MutableList<String>) {
        countries += moreCountries
    }
}

fun main(){
    val book1= Book("name1", "Subtitle1", "ISBN", 100, "key", 228,  Author("Puskin", "Alex"))
    val book2= Book("name1", "Subtitle1", "ISBN", 100, "key", 228,  Author("Puskin", "Alex"))
    println(book1)
    println(book2)
    book1.publish()
    val xmlMapper = XmlMapper()
    val xmlStr:String? = xmlMapper.writeValueAsString(book1)
    val xmlMapper2 = XmlMapper()
    val book3 = xmlMapper2.readValue(xmlStr, Book::class.java)
    book3.publish()
}
